package in.redexp.watersupply.model;

import java.io.Serializable;

public class Block implements Serializable{
 private String blockID;
 private String blockName;
 private String districtID;
 private String constituencyID;
 public String getBlockID() {
	return blockID;
}
 public void setBlockID(String blockID) {
	this.blockID = blockID;
}
 public String getBlockName() {
	return blockName;
}
 public void setBlockName(String blockName) {
	this.blockName = blockName;
}
public String getDistrictID() {
	return districtID;
}
public void setDistrictID(String districtID) {
	this.districtID = districtID;
}
public String getConstituencyID() {
	return constituencyID;
}
public void setConstituencyID(String constituencyID) {
	this.constituencyID = constituencyID;
}

}
