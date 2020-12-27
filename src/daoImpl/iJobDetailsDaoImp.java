package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.iJobDetailsDao;

import model.JobDetails;
public class iJobDetailsDaoImp implements iJobDetailsDao {
  Connection conn = null;
  
  public iJobDetailsDaoImp() {
	  conn = JDBCConnection.getDBConnection();
  }

  @Override
  public List<JobDetails> getAllDetails(){
	  List<JobDetails> dList = new ArrayList<JobDetails>();
	  try {
		  String query="select * from JobDetails";
		  Statement stmt = conn.createStatement();
		  ResultSet rst = stmt.executeQuery(query);
		  if(rst!=null) {
			  JobDetails d = new JobDetails();
			  while(rst.next()) {
				  d.setJobId(rst.getInt(1));
				  d.setJobTitle(rst.getString(2));
				  d.setJobDescription(rst.getString(3));
				  d.setCompanyName(rst.getString(4));
				  d.setLocation(rst.getString(5));
				  d.setKeyskill(rst.getString(6));
				  d.setSalary(rst.getFloat(7));
				  d.setExperience(rst.getInt(8));
				  d.setActive(rst.getString(9));
				  dList.add(d);
				  
			  }
		  }
	  
	  }catch(SQLException ex) {
		  System.out.println(ex);
	  }
	  return dList;
  }
  
  @Override
  
  public void addDetails(JobDetails d) {
	  try {
		  String query ="insert into JobDetails(JobTitle,JobDescription,CompanyName,Location,Keyskill,Salary,Experience,Active)values(?,?,?,?,?,?,?,?)";
	      PreparedStatement pst = conn.prepareStatement(query);
	      pst.setString(1, d.getJobTitle());
	      pst.setString(2, d.getJobDescription());
	      pst.setString(3, d.getCompanyName());
	      pst.setString(4,d.getLocation());
	      pst.setString(5, d.getKeyskill());
	      pst.setFloat(6,d.getSalary());
	      pst.setInt(7, d.getExperience());
	      pst.setString(8, d.getActive());
	      int i = pst.executeUpdate();
	      if(i==1) {
	    	  System.out.println("1 record Inserted...");
	      }
	      else {
	    	  System.out.println("Insertion failed...");
	      }
	  }catch(SQLException ex) {
		  System.out.println(ex);
	  }
  }
   
  @Override
  public JobDetails getDetailsById(int id) {
	JobDetails d = new JobDetails();
	try {
		String query = "select * from JobDetails where Jobid=?";
	    PreparedStatement pst = conn.prepareStatement(query);
	    pst.setInt(1,id);
	    ResultSet rst =pst.executeQuery(query);
	    if(rst!=null) {
	    	while(rst.next()) {
	    		d.setJobId(rst.getInt(1));
	    		d.setJobTitle(rst.getString(2));
	    		d.setJobDescription(rst.getString(3));
	    		d.setCompanyName(rst.getString(4));
	    		d.setLocation(rst.getString(5));
	    		d.setKeyskill(rst.getString(6));
	    		d.setSalary(rst.getFloat(7));
	    		d.setExperience(rst.getInt(8));
	    		d.setActive(rst.getString(9));
	    	}
	    }
	}catch(SQLException ex) {
		System.out.println(ex);
	}
	return d;
  }
  
 /* @Override
  public void updateDetails(JobDetails d) {
	  try {
		  String query = "UPDATE Employee SET JobTitle =?,CompanyName=? WHERE Jobid=?"; 
	      PreparedStatement statement = conn.prepareStatement(query);
	      statement.setString(1,d.getJobTitle());
	      statement.setString(2,d.getCompanyName());
	      statement.setInt(3,d.getJobId() );
	      int rowsUpdated = statement.executeUpdate();
	      if(rowsUpdated >0) {
	    	  System.out.println("An Existing user was updated Successfully!");
	    	 
	      }
	      else {
	    	  System.out.println("Updation failed...");
	      }
	  
	  }catch(SQLException ex) {
		  System.out.println(ex);
	  }
  }
  */
  @Override
  public void deactiveDetails(JobDetails d) {
	try {
		//creating PreparedStatement object by passing query string
		PreparedStatement pst=conn.prepareStatement("update jobdetails set Active=? where JobId=?");
		pst.setString(1, "Deactive");
		pst.setInt(2, d.getJobId());
		int i=pst.executeUpdate();
		if(i==1){
			System.out.println("Jobid deactivated...");
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
	public void activeDetails(JobDetails d) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Jobdetail set Active=? where JobId=?");
			pst.setString(1, "Active");
			pst.setInt(2, d.getJobId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Jobid Activated...");
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
  public void deleteDetails(int id) {
	  try {
		  PreparedStatement pst = conn.prepareStatement("delete from JobDetails where Jobid=?");
	      pst.setInt(1, id);
	      int i = pst.executeUpdate();
	      if(i==1) {
	    	  System.out.println("JobDetails deleted...");
	      }
	      else {
	    	  System.out.println("deletion failed...");
	      }
	  }catch(SQLException ex) {
		  System.out.println(ex);
	  }
  }
  
  
}
