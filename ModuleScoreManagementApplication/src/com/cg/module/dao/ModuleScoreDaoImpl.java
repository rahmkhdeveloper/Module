package com.cg.module.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.module.dto.ModuleScoreBean;
import com.cg.module.exception.ModuleScoreException;
import com.cg.module.utility.DBUtil;

public class ModuleScoreDaoImpl implements IModuleScoreDao{

	Connection con = null;
	
	
	/***************************************************************************************
	 *
	 *Function Name						:getTraineeId()
	 *Initial Parameters				:	
	 *Return Type						:ArrayList<Integer>
	 *Throws							:SQLException, ModuleScoreException							
	 *Author							:Rahul Mukherjee
	 *Creation Date						:11/10/2017
	 *Description						:fetching Trainee-Id from the DataBase.
	 *				
	 ****************************************************************************************/
	
	@Override
	public ArrayList<Integer> getTraineeId() throws SQLException, ModuleScoreException {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> idList = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			String selectQuery = "SELECT trainee_id FROM trainees";
		
			PreparedStatement pss = con.prepareStatement(selectQuery);
			ResultSet rs = pss.executeQuery();
			
			while(rs.next()){
				idList.add(rs.getInt(1));
			}

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			throw new ModuleScoreException("ERROR: "+e.getMessage());
		}
		
		return idList;
		
	}

	

	/***************************************************************************************
	 *
	 *Function Name						:addDetails()
	 *Initial Parameters				:Bean Object<bean>
	 *Return Type						:Integer
	 *Throws							:SQLException, ModuleScoreException						
	 *Author							:Rahul Mukherjee
	 *Creation Date       				:11/10/2017
	 *Description 						:insert data into the DataBase.	
	 *			
	 ****************************************************************************************/

	
	@Override
	public int addDetails(ModuleScoreBean bean) throws SQLException, ModuleScoreException {
		// TODO Auto-generated method stub
		int row  = 0;
		
		try {
			con = DBUtil.getConnection();
			
			String insertQuery = "INSERT INTO AssessmentScore VALUES(?,?,?,?,?,?,?)";
			PreparedStatement psi = con.prepareStatement(insertQuery);
			
			psi.setInt(1, bean.getTraineeId());
			psi.setString(2, bean.getModuleName());
			psi.setInt(3, bean.getMpt());
			psi.setInt(4, bean.getMtt());
			psi.setInt(5, bean.getAssignment());
			psi.setInt(6, bean.getTotal());
			psi.setInt(7, bean.getGrade());
			
			row = psi.executeUpdate();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			throw new ModuleScoreException("ERROR: "+e.getMessage());
		}
		
		
		return row;
	}



	/***************************************************************************************
	 *
	 *Function Name						:getIdAndModule()
	 *Initial Parameters				:				
	 *Return Type						:ArrayList<ModuleScoreBean>
	 *Throws							:SQLException, ModuleScoreException 							
	 *Author							:Rahul Mukherjee
	 *Creation Date						:11/10/2017
	 *Description						:fetching Trainee-Id and Module-Name from the DataBase.
	 *				
	 ****************************************************************************************/
	
	
	public ArrayList<ModuleScoreBean> getIdAndModule() throws SQLException, ModuleScoreException {
		// TODO Auto-generated method stub
		
		ArrayList<ModuleScoreBean> scoreList = new ArrayList<ModuleScoreBean>();
		
		try {
			con = DBUtil.getConnection();
			
			String selectQuery = "select * from AssessmentScore";
			
			PreparedStatement pss = con.prepareStatement(selectQuery);
			ResultSet rs = pss.executeQuery();
			
			while(rs.next()){
				
				int traineeId = rs.getInt(1);
				String moduleName = rs.getString(2);

				scoreList.add(new ModuleScoreBean(traineeId, moduleName));

			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			throw new ModuleScoreException("ERROR: "+e.getMessage());
		}
		
		return scoreList;
	}

}
