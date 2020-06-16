package org.assignment.runner;

import org.apache.commons.lang3.StringUtils;
import org.assignment.entities.Constants;
import org.assignment.impl.ApiTruckDataFetcher;
import org.assignment.impl.JsonTruckDataReader;
import org.assignment.impl.SimpleTruckDataPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		String property = System.getProperty(Constants.RuntimeProperty.ITEMS_PER_PAGE);
		int itemsPerPage = StringUtils.isBlank(property) ? Constants.Defaults.ITEMS_PER_PAGE : Integer.parseInt(property);

		String jsonUrl = System.getProperty(Constants.RuntimeProperty.JSON_URL);
		String url = StringUtils.isBlank(jsonUrl) ? Constants.Defaults.JSON_URL : jsonUrl;

		Workflow.builder().maxItemsToPrint(itemsPerPage)
				.truckDataFetcher(ApiTruckDataFetcher.builder().url(url).build())
				.truckDataReader(JsonTruckDataReader.builder().build())
				.truckDataPrinter(SimpleTruckDataPrinter.builder().build())
				.build()
				.start();

	}

}
