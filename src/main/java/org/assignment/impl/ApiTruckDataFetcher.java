package org.assignment.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.assignment.entities.RequestType;
import org.assignment.exceptions.APIRequestException;
import org.assignment.exceptions.InvalidDataException;
import org.assignment.service.TruckDataFetcher;
import org.assignment.utils.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

/**
 * Makes a call to the Socrata API to get the truck data.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ApiTruckDataFetcher implements TruckDataFetcher {
	private static final Logger log = LoggerFactory.getLogger(ApiTruckDataFetcher.class);

	private String url;

	@Override
	public InputStream getTruckData() {
		RestClient restClient = RestClient.builder().url(this.url).requestType(RequestType.GET).build();
		try {
			return restClient.makeRequest();
		} catch (InvalidDataException e) {
			log.error("Invalid URL passed.");
			return null;
		} catch (APIRequestException e) {
			log.error("Could successfully complete the Socrata API request.");
			return null;
		}
	}
}
