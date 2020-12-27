package excDao;


import java.io.*;
import java.util.List;
import java.util.Iterator;


import model.JobDetails;
import controller.JobDetailsController;

import controller.JobDetailsController;

public class JobDetailsExec {
   JobDetailsController dController = null;
   
   public JobDetailsExec() {
	   dController = new JobDetailsController();
   }
   
   public void getAllDetails() {
	   List<JobDetails> dList = dController.getAllDetails();
	   for(JobDetails d:dList) {
		   System.out.println(d);
	   }
   }
   
   public void getJobDetailsById() {
	   int id =0;
	   try {
		   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		   System.out.println("Enter Job id whose record you want to view:");
		   id = Integer.parseInt(reader.readLine());
	   }
	   catch(IOException ex) {
		   System.out.println(ex);
	   }
	   JobDetails d = dController.getDetailsById(id);
	   System.out.println(d);
	   
	   }
   

public void addDetails() {
	JobDetails d = new JobDetails();
	try {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter job details:");
		System.out.println("JobTitle:");
		String jobtitle=reader.readLine();
	    d.setJobTitle(jobtitle);
		System.out.println("JobDescription:");
		d.setJobDescription(reader.readLine());
		System.out.println("CompanyName:");
		d.setCompanyName(reader.readLine());
		System.out.println("Location:");
     	d.setLocation(reader.readLine());
     	System.out.println("KeySkills:");
     	d.setKeyskill(reader.readLine());
     	System.out.println("Salary:");
     	d.setSalary(reader.read());
     	System.out.println("Experience:");
     	d.setExperience(reader.read());
     	System.out.println("Active:");
     	d.setActive(reader.readLine());
     	if(jobtitle.equals("Developer")) {
     		d.setActive("Active");
     	}
     	else {
     		d.setActive("Deactive");
     	}
     	}catch(IOException ex) {
     		System.out.println(ex);
     	}
	    dController.addDetails(d);
}

/*/public void updateDetails() {
	try {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int id;
		String JobTitle,CompanyName;
		System.out.println("Enter JobDetailsId whose record you want to update:");
		id=Integer.parseInt(reader.readLine());
		JobDetails d = dController.getDetailsById(id);
		System.out.println("Enter the new jobtitle:");
		JobTitle=reader.readLine();
		System.out.println("Enter the new CompanyName:");
		CompanyName=reader.readLine();
		if(JobTitle==1 || CompanyName==1) {
			System.out.println("Updated Successfully...");
		}
			
	}catch(IOException ex) {
		System.out.println(ex);
	}
*/
public void deactivateDetails() {
	try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		System.out.println("Enter JobId whose record you want to deactivate:");
		id=Integer.parseInt(reader.readLine());
		JobDetails d=dController.getDetailsById(id);
		dController.deactiveDetails(d);
	}
	catch(IOException ex) {
		System.out.println(ex.getMessage());
	}
}
public void deleteDetails() {
	try {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int id;
		System.out.println("Enter JobDetailsid whose record you want to delete");
		id = Integer.parseInt(reader.readLine());
		dController.deleteDetails(id);
				
	}catch(IOException ex) {
		System.out.println(ex);
	}
}
public void activateDetails() {
	try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		System.out.println("Enter JobeId whose record you want to activate:");
		id=Integer.parseInt(reader.readLine());
		JobDetails d=dController.getDetailsById(id);
		dController.activeDetails(d);
	}
	catch(IOException ex) {
		System.out.println(ex.getMessage());
	}
}
}