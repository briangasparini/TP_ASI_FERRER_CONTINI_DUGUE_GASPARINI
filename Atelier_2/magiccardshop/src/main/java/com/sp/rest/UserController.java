package com.sp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.dto.CardDTO;
import com.sp.model.dto.UserDTO;
import com.sp.service.UserService;

@RestController
public class UserController {
	
	@Autowired
    UserService uService;
	
	@Autowired
	AuthController aController;
	
	@RequestMapping(method=RequestMethod.POST,value="/users")
    public void addUser(@RequestBody UserDTO User) {
        uService.addUser(User);
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/users/{id}")
    public UserDTO getUser(@PathVariable String id) {
        UserDTO u=uService.getUserDto(Integer.valueOf(id));
        if(u != null) {
        	return u;
        }
        return null;
    }
    
    @RequestMapping(method=RequestMethod.POST,value="/users/{id}/cards")
    public List<CardDTO> getCards(@RequestHeader("encoded-token") String encodedToken, 
    						      @RequestParam int userId) {
    	if (aController.checkToken(encodedToken)) {
            return uService.getCards(userId);
    	}
    	return null;
    }
    
    

}

