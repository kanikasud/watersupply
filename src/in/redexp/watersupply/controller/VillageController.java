package in.redexp.watersupply.controller;

import java.util.ArrayList;
import java.util.Iterator;

import in.redexp.watersupply.dao.impl.DistrictDaoImpl;
import in.redexp.watersupply.dao.impl.VillageDaoImpl;
import in.redexp.watersupply.model.District;
import in.redexp.watersupply.model.Scheme;
import in.redexp.watersupply.model.Village;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ognl.ObjectMethodAccessor;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;
import org.codehaus.jackson.map.ObjectMapper;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class VillageController implements Action , ModelDriven<Village>, ServletContextAware, ServletRequestAware, ServletResponseAware{
	private HttpServletResponse response;
	private HttpServletRequest request;
	private ServletContext servletContext;
	private Village village;
	
	String jsonString = "";
	private String districtID;
	@Override
	public String execute() {
		
		System.out.println("in.redexp.watersupply.controller.VillageController.execute()");
		try
		{
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
		
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		servletContext = arg0;
		
	}

	@Override
	public Village getModel() {
		// TODO Auto-generated method stub
		return village;
	}
	
	

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}


	public String getDistrictID() {
		return districtID;
	}

	public void setDistrictID(String districtID) {
		this.districtID = districtID;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

}
