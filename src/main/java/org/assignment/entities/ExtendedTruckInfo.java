package org.assignment.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtendedTruckInfo extends TruckInfo {

	@JsonProperty("dayorder")
	public String dayorder;
	@JsonProperty("dayofweekstr")
	public String dayofweekstr;
	@JsonProperty("starttime")
	public String starttime;
	@JsonProperty("endtime")
	public String endtime;
	@JsonProperty("permit")
	public String permit;
	@JsonProperty("locationdesc")
	public String locationdesc;
	@JsonProperty("optionaltext")
	public String optionaltext;
	@JsonProperty("locationid")
	public String locationid;
	@JsonProperty("start24")
	public String start24;
	@JsonProperty("end24")
	public String end24;

}