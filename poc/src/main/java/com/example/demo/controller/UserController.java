package com.example.demo.controller;


import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.POCUser;
import com.example.demo.model.UserVO;
import com.example.demo.service.SecurityService;
import com.example.demo.service.UserService;
import com.example.demo.util.CustomUtility;
import com.example.demo.util.StringBufferEditor;
import com.example.demo.validator.UserValidator;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    private static final Logger logger = LogManager.getLogger(UserController.class);
   
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") @Valid UserVO userForm, BindingResult bindingResult, Model model) {
        //userValidator.validate(userForm, bindingResult);
    	logger.debug("Caaling registration for user: "+userForm.getUsername());

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        POCUser u=new POCUser();
        u.setUsername(userForm.getUsername());
        u.setPassword(CustomUtility.convertToString(userForm.getPassword()));
        u.setPasswordConfirm(CustomUtility.convertToString(userForm.getPasswordConfirm()));
        u.setTypeid(5);
        userService.save(u);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        
        logger.debug(" registration done for user: "+userForm.getUsername());
        
       // rabbitTemplate.convertAndSend("remoting.binding", "Hello  RabbitMQ! I have registered  ");

        return "redirect:/welcome";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
    	String[] allowedFields = { "username", "password","passwordConfirm"};
    	binder.setAllowedFields(allowedFields);
    	binder.addValidators(userValidator);
        binder.registerCustomEditor(null, "password",new StringBufferEditor());
        binder.registerCustomEditor(null, "passwordConfirm",new StringBufferEditor());
        
    }
}
