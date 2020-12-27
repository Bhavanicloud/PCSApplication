package controller;

import java.util.List;

import dao.iJobDetailsDao;
import daoImpl.iJobDetailsDaoImp;
import model.JobDetails;

public class JobDetailsController {
     iJobDetailsDao dDao = null;
     
     public JobDetailsController() {
    	 dDao = new iJobDetailsDaoImp();
     }
     
     public List<JobDetails> getAllDetails(){
    	 List<JobDetails> dList = dDao.getAllDetails();
    	 return dList;
     }
     
     public void addDetails(JobDetails d) {
    	 dDao.addDetails(d);
     }
     
     public JobDetails getDetailsById(int id) {
    	 JobDetails d = dDao.getDetailsById(id);
    	 return d;
     }
     
    
     
     public void deleteDetails(int id) {
    	 dDao.deleteDetails(id);
     }

	public void deactiveDetails(JobDetails d) {
		dDao.deactiveDetails(d);
		
	}
	public void activeDetails(JobDetails d) {
		dDao.activeDetails(d);
	}
     
     
     
}
