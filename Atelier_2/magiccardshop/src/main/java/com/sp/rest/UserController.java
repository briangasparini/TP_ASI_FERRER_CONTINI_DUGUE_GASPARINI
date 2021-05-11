package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.Card;
import com.sp.model.User;
import com.sp.service.UserService;

@RestController
public class UserController {
	
	@Autowired
    UserService uService;

	@RequestMapping(method=RequestMethod.POST,value="/user")
    public void addUser(@RequestBody User User) {
        uService.addUser(User);
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/user/{id}")
    public User getUser(@PathVariable String id) {
        User u=uService.getUser(Integer.valueOf(id));
        if(u != null) {
        	u.setConnected(true);
        	return u;
        }
        return null;
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/user-connection")
    public void connectUser(@RequestBody String login, String password) {
        uService.connectUser(login, password);
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/card-paiement")
    public Boolean cardPaiement(@RequestBody User user, Card card) {
    	if (isUserConnected(user.getId())) {
            return uService.cardPaiement(user, card);
    	}
    	return false;
    }
    
    @RequestMapping(method=RequestMethod.POST,value="/sell-paiement")
    public Boolean sellCard(@RequestBody User user, Card card) {
    	if (isUserConnected(user.getId())) {
            return uService.sellCard(user, card);
    	}
    	return false;
    }
    
    // Permet de s'assurer que l'user est connecté
    public Boolean isUserConnected(int id) {
		return uService.getUser(Integer.valueOf(id)).isConnected();
    }

}

