package decaf;
import java.io.*;
import java.util.Arrays;
import javax.swing.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.*;
import java6G6Z1110.tools.CLI.*;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
public class Main {
    public static void main(String[] args) {
        try {
            CLI.parse (args, new String[0]);

            InputStream inputStream = args.length == 0 ?
                    System.in : new java.io.FileInputStream(CLI.infile);
            ANTLRInputStream antlrIOS = new ANTLRInputStream(inputStream);
            if (CLI.target == CLI.SCAN || CLI.target == CLI.DEFAULT) {
                DecafLexer lexer = new DecafLexer(antlrIOS);
                Token token;
                boolean done = false;
                while (!done) {
                    try {
                        for (token=lexer.nextToken(); token.getType() != Token.EOF; token=lexer.nextToken()) {
                            String type = "";
                            String text = token.getText();

                            switch (token.getType()) {
                                case DecafLexer.ID:
                                    type = " IDENTIFIER";
                                    break;
                                case DecafLexer.INT_LITERAL:
                                    type = " INT_LITERAL";
                                    break;
                                case DecafLexer.CHAR_LITERAL:
                                    type = " CHAR_LITERAL";
                                    break;
                                case DecafLexer.TRUE:
                                case DecafLexer.FALSE:
                                    type = " BOOLEAN_LITERAL";
                                    break;
                                case DecafLexer.STRING_LITERAL:
                                    type = " STRING_LITERAL";
                                    break;
                            }
                            System.out.println (token.getLine() + type + " " + text);
                        }
                        done = true;
                    } catch(Exception e) {
                        System.out.println(CLI.infile+" "+e);
                    }
                }
            } else if (CLI.target == CLI.PARSE) {
                DecafLexer lexer = new DecafLexer(antlrIOS);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                DecafParser parser = new DecafParser(tokens);
                ParseTree tree = parser.program();
                if (CLI.debug) {
                    TreePrinterListener listener = new TreePrinterListener(parser);
                    ParseTreeWalker.DEFAULT.walk(listener, tree);
                    String formatted = listener.toString();
                    System.out.println(formatted);
                }

                /****
                 * Below: code for drawing/viewing your parse tree
                 ****/
                JFrame frame = new JFrame("Antlr AST");
                JPanel panel = new JPanel();
                TreeViewer viewr = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
                viewr.setScale(1.5);
                panel.add(viewr);
                frame.add(panel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 600);
                frame.setVisible(true);
             } else if (CLI.target == CLI.INTER) {
                DecafLexer lexer = new DecafLexer(antlrIOS);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                DecafParser parser = new DecafParser(tokens);
                ParseTree tree = parser.program();
                ScopeListener listener = new ScopeListener();
                ParseTreeWalker.DEFAULT.walk(listener, tree);
            }

        } catch(Exception e) {
            System.out.println(CLI.infile+" "+e);
        }
    }
}