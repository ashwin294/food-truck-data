package org.assignment.tests;

import org.assignment.entities.APIResponseModel;
import org.assignment.impl.JsonTruckDataReader;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;

public class DataReaderTest {
	private static final Logger log = LoggerFactory.getLogger(DataReaderTest.class);

	@Test
	public void testDataReader() {
		InputStream testData = PrinterTest.class.getClassLoader().getResourceAsStream("test_data.json");
		List<APIResponseModel> apiResponseModels = new JsonTruckDataReader().readData(testData);
		log.info("Response has {} truck details.", apiResponseModels.size());
		Assert.assertTrue(apiResponseModels != null && !apiResponseModels.isEmpty());
	}

}
