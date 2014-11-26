package edu.sml.main;

import edu.sml.data.SimpleKMeansRequest;
import edu.sml.data.SimpleKMeansResponse;
import edu.sml.service.SMLService;

public class Main {

	public static void main(String[] args) {
		SMLService service = new SMLService();
		String filesPath = service.getFilesPath();
		SimpleKMeansRequest request = new SimpleKMeansRequest();
		request.setNumberOfClusters(3);
		request.setSourceQualifiedName("WebContent/files/iris.csv");
		SimpleKMeansResponse response = service.clusterDataWithSimpleKMeans(request);
		System.out.println(response.getResponseMessage());
	}

}
