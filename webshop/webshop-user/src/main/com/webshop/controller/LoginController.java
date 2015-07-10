package com.webshop.controller;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.webshop.login.service.LoginManager;
import com.webshop.registration.model.ProductCategories;
import com.webshop.registration.model.UserEntity;
import com.webshop.registration.service.ProductCategoryManager;
import com.webshop.registration.constants.WebshopConstants;
/**
 * Login controller class  provides implementations for login user. 
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
public class LoginController {

	@Autowired
	LoginManager loginmanager;
	
	@Autowired
	ProductCategoryManager productCategoryManager;
	
	
	@RequestMapping("login.action")
	public String showLoginForm(){
		return "login";
	}
	@RequestMapping("adminhome.action")
	public String showUserpage(){
		return "admin/adminhome";
	}


	@RequestMapping("loginuser.action")
	public ModelAndView getAuthenticated(@RequestParam String username,@RequestParam String password,HttpSession session,Model model){

		UserEntity user;
		if(username.equals("") || password.equals("")){
			return new ModelAndView(new RedirectView(WebshopConstants.Logging_action));

		}
		else{
			user=loginmanager.getAuthenticted(username, password);

			if(user.equals("")){

				model.addAttribute(WebshopConstants.Logging_Error, WebshopConstants.ErrorMsg);

				return new ModelAndView(new RedirectView(WebshopConstants.Logging_action));
			}
			session.setAttribute(WebshopConstants.Logged_User, user);
			String authority=loginmanager.getRole(username);

			if(authority.equals(WebshopConstants.ROLE_USER)){
				List<ProductCategories> productCategoriesList=productCategoryManager.getProductCategoriesList();

				return new ModelAndView(WebshopConstants.Admin_Home , WebshopConstants.Product_CategoryList, productCategoriesList);
			

			}
			
			return new ModelAndView(new RedirectView(WebshopConstants.Adminmain_action));
		}
	}
}