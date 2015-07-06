package com.webshop.registration.repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
	public boolean deletecategory( Integer id )
	{
		try
		{
			entitymanager.createNamedQuery("deleteEmployeeById", ProductCategories.class)
			.setParameter(1, id)
			.executeUpdate();
			entitymanager.flush();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	/**
	 * This method used to add the category
	 *  @param productCategory 
	 */
	public void addCategory(ProductCategories productCategory){
		System.out.println("in add Repo");
		entitymanager.persist(productCategory);
	}
	/**
	 * This method used to add the product
	 *  @param product 
	 */

	public void addProduct(ProductEntity product){
		System.out.println("in add Repo Product");
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
		try
		{
 		entitymanager.createNamedQuery("deleteProductById", ProductEntity.class)
		.setParameter(1, id)
		.executeUpdate();
		entitymanager.flush();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}


}
