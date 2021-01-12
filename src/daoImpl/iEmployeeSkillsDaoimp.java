package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.iEmployeeSkillDao;
import model.EmployeeSkills;
import config.JDBCConnection;

public class iEmployeeSkillsDaoimp implements iEmployeeSkillDao {

	Connection conn=null;
	
	public iEmployeeSkillsDaoimp() {
		conn=JDBCConnection.getDBConnection();
	}

	@Override
	public List<EmployeeSkills> getAllEmployeeskill() {
		List<EmployeeSkills> empList=new ArrayList<EmployeeSkills>();
		try {
			String query="select * from Employeeskills";
			Statement stm=conn.createStatement();
			ResultSet rst=stm.executeQuery(query);
			if(rst!=null) {
				EmployeeSkills emp=new EmployeeSkills();
				while(rst.next()) {
					//emp.setEsId(rst.getInt(1));
					emp.setEmpid(rst.getString(1));
					emp.setSkillid(rst.getString(2));
					emp.setExperience(rst.getString(3));
					/*emp.setRole(rst.getString(5));
					emp.setActive(rst.getString(6));*/
					empList.add(emp);
				}
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return empList;
	}

	@Override
	public void addEmployeeskill(EmployeeSkills emp) {
		try {
			String query="insert into Employeeskills(EmpId,SkillId,Experience) values(?,?,?)";
			PreparedStatement pst=conn.prepareStatement(query);
			//pst.setInt(1,emp.getEsId());
			pst.setString(1,emp.getEmpid());
			pst.setString(2,emp.getSkillid());
			pst.setString(3,emp.getExperience());
			
			int i=pst.executeUpdate();
			if(i==1) {
				System.out.println("1 record inserted...");
			}
			else {
				System.out.println("Insertion failed...");
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
	}

	@Override
	public EmployeeSkills getEmployeeskillById(int id) {
		EmployeeSkills emp=new EmployeeSkills();
		try {
			String query="select * from Employeeskills where ESid=?";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery(query);
			if(rst!=null) {
				while(rst.next()) {
					//emp.setEsId(rst.getInt(1));
					emp.setEmpid(rst.getString(1));
					emp.setSkillid(rst.getString(2));
					emp.setExperience(rst.getString(3));
					/*emp.setRole(rst.getString(5));
					emp.setActive(rst.getString(6));*/
				}
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return emp;
	}

	@Override
	public void updateEmployeeskills(EmployeeSkills emp) {
		try {
			String query = "UPDATE Employeeskills SET EmpId=?, SkillId=? ,Experience=? WHERE ESid=?";
		
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, emp.getEmpid());
			statement.setString(1, emp.getSkillid());
			statement.setString(2,emp.getExperience());		 
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing user was updated successfully!");
			}
			else {
				System.out.println("updation failed...");
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
	}

	@Override
	/*public void deactivateEmployeeskills(Employeeskills emp) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Employee set Deactive=? where EmployeeSkillId=?");
			pst.setString(1, "Deactive");
			pst.setInt(2, emp.getEsId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Employee deactivated...");
			}
			else {
				System.out.println("updation failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}	
		
		
	}
	
	@Override
	public void activateEmployeeskills(Employeeskills emp) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Employee set Active=? where EmployeeskillId=?");
			pst.setString(1, "Active");
			pst.setInt(2, emp.getEsId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Employee Activated...");
			}
			else {
				System.out.println("updation failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}	
		
		
	}*/

	
	public void deleteEmployeeskills(int id) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("delete from Employeeskills where EmpId=?");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Employee deleted...");
			}
			else {
				System.out.println("deletion failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}	
		
	}

	
	
	
}