package com.example.demo.validator;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.demo.model.UserVO;
import com.example.demo.service.UserService;
import com.example.demo.util.CustomUtility;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;
    
    private static final Logger logger =  LogManager.getLogger(UserValidator.class);

    @Override
    public boolean supports(Class<?> aClass) {
        return UserVO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	UserVO user = (UserVO) o;
    	
    	logger.debug("Vadidation for registation starts");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (CustomUtility.convertToString(user.getPassword()).length() < 8 || CustomUtility.convertToString(user.getPassword()).length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!CustomUtility.convertToString(user.getPasswordConfirm()).equals(CustomUtility.convertToString(user.getPassword()))) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
        
        logger.debug("Vadidation for registation Ends");
    }
}
