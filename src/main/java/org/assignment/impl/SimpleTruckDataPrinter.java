package org.assignment.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import net.je2sh.asciitable.JTable;
import org.apache.commons.lang3.StringUtils;
import org.assignment.entities.Constants;
import org.assignment.entities.ShortTruckInfo;
import org.assignment.service.TruckDataPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Prints given list of Truck details to System.out
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class SimpleTruckDataPrinter implements TruckDataPrinter {
	private static final Logger log = LoggerFactory.getLogger(SimpleTruckDataPrinter.class);

	private static String headerOne;
	private static String headerTwo;
	private static int tableWidth;

	static {

		String[] tokens = Constants.Defaults.HEADERS.split(",");
		headerOne = tokens[0];
		headerTwo = tokens[1];

		// Attempt to read table width from vm arg.
		String property = System.getProperty(Constants.RuntimeProperty.TABLE_WIDTH);
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