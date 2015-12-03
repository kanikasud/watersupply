package in.redexp.watersupply.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="prwss_main.mst_village_population")
public class VillagePopulation implements Serializable{
	/**
	 * 
	 */
	public static final long serialVersionUID = 6208783841365568210L;
	private String populationID;
	private String villageID;
	private Integer populationYear;
	private String totalPopulation;
	private Date asOnDate;
	public String getPopulationID() {
		return populationID;
	}
	public void setPopulationID(String populationID) {
		this.populationID = populationID;
	}
	public String getVillageID() {
		return villageID;
	}
	public void setVillageID(String villageID) {
		this.villageID = villageID;
	}
	public Integer getPopulationYear() {
		return populationYear;
	}
	public void setPopulationYear(Integer populationYear) {
		this.populationYear = populationYear;
	}
	public String getTotalPopulation() {
		return totalPopulation;
	}
	public void setTotalPopulation(String totalPopulation) {
		this.totalPopulation = totalPopulation;
	}
	public Date getAsOnDate() {
		return asOnDate;
	}
	public void setAsOnDate(Date asOnDate) {
		this.asOnDate = asOnDate;
	}
}
