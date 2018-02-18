package com.nzoudy;

public class InvalidInputException extends InformationException {

	public InvalidInputException(String reason, String errorDetails){
		super(reason);
		this.errorDetails = errorDetails;
	}
	
}
