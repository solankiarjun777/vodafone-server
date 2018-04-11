package com.celfocus.online.interview.topups.dto;

import java.time.LocalDateTime;

public class TopupResponse {
	
	 	private String conversionID;
	    private LocalDateTime timeStamp;
	    private String code;
	    private String errorMessage;
		public String getConversionID() {
			return conversionID;
		}
		public void setConversionID(String conversionID) {
			this.conversionID = conversionID;
		}
		public LocalDateTime getTimeStamp() {
			return timeStamp;
		}
		public void setTimeStamp(LocalDateTime timeStamp) {
			this.timeStamp = timeStamp;
		}
		
		public String getErrorMessage() {
			return errorMessage;
		}
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}

}
