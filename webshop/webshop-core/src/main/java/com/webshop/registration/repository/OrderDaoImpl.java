
package com.webshop.registration.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webshop.registration.model.OrderShipment;
import com.webshop.registration.model.OrderEntity;
/**
 * OrderManagerImpl invoke OrderManager class and calls the method addOrder. 
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


@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {
private static final Logger logger = Logger.getLogger(ProductCategoryDaoImpl.class);
	@PersistenceContext
	private EntityManager entitymanager;
	/**
	 * This method used to add the shipmentorder.
	 * @param orderShipment 
	 */

	public void addOrder(OrderShipment orderShipment){
	 logger.debug("OrderDaoImpl ::addOrder -START");
		try
		{
			entitymanager.persist(orderShipment);	 

		} catch(Exception e){
			e.printStackTrace();
		}
	  logger.debug("OrderDaoImpl ::addOrder -END");
	}
	
	/**
	 * This method used to add the multiple shipments with different order lines.
	 * @param orderShipment 
	 */

	public void addOrderLines(List<OrderEntity> orderlines) {
	 logger.debug("OrderDaoImpl ::addOrder -START");  			
		try
		{ 
			
		 for (OrderEntity orderEntity : orderlines){
			 entitymanager.persist(orderEntity);		 
		 }
		  
		  } catch(Exception e){
			e.printStackTrace();
		}
	logger.debug("OrderDaoImpl ::addOrder -END");
	}

}
