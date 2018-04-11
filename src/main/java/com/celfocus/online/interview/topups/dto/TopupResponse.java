package com.celfocus.online.interview.topups.dto;

import java.time.LocalDateTime;

/**
 * This class represents response attribute for topup recharge web service
 * 
 * @author Arjun solanki
 *
 */
public class TopupResponse {

	/**
	 * unique conversion id for topup recharge
	 */
	private String conversionID;
	
	/**
	 * particular recharge transaction timestamp
	 */
	private LocalDateTime timeStamp;
	
	/**
	 *  topup recharge operation result code either "Success"/"Error"
	 */
	private String code;
	
	/**
	 *  topup recharge operation result error message
	 */
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
