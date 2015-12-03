package in.redexp.watersupply.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="prwss_main.mst_divisional")
public class Division implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3275182191048910585L;
	private String divID;
	private String divName;
	private String distID;
	
	public String getDivID() {
		return divID;
	}
	public void setDivID(String divID) {
		this.divID = divID;
	}
	public String getDivName() {
		return divName;
	}
	public void setDivName(String divName) {
		this.divName = divName;
	}
	public String getDistID() {
		return distID;
	}
	public void setDistID(String distID) {
		this.distID = distID;
	}
}
