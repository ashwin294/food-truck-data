package org.assignment.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {
	private static final Logger log = LoggerFactory.getLogger(Constants.class);

	private Constants() {
	}

	public static class RuntimeProperty {
		public static final String JSON_URL = "JSON_URL";
		public static final String ITEMS_PER_PAGE = "ITEMS_PER_PAGE";
		public static final String TABLE_WIDTH = "TABLE_WIDTH";
	}

	public static class Defaults {
		public static final String JSON_URL = "https://data.sfgov.org/resource/jjew-r69b.json";
		public static final String HEADERS = "NAME,ADDRESS";
		public static final int ITEMS_PER_PAGE = 10;
		public static final int TABLE_WIDTH = 150 ;

	}

}
