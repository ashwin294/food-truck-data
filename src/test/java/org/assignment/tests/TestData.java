package org.assignment.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assignment.entities.ExtendedTruckInfo;
import org.assignment.entities.TruckInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestData {
	private static final Logger log = LoggerFactory.getLogger(TestData.class);

	public static List<TruckInfo> prepareData() {
		List<TruckInfo> shortTruckInfoList = new ArrayList<>();
		List<ExtendedTruckInfo> extendedTruckInfoList = new ArrayList<>();
		try {
			InputStream testData = PrinterTest.class.getClassLoader().getResourceAsStream("test_data.json");
			extendedTruckInfoList = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(testData, new TypeReference<List<ExtendedTruckInfo>>() {
			});
		} catch (Exception e) {
			log.error("", e);
		}
		extendedTruckInfoList.forEach(apiResponseModel -> {
			shortTruckInfoList.add(TruckInfo.builder().applicant(apiResponseModel.getApplicant()).location(apiResponseModel.getLocation()).build());
		});
		return shortTruckInfoList;
	}

}
