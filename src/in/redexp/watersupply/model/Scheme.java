package in.redexp.watersupply.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prwss_main.mst_scheme_header")
public class Scheme implements Serializable{
	/**
	 * 
	 */
	public static final long serialVersionUID = -3809232656073732690L;
	String schemeID;
	String schemeName;
	String status;
	String locationID;
	String schemeSource;
	String districtID;
	String progID;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="scheme_id")
	public String getSchemeID() {
		return schemeID;
	}
	public void setSchemeID(String schemeID) {
		this.schemeID = schemeID;
	}
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLocationID() {
		return locationID;
	}
	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}
	public String getSchemeSource() {
		return schemeSource;
	}
	public void setSchemeSource(String schemeSource) {
		this.schemeSource = schemeSource;
	}
	public String getDistrictID() {
		return districtID;
	}
	public void setDistrictID(String districtID) {
		this.districtID = districtID;
	}
	public String getProgID() {
		return progID;
	}
	public void setProgID(String progID) {
		this.progID = progID;
	}
	
}
