package edu.sml.data;

public class SimpleKMeansRequest {
	
	public String sourceQualifiedName;
	public int numberOfClusters;

	public int getNumberOfClusters() {
		return numberOfClusters;
	}

	public void setNumberOfClusters(int numberOfClusters) {
		this.numberOfClusters = numberOfClusters;
	}

	public String getSourceQualifiedName() {
		return sourceQualifiedName;
	}

	public void setSourceQualifiedName(String sourceQualifiedName) {
		this.sourceQualifiedName = sourceQualifiedName;
	}
	
	

}
