package in.redexp.watersupply.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.redexp.watersupply.dao.impl.DistrictDaoImpl;
import in.redexp.watersupply.dao.impl.SchemeDaoImpl;
import in.redexp.watersupply.dao.impl.SchemeVillageDaoImpl;
import in.redexp.watersupply.dao.impl.SubDivisionDaoImpl;
import in.redexp.watersupply.dao.impl.VillageDaoImpl;
import in.redexp.watersupply.dao.impl.WorkflowDaoImpl;
import in.redexp.watersupply.model.District;
import in.redexp.watersupply.model.Scheme;
import in.redexp.watersupply.model.SchemeVillage;
import in.redexp.watersupply.model.SubDivision;
import in.redexp.watersupply.model.User;
import in.redexp.watersupply.model.Village;
import in.redexp.watersupply.model.VillagePopulation;
import in.redexp.watersupply.model.Workflow;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class SchemeController implements Action , ModelDriven<Scheme>, ServletContextAware, ServletRequestAware, 
ServletResponseAware, ApplicationAware{

	public SchemeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	private HttpServletResponse response;
	private HttpServletRequest request;
	private ServletContext servletContext;
	private Scheme scheme;
	
	private String districtID;
	private ArrayList<Village> villageList = new ArrayList<Village>();
	private String locationID;
	
	private String sourceOfscheme;
	private Map<String, String> categoryMap = new HashMap<String, String>();
	private ArrayList<SubDivision> subDivisionList = new ArrayList<SubDivision>();
	private Map<String, String> populationMap = new HashMap<String, String>();
	private Map<String, Object> application;
	private String userByLocation = null;
	private String schemeNameFilter;
	@Override
	public String execute() {
		
		System.out.println("in.redexp.watersupply.controller.SchemeController.execute()");
		try
		{
			
			
			
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	public String editEstimate()
	{
		try {
			System.out.println("in.redexp.watersupply.controller.SchemeController.editEstimate()");
			
			SchemeDaoImpl schemeDao = new SchemeDaoImpl();
			String schemeID = request.getParameter("schemeID");
			scheme = schemeDao.getSchemeByID(schemeID);
			districtID = scheme.getDistrictID();
			//fetch district
			SchemeVillageDaoImpl villageUnderSchemeDao = new SchemeVillageDaoImpl();
			ArrayList<SchemeVillage> schemeVillageList = villageUnderSchemeDao.getAllVillagesUnderSchemeID(request.getParameter("schemeID"));
			Iterator<SchemeVillage> schemeVillageListIterator = schemeVillageList.iterator();
			String villageID = "";
			String villageCategory = "";
			VillagePopulation population = null;
			SchemeVillage schemeVillageMapping = null;
			System.out.println("districtID: "+  districtID);
			while(schemeVillageListIterator.hasNext())
			{
				schemeVillageMapping  = schemeVillageListIterator.next();
				villageID = schemeVillageMapping.getVillageID();
				System.out.println("villageID::" + villageID);
				VillageDaoImpl villageDao = new VillageDaoImpl();
				Village village = villageDao.getVillageByID(villageID);
				villageList.add(village);
				population = villageDao.getLatestPopulationForVillage(villageID);
				System.out.println("Population for villageID: " + villageID + " population: " + population.getTotalPopulation());
				populationMap.put(villageID, population.getTotalPopulation());
				villageCategory = schemeVillageMapping.getVillageCategory();
				//System.out.println(villageCategory);
				if(villageCategory == null)
					villageCategory = "";
				categoryMap.put(villageID, villageCategory);
				
			}
			System.out.println(categoryMap.size());
			DistrictDaoImpl distDao = new DistrictDaoImpl();
			District district = distDao.getDistrictByID(districtID);
			locationID = scheme.getLocationID();
			sourceOfscheme = scheme.getSchemeSource();
			
			//fetch subDivision List
			SubDivisionDaoImpl subDivisionDao = new SubDivisionDaoImpl();
			subDivisionList  = subDivisionDao.getSubDivisionByDivID(request.getParameter("locID"));
			//userByLocation = (String) request.getAttribute("userByLocation");
			//System.out.println("editEstimateController: " +subDivisionList);
			//add location id to session scope
			
			
			Map map = (Map) ActionContext.getContext().get("session");
			String fromRoleID = (String) map.get("userRoleID");
			String fromLocID = "";
			userByLocation = request.getParameter("userByLocation");
			int beginIndex = userByLocation.indexOf('(');
			int endIndex = userByLocation.indexOf(')');
			userByLocation = userByLocation.substring(beginIndex+1, endIndex);
			fromLocID = userByLocation;
			map.put("userLocationID", fromLocID);
			System.out.println("Value Selected In Drop Down: " + userByLocation);
			System.out.println("Query Param::");
			System.out.println(fromRoleID);
			System.out.println(fromLocID);
			WorkflowDaoImpl daoWF = new WorkflowDaoImpl();
			ArrayList<Workflow> workflowList = daoWF.getWorkflowForUser(fromRoleID, fromLocID);
			System.out.println(workflowList);
			if(workflowList == null)
				return ERROR;
			request.setAttribute("workflowList", workflowList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String getFilteredSchemes()
	{
		try
		{
			SchemeDaoImpl schemeDao = new SchemeDaoImpl();
			ArrayList<Scheme> schemesByNameFilter = schemeDao.getSchemeByName(schemeNameFilter);
			if(schemesByNameFilter == null)
				return ERROR;
			request.setAttribute("schemesByNameFilter", schemesByNameFilter);
			ArrayList<Scheme> schemes = schemeDao.getAllSchemes();
			if(schemes == null)
				return ERROR;
			request.setAttribute("schemesList", schemes);
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String getAllSchemes()
	{
		try
		{
			SchemeDaoImpl schemeDao = new SchemeDaoImpl();
	           ArrayList<Scheme> schemes = schemeDao.getAllSchemes();
	           Map session = (Map) ActionContext.getContext().get("session");
	           String userRoleId = (String) session.get("userRoleID");
	           //String locationID = 
			if(schemes == null)
				return ERROR;
			request.setAttribute("schemesList", schemes);
			request.setAttribute("userRoleID", userRoleId);
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
	public Scheme getModel() {
		// TODO Auto-generated method stub
		return scheme;
	}



	public ArrayList<Village> getVillageList() {
		System.out.println(villageList.size());
		return villageList;
	}

	public void setVillageList(ArrayList<Village> villages) {
		villageList = villages;
	}


	public Scheme getScheme() {
		return scheme;
	}


	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}


	public String getDistrictID() {
		return districtID;
	}


	public void setDistrictID(String districtID) {
		this.districtID = districtID;
	}


	public String getLocationID() {
		return locationID;
	}


	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}


	public String getSourceOfscheme() {
		return sourceOfscheme;
	}


	public void setSourceOfscheme(String sourceOfscheme) {
		this.sourceOfscheme = sourceOfscheme;
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


	public Map getCategoryMap() {
		return categoryMap;
	}


	public void setCategoryMap(Map<String, String> categoryMap) {
		this.categoryMap = categoryMap;
	}


	public ArrayList<SubDivision> getSubDivisionList() {
		
		return subDivisionList;
	}


	public void setSubDivisionList(ArrayList<SubDivision> subDivsionList) {
		this.subDivisionList = subDivsionList;
	}


	public Map<String, String> getPopulationMap() {
		return populationMap;
	}


	public void setPopulationMap(Map<String, String> populationMap) {
		this.populationMap = populationMap;
	}


	@Override
	public void setApplication(Map<String, Object> arg0) {
		application = arg0;
	}


	public Map<String, Object> getApplication() {
		return application;
	}

	public String getUserByLocation() {
		return userByLocation;
	}

	public void setUserByLocation(String userByLocation) {
		this.userByLocation = userByLocation;
	}


	public String getSchemeNameFilter() {
		return schemeNameFilter;
	}


	public void setSchemeNameFilter(String schemeNameFilter) {
		this.schemeNameFilter = schemeNameFilter;
	}

	
	

}
