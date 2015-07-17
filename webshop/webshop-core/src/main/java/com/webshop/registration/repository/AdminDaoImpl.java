package com.webshop.registration.repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webshop.registration.constants.WebshopConstants;
import com.webshop.registration.model.ProductCategories;
import com.webshop.registration.model.ProductEntity;

/**
 * AdminDAOImpl class will invoke AdminDAO and calls the methods addCategory, deleteCategory and addProduct methods
 * * <P>
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

@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {
private static final Logger logger = Logger.getLogger(AdminDaoImpl.class);
	/**
	 * This method used to add the product categories list
	 *  @param productCategories 
	 */
	@PersistenceContext
	private EntityManager entitymanager;
	public List<ProductCategories> getproduct_categorylist(){
	 TypedQuery<ProductCategories> Query=entitymanager.createNamedQuery("ProductCategories.find",ProductCategories.class);
	 List<ProductCategories> productlist=Query.getResultList();
		return productlist;

	}
	/**
	 * This method used to delete the category
	 *  @param id 
	 */
	public boolean deletecategory(Integer id )
	{
	 logger.debug("AdminDaoImpl ::deletecategory -START");

		try
		{
			entitymanager.createNamedQuery("deleteEmployeeById", ProductCategories.class)
			.setParameter(1, id)
			.executeUpdate();
			entitymanager.flush();
			return true;
		}
		catch (Exception e){
		}
		logger.debug("AdminDaoImpl ::deletecategory -END");
		return false;

	}
	/**
	 * This method used to update the product Categories
	 *  @param productCategory 
	 */
	public boolean updateCategory(ProductCategories productCategory)
	{
	logger.debug("AdminDaoImpl ::updateCategory -START");
		try
		{

		Integer id1=productCategory.getId();
		String name1=productCategory.getName();
		TypedQuery<ProductCategories> Query=entitymanager.createNamedQuery("ProductEntity.findCategoryName",ProductCategories.class);
		Query.setParameter(WebshopConstants.PRODUCT_ID, id1);
		List<ProductCategories> productlist1=Query.getResultList();
		Query updatequery=entitymanager.createNamedQuery("ProductEntity.updateCategory");
		updatequery.setParameter(WebshopConstants.PRODUCT_ID, id1);
		updatequery.setParameter(WebshopConstants.PRODUCT_NAME, name1);
		int updatecount=updatequery.executeUpdate();

		return true;
		}
		catch (Exception e){
	 	}
	  logger.debug("AdminDaoImpl ::updateCategory -END");		
		return false;
	}
	/**
	 * This method used to add the product
	 *  @param productCategory 
	 */
	public boolean updateProduct(ProductEntity product)
	{
	logger.debug("AdminDaoImpl ::updateProduct -START");
		try
		{
			
			Integer pid1=product.getId();
			String pname1=product.getName();
			String pdesc=product.getDescription();
        	String pprice=product.getPrice();
			Query updatequery=entitymanager.createNamedQuery("ProductEntity.updateProduct");
			updatequery.setParameter(WebshopConstants.PRODUCT_ID,pid1);
			updatequery.setParameter(WebshopConstants.PRODUCT_NAME, pname1);
			updatequery.setParameter(WebshopConstants.PRODUCT_DESCRIPTION,pdesc);
			updatequery.setParameter(WebshopConstants.PRODUCT_PRICE, pprice);
			int updatecount=updatequery.executeUpdate();

			return true;
		}
		catch (Exception e)	{
		}
	logger.debug("AdminDaoImpl ::updateProduct -START");
		return false;
	}
	/**
	 * This method used to add the category
	 *  @param productCategory 
	 */
	public void addCategory(ProductCategories productCategory){
		entitymanager.persist(productCategory);
	}
	/**
	 * This method used to add the product
	 *  @param product 
	 */

	public void addProduct(ProductEntity product){
		entitymanager.persist(product);
	}
	/**
	 * This Method used to get the productlist
	 *  @param productEntity 
	 */
	public List<ProductEntity> getproduct_list(){
		TypedQuery<ProductEntity> Query=entitymanager.createNamedQuery("ProductEntity.find",ProductEntity.class);
		List<ProductEntity> products=Query.getResultList();
		return products;

	}
	/**
	 * This method used to get the delete the product
	 *  @param id 
	 */

	public boolean deleteProduct( Integer id )
	{
	logger.debug("AdminDaoImpl ::deleteProduct -START");
		try
		{
			entitymanager.createNamedQuery("deleteProductById", ProductEntity.class)
			.setParameter(1, id)
			.executeUpdate();
			entitymanager.flush();
			return true;
		}
		catch (Exception e)	{
			
		}
	logger.debug("AdminDaoImpl ::deleteProduct -END");
		return false;
	}


}
