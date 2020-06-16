package org.assignment.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assignment.entities.APIResponseModel;
import org.assignment.entities.ShortTruckInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestData {
	private static final Logger log = LoggerFactory.getLogger(TestData.class);

	public static List<ShortTruckInfo> prepareData() {
		List<ShortTruckInfo> shortTruckInfoList = new ArrayList<>();
		List<APIResponseModel> apiResponseModelList = new ArrayList<>();
		try {
			InputStream testData = PrinterTest.class.getClassLoader().getResourceAsStream("test_data.json");
			apiResponseModelList = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(testData, new TypeReference<List<APIResponseModel>>() {
			});
		} catch (Exception e) {
			log.error("", e);
		}
		apiResponseModelList.forEach(apiResponseModel -> {
			shortTruckInfoList.add(ShortTruckInfo.builder().applicant(apiResponseModel.getApplicant()).location(apiResponseModel.getLocation()).build());
		});
		return shortTruckInfoList;
	}

}
