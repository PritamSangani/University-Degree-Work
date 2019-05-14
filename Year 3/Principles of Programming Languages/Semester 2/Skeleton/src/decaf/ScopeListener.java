package decaf;


/*
    Rule 1 - No identifier declared twice in same scope ✅
    Rule 2 - No identifier used before it is declared. ✅
    Rule 3 - ✅
    Rule 4 -
    Rule 5 -
    Rule 6 -
    Rule 7 -
    Rule 8 -
    Rule 9 -
    Rule 10 -
    Rule 11 -
    Rule 12 -
    Rule 13 -
    Rule 14 -
    Rule 15 -
    Rule 16 -
    Rule 17 -
    Rule 18 -
 */
class ScopeListener extends DecafParserBaseListener {
    private boolean main_method_found;
    private SymbolTable symbolTable;

    ScopeListener() {
        symbolTable = new SymbolTable();
    }

    @Override
    public void enterProgram(DecafParser.ProgramContext ctx) {
        symbolTable.enterScope();
        main_method_found = false;

        String name = ctx.ID().getText();
        int type = DecafLexer.CLASS;
        int line = ctx.getStart().getLine();
        ScopeElement newScopeElement = new ScopeElement(name, type, line);
        symbolTable.addId(name, newScopeElement);
    }

    @Override
    public void enterMethod_decl(DecafParser.Method_declContext ctx) {
        String name = ctx.method_header().ID().getSymbol().getText();

        if (name.equals("main")) {
            main_method_found = true;
        }
    }

    @Override
    public void enterBlock(DecafParser.BlockContext ctx) {
        symbolTable.enterScope();
    }

    @Override
    public void enterField_decl(DecafParser.Field_declContext ctx) {
        int field_count = ctx.field_name().size();
        int line = ctx.getStart().getLine();
        int type;

        type = (ctx.type().INT() != null) ? DecafParser.INT : DecafParser.BOOLEAN;

        for (int i = 0; i < field_count; i++) {
            DecafParser.Field_nameContext field_nameContext = ctx.field_name().get(i);
            String name = field_nameContext.ID().getText();

            ScopeElement scopeElement = (ScopeElement)symbolTable.probe(name);

            if (scopeElement != null) {
                System.err.println(String.format("Error at line %s: field %s has already been declared at line %s",line, name,scopeElement.getLine()));
            }
            symbolTable.addId(name, new ScopeElement(name, type, line));
        }
    }

    @Override
    public void enterStatement(DecafParser.StatementContext ctx) {
        // rule 2
        int line = ctx.getStart().getLine();
        String name = ctx.location().ID().getText();
        ScopeElement scopeElement = (ScopeElement)symbolTable.probe(name);

        if (scopeElement == null) {
            System.err.println(String.format("Error at line %s: variable/field %s has not been declared in any scope.",line, name));
        }
    }

    @Override
    public void enterVar_decl(DecafParser.Var_declContext ctx) {
        int var_count = ctx.param_name().size();
        int line = ctx.getStart().getLine();
        int type;

        type = (ctx.type().INT() != null) ? DecafParser.INT : DecafParser.BOOLEAN;

        for (int i = 0; i < var_count; i++) {
            DecafParser.Param_nameContext param_nameContext = ctx.param_name().get(i);
            String name = param_nameContext.ID().getText();

            ScopeElement scopeElement = (ScopeElement)symbolTable.probe(name);

            if (scopeElement != null) {
                System.err.println(String.format("Error at line %s: variable %s has already been declared at line %s",line, name,scopeElement.getLine()));
            }
            symbolTable.addId(name, new ScopeElement(name, type, line));
        }
    }



    /* ====================================== EXIT METHODS ========================================================*/

    @Override
    public void exitBlock(DecafParser.BlockContext ctx) {
        symbolTable.exitScope();
    }

    @Override
    public void exitProgram(DecafParser.ProgramContext ctx) {
        // Rule 3
        if (!main_method_found) {
            System.err.println("Error: main() method not found in program");
        }
    }

}
