package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.dto.CardDTO;
import com.sp.model.dto.UserDTO;
import com.sp.service.MarketService;

@RestController
public class MarketController {
	
	@Autowired
    MarketService mService;
	
	@Autowired
	AuthController aController;
	    
    @RequestMapping(method=RequestMethod.POST,value="/buy")
    public Boolean buyCard(@RequestHeader("encoded-token") String encodedToken,
    							@RequestBody UserDTO user, CardDTO card) {
    	if (aController.checkToken(encodedToken)) {
            return mService.buyCard(user, card);
    	}
    	return false;
    }
    
    @RequestMapping(method=RequestMethod.POST,value="/sell")
    public Boolean sellCard(@RequestHeader("encoded-token") String encodedToken, 
    						@RequestBody UserDTO user, CardDTO card) {
    	if (aController.checkToken(encodedToken)) {
            return mService.sellCard(user, card);
    	}
    	return false;
    }

}

