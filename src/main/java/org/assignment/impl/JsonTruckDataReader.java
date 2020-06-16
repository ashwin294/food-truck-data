package org.assignment.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.assignment.entities.APIResponseModel;
import org.assignment.service.TruckDataReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

/**
 * Parses given InputStream of JSON formatted truck data.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class JsonTruckDataReader implements TruckDataReader {
	private static final Logger log = LoggerFactory.getLogger(JsonTruckDataReader.class);

	@Override
	public List<APIResponseModel> readData(InputStream inputStream) {
		try {
			return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(inputStream, new TypeReference<List<APIResponseModel>>() {
			});
		} catch (IOException e) {
			log.error("Could not read data from the InputStream due to " + e.getMessage());
			log.debug("Could not read data from the InputStream.", e);
			return Collections.emptyList();
		}
	}

	/**
	 * Convenience method to use String object.
	 *
	 * @param inputString String containing the JSON data.
	 * @return List of APIResponse objects.
	 */
	public List<APIResponseModel> readData(String inputString) {
		return readData(new ByteArrayInputStream(inputString.getBytes(StandardCharsets.UTF_8)));
	}

	/**
	 * Convenience method to use File object.
	 *
	 * @param inputFile File containing the JSON data.
	 * @return List of APIResponse objects.
	 * @throws FileNotFoundException
	 */
	public List<APIResponseModel> readData(File inputFile) throws FileNotFoundException {
		return readData(new FileInputStream(inputFile));
	}
}
