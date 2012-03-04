/**
 * If you really care for the license, look for the LICENSE.txt at the project root. Frankly, I 
 * really don't care.
 **/
package com.example.starter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.starter.entity.User;
import com.example.starter.service.UserService;

/**
 * This controller facilitates actions related to general user welcome and admin welcome pages.
 * 
 * @author Roshan Amadoru
 **/
@Controller
public class WelcomeController {

    /**
     * The logger instance
     **/
    private static Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    /**
     * The instance of userDetailsService injected with Spring
     **/
    @Autowired
    UserService userDetailsService;
    
    /**
     * Handles requests to the /welcome.do page
     **/
    @RequestMapping(method = RequestMethod.GET, value = { "welcome" })
    public String showWelcomePage(Model model) {
        logger.debug("Page Request: /welcome.do");
        User user = userDetailsService.getCurrentUser();
        model.addAttribute("name", user.getFirstName() + " " + user.getLastName());
        return "user.welcome";
    }
    
    /**
     * Handles requests to the /admin/welcome.do page
     **/
    @RequestMapping(method = RequestMethod.GET, value = { "admin/welcome" })
    public String showAdminWelcomePage(Model model) {
        logger.debug("Page Request: /admin/welcome.do");
        User user = userDetailsService.getCurrentUser();
        model.addAttribute("name", user.getFirstName() + " " + user.getLastName());
        return "admin.welcome";
    }
}