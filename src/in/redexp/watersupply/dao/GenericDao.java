package in.redexp.watersupply.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;



public abstract class GenericDao {
    private SessionFactory sf; 
    private Session session;
    private Transaction tx;

    public GenericDao(SessionFactory sf) {
    	this.sf = sf;
    	session = sf.openSession();
    }
    
    /**
     * method to save the object
     * 
     * @param _obj
     * @param autoCommit - If true, transaction will begin and commit in same call. If false, then commiting transaction should be handled at utliites level
     */
    public void save(Object _obj,boolean _autoCommit) {
        try {
        	if(_autoCommit)beginTransaction();
            session.save(_obj);
            if(_autoCommit)commitTransaction();
        } catch (HibernateException e) {
        	e.printStackTrace();
           
        }catch (Exception e) {
        	e.printStackTrace();
		} finally {
           // HibernateFactory.close(session);
        }
    }
    
    /**
     * method to save and auto commit the transaction by default
     * @param obj
     */
    protected void save(Object _obj) {
        save(_obj,true);
    }
    
    /**
     * method to update or save the object
     * 
     * @param _obj
     * @param autoCommit - If true, transaction will begin and commit in same call. If false, then commiting transaction should be handled at utliites level
     */
    public void saveOrUpdate(Object _obj,boolean _autoCommit) {
        try {
        	if(_autoCommit)beginTransaction();
            session.saveOrUpdate(_obj);
            if(_autoCommit)commitTransaction();
        } catch (HibernateException e) {
        	e.printStackTrace();
           
        }catch (Exception e) {
        	e.printStackTrace();
		} finally {
           // HibernateFactory.close(session);
        }
    }
    
    /**
     * method to save or update the object - by setting the auto commit option
     * 
     * @param _obj
     */
    protected void saveOrUpdate(Object _obj) {
        try {
            saveOrUpdate(_obj,true);
        } catch (HibernateException e) {
        	e.printStackTrace();
           
        }catch (Exception e) {
        	e.printStackTrace();
		}finally {
           // HibernateFactory.close(session);
        }
    }
    
    /**
     * method to save or update the object - by setting the auto commit option
     * 
     * @param _obj
     */
    protected void update(Object _obj) {
        try {
            session.update(_obj);
        } catch (HibernateException e) {
        	e.printStackTrace();
           
        }catch (Exception e) {
        	e.printStackTrace();
		}finally {
           // HibernateFactory.close(session);
        }
    }

    /**
     * method to delete the object
     * 
     * @param _obj
     * @param autoCommit - If true, transaction will begin and commit in same call. If false, then commiting transaction should be handled at utliites level
     */
    public void delete(Object _obj,boolean _autoCommit) {
        try {
        	if(_autoCommit)beginTransaction();
            session.delete(_obj);
            if(_autoCommit)commitTransaction();
        } catch (HibernateException e) {
        	e.printStackTrace();
           
        } catch (Exception e) {
        	e.printStackTrace();
		}finally {
           // HibernateFactory.close(session);
        }
    }

    /**
     * method to delete the object - by setting the auto commit mode to true
     * 
     * @param _obj
     */
    protected void delete(Object _obj) {
        try {
           delete(_obj,true);
           session.flush();
        } catch (HibernateException e) {
        	e.printStackTrace();
           
        } catch (Exception e) {
        	e.printStackTrace();
		}finally {
            //HibernateFactory.close(session);
        }
    }

    /**
     * method to get the required object based on primary key index
     * 
     * @param _clazz
     * @param _id
     * @return
     */
    @SuppressWarnings("unchecked")
	protected Object find(Class _clazz, long _id) {
        Object obj = null;
        try {
        	//Transaction readTransaction = session.beginTransaction();
            obj = session.get(_clazz, _id);
            //readTransaction.commit();
        } catch (HibernateException e) {
        	e.printStackTrace();
           
        }catch (Exception e) {
        	e.printStackTrace();
		}finally {
//            HibernateFactory.close(session);
        }
        return obj;
    }

    /**
     * method to get all the data from the specified entity
     * 
     * @param _clazz
     * @return
     */
    @SuppressWarnings("unchecked")
	protected List findAll(Class _clazz) {
        List objects = null;
        try {
        	//Transaction readTransaction = session.beginTransaction();
            Criteria query = session.createCriteria( _clazz);
            System.out.println(":::::::::::::: Generic Dao :: findAll :: query :: "+query);
            objects = query.list();
            //readTransaction.commit();
        } catch (HibernateException e) {
        	e.printStackTrace();
           
        } catch (Exception e) {
        	e.printStackTrace();            
        } finally {
            //HibernateFactory.close(session);
        }
        return objects;
    }
    
    /**
     * method to get all the data from the specified entity
     * 
     * @param _clazz
     * @return
     */
    @SuppressWarnings("unchecked")
	public List findAllBySorted(Class _clazz,String _fieldName,boolean _isAscending) {
        List objects = null;
        try {
        	//Transaction readTransaction = session.beginTransaction();
            Criteria query = session.createCriteria( _clazz);
            if(!_isAscending)
            	query.addOrder(Order.desc(_fieldName));
            else
            	query.addOrder(Order.asc(_fieldName));
            System.out.println(":::::::::::::: Generic Dao :: findAllBySorted :: query :: "+query);
            objects = query.list();
            //readTransaction.commit();
        } catch (HibernateException e) {
        	e.printStackTrace();
           
        } catch (Exception e) {
        	e.printStackTrace();            
        } finally {
            //HibernateFactory.close(session);
        }
        return objects;
    }
    
    /**
     * method to get the data based on criteria
     * 
     * @param _criteria
     * @return
     */
    protected List findByCriteria (Criteria _criteria) {
    	List objects = null;
        try {
            objects = _criteria.list();
            System.out.println("in.redexp.watersupply.dao.GenericDao.findByCriteria(Criteria)");
            System.out.println(objects.size());
        } catch (HibernateException e) {
        	e.printStackTrace();
           
        }catch (Exception e) {
        	e.printStackTrace();
		} finally {
            //HibernateFactory.close(session);
        }
        return objects;
    }

   
    
    /**
     * this method needs to be called from utilities to commit the transaction
     * 
     * @throws DataAccessLayerException
     */
    public void commitTransaction() throws HibernateException{
    	if(tx != null)tx.commit();
    }

    /**
     * this method needs to be called from utilities to begin the transaction
     * 
     * @throws DataAccessLayerException
     */
    public void beginTransaction() throws HibernateException {
        if(tx == null)tx = session.beginTransaction();
    }
    
   

	/**
	 * method to get the hibernate session object
	 * 
	 * @return Hibernate Session
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * method to set the Hibernate session object
	 * 
	 * @param session
	 */
	public void setSession(Session session) {
		this.session = session;
	}
}
