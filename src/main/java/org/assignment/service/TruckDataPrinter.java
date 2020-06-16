package org.assignment.service;

import org.assignment.entities.ShortTruckInfo;

import java.util.List;

public interface TruckDataPrinter {

	/**
	 * Prints the given list of Truck info in a suitalble format.
	 *
	 * @param truckInfoList The ShortTruckInfo list.
	 */
	void print(List<ShortTruckInfo> truckInfoList);

}
