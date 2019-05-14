package java6G6Z1110.tools.CLI;

import java.util.Vector;

/**
 * A generic command-line interface for a compiler.  This class
 * provides command-line parsing for student projects.  It recognizes
 * the required <tt>-target</tt>, <tt>-debug</tt>, <tt>-opt</tt>, and
 * <tt>-o</tt> switches, and generates a name for input and output
 * files.
 *
 * @author  Adapted for use at MMU by Emma Norling, from code used in
 * MIT OpenCourseWare unit 6.035 Computer Language Engineering Spring 2010
 */

public class CLI
{
    /**
     * Target value indicating that the compiler should produce its
     * default output.
     */
    public static final int DEFAULT = 0;

    /**
     * Target value indicating that the compiler should scan the input
     * and stop.
     */
    public static final int SCAN = 1;

    /**
     * Target value indicating that the compiler should scan and parse
     * its input, and stop.
     */
    public static final int PARSE = 2;

    /**
     * Target value indicating that the compiler should produce an
     * intermediate representation from its input, and stop.
     */
    public static final int INTER = 3;

    /**
     * Target value indicating that the compiler should produce
     * assembly from its input.
     */
    public static final int ASSEMBLY = 4;

    /**
     * Vector of String containing the command-line arguments which could
     * not otherwise be parsed.
     */
    public static Vector<String> extras;
  
    /**
     * Name of the file to put the output in.
     */
    public static String outfile;
  
    /**
     * Name of the file to get input from.  This is null if the user didn't
     * provide a file name.
     */
    public static String infile;

    /**
     * The target stage.  This should be one of the integer constants
     * defined elsewhere in this package.
     */
    public static int target;

    /**
     * The debug flag.  This is true if <tt>-debug</tt> was passed on
     * the command line, requesting debugging output.
     */
    public static boolean debug;

    /**
     * Sets up default values for all of the
     * result fields.  Specifically, sets the input and output files
     * to null, the target to DEFAULT, and the extras 
     * array to new empty Vector.
     */
    static
    {
	outfile = null;
	infile = null;
	target = DEFAULT;
	extras = new Vector<String>();
    }

    /**
     * Parse the command-line arguments.  Sets all of the result fields
     * accordingly. <BR>
     *
     * <TT>-target <I>target</I></TT> sets the CLI.target field based
     * on the <I>target</I> specified. <BR>
     * <TT>scan</TT> or <TT>scanner</TT> specifies CLI.SCAN
     * <TT>parse</TT> specifies CLI.PARSE
     * <TT>inter</TT> specifies CLI.INTER
     * <TT>assembly</TT> or <TT>codegen</TT> specifies CLI.ASSEMBLY
     *
     * The boolean array opts[] indicates which, if any, of the
     * optimizations in optnames[] should be performed; these arrays
     * are in the same order.
     *
     * @param args Array of arguments passed in to the program's Main
     *   function.
     * @param optnames Ordered array of recognized optimization names.  */
    public static void parse(String args[], String optnames[])
    {
	int context = 0;
	String ext = ".out";

	for (int i = 0; i < args.length; i++)
	    {
		if (args[i].equals("-debug"))
		    {
			context = 0;
			debug = true;
		    }
		else if (args[i].equals("-o"))
		    context = 1;
		else if (args[i].equals("-target"))
		    context = 2;
		else if (context == 1)
		    {
			outfile = args[i];
			context = 0;
		    }
		else if (context == 2)
		    {
			// Process case insensitive.
			String argSansCase = args[i].toLowerCase();
			if (argSansCase.equals("scan"))
			    target = SCAN;
			else if (argSansCase.equals("parse"))
			    target = PARSE;
			else if (argSansCase.equals("inter"))
			    target = INTER;
			else if (argSansCase.equals("assembly") ||
				 argSansCase.equals("codegen"))
			    target = ASSEMBLY;
			else
			    target = DEFAULT; // Anything else is just default
			context = 0;
		    }
		else
		    extras.addElement(args[i]);
	    }

	// grab infile and lose extra args
	int i = 0;
	while (infile == null && i < extras.size())
	    {
		String fn = (String) extras.elementAt(i);
	  
		if (fn.charAt(0) != '-')
		    {
			infile = fn;
			extras.removeElementAt(i);
		    }
		i++;
	    }

	// create outfile name
	switch (target) {
	case SCAN:
	    ext = ".scan";
	    break;
	case PARSE:
	    ext = ".parse";
	    break;
	case INTER:
	    ext = ".ir";
	    break;
	case ASSEMBLY:
	    ext = ".s";
	    break;
	case DEFAULT:
	default:
	    ext = ".out";
	    break;
	}

	if (outfile == null && infile != null)
	    {
		int dot = infile.lastIndexOf('.');
		int slash = infile.lastIndexOf('/');
		// Last dot comes after last slash means that the file
		// has an extention.  Note that the base case where dot
		// or slash are -1 also work.
		if (dot <= slash)
		    outfile = infile + ext;
		else
		    outfile = infile.substring(0, dot) + ext;
	    }
    }
}
