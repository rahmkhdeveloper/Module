package com.cg.module.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.module.dto.ModuleScoreBean;
import com.cg.module.exception.ModuleScoreException;

public interface IModuleScoreService {

	ArrayList<Integer> getTraineeId() throws SQLException, ModuleScoreException;

	int getTotal(int mpt, int mtt, int assignment);

	int getGrade(int total);

	int addDetails(ModuleScoreBean bean) throws SQLException, ModuleScoreException;

	ArrayList<ModuleScoreBean> getIdAndModule() throws SQLException, ModuleScoreException;

	

}
