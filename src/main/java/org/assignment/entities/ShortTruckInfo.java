package org.assignment.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
public class ShortTruckInfo implements Comparable<ShortTruckInfo> {
	private static final Logger log = LoggerFactory.getLogger(ShortTruckInfo.class);

	@JsonProperty("location")
	public String location;
	@JsonProperty("applicant")
	public String applicant;

	@Override
	public int compareTo(ShortTruckInfo that) {
		if (that == null) return -1;    //To have this earlier in the sort order.
		return this.applicant.compareTo(that.applicant);
	}
}
