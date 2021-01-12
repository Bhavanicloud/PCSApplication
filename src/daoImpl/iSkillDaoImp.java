package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import model.SkillDetails;
import dao.iSkillDao;

public class iSkillDaoImp implements iSkillDao {
Connection conn=null;
	
	public iSkillDaoImp() {
		conn=JDBCConnection.getDBConnection();
	}

	@Override
	public List<SkillDetails> getAllSkillDetails() {
		List<SkillDetails> skList=new ArrayList<SkillDetails>();
		try {
			String query="select * from SkillDetails";
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(query);
			if(rst!=null) {
				SkillDetails sk=new SkillDetails();
				while(rst.next()) {
					sk.setSkillid(rst.getInt(1));
					sk.setSkillName(rst.getString(2));
					sk.setSkillDescription(rst.getString(3));
					skList.add(sk);
				}
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return skList;
	}

	@Override
	public void addSkillDetails(SkillDetails sk) {
		try {
			String query="insert into SkillDetails(SkillName,SkillDescription) values(?,?)";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1,sk.getSkillName());
			pst.setString(2,sk.getSkillDescription());
			
			int i=pst.executeUpdate();
			if(i==1) {
				System.out.println("1 record inserted...");
			}
			else {
				System.out.println("Insertion failed...");
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
	}

	@Override
	public SkillDetails getSkillDetailsById(int id) {
		SkillDetails sk=new SkillDetails();
		try {
			String query="select * from SkillDetails where SkillId=?";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery(query);
			if(rst!=null) {
				while(rst.next()) {
					sk.setSkillid(rst.getInt(1));
					sk.setSkillName(rst.getString(2));
					sk.setSkillDescription(rst.getString(3));
					
				}
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return sk;
	}

	
	@Override
	public void deactivateSkillDetails(SkillDetails sk) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update SkillDetails set Active=? where SkillId=?");
			pst.setString(1, "Deactive");
			pst.setInt(2, sk.getSkillid());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Employee deactivated...");
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
	public void activateSkillDetails(SkillDetails sk) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update SkillDetails set Active=? where SkillId=?");
			pst.setString(1, "Active");
			pst.setInt(2, sk.getSkillid());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Employee Activated...");
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
	public void deleteSkillDetails(int id) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("delete from SkillDetails where SkillId=?");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Employee deleted...");
			}
			else {
				System.out.println("deletion failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}	
		
	}
}