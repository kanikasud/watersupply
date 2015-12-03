package in.redexp.watersupply.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="prwss_main.mst_district")
public class District implements Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String districtID;
 private String districtName;
 private ArrayList<Village> villages;
 public String getDistrictID() {
	return districtID;
 }
 public void setDistrictID(String districtID) {
	this.districtID = districtID;
 }
 public String getDistrictName() {
	return districtName;
 }
 public void setDistrictName(String districtName) {
	this.districtName = districtName;
 }
public ArrayList<Village> getVillages() {
	return villages;
}
public void setVillages(ArrayList<Village> villages) {
	this.villages = villages;
}
 
 
}
