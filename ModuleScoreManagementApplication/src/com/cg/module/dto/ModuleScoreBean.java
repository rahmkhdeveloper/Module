package com.cg.module.dto;

public class ModuleScoreBean {

	private int traineeId; 
	private String moduleName;
	private int mpt, mtt, assignment;
	private int total, grade;
	
	

	/***************************************************************************************
	 *
	 *Constructor Name					:ModuleScoreBean()
	 *Initial Parameters				:traineeId, moduleName, mpt, mtt, assignment
	 *Return Type						:
	 *Throws							:						
	 *Author							:Rahul Mukherjee
	 *Creation Date						:11/10/2017
	
	 *				
	 ****************************************************************************************/
	
	public ModuleScoreBean(int traineeId, String moduleName, int mpt, int mtt,
			int assignment) {
		super();
		this.traineeId = traineeId;
		this.moduleName = moduleName;
		this.mpt = mpt;
		this.mtt = mtt;
		this.assignment = assignment;
	}
	
	
	/***************************************************************************************
	 *
	 *Constructor Name					:ModuleScoreBean()
	 *Initial Parameters				:traineeId, moduleName
	 *Return Type						:
	 *Throws							:						
	 *Author							:Rahul Mukherjee
	 *Creation Date						:11/10/2017
	
	 *				
	 ****************************************************************************************/
	
	public ModuleScoreBean(int traineeId, String moduleName) {
		super();
		this.traineeId = traineeId;
		this.moduleName = moduleName;
	}
	
	/*
	 * DEFAULT CONSTRUCTOR
	 */
	public ModuleScoreBean() {
		
		
	}
	
	
	
	
	
	
	/*
	 * GETTERS AND SETTERS
	 * 
	 */
	
	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	
	
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	
	public int getMpt() {
		return mpt;
	}
	public void setMpt(int mpt) {
		this.mpt = mpt;
	}
	
	
	public int getMtt() {
		return mtt;
	}
	public void setMtt(int mtt) {
		this.mtt = mtt;
	}
	
	
	public int getAssignment() {
		return assignment;
	}
	public void setAssignment(int assignment) {
		this.assignment = assignment;
	}
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	
}
