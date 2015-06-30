package com.webshop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.webshop.registration.model.OrderEntity;
import com.webshop.registration.service.OrderManager;

/**
 * OrderController prepares the order entity object with price, product and quantity information. 
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
public class OrderController {
	@Autowired
	OrderManager manager;
	@RequestMapping(value = "order.action", method=RequestMethod.GET, params="id")
	public String byParameter(@RequestParam("id") int id,Model model){
		OrderEntity orderentity=new OrderEntity();
		orderentity.setOrderid(1);
		orderentity.setPrice(100.00);
		orderentity.setProductid(id);
		orderentity.setQuantity(1);
		manager.addOrder(orderentity);
		ModelAndView model1 = new ModelAndView("login");
		return "login"; 
	}


}
