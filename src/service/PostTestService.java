package service;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import function.DepartmentDAO;
import model.Department;

@Path("post")
public class PostTestService {
	
	@POST
	@Path("add")
	@Produces(MediaType.APPLICATION_JSON)
	public String addUser(@FormParam("id") int id,
						  @FormParam("name") String name,
						  @FormParam("man_id") String man_id,
						  @FormParam("loc_id") String loc_id) {
		
	
		DepartmentDAO deptDAO = new DepartmentDAO();
		List<Department> result = deptDAO.getAll();
		Department depart = new Department();
		//depart.setDepartmentId(id);
        depart.setDepartmentName(name);
        depart.setManagerId(man_id);
        depart.setLocationId(loc_id);
		deptDAO.insertData(depart);
        result =  deptDAO.getAll();
        
        return name+" "+man_id+" "+loc_id;
	}
	
//	@GET
//	@Path("department")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Department> getDepartment() {
//		DepartmentDAO deptDAO = new DepartmentDAO();
//		List<Department> result = deptDAO.getAll();
//		
//		return result;
//	}
//	
//	@GET
//	@Path("department/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Department getParameter(@PathParam("id")int id) {
//		DepartmentDAO deptDAO = new DepartmentDAO();
//		Department dept = deptDAO.getID(id);
//		return dept;
//	}	
}

