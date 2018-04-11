package com.celfocus.online.interview.topups.dto;

import java.time.LocalDateTime;

/**
 * This class represents information required to topup recharge
 * 
 * @author Arjun solanki
 *
 */
public class Topup extends TopupResponse {

	/**
	 *  unique conversion id for topup recharge
	 */
	private String conversionID;
	/**
	 *  unique id associated with account holder
	 */
	private String financialAccount;
	/**
	 *  Mobile number that need to be recharge
	 */
	private String phoneNumber;
	/**
	 * particular recharge transaction timestamp
	 */
	private LocalDateTime timeStamp;
	/**
	 * term and condition checkbox value, that user has to agree upon
	 */
	private boolean termsAndConditionResult;
	/**
	 * recharge amount value 
	 */
	private String amount;

	public String getConversionID() {
		return conversionID;
	}

	public void setConversionID(String conversionID) {
		this.conversionID = conversionID;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public boolean isTermsAndConditionResult() {
		return termsAndConditionResult;
	}

	public void setTermsAndConditionResult(boolean termsAndConditionResult) {
		this.termsAndConditionResult = termsAndConditionResult;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getFinancialAccount() {
		return financialAccount;
	}

	public void setFinancialAccount(String financialAccount) {
		this.financialAccount = financialAccount;
	}

}
