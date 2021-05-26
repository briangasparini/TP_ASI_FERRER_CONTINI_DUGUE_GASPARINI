package com.sp.rest;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sp.model.User;
import com.sp.service.UserService;

@RestController
public class AuthController {
	
	@Autowired
    UserService uService;
	
    @RequestMapping(method=RequestMethod.POST,value="/login")
    public String connectUser(@RequestBody ObjectNode objectNode) {
    	String login = objectNode.get("login").asText();
    	String hashedPassword = objectNode.get("password").asText();
    	
    	return uService.connectUser(login, hashedPassword);
    }
    
    @RequestMapping(method=RequestMethod.POST,value="/logout")
    public String disconnectUser() {
        return uService.disconnectUser();
    }
    
    public boolean checkToken(String encodedToken) {
    	byte[] decodedBytes = Base64.getDecoder().decode(encodedToken);
    	String decodedString = new String(decodedBytes);
    	String[] parts = decodedString.split("/");
    	int userId = Integer.parseInt(parts[2]);
    	User u = uService.getUserById(Integer.valueOf(userId));
    	if(u.getPassword().equals(parts[1]) && u.getLogin().equals(parts[0])) {
    		return true;
    	}
    	return false;
    }
}

