package com.cg.module.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.module.dto.ModuleScoreBean;
import com.cg.module.exception.ModuleScoreException;

public interface IModuleScoreDao {

	ArrayList<Integer> getTraineeId() throws SQLException, ModuleScoreException;

	int addDetails(ModuleScoreBean bean) throws SQLException, ModuleScoreException;

	ArrayList<ModuleScoreBean> getIdAndModule() throws SQLException, ModuleScoreException;

}
