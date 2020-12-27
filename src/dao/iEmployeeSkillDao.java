package dao;
import java.util.*;
import model.EmployeeSkills;
public interface iEmployeeSkillDao {
 List<EmployeeSkills> getAllEmployeeskill();
 void addEmployeeskill(EmployeeSkills emp);
 EmployeeSkills getEmployeeskillById(int id);
 void updateEmployeeskills(EmployeeSkills emp);
 void deleteEmployeeskills(int id);
 
}
