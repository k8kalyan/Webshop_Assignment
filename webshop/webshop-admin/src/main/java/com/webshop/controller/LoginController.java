package com.webshop.controller;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.webshop.login.service.LoginManager;
import com.webshop.registration.model.UserEntity;
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
			return new ModelAndView(new RedirectView("login.action"));

		}
		else{
			user=loginmanager.getAuthenticted(username, password);

			if(user.equals("")){

				model.addAttribute("loginError", "Error In login,Please try again");

				return new ModelAndView(new RedirectView("login.action"));
			}
			session.setAttribute("loggedinUser", user);
			String authority=loginmanager.getRole(username);

			if(authority.equals("ROLE_ADMIN")){

				return new ModelAndView(new RedirectView("adminmain.action"));

			}
			return new ModelAndView(new RedirectView("adminhome.action"));

		}
	}
}