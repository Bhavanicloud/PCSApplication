package excDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import controller.SkillsController;
import model.SkillDetails;

public class SkillDetailsExec {

     SkillsController skController=null;
		
		public SkillDetailsExec() {
			skController=new SkillsController();
		}
		
		public void getAllSkillDetails() {
			List<SkillDetails> skList=skController.getAllSkillDetails();
			for(SkillDetails sk:skList) {
				System.out.println(sk);
			}
		}
		
		public void getSkillDetailsById() {
			int id=0;
			try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter Skill id whose record you want to view:");
				id=Integer.parseInt(reader.readLine());
			}
			catch(IOException ex){
				System.out.println(ex);
			}
			SkillDetails sk=skController.getSkillDetailsById(id);
			System.out.println(sk);
		}
		
		public void addSkillDetails() {
			SkillDetails sk=new SkillDetails();
		
			try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter Skill Detail:");
				System.out.println("Skill Name:");
				String skillname = reader.readLine();
				sk.setSkillName(skillname);
				System.out.println("Skill Description:");
				sk.setSkillDescription(reader.readLine());
				
				if(skillname.equals("java")) {
					sk.setActive("Active");
				}
				else {
					sk.setActive("Deactive");
				}
				
			}catch(IOException ex){
				System.out.println(ex);
			}
			skController.addSkillDetails(sk);
		}

	
	public void deactiveSkillDetails() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter SkillId whose record you want to deactivate:");
			id=Integer.parseInt(reader.readLine());
			SkillDetails sk=skController.getSkillDetailsById(id);
			skController.deactivateSkillDetails(sk);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void activeSkillDetails() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter SkillId whose record you want to activate:");
			id=Integer.parseInt(reader.readLine());
			SkillDetails sk=skController.getSkillDetailsById(id);
			skController.activateSkillDetails(sk);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deleteSkillDetails() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter SkillId whose record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			skController.deleteSkillDetails(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}


}
