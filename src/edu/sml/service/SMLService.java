package edu.sml.service;

import java.io.File;
import java.io.IOException;

import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.CSVLoader;
import edu.sml.data.SimpleKMeansRequest;
import edu.sml.data.SimpleKMeansResponse;

public class SMLService {
	
	//my paths
	//public static final String LOCAL_FILES_PATH = "WebContent/files/";
	//public static final String SERVER_FILES_PATH = "WebContent/files/";
	
	//ssrg paths
	public static final String LOCAL_FILES_PATH = "/var/lib/tomcat7/webapps/SMLService/files/";
	public static final String SERVER_FILES_PATH = "http://ssrg18.cs.ualberta.ca:8080/SMLService/files/";
	
	public String getFilesPath() {
		return LOCAL_FILES_PATH;
	}
	
	public SimpleKMeansResponse clusterDataWithSimpleKMeans(SimpleKMeansRequest request) {
		SimpleKMeans clusterer = new SimpleKMeans();
		SimpleKMeansResponse response = new SimpleKMeansResponse();
		String inputFile = request.getSourceQualifiedName();
		int numOfClusters = request.getNumberOfClusters();
		Instances data = null;
		try {
			if(inputFile.endsWith(".csv")) {
				CSVLoader loader = new CSVLoader();
				loader.setFile(new File(inputFile));
				data = loader.getDataSet();
			}
			else if(inputFile.endsWith(".arff")) {
				ArffLoader loader = new ArffLoader();
				loader.setFile(new File(inputFile));
				data = loader.getDataSet();
			}
			else {
				response.setStatusCode(-1);
				response.setResponseMessage("Incorrect file format.");
			}
			clusterer.setNumClusters(numOfClusters);
			clusterer.setPreserveInstancesOrder(true);
			clusterer.buildClusterer(data);
			response.setClusterAssignments(clusterer.getAssignments());
			response.setNumberOfClusters(numOfClusters);
			response.setStatusCode(0);
			response.setResponseMessage("Data clustered successfully!");
		}
		catch(IOException e) {
			response.setStatusCode(-1);
			response.setResponseMessage(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			response.setStatusCode(-1);
			response.setResponseMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

}
