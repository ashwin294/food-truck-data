package org.assignment.utils;

import org.apache.commons.lang3.StringUtils;
import org.assignment.entities.RequestParameters;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.DayOfWeek;

public class GenericUtils {
	private static final Logger log = LoggerFactory.getLogger(GenericUtils.class);

	private GenericUtils() {
	}

	/**
	 * Generates a request param string from the given RequestParameters.
	 *
	 * @param requestParameters The request params.
	 * @return Request parameters string.
	 */
	public static String getRequestParamString(RequestParameters requestParameters) {
		StringBuilder urlBuilder = new StringBuilder("");

		if (!StringUtils.isBlank(requestParameters.getStarttime())) urlBuilder.append("&starttime=" + requestParameters.getStarttime());
		if (!StringUtils.isBlank(requestParameters.getEndtime())) urlBuilder.append("&endtime=" + requestParameters.getEndtime());

		if (!StringUtils.isBlank(requestParameters.getStart24())) urlBuilder.append("&start24=" + requestParameters.getStart24());
		if (!StringUtils.isBlank(requestParameters.getEnd24())) urlBuilder.append("&end24=" + requestParameters.getEnd24());

		if (!StringUtils.isBlank(requestParameters.getLocation())) urlBuilder.append("&location=" + requestParameters.getLocation());
		if (!StringUtils.isBlank(requestParameters.getDayofweekstr())) urlBuilder.append("&dayofweekstr=" + requestParameters.getDayofweekstr());

		// Ensure request param string format.
		if (urlBuilder.charAt(0) == '&') urlBuilder.deleteCharAt(0);

		return urlBuilder.toString();

	}

	/**
	 * @return The current hour in 24 hour format - {15:00}
	 */
	public static String getCurrentHourString() {
		return new DateTime().getHourOfDay() + ":00";
	}

	/**
	 * @param dateTime The DateTime
	 * @return If its AM or PM from the given DateTime.
	 */
	public static boolean isAM(DateTime dateTime) {
		return dateTime.getHourOfDay() < 12;
	}

	/**
	 * @return Returns the Day of the Week with the first char in uppercase and the rest in lowercase .
	 */
	public static String getCurrentDay() {
		return StringUtils.capitalize(DayOfWeek.of(new DateTime().getDayOfWeek()).toString().toLowerCase());
	}

}


