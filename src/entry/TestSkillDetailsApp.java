package entry;

import java.sql.SQLException;
import java.util.Scanner;

import config.JDBCConnection;
import excDao.SkillDetailsExec;


public class TestSkillDetailsApp {
	public void testConnection() {
		try{
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
		SkillDetailsExec obj=new SkillDetailsExec();
		Scanner sc=new Scanner(System.in);
		int option=0;
		char ch='y';
		do {
			System.out.println("----------CRUD Operation-----------");
			System.out.println("1. View all SkillDetails");
			System.out.println("2. View single SkillDetail");
			System.out.println("3. Add SkillDetails");
			System.out.println("4. Delete SkillDetails");
			System.out.println("5. Deactivate SkillDetails");
			System.out.println("6. Activate SkillDetails");
			System.out.println("7. Quit");
			System.out.println("___________________");
			System.out.println("Enter your choice:");
			option=sc.nextInt();
			switch(option) {
				case 1:
					obj.getAllSkillDetails();
					break;
				case 2:
					obj.getSkillDetailsById();
					break;
				case 3:
					obj.addSkillDetails();
					break;
				case 4:
					obj.deleteSkillDetails();
					break;
				case 5:
					obj.deactiveSkillDetails();
					break;
				case 6:
					obj.activeSkillDetails();
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
		TestSkillDetailsApp test=new TestSkillDetailsApp();
		//test.testConnection();
		test.processMenu();
		
	}

}
