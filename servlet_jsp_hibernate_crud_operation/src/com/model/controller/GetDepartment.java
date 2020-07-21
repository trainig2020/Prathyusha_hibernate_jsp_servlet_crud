package com.model.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.dto.Department;
import com.model.service.DepartmentService;

/**
 * Servlet implementation class GetDepartment
 */
@WebServlet("/GetDepartment")
public class GetDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDepartment() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptid =Integer.parseInt(request.getParameter("DeptID"));
	     Department dept=DepartmentService.getDepartment(deptid);
	     
		 request.setAttribute("department", dept);
		 
		 HttpSession session = request.getSession();
		 List<Department> lst= (List<Department>) session.getAttribute("getAllDept1");
		 
		 request.setAttribute("getalldept1", lst);
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("alldepartments.jsp");
		 dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
