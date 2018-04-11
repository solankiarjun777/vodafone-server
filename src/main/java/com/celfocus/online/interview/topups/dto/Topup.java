package com.celfocus.online.interview.topups.dto;

import java.time.LocalDateTime;

public class Topup extends TopupResponse {

    private String conversionID;
    private String financialAccount;
    private String phoneNumber;
    private LocalDateTime timeStamp;
    private boolean termsAndConditionResult;
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
