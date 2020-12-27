package dao;

import java.util.List;

import model.SkillDetails;

public interface iSkillDao {
	List<SkillDetails> getAllSkillDetails();
	void addSkillDetails(SkillDetails emp);
	SkillDetails getSkillDetailsById(int id);
	void deactivateSkillDetails(SkillDetails emp);
	void activateSkillDetails(SkillDetails emp);
	void deleteSkillDetails(int id);
}