package model;

public class EmployeeSkills {
	
	private int ESid;
	private String EmpId;
	private String SkillId;
	private String Experience;
	/*private String Role;
	private String Active;*/
	public EmployeeSkills() {
		super();
	}
	public EmployeeSkills(int esId, String empid, String skillid, String experience) {
		super();
		//EsId = esId;
		EmpId = empid;
		SkillId = skillid;
		Experience = experience;
		/*Role = role;
		Active = active;*/
		
		
	}
	public EmployeeSkills(String empid, String skillid, String experience) {
		super();
		EmpId = empid;
		SkillId = skillid;
		Experience = experience;
		/*Role = role;
		Active = active;*/
	}
	/*public int getEsId() {
		return EsId;
	}
	public void setEsId(int esId) {
		EsId = esId;
	}
	*/
	public String getEmpid() {
		return EmpId;
	}
	public void setEmpid(String empid) {
		EmpId = empid;
	}
	public String getSkillid() {
		return SkillId;
	}
	public void setSkillid(String skillid) {
		SkillId = skillid;
	}
	public String getExperience() {
		return Experience;
	}
	public void setExperience(String experience) {
		Experience = experience;
	}
	/*public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		this.Role = role;
	}
	public String getActive() {
		return Active;
	}
	public void setActive(String active) {
	    this.Active= active;
	}
	*/
	@Override
	public String toString() {
		return "Employeeskills [Empid=" + EmpId + ", Skillid=" + SkillId + " Experience="
	+Experience+"]";
	}
	

	

}
