package com.sp.rest;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.User;
import com.sp.service.UserService;

@RestController
public class AuthController {
	
	@Autowired
    UserService uService;
	
    @RequestMapping(method=RequestMethod.POST,value="/login")
    public String connectUser(@RequestBody String login, String hashedPassword) {
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
    	User u = uService.getUser(Integer.valueOf(userId));
    	if(u.getPassword() == parts[1] && u.getLogin() == parts[0]) {
    		return true;
    	}
    	return false;
    }
}

