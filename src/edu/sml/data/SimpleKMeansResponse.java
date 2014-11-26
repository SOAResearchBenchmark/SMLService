package edu.sml.data;

public class SimpleKMeansResponse {

	public int numberOfClusters;
	public int[] clusterAssignments;
	public int statusCode;
	public String responseMessage;

	public int getNumberOfClusters() {
		return numberOfClusters;
	}

	public void setNumberOfClusters(int numberOfClusters) {
		this.numberOfClusters = numberOfClusters;
	}

	public int[] getClusterAssignments() {
		return clusterAssignments;
	}

	public void setClusterAssignments(int[] clusterAssignments) {
		this.clusterAssignments = clusterAssignments;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
