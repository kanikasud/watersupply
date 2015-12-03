package in.redexp.watersupply.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="sd_user")
public class User implements Serializable{
	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;
	
	
	
	
    private String userName;
    private String pwd;
    
    
    private String userID;
    
    
    private String empID;
    
    
    private String roleID;
   
    
    @Column(name="user_name")
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String name) {
        this.userName = name;
    }
 
    @Column(name="user_password")
    public String getPwd() {
        return pwd;
    }
 
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
   
    @Override
    public String toString(){
        return "Name= "+userName+", roleID= "+roleID;
    }

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")*/
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	 @Column(name="employee_id")
	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	 @Column(name="role_id")
	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	

}
