package in.redexp.watersupply.dao;

import java.util.List;

import org.hibernate.*;

import in.redexp.watersupply.model.*;

import org.hibernate.SessionFactory;

public class UserDAO extends GenericDao{

	public UserDAO(SessionFactory sf) {
		super(sf);
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
     * Insert a new User into the database.
     * @param user
     */
    public void create(User user) throws RuntimeException {
        super.save(user);
    }
    
    /**
     * @param user
     * @throws RuntimeException
     */
    public void update(User user) throws RuntimeException {
        super.saveOrUpdate(user);
    }


    /**
     * Delete a detached User from the database.
     * @param user
     */
    public void delete(User user) throws RuntimeException {
        super.delete(user);
    }

    /**
     * Find an User by its primary key.
     * @param id
     * @return
     */
    public User find(long id) throws RuntimeException {
        return (User) super.find(User.class, id);
    }

     /**
     * Finds all Users in the database.
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<User> findAll() throws RuntimeException{
        return super.findAll(User.class);
    }
    
    
    /**
     * @param criteria
     * @return
     * @throws RuntimeException
     */
    @Override
	@SuppressWarnings("unchecked")
	public List<User> findByCriteria (Criteria criteria) throws RuntimeException  {
    	return super.findByCriteria(criteria);
    
    }

}
