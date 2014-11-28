package edu.sml.data;

public enum FileType {
	
	CSV("csv"), ARFF("arff");
	
	private String type;
	
	private FileType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
}
