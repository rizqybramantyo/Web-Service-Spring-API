package service;

import javax.ws.rs.core.MediaType;

import function.DepartmentDAO;
import model.Department;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("hello")
public class TestService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello Jersey";
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html>" + "<title>" + "Hello Jersey" + "</title" + "<body><h1>" + "Hello Jersey" + "</h1></body>" + "</html>";
	}
	
	@GET
	@Path("collection")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Map> getList() {
		List<Map> result = new ArrayList<Map>();
		for(int i = 0; i<5;i++) {
			Map model = new HashMap();
			model.put("kolom 1", "data kolom 1 ke-" + i);
			model.put("kolom 2", "data kolom 2 ke-" + i);
			result.add(model);
		}
		return result;
	}

	@GET
	@Path("department/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Department getParameter(@PathParam("id")int id) {
		DepartmentDAO deptDAO = new DepartmentDAO();
		Department dept = deptDAO.getID(id);
		return dept;
	}
	
	//}
	@GET
	@Path("department")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Department> getDepartment() {
		DepartmentDAO deptDAO = new DepartmentDAO();
		List<Department> result = deptDAO.getAll();
		
		return result;
	}

}
