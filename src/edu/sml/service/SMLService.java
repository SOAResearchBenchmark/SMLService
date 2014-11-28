package edu.sml.service;

import java.io.File;
import java.io.IOException;

import weka.classifiers.trees.J48;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.CSVLoader;
import edu.sml.data.J48Request;
import edu.sml.data.J48Response;
import edu.sml.data.SimpleKMeansRequest;
import edu.sml.data.SimpleKMeansResponse;
import edu.sml.utils.FileUtils;

public class SMLService {
	
	//my paths
	//public static final String LOCAL_FILES_PATH = "WebContent/files/";
	//public static final String SERVER_FILES_PATH = "WebContent/files/";
	
	//ssrg paths
	public static final String LOCAL_FILES_PATH = "/var/lib/tomcat7/webapps/SMLService/files/";
	public static final String SERVER_FILES_PATH = "http://ssrg18.cs.ualberta.ca:8080/SMLService/files/";
	
	public SimpleKMeansResponse clusterDataWithSimpleKMeans(SimpleKMeansRequest request) {
		SimpleKMeans clusterer = new SimpleKMeans();
		SimpleKMeansResponse response = new SimpleKMeansResponse();
		String sourceData = request.getSourceData();
		String fileType = request.getFileType();
		int numOfClusters = request.getNumberOfClusters();
		String filePath = FileUtils.stringToFile(sourceData, fileType);
		Instances data = null;
		try {
			if(fileType.toLowerCase().equals("csv")) {
				CSVLoader loader = new CSVLoader();
				loader.setFile(new File(filePath));
				data = loader.getDataSet();
			}
			else if(fileType.toLowerCase().equals("arff")) {
				ArffLoader loader = new ArffLoader();
				loader.setFile(new File(filePath));
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
	
	public J48Response classifyDataWithJ48(J48Request request) {
		J48 classifier = new J48();
		J48Response response = new J48Response();
		try {
			String sourceData = request.getSourceData();
			int classIndex = request.getClassIndex();
			String fileType = request.getFileType();
			String filePath = FileUtils.stringToFile(sourceData, fileType);
			Instances data = null;
			if(fileType.toLowerCase().equals("csv")) {
				CSVLoader loader = new CSVLoader();
				loader.setFile(new File(filePath));
				data = loader.getDataSet();
			}
			else if(fileType.toLowerCase().equals("arff")) {
				ArffLoader loader = new ArffLoader();
				loader.setFile(new File(filePath));
				data = loader.getDataSet();
			}
			else {
				response.setStatusCode(-1);
				response.setResponseMessage("Incorrect file format.");
			}
			data.setClassIndex(classIndex);
			classifier.buildClassifier(data);
			response.setTree(classifier.graph());
			response.setStatusCode(0);
			response.setResponseMessage("Data classified successfully!");
		}
		catch(IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
