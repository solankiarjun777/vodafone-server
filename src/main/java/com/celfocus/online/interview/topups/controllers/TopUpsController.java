package com.celfocus.online.interview.topups.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.celfocus.online.interview.topups.dto.AccountHolder;
import com.celfocus.online.interview.topups.dto.Topup;
import com.celfocus.online.interview.topups.dto.TopupResponse;
import com.celfocus.online.interview.topups.util.JsonMapper;

/**
 * The class contains topup related rest web service over json
 * 
 * @author Arjun solanki
 *
 */

@Controller
@RequestMapping("/topups")
@CrossOrigin(origins = {"http://localhost:4200"})
public class TopUpsController {

	/**
	 * This method used to recharge mobile number.
	 * This accept as argument {@link Topup} and {@link HttpServletRequest}
	 * 
	 * @param topupDto - required information to recharge mobile number
	 * @param request - http servlet request object
	 * @return {@link TopupResponse} return conversionID and timestamp with errorMessage and code
	 */
	
	@RequestMapping(value = "/recharge", method = RequestMethod.POST)
	public ResponseEntity<TopupResponse> topupRecharge(
			@RequestBody Topup topupDto,HttpServletRequest request) {
		TopupResponse response = new TopupResponse();
		response.setConversionID(topupDto.getConversionID());
		response.setTimeStamp(topupDto.getTimeStamp());
		
		String subscriberNumber = JsonMapper.getAccountHolderAsMap().get(topupDto.getFinancialAccount()).getNumber();
	
		if( subscriberNumber == null || subscriberNumber.isEmpty()){
			response.setCode("Error");
			response.setErrorMessage("The selected account does not have mobile subscriptions. In order to proceed, Please select an account with mobile subscriptions");
			return new ResponseEntity<TopupResponse>(response, HttpStatus.OK);
		}
		String regex = "\\d+";
		String rechargeNum = topupDto.getPhoneNumber();
		if( !rechargeNum.matches(regex) || rechargeNum == null || rechargeNum.isEmpty() || rechargeNum.length() < 8){
			response.setCode("Error");
			response.setErrorMessage("Invalid mobile number");
			return new ResponseEntity<TopupResponse>(response, HttpStatus.OK);
		}
		response.setCode("Success");
		return new ResponseEntity<TopupResponse>(response, HttpStatus.OK);
	}
	/**
	 * This method provide list of account holder configured in system.
	 * @return list of {@link AccountHolder}} 
	 */
	
	@ResponseBody
	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	public ResponseEntity<List<AccountHolder>> getAccountList() {
		return new ResponseEntity<List<AccountHolder>>(JsonMapper.getAccountHolderAsList(), HttpStatus.OK);
		
	}

}
