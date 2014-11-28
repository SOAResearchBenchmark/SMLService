package edu.sml.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(new File("WebContent/files/iris.csv")));
			StringBuilder builder = new StringBuilder();
			String line = "";
			while ((line = in.readLine()) != null) {
			    builder.append(line);
			    builder.append("\n");
			}
			in.close();
			String sourceData = builder.toString();
			request.setSourceData(sourceData);
			request.setClassIndex(4);
			request.setFileType("csv");
			J48Response response = service.classifyDataWithJ48(request);
			System.out.println(response.getResponseMessage());
			System.out.println(response.getTree());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
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
