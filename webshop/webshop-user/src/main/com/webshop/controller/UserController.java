package com.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import com.webshop.model.UserEntity;
import com.registration.service.UserManager;
/**
 * UserController class will get all the Registrationform details. 
 * <P>
 * <B> Visibility decisions: </B>
 * <P>
 * Unless otherwise noted, attributes are private, and a public getter and
 * setter is provided for each.
 * <P>
 * <B> Design/implementation notes: </B>
 * <P>
 * Document any decisions, assumptions, issues, or other notes regarding the
 * implementation of this class.
 * <P>
 * <P>
 * <B> Revision History: </B>
 * 
 * <PRE>
 * 
 * =============================================================================
 * Prior Date            By                  Version  Project/CSR  Description 
 * ---------- --------------------------   ---------- ------------ ------------ 
 * 18/06/2015         kalyan             N/A          webshop        Created.
 * 
 * =============================================================================
 * 
 * </PRE>
 */


@Controller
public class UserController {
	@Autowired
	UserManager manager;
	@RequestMapping("newuser.action")
	public String addUserForm(@ModelAttribute("user") UserEntity user){

		return "registration/registration";
	}
	@RequestMapping("register.action")
	public String SubmitForm(@ModelAttribute("user") UserEntity user, BindingResult result,SessionStatus status){

		manager.addUser(user);

		status.setComplete();
		return "registration/home";

	}

}
