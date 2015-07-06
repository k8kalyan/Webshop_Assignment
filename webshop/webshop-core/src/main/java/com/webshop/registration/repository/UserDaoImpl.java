package com.webshop.registration.repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.webshop.registration.model.UserEntity;
/**
 * UserDAOImpl class invoke UserDAO and persist the data into database. 
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
public class UserDaoImpl  implements UserDao{
/**
 * This method will persist user details into the database.
 * @param userEntity 
*/
	@PersistenceContext
	private EntityManager manager;

	public void addUser(UserEntity user){

		manager.persist(user);
	}


}
