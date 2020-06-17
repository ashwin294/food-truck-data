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

/**
 * The core user workflow.
 * 1. Gets raw truck data from datasource using TruckDataFetcher.
 * 2. Converts raw truck data to object format using TruckDataReader.
 * 3. Prints formatted & paginated data using TruckDataPrinter while waiting for user to press [Enter] key before moving to next page.
 */
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

	/**
	 * Starts the workflow.
	 */
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
			log.info("Displaying truck details {} - {} of {}.", count - shortTruckInfoList.size() + 1, count, apiResponseModelList.size());
			truckDataPrinter.print(shortTruckInfoList);
		}

		log.info("No more truck details left to display. Exiting workflow.\n");

	}

	/**
	 * Waits for user to press [Enter] key.
	 */
	private void waitForUserInput() {
		new Scanner(System.in).nextLine();
	}

}
