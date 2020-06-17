package org.assignment.tests;

import org.assignment.entities.TruckInfo;
import org.assignment.impl.SimpleTruckDataPrinter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PrinterTest {
	private static final Logger log = LoggerFactory.getLogger(PrinterTest.class);

	private static final List<TruckInfo> shortTruckInfoList = new TestData().prepareData();

	@Test
	public void testTruckDtaPrinter() {	// Print test
		new SimpleTruckDataPrinter().print(shortTruckInfoList);
	}

}
