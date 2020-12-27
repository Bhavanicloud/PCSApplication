package controller;

import java.util.List;

import dao.iEmployeeSkillDao;
import daoImpl.iEmployeeSkillsDaoimp;
import model.EmployeeSkills;
import model.EmployeeSkills;

public class EmployeeskillsController {

	iEmployeeSkillDao empDao=null;
	
	public EmployeeskillsController() {
		empDao=new iEmployeeSkillsDaoimp();
	}
	
	public List<EmployeeSkills> getAllEmployeeskill(){
		List<EmployeeSkills> empList=empDao.getAllEmployeeskill();
		return empList;
	}
	
	public void addEmployeeskill(EmployeeSkills emp) {
		empDao.addEmployeeskill(emp);
	}
	public EmployeeSkills getEmployeeskillById(int id) {
		EmployeeSkills emp=empDao.getEmployeeskillById(id);
		return emp;
	}
	public void updateEmployeeskills(EmployeeSkills emp) {
		empDao.updateEmployeeskills(emp);
	}
	public void deleteEmployeeskills(int id) {
		empDao.deleteEmployeeskills(id);
	}
	/*public void deactivateEmployeeskills(Employeeskills emp) {
		empDao.deactivateEmployeeskills(emp);
		
	}
	public void activateEmployeeskills(Employeeskills emp) {
		empDao.activateEmployeeskills(emp);
	}*/

	 

	
}