package org.assignment.service;

import java.io.InputStream;

/**
 * Gets raw data from a Truck Data Source.
 */
public interface TruckDataFetcher {

	/**
	 * @return Returns a string containing the food truck data.
	 */
	InputStream getTruckData();

}
