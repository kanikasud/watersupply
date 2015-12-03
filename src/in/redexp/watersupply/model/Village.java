package in.redexp.watersupply.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Village implements Serializable{

	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;
	private String villageID;
	private String constituencyID;
	private String villageName;
	private String districtID;
	public String getVillageID() {
		return villageID;
	}
	public void setVillageID(String villageID) {
		this.villageID = villageID;
	}
	public String getConstituencyID() {
		return constituencyID;
	}
	public void setConstituencyID(String constituencyID) {
		this.constituencyID = constituencyID;
	}
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	public String getDistrictID() {
		return districtID;
	}
	public void setDistrictID(String districtID) {
		this.districtID = districtID;
	}
}
