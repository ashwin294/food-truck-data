package org.assignment.runner;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.assignment.entities.APIResponseModel;
import org.assignment.entities.ShortTruckInfo;
import org.assignment.service.TruckDataFetcher;
import org.assignment.service.TruckDataPrinter;
import org.assignment.service.TruckDataReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
public class Workflow {
	private static final Logger log = LoggerFactory.getLogger(Workflow.class);

	private TruckDataFetcher truckDataFetcher;
	private TruckDataReader truckDataReader;
	private TruckDataPrinter truckDataPrinter;
	private int maxItemsToPrint;

	public void start() {

		// Get Truck data from datasource.
		InputStream truckDataStream = truckDataFetcher.getTruckData();

		// Parse data from the raw input.
		List<APIResponseModel> apiResponseModelList = truckDataReader.readData(truckDataStream);

		List<ShortTruckInfo> shortTruckInfoList = new ArrayList<>();

		// Begin paginating truck details..
		int count = 0;
		for (APIResponseModel apiResponseModel : apiResponseModelList) {
			shortTruckInfoList.add(ShortTruckInfo.builder().location(apiResponseModel.getLocation()).applicant(apiResponseModel.getApplicant()).build());
			count++;
			if (count % maxItemsToPrint == 0) {
				log.info("Displaying truck details {} - {} of {}. Press [Enter] key to display next set of items..", count - maxItemsToPrint + 1, count, apiResponseModelList.size());
				truckDataPrinter.print(shortTruckInfoList);
				waitForUserInput();
				shortTruckInfoList.clear();
			}
		}

		if (!shortTruckInfoList.isEmpty()) {
			log.info("Displaying truck details {} - {} of {}. Press [Enter] key to display next set of items..", count - shortTruckInfoList.size(), count, apiResponseModelList.size());
			truckDataPrinter.print(shortTruckInfoList);
		}

		log.info("No more truck details left to display.");

	}

	private void waitForUserInput() {
		new Scanner(System.in).nextLine();
	}

}
