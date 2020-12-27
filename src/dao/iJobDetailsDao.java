package dao;
import java.util.*;

import model.JobDetails;
public interface iJobDetailsDao {
  List<JobDetails> getAllDetails();
  void addDetails(JobDetails d);
  JobDetails getDetailsById(int id);
  void deactiveDetails(JobDetails d);
  void activeDetails(JobDetails d);
  void deleteDetails(int id);
}
