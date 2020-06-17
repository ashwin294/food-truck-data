package org.assignment.service;

import org.assignment.entities.TruckInfo;

import java.io.InputStream;
import java.util.List;

/**
 * Interface to parse Food Truck Data and produce TruckInfo.
 */
public interface TruckDataReader {

	/**
	 * Read from source and generate a list of APIResponse objects.
	 *
	 * @param inputStream InputStream to the source data.
	 * @return A list of APIResponse objects read from the InputStream, empty list in case of failures or if no data present.
	 */
	List<TruckInfo> readData(InputStream inputStream);

}
