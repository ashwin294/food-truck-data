package org.assignment.service;

import org.assignment.entities.TruckInfo;

import java.util.List;

/**
 * Prints Truck data in a suitable format.
 */
public interface TruckDataPrinter {

	/**
	 * Prints the given list of Truck info in a suitalble format.
	 *
	 * @param truckInfoList The ShortTruckInfo list.
	 */
	void print(List<TruckInfo> truckInfoList);

}
