package com.nzoudy;

public class InvalidUserIdFault extends InformationException{
	
	public InvalidUserIdFault(String reason, String errorDetails) {
		super(reason);
		this.errorDetails = errorDetails;
	}

}
