package org.assignment.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Entity to build request params.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
public class RequestParameters {
	private static final Logger log = LoggerFactory.getLogger(RequestParameters.class);

	private String starttime;
	private String endtime;
	private String location;
	private String start24;
	private String end24;
	private String dayofweekstr;

}
