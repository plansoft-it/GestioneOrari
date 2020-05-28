package row;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class Row {
	
	private Date date;
	private String startHour;
	private String endHour;
	private String order;
	private String note;
}
