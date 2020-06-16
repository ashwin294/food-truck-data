package org.assignment.runner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assignment.entities.APIResponseModel;
import org.assignment.entities.ShortTruckInfo;
import org.assignment.impl.SimpleTruckDataPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
	private static final Logger log = LoggerFactory.getLogger(TestRunner.class);

	public TestRunner() {
	}

	public static void main(String[] args) {
		try {
			StringBuilder result = new StringBuilder();
//			URL url = new URL("http://data.sfgov.org/resource/bbb8-hzi6.xml?starttime=10AM&dayofweekstr=Monday");
			URL url = new URL("https://data.sfgov.org/resource/jjew-r69b.json");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
//			List<APIResponseModel> apiResponseModelList = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(conn.getInputStream(), new TypeReference<List<APIResponseModel>>() {
//			});

//			List<ShortTruckInfo> shortTruckInfoList = new ArrayList<>();
//			apiResponseModelList.forEach(apiResponseModel -> {
//				shortTruckInfoList.add(ShortTruckInfo.builder().applicant(apiResponseModel.getApplicant()).location(apiResponseModel.getLocation()).build());
//			});
//
//			new SimpleTruckDataPrinter().print(shortTruckInfoList);

			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			rd.close();
			log.info(result.toString());


//			log.info("Response: {}", apiResponseModelList);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

}
