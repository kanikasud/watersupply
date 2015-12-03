package in.redexp.watersupply.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="prwss_main.sd_user_location")
@Embeddable
public class UserLocation implements Serializable{
	/**
	 * 
	 */
	public static final long serialVersionUID = 7319132728523547085L;
	
	@Column(name="user_id")
	private String userID;
	
	
    @Column(name="location_id")
	private String locationID;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getLocationID() {
		return locationID;
	}
	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}
	 @Override
	    public String toString(){
	        return "userID= "+userID+", locID= "+locationID;
	    }
	
}
