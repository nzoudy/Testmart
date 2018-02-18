package com.nzoudy;

public class InformationException extends Exception {
	
	protected String errorDetails;
	
	public InformationException(String reason){
		super(reason);
	}
	
	public String getFaultInfo() {
		return errorDetails;
	}

}
