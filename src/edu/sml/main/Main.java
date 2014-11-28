package edu.sml.main;

import java.io.File;
import java.io.IOException;

import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.CSVLoader;
import edu.sml.data.J48Request;
import edu.sml.data.J48Response;
import edu.sml.data.SimpleKMeansRequest;
import edu.sml.data.SimpleKMeansResponse;
import edu.sml.service.SMLService;

public class Main {

	public static void main(String[] args) {
		SMLService service = new SMLService();
		J48Request request = new J48Request();
		request.setSourceData("WebContent/files/iris.csv");
		request.setClassIndex(4);
		J48Response response = service.classifyDataWithJ48(request);
		System.out.println(response.getResponseMessage());
		System.out.println(response.getTree());
	}
	

	private static void clusterWithSimpleKMeans() {
		SMLService service = new SMLService();
		SimpleKMeansRequest request = new SimpleKMeansRequest();
		request.setNumberOfClusters(3);
		request.setSourceData("WebContent/files/iris.csv");
		SimpleKMeansResponse response = service.clusterDataWithSimpleKMeans(request);
		System.out.println(response.getResponseMessage());
	}

}
