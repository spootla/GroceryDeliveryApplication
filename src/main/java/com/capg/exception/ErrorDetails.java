package com.capg.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
	public ErrorDetails(Date date, String message2, String description) {
		// TODO Auto-generated constructor stub
		this.timestamp=date;
		this.message=message2;
		this.details=description;
	}
	private Date timestamp;
	private String message;
	private String details;

}
