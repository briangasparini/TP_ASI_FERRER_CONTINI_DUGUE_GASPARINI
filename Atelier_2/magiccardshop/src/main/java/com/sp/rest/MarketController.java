package com.sp.rest;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.Card;
import com.sp.model.User;
import com.sp.service.MarketService;
import com.sp.service.UserService;

@RestController
public class MarketController {
	
	@Autowired
    MarketService mService;
	
	@Autowired
	AuthController aController;
	    
    @RequestMapping(method=RequestMethod.POST,value="/buy")
    public Boolean buyCard(@RequestHeader("encoded-token") String encodedToken,
    							@RequestBody User user, Card card) {
    	if (aController.checkToken(encodedToken)) {
            return mService.buyCard(user, card);
    	}
    	return false;
    }
    
    @RequestMapping(method=RequestMethod.POST,value="/sell")
    public Boolean sellCard(@RequestHeader("encoded-token") String encodedToken, 
    						@RequestBody User user, Card card) {
    	if (aController.checkToken(encodedToken)) {
            return mService.sellCard(user, card);
    	}
    	return false;
    }

}

