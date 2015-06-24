package com.webshop.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.webshop.registration.model.ProductEntity;
import com.webshop.registration.service.ProductManager;
/**
 * ProductController prepares the order entity object with price, product and quantity information. 
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
public class ProductController {
	@Autowired
	ProductManager productmanager;
	@RequestMapping("product.action")
	public ModelAndView onSubmit(@RequestParam String product,Model model){
		List<ProductEntity> productlist=productmanager.getproductlist();
		ModelAndView model1 = new ModelAndView("admin/adminhome");
		model1.addObject("lists", productlist);
		model1.addObject("product", product);
		return model1; 
	}

}
