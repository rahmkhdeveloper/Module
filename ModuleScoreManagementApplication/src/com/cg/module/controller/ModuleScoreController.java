package com.cg.module.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.module.dto.ModuleScoreBean;
import com.cg.module.exception.ModuleScoreException;
import com.cg.module.service.IModuleScoreService;
import com.cg.module.service.ModuleScoreServiceImpl;


/**
 * Servlet implementation class ModuleScoreController
 */
@WebServlet("*.obj")
public class ModuleScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	/***************************************************************************************
	 *
	 *Function Name						:doGet()
	 *Initial Parameters				:HttpServletRequest request, HttpServletResponse response
	 *Return Type						:void
	 *Throws							:SQLException, IOException					
	 *Author							:Rahul Mukherjee
	 *Creation Date						:11/10/2017
	 
	 *				
	 ****************************************************************************************/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		IModuleScoreService service = new ModuleScoreServiceImpl();
		ModuleScoreBean bean = null;
		
		String path = request.getServletPath();
		System.out.println(path);
		String target = null;
		
		int row = 0;
		
		switch(path){
		
		case "/add.obj":
			

			try {
				System.out.println("hi");
				ArrayList<Integer> idList = service.getTraineeId();

				System.out.println("hi");
				session.setAttribute("idList", idList);
				target = "AddAssessment.jsp";
				
			} catch (SQLException | ModuleScoreException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				
				session.setAttribute("exception", e.getMessage());
				target = "exception.jsp";
				
			}
			
			break;
			
		case "/getDetails.obj":
			
			int traineeId = Integer.parseInt(request.getParameter("traineeId"));
			String moduleName = request.getParameter("module");
			
			
			int mpt = Integer.parseInt(request.getParameter("mpt"));
			int mtt = Integer.parseInt(request.getParameter("mtt"));
			int assignment =Integer.parseInt(request.getParameter("assignment"));
			
			int total = service.getTotal(mpt, mtt, assignment);
			int grade = service.getGrade(total);
			
			
			bean = new ModuleScoreBean(traineeId, moduleName, mpt, mtt, assignment);
			try {
				
				ArrayList<ModuleScoreBean> idAndModule = service.getIdAndModule();

				int flag = 0;
				
				for(ModuleScoreBean m: idAndModule){
					
					if(m.getTraineeId() == traineeId && moduleName.equals(m.getModuleName())){
						
						flag=1;
						break;
					}
					
				}
				
				if(flag == 0){
				row = service.addDetails(bean);
				
					if(row>0){
						
						session.setAttribute("traineeId", traineeId);
						session.setAttribute("moduleName", moduleName);
						session.setAttribute("total", total);
						session.setAttribute("grade", grade);
						
						target = "ModuleScore.jsp";
					}
				}
				else {
					String message = "This data is already present in the database";
					session.setAttribute("exception", message);
					target = "exception.jsp";
				}
				
				
			} catch (SQLException | ModuleScoreException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				
				session.setAttribute("exception", e.getMessage());
				target = "exception.jsp";
			}
			
			
			break;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
