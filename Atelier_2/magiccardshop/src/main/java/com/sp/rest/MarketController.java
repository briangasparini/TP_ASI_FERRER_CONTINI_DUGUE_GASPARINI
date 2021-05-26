package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sp.mapper.UserMapper;
import com.sp.model.dto.CardDTO;
import com.sp.model.dto.UserDTO;
import com.sp.service.CardService;
import com.sp.service.MarketService;
import com.sp.service.UserService;

@RestController
public class MarketController {
	
	@Autowired
    MarketService mService;
	
	@Autowired
    UserService uService;
	
	@Autowired
    CardService cService;
	
	@Autowired
	AuthController aController;
	    
    @RequestMapping(method=RequestMethod.POST,value="/buy")
    public Boolean buyCard(@RequestHeader("encoded-token") String encodedToken,
    					   @RequestBody ObjectNode objectNode) {
    	Integer userId = objectNode.get("userId").asInt();
    	UserDTO user = UserMapper.convertUserDto(uService.getUserById(userId));
    	Integer cardId =  objectNode.get("cardId").asInt();
    	CardDTO card = cService.getCard(cardId);
    	if (aController.checkToken(encodedToken)) {
            return mService.buyCard(user, card);
    	}
    	return false;
    }
    
    @RequestMapping(method=RequestMethod.POST,value="/sell")
    public Boolean sellCard(@RequestHeader("encoded-token") String encodedToken, 
    						@RequestBody ObjectNode objectNode) {
    	Integer userId = objectNode.get("userId").asInt();
    	UserDTO user = UserMapper.convertUserDto(uService.getUserById(userId));
    	Integer cardId =  objectNode.get("cardId").asInt();
    	CardDTO card = cService.getCard(cardId);
    	if (aController.checkToken(encodedToken)) {
            return mService.sellCard(user, card);
    	}
    	return false;
    }

}

