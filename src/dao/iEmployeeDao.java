package dao;
import java.util.*;
import model.Employee;

public interface iEmployeeDao {
	List<Employee> getAllEmployees();
	void addEmployee(Employee emp);
	Employee getEmployeeById(int id);
	void updateEmployee(Employee emp);
	void deactivateEmployee(Employee emp);
	void activateEmployee(Employee emp);
	void deleteEmployee(int id);
	Employee checkLogin(String userId, String password);
}
