package com.cg.module.service;


import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.module.dao.IModuleScoreDao;
import com.cg.module.dao.ModuleScoreDaoImpl;
import com.cg.module.dto.ModuleScoreBean;
import com.cg.module.exception.ModuleScoreException;

public class ModuleScoreServiceImpl implements IModuleScoreService{

	
	IModuleScoreDao dao = new ModuleScoreDaoImpl();
	
	/***************************************************************************************
	 *
	 *Function Name						:getTraineeId()
	 *Initial Parameters				:				
	 *Return Type						:ArrayList<Integer>
	 *Throws							:SQLException, ModuleScoreException							
	 *Author							:Rahul Mukherjee
	 *Creation Date						:11/10/2017
	 *Description						:Concerned with retrieval and management of application data.
	 *				
	 ****************************************************************************************/
	
	@Override
	public ArrayList<Integer> getTraineeId() throws SQLException, ModuleScoreException {
		// TODO Auto-generated method stub
		return dao.getTraineeId();
	}
	
	/***************************************************************************************
	 *
	 *Function Name						:addDetails()
	 *Initial Parameters				:Bean Object<bean>			
	 *Return Type						:Integer
	 *Throws							:SQLException, ModuleScoreException 						
	 *Author							:Rahul Mukherjee
	 *Creation Date						:11/10/2017
	 *Description						:Concerned with processing and transformation of application data.
	 *				
	 ****************************************************************************************/
	
	@Override
	public int addDetails(ModuleScoreBean bean) throws SQLException, ModuleScoreException {
		// TODO Auto-generated method stub
		return dao.addDetails(bean);
	}
	

	/***************************************************************************************
	 *
	 *Function Name						:getIdAndModule() 
	 *Initial Parameters				:				
	 *Return Type						:ArrayList<ModuleScoreBean>
	 *Throws							:SQLException, ModuleScoreException							
	 *Author							:Rahul Mukherjee
	 *Creation Date						:11/10/2017
	 *Description						:Concerned with retrieval and management of application data.
	 *				
	 ****************************************************************************************/
	
	public ArrayList<ModuleScoreBean> getIdAndModule() throws SQLException, ModuleScoreException {
		// TODO Auto-generated method stub
		return dao.getIdAndModule() ;
	}
	
	/***************************************************************************************
	 *
	 *Function Name						:getTotal() 
	 *Initial Parameters				:mpt, mtt, assignment				
	 *Return Type						:int
	 *Throws							:					
	 *Author							:Rahul Mukherjee
	 *Creation Date						:11/10/2017
	 *Description						:Calculate the total score of the trainee.
	 *				
	 ****************************************************************************************/
	
	@Override
	public int getTotal(int mpt, int mtt, int assignment) {
		// TODO Auto-generated method stub
		return (mpt+mtt+assignment);
	}
	
	/***************************************************************************************
	 *
	 *Function Name						:getGrade() 
	 *Initial Parameters				:total				
	 *Return Type						:int
	 *Throws							:					
	 *Author							:Rahul Mukherjee
	 *Creation Date						:11/10/2017
	 *Description						:Calculate the grade score of the trainee.
	 *				
	 ****************************************************************************************/
	
	@Override
	public int getGrade(int total) {
		// TODO Auto-generated method stub
		int grade = 0;
		
		if(total>=50 && total<=59){
			grade = 1;
		}
		else if(total>=60 && total<=69){
			grade = 2;
		} 
		else if(total>=70 && total<=79){
			grade = 3;
		}
		else if(total>=80 && total<=89){
			grade = 4;
		}
		else if(total>=90 && total<=100){
			grade = 5;
		}
		
		return grade;
	}
	

}
