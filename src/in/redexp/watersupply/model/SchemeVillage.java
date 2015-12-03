package in.redexp.watersupply.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="prwss_main.mst_scheme_village")
public class SchemeVillage implements Serializable{
	/**
	 * 
	 */
	public static final long serialVersionUID = -2244065131496268769L;
	String schemeID;
	String villageID;
	String status;
	String schemeCommissionedDate;
	String schemeCompletedDate;
	String villageName;
	String locationWaterWorks;
	String villageCategory;
	public String getSchemeID() {
		return schemeID;
	}
	public void setSchemeID(String schemeID) {
		this.schemeID = schemeID;
	}
	public String getVillageID() {
		return villageID;
	}
	public void setVillageID(String villageID) {
		this.villageID = villageID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSchemeCommisionedDate() {
		return schemeCommissionedDate;
	}
	public void setSchemeCommisionedDate(String schemeCommisionedDate) {
		this.schemeCommissionedDate = schemeCommisionedDate;
	}
	public String getSchemeCompletedDate() {
		return schemeCompletedDate;
	}
	public void setSchemeCompletedDate(String schemeCompletedDate) {
		this.schemeCompletedDate = schemeCompletedDate;
	}
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	public String getLocationWaterWorks() {
		return locationWaterWorks;
	}
	public void setLocationWaterWorks(String locationWaterWorks) {
		this.locationWaterWorks = locationWaterWorks;
	}
	public String getVillageCategory() {
		return villageCategory;
	}
	public void setVillageCategory(String villageCategory) {
		this.villageCategory = villageCategory;
	}
	public String getSchemeCommissionedDate() {
		return schemeCommissionedDate;
	}
	public void setSchemeCommissionedDate(String schemeCommissionedDate) {
		this.schemeCommissionedDate = schemeCommissionedDate;
	}
	
	
}
