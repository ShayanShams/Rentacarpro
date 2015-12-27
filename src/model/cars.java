package model;

public class cars {
private int cid;
private String fname;
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
private String lname;
private String pickloc;
private String droploc;
private String pickdate;
private String carbrand;
private String transmission;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getPickloc() {
	return pickloc;
}
public void setPickloc(String pickloc) {
	this.pickloc = pickloc;
}
public String getDroploc() {
	return droploc;
}
public void setDroploc(String droploc) {
	this.droploc = droploc;
}
public String getPickdate() {
	return pickdate;
}
public void setPickdate(String pickdate) {
	this.pickdate = pickdate;
}
public String getCarbrand() {
	return carbrand;
}
public void setCarbrand(String carbrand) {
	this.carbrand = carbrand;
}

public String getTransmission() {
	return transmission;
}
public void setTransmission(String transmission) {
	this.transmission = transmission;
}


}

