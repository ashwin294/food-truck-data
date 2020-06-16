package org.assignment.runner;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.assignment.entities.RequestType;
import org.assignment.service.TruckDataReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
public class Workflow {
	private static final Logger log = LoggerFactory.getLogger(Workflow.class);

	private TruckDataReader truckDataReader;
	private String dataSourceURL;
	private RequestType requestType;

}
