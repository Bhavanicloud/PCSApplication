package model;

public class JobDetails {
     int jobId;
     String JobTitle;
     String JobDescription;
     String CompanyName;
     String location;
     String keyskill;
     int salary;
     int experience;
     String active;
	public JobDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
     

public JobDetails(int jobId, String jobTitle, String jobDescription, String companyName, String location,
		String keyskill, int salary, int experience,String active) {
	super();
	this.jobId = jobId;
	JobTitle = jobTitle;
	JobDescription = jobDescription;
	CompanyName = companyName;
	this.location = location;
	this.keyskill = keyskill;
	this.salary = salary;
	this.experience = experience;
	 this.active = active;
}
public JobDetails(String jobTitle, String jobDescription, String companyName, String location, String keyskill,
		int salary, int experience,String active) {
	super();
	JobTitle = jobTitle;
	JobDescription = jobDescription;
	CompanyName = companyName;
	this.location = location;
	this.keyskill = keyskill;
	this.salary = salary;
	this.experience = experience;
	this.active=active;
}
public int getJobId() {
	return jobId;
}
public void setJobId(int jobId) {
	this.jobId = jobId;
}
public String getJobTitle() {
	return JobTitle;
}
public void setJobTitle(String jobTitle) {
	JobTitle = jobTitle;
}
public String getJobDescription() {
	return JobDescription;
}
public void setJobDescription(String jobDescription) {
	JobDescription = jobDescription;
}
public String getCompanyName() {
	return CompanyName;
}
public void setCompanyName(String companyName) {
	CompanyName = companyName;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getKeyskill() {
	return keyskill;
}
public void setKeyskill(String keyskill) {
	this.keyskill = keyskill;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public int getExperience() {
	return experience;
}
public void setExperience(int experience) {
	this.experience = experience;
}
public String getActive() {
	return active;
}
public void setActive(String active) {
	this.active = active;
}
}