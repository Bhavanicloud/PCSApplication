package controller;

import java.util.List;

import dao.iSkillDao;
import daoImpl.iSkillDaoImp;
import model.SkillDetails;

public class SkillsController {

		iSkillDao skDao=null;
		
		public SkillsController() {
			skDao=new iSkillDaoImp();
		}
		
		public List<SkillDetails> getAllSkillDetails(){
			List<SkillDetails> skList=skDao.getAllSkillDetails();
			return skList;
		}
		
		public void addSkillDetails(SkillDetails sk) {
			skDao.addSkillDetails(sk);
		}
		public SkillDetails getSkillDetailsById(int id) {
			SkillDetails sk=skDao.getSkillDetailsById(id);
			return sk;
		}
		
		public void deleteSkillDetails(int id) {
			skDao.deleteSkillDetails(id);
		}
		public void deactivateSkillDetails(SkillDetails sk) {
			skDao.deactivateSkillDetails(sk);
		}
		public void activateSkillDetails(SkillDetails sk) {
			skDao.activateSkillDetails(sk);
		}
	}

