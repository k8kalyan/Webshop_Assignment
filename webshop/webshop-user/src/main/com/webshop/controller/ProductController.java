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
		List<ProductEntity> prList=productmanager.getproductlist(product);
		List<testProduct> testProductList = new ArrayList<testProduct>();	
				
		Iterator<ProductEntity> iterator = prList.iterator();
		while (iterator.hasNext()) {
			ProductEntity testPr = iterator.next();
			testProduct a = new testProduct();
			a.setId(testPr.getId().toString());
			a.setName(testPr.getName().toString());
			a.setDesc(testPr.getDesc().toString());
			a.setPrice(testPr.getPrice().toString());
			testProductList.add(a);
		}
		
		productList productList = new productList();
		productList.setProducts(testProductList);
		
		 return new ModelAndView("admin/adminhome" , "productList", productList);
	}
	
	List<OrderEntity> orderlist=new ArrayList<OrderEntity>();
	@RequestMapping(value="addtocart.action", method=RequestMethod.GET )	
	public String addToCart(@RequestParam("id") String id,@RequestParam("name") String name , @RequestParam("price") String price ,Model model,HttpSession session){
		
		OrderEntity orderentity=new OrderEntity();
		orderentity.setPrice(Double.valueOf(price));
		orderentity.setProductid(Integer.parseInt(id));
		orderentity.setQuantity(1);
		
		System.out.println("Order entity"+orderentity.getId()+"Price"+orderentity.getPrice());
		orderlist.add(orderentity);
		session.setAttribute("cart", orderlist);		
		return "admin/cart";
		}

	
	@RequestMapping(value="removefromcart.action",method=RequestMethod.GET)
	public String removeFromCart(@RequestParam("id") int id,Model model){
		orderlist.remove(id);
		return "admin/cart";
	}
}
