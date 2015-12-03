package in.redexp.watersupply.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
















import in.redexp.watersupply.dao.impl.SchemeDaoImpl;
import in.redexp.watersupply.dao.impl.UserDAOImpl;
import in.redexp.watersupply.dao.impl.UserLocationDaoImpl;
import in.redexp.watersupply.model.Scheme;
import in.redexp.watersupply.model.User;

public class LoginController  implements Action, ModelDriven<User>, ServletContextAware, ServletRequestAware, ServletResponseAware, 
ApplicationAware, SessionAware {
	private HttpServletRequest request = null;
    private HttpServletResponse response = null;
    
   @Override
   public String execute() {
       try 
       {
       
       UserDAOImpl userDAOimpl = new UserDAOImpl();
      
       User userDB = userDAOimpl.getUserByCredentials(user.getUserName(), user.getPwd());
       if(userDB == null) return ERROR;
       else {
           
           
           UserLocationDaoImpl userLocationDao = new UserLocationDaoImpl();
           ArrayList<String> locationIDList = userLocationDao.getUserLocationID(userDB);
           System.out.println("Location ID: " + locationIDList);
           
           SchemeDaoImpl schemeDao = new SchemeDaoImpl();
           ArrayList<Scheme> schemes = schemeDao.getAllSchemes();
           
           
           request.setAttribute("locationIDList", locationIDList);
           request.setAttribute("userRoleID", userDB.getRoleID());
           request.setAttribute("schemesList", schemes);
           Map session = (Map) ActionContext.getContext().get("session");
           session.put("userRoleID", userDB.getRoleID());
           
           
       }
       
       }
       catch(Exception ex)
       {
    	   ex.printStackTrace();
    	   return ERROR;
       }
       return SUCCESS;
   }

   @Override
   public User getModel() {
       return user;
   }
    
   private User user = new User();
    
   private ServletContext ctx;
private Map<String, Object> application;
private Map<String, Object> userSession;

   @Override
   public void setServletContext(ServletContext sc) {
       this.ctx = sc;
   }

@Override
public void setServletResponse(HttpServletResponse arg0) {
	// TODO Auto-generated method stub
	response = arg0;
}

@Override
public void setServletRequest(HttpServletRequest arg0) {
	// TODO Auto-generated method stub
	request = arg0;
}

@Override
public void setApplication(Map<String, Object> arg0) {
	application = arg0;
	
}

public Map<String, Object> getApplication() {
	return application;
}

@Override
public void setSession(Map<String, Object> arg0) {
	userSession = arg0;
	
}

public Map<String, Object> getUserSession() {
	return userSession;
}

public void setUserSession(Map<String, Object> userSession) {
	this.userSession = userSession;
}



    
}
