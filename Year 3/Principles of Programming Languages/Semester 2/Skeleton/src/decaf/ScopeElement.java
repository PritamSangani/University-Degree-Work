package decaf;

public class ScopeElement {
	private String name;
	private int type;
	private int line;
	private int[] ptypes = null;
	private int size = -1;

	// for a normal variable
	public ScopeElement(String name, int type, int line) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.type = type;
		this.line = line;
	}
	
	// for an array variable
	public ScopeElement(String name, int type, int line, int size) {
		this.name = name;
		this.type = type;
		this.line = line;
		this.size = size;
		if (size <= 0)
			System.err.println("Error line " + line
					+ ": array \"" + name + "\" should have size > 0");
	}

	// For a method declaration
	public ScopeElement(String name, int type, int line, int[] ptypes) {
		this.name = name;
		this.type = type;
		this.line = line;
		
		if (ptypes == null || ptypes.length == 0) {
			this.ptypes = null;
		} else {
			int n = ptypes.length;
			this.ptypes = new int[n];
			for (int i = 0; i < n; i++)
				this.ptypes[i] = ptypes[i];
		}
	}
	
	public int getLine() {
		return line;
	}
	
	public int getType() {
		return type;
	}
	
	public int[] getTypes() {
		return ptypes;
	}
	
	public int getSize() {
		return size;
	}
}


