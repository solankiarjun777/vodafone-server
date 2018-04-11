package com.celfocus.online.interview.topups.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.celfocus.online.interview.topups.dto.AccountHolder;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper {
	
	public static void main(String[] args) {
		getAccountHolderAsMap();
	}
	
	
	public static ArrayList<AccountHolder> getAccountHolderAsList(){
		ObjectMapper mapper = new ObjectMapper();
     
		try {
			
			String respath = "AccountHolder.json";
			AccountHolder[] accountHolderArray;
			InputStream in = JsonMapper.class.getResourceAsStream(respath);
			if ( in == null ){
				String accountHolder = "[{\"id\":\"12345\",\"name\":\"Arjun's Family\",\"number\":\"9737363736\"},{\"id\":\"54321\",\"name\":\"Uday's Family\",\"number\":\"\"}]";
				accountHolderArray = mapper.readValue(accountHolder, AccountHolder[].class);
			}else{
				accountHolderArray = mapper.readValue(in, AccountHolder[].class);
			}

			return new ArrayList<AccountHolder>(Arrays.asList(accountHolderArray));
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public static HashMap<String,AccountHolder> getAccountHolderAsMap(){
			HashMap<String,AccountHolder> accountMap = new HashMap<String,AccountHolder>();
			for(AccountHolder obj : getAccountHolderAsList()){
				accountMap.put(obj.getId(), obj);
			}
			return accountMap;
	}

}
