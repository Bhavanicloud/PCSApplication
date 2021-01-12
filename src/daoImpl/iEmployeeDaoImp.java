package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.iEmployeeDao;
import model.Employee;

public class iEmployeeDaoImp implements iEmployeeDao {

	Connection conn=null;
	
	public iEmployeeDaoImp() {
		conn=JDBCConnection.getDBConnection();
	}
    public Employee checkLogin(String userId,String password) {
    	Employee emp = new Employee();
    	try {
    		String query ="select * from Employee where userId=? and password=?";
    		PreparedStatement pst = conn.prepareStatement("");
    		pst.setString(1, userId);
    		pst.setString(2, password);
    		ResultSet rst=pst.executeQuery();
    		if(rst!=null) {
    			if(rst.next()) {
    				emp.setEmployeeid(rst.getInt(1));
    				emp.setFirstName(rst.getString(2));
    				emp.setLastName(rst.getString(3));
    				emp.setEmail(rst.getString(3));
    				emp.setUserId(rst.getString(3));
    				emp.setPassword(rst.getString(3));
    				emp.setRole(rst.getString(3));
    				emp.setGender(rst.getString(3));
    				emp.setActive(rst.getString(3));
    				
    			}
    		}
    	}catch(SQLException ex) {
    		System.out.println(ex);
    	}
    	return emp;
    }
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList=new ArrayList<Employee>();
		try {
			String query="select * from Employee";
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(query);
			if(rst!=null) {
				
				while(rst.next()) {
					Employee emp=new Employee();
					emp.setEmployeeid(rst.getInt(1));
					emp.setFirstName(rst.getString(2));
					emp.setLastName(rst.getString(3));
					emp.setEmail(rst.getString(4));
					emp.setUserId(rst.getString(5));
					emp.setPassword(rst.getString(6));
					emp.setRole(rst.getString(7));
					emp.setGender(rst.getString(8));
					emp.setActive(rst.getString(9));
					empList.add(emp);
				}
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return empList;
	}

	@Override
	public void addEmployee(Employee emp) {
		try {
			String query="insert into Employee(FirstName, LastName, Email, UserId, Password, Role, Gender, Active) values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1,emp.getFirstName());
			pst.setString(2,emp.getLastName());
			pst.setString(3,emp.getEmail());
			pst.setString(4,emp.getUserId());
			pst.setString(5,emp.getPassword());
			pst.setString(6,emp.getRole());
			pst.setString(7,emp.getGender());
			pst.setString(8,emp.getActive());
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
	public Employee getEmployeeById(int id) {
		Employee emp=new Employee();
		try {
			String query="select * from Employee where EmployeeId=?";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				while(rst.next()) {
					emp.setEmployeeid(rst.getInt(1));
					emp.setFirstName(rst.getString(2));
					emp.setLastName(rst.getString(3));
					emp.setEmail(rst.getString(4));
					emp.setUserId(rst.getString(5));
					emp.setPassword(rst.getString(6));
					emp.setRole(rst.getString(7));
					emp.setGender(rst.getString(8));
					emp.setActive(rst.getString(9));
				}
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return emp;
	}

	@Override
	public void updateEmployee(Employee emp) {
		try {
			String query = "UPDATE Employee SET password=?, email=? WHERE EmployeeId=?";
		
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, emp.getPassword());
			statement.setString(2, emp.getEmail());
			statement.setInt(3,emp.getEmployeeid());		 
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
	public void deactivateEmployee(Employee emp) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Employee set Active=? where EmployeeId=?");
			pst.setString(1, "Deactive");
			pst.setInt(2, emp.getEmployeeid());
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
	public void activateEmployee(Employee emp) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Employee set Active=? where EmployeeId=?");
			pst.setString(1, "Active");
			pst.setInt(2, emp.getEmployeeid());
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
		
		
	}

	@Override
	public void deleteEmployee(int id) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("delete from Employee where EmployeeId=?");
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