package entry;


import java.util.Scanner;
import config.JDBCConnection;
import java.sql.SQLException;
import excDao.JobDetailsExec;
public class TestJobDetailsAp {

	public void testConnection() {
		try {
			if(JDBCConnection.getDBConnection().isClosed()) {
				System.out.println("Connection is closed");
			}
			else {
				System.out.println("Connection is opened");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void processMenu() {
		JobDetailsExec obj = new JobDetailsExec();
		Scanner sc = new Scanner(System.in);
		int option = 0;
		char ch ='y';
		do {
			System.out.println("----------CRUD Operation-----------");
			System.out.println("1. View all JobDetails:");
			System.out.println("2. View single Details:");
			System.out.println("3. Add Employee");
	//ystem.out.println("4. Update Employee");
			System.out.println("4.Delete Details");
			System.out.println("5.Deactivate Details");
			System.out.println("6.Activate Details");
			System.out.println("7.Quit");
			System.out.println("___________________");
			System.out.println("Enter your choice:");
			option=sc.nextInt();
			switch(option) {
			case 1:
				obj.getAllDetails();
				break;
			case 2:
				obj.getJobDetailsById();
				break;
			case 3:
				obj.addDetails();
				break;
	
			case 4:
				obj.deleteDetails();
				break;
			case 5:
				obj.deactivateDetails();
				break;
			case 6:
				obj.activateDetails();
				break;
			case 7:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong input!");
				break;
		}
		System.out.println("Do you want to continue(y/n)?");	
		ch=sc.next().charAt(0);
	}while(ch=='y' || ch=='Y');
	
}
public static void main(String[] args) {
	TestJobDetailsAp test = new TestJobDetailsAp();
	//test.testConnection();
	test.processMenu();
	
}
		

}
