package com.webshop.controller;
import java.util.ArrayList;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.webshop.registration.constants.WebshopConstants;
import com.webshop.registration.model.OrderShipment;
import com.webshop.registration.service.OrderManager;
import com.webshop.registration.model.OrderEntity;


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
	@RequestMapping("orderuser.action")
	public String addOrderForm(@ModelAttribute("orderShipment") OrderShipment orderShipment){

		return WebshopConstants.USER_ORDER;
	}
	
	@RequestMapping("order.action")
	public String SubmitForm(@ModelAttribute("orderShipment") OrderShipment orderShipment, BindingResult result,SessionStatus status,HttpSession session){

		manager.addOrder(orderShipment);
		
		List<OrderEntity> tempOrderlines = (List<OrderEntity>) session.getAttribute(WebshopConstants.CART);
					
	   List<OrderEntity> orderlines=new ArrayList<OrderEntity>();
	   
	   for(OrderEntity orderLine : tempOrderlines)
	   {
		   OrderEntity tempOrderLine = new OrderEntity();
		   tempOrderLine.setOrderid(orderShipment.getId());
		   tempOrderLine.setPrice(orderLine.getPrice());
		   tempOrderLine.setProductid(orderLine.getProductid());
		   tempOrderLine.setQuantity(orderLine.getQuantity());
		   
		   orderlines.add(tempOrderLine);
	   }
		manager.addOrderLines(orderlines);
		
		status.setComplete();
		return WebshopConstants.ORDER_SUCCESS;

	}


}
