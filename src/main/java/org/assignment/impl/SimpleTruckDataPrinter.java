package org.assignment.impl;

import net.je2sh.asciitable.JTable;
import org.apache.commons.lang3.StringUtils;
import org.assignment.entities.Constants;
import org.assignment.entities.ShortTruckInfo;
import org.assignment.service.TruckDataPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SimpleTruckDataPrinter implements TruckDataPrinter {
	private static final Logger log = LoggerFactory.getLogger(SimpleTruckDataPrinter.class);
	private static int itemsPerPage; //TODO: should this be here

	private static String headerOne;
	private static String headerTwo;
	private static int tableWidth;

	static {
		String property = System.getProperty(Constants.RuntimeProperty.ITEMS_PER_PAGE);
		itemsPerPage = StringUtils.isBlank(property) ? Constants.Defaults.ITEMS_PER_PAGE : Integer.parseInt(property);
		String[] tokens = Constants.Defaults.HEADERS.split(",");
		headerOne = tokens[0];
		headerTwo = tokens[1];

		// Attempt to read table width from vm arg.
		property = System.getProperty(Constants.RuntimeProperty.TABLE_WIDTH);
		tableWidth = StringUtils.isBlank(property) ? Constants.Defaults.TABLE_WIDTH : Integer.parseInt(property);
	}

	// @formatter:off
	@Override
	public void print(List<ShortTruckInfo> truckInfoList) {

		JTable jTable = JTable.of().width(tableWidth)			// https://jeeshell.github.io/asciitable/
									.row()
										.col().content(headerOne).done()
										.col().content(headerTwo).done()
									.done();
		truckInfoList.forEach(shortTruckInfo -> {
			jTable
				.row()
					.col().content(shortTruckInfo.getApplicant()).done()
					.col().content(shortTruckInfo.getLocation()).done()
				.done();
		});

		jTable.render().forEach(System.out::println);

	}
	// @formatter:on
}