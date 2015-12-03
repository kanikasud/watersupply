package in.redexp.watersupply.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="prwss_main.mst_subdivisional")
public class SubDivision implements Serializable{
	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;
	private String subDivisionalID;
	private String subDivisionalName;
	private String divisionalID;
	private String status;
	public String getSubDivisionalID() {
		return subDivisionalID;
	}
	public void setSubDivisionalID(String subDivisionalID) {
		this.subDivisionalID = subDivisionalID;
	}
	public String getSubDivisionalName() {
		return subDivisionalName;
	}
	public void setSubDivisionalName(String subDivisionalName) {
		this.subDivisionalName = subDivisionalName;
	}
	public String getDivisionalID() {
		return divisionalID;
	}
	public void setDivisionalID(String divisionalID) {
		this.divisionalID = divisionalID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
