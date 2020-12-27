package entry;

import java.sql.SQLException;
import java.util.Scanner;

import config.JDBCConnection;
import excDao.EmployeeSkillsExec;

public class TestEmpSkillApp {
  
	public void testConnection() {
		try {
			if(JDBCConnection.getDBConnection().isClosed()) {
				System.out.println("Connection id closed");
				
			}
			else {
				System.out.println("Connection is opened");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void processMenu() {
		EmployeeSkillsExec obj = new EmployeeSkillsExec();
		Scanner sc = new Scanner(System.in);
		int option =0;
		char ch='y';
		do {
			System.out.println("----------CRUD Operation-----------");
			System.out.println("1. View all Employees");
			System.out.println("2. View single Employee");
			System.out.println("3. Add Employee");
			System.out.println("4. Update Employee");
			System.out.println("5. Delete Employee");
			/*System.out.println("6. Deactivate Employee");
			System.out.println("7. Activate Employee");*/
			System.out.println("6. Quit");
			System.out.println("___________________");
			System.out.println("Enter your choice:");
			option =sc.nextInt();
			switch(option) {
			case 1:
				obj.getAllEmployeeskill();
				break;
			case 2:
				obj.getEmployeeskillById();
				break;
			case 3:
				obj.addEmployeeskill();
				break;
			case 4:
				obj.updateEmployeeskills();
				break;
			case 5:
				obj.deleteEmployeeskills();
				break;
			/*case 6:
				obj.deactiveEmployeeskills();
				break;
			case 7:
				obj.deactiveEmployeeskills();
				break;*/
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong input!");
				break;
				
			}
			System.out.println("Do you want to continye(y/n)?");
			ch=sc.next().charAt(0);
		}while(ch=='y'||ch=='Y');
	}
	
	public static void main(String[] args) {
		TestEmpSkillApp test = new TestEmpSkillApp();
		test.processMenu();

	}

}
