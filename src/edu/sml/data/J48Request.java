package edu.sml.data;

public class J48Request {

	private String sourceData;
	private FileType fileType;
	private int classIndex;

	public String getSourceData() {
		return sourceData;
	}

	public void setSourceData(String sourceData) {
		this.sourceData = sourceData;
	}

	public int getClassIndex() {
		return classIndex;
	}

	public void setClassIndex(int classIndex) {
		this.classIndex = classIndex;
	}

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}
	
	
	
}
