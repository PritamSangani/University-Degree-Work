# Skeleton

This is the skeleton code for the Compiler coursework in 6G6Z1010
Software Architectures, term 2 2015/16 academic year. As per the
specifications (available on Moodle), this is a multi-stage assignment.

The first stage is to develop the Lexer (Scanner) for the compiler,
which will break the input file into its component tokens, giving a
helpful error message if invalid input is encountered. In order to
complete this part, you will need to modify src/decaf/DecafLexer.g4
(which should contain the rules to identify tokens) and
src/decaf/Main.java (which should ensure that the output appears as
specified).

For the second stage, you will need to modify src/decaf/DecafParser.g4
to capture the grammar rules of the Decaf language.

The third and fourth stages require you to develop your own code for
semantic checking and code generation. No further material is provided
for these stages.
