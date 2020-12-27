package model;

public class SkillDetails {
     int Skillid;
     String SkillName;
     String SkillDescription;
     String Active;
	public SkillDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SkillDetails(int skillid, String skillName, String skillDescription,String active) {
		super();
		Skillid = skillid;
		SkillName = skillName;
		SkillDescription = skillDescription;
		Active = active;
	}
	public SkillDetails(String skillName, String skillDescription,String active) {
		super();
		SkillName = skillName;
		SkillDescription = skillDescription;
		Active = active;
	}
	public int getSkillid() {
		return Skillid;
	}
	public void setSkillid(int skillid) {
		Skillid = skillid;
	}
	public String getSkillName() {
		return SkillName;
	}
	public void setSkillName(String skillName) {
		SkillName = skillName;
	}
	public String getSkillDescription() {
		return SkillDescription;
	}
	public void setSkillDescription(String skillDescription) {
		SkillDescription = skillDescription;
	}
	public String getActive() {
		return Active;
	}
	public void setActive(String active) {
		Active = active;
	}
     
}