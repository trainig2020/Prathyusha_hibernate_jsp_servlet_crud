package com.model.service;

import java.util.List;

import com.model.dao.DepartmentDao;
import com.model.dto.Department;

public class DepartmentService {
	
	public static String createDepartment(Department dept) { 
	    return new DepartmentDao().createDepartment(dept);
	  }
	public static String updateDepartment(Department dept) { 
	    return new DepartmentDao().updateDepartment(dept);
	  }
	public static Department getDepartment(int deptid) {
		return new DepartmentDao().getDepartment(deptid);
	}
	public static String deleteDepartment(int deptid) { 
		return new DepartmentDao().deleteDepartment(deptid);
	  }
	public static List<Department>getAllDepartments() {
		return new DepartmentDao().getAllDepartments();
	}


}
