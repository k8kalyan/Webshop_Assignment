package com.webshop.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.webshop.registration.constants.WebshopConstants;
import com.webshop.registration.model.ProductCategories;
import com.webshop.registration.model.ProductEntity;
import com.webshop.registration.service.AdminManager;
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
public class AdminController {
	@Autowired
	AdminManager adminmanager;
	@RequestMapping("adminmain.action")
	public String getproductCategoryList(HttpSession session){
		List<ProductCategories> productlist=adminmanager.getproduct_categorylist();
		session.setAttribute(WebshopConstants.PRODUCT_CATEGORY, productlist);
		return "admin/adminmain";

	}
	@RequestMapping("editcategory.action")
	public String editCategory(@ModelAttribute("productcategory") ProductCategories aproductcategory, BindingResult result,HttpSession session){
		session.setAttribute(WebshopConstants.PRODUCT_CATEGORIES, aproductcategory);
		return "admin/editcategory";
	}
	@RequestMapping("editupdatecategory.action")
	public ModelAndView editupdateCategory(@ModelAttribute("productcategory") ProductCategories productcategory, BindingResult result,HttpSession session){
		adminmanager.updateCategory(productcategory);
		return new ModelAndView(new RedirectView(WebshopConstants.ADMIN_MAIN_ACTION));
	}
	@RequestMapping("deletecategory.action")
	public ModelAndView deleteproductCategoryList(@RequestParam("id") int id,HttpSession session){
		Integer getid=id;
		adminmanager.deletecategory(getid);
		return new ModelAndView(new RedirectView(WebshopConstants.ADMIN_MAIN_ACTION));

	}
	@RequestMapping("addcategory.action")
	public ModelAndView addCategory(@ModelAttribute("productcategory") ProductCategories productcategory, BindingResult result,SessionStatus status){
		adminmanager.addCategory(productcategory);
		status.setComplete();
		return new ModelAndView(new RedirectView(WebshopConstants.ADMIN_MAIN_ACTION));

	}
	@RequestMapping("newcategory.action")
	public String showCategoryForm(@ModelAttribute("productcategory") ProductCategories user){
		return "admin/addcategory";
	}
	@RequestMapping("productlist.action")
	public String getProductList(HttpSession session){
		List<ProductEntity> products=adminmanager.getproduct_list();
		session.setAttribute(WebshopConstants.PRODUCTS, products);
		return "admin/productlist";

	}

	@RequestMapping("editproduct.action")
	public String editProduct(@ModelAttribute("product") ProductEntity aproduct, BindingResult result,HttpSession session){
		session.setAttribute("product1", aproduct);
		return "admin/editProduct";
	
	}
	
	@RequestMapping("editupdateproduct.action")
	public ModelAndView editupdateProduct(@ModelAttribute("product") ProductEntity product, BindingResult result,HttpSession session){
		adminmanager.updateProduct(product);
		return new ModelAndView(new RedirectView("adminmain.action"));

}	
	@RequestMapping("deleteproduct.action")
	public ModelAndView deleteproduct(@RequestParam("id") int id,HttpSession session){
		adminmanager.deleteProduct(id);
		return new ModelAndView(new RedirectView(WebshopConstants.PRODUCTLIST_ACTION));

	}
	@RequestMapping("addproduct.action")
	public ModelAndView addProduct(@ModelAttribute("product") ProductEntity product, BindingResult result,SessionStatus status){
		adminmanager.addProduct(product);
		status.setComplete();
		return new ModelAndView(new RedirectView(WebshopConstants.PRODUCTLIST_ACTION));

	}
	@RequestMapping("newproduct.action")
	public String showProductForm(@ModelAttribute("product") ProductEntity product){
		return "admin/addProduct";
	}

}
