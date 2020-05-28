package row;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

//https://projectlombok.org
//https://projectlombok.org/api/lombok/AllArgsConstructor.html
//https://projectlombok.org/api/lombok/Data.html

@AllArgsConstructor
public @Data class Row {
	
	private Date date;
	private String startHour;
	private String endHour;
	private String order;
	private String note;
}
