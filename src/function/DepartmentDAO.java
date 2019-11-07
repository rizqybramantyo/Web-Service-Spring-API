package function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Department;
import util.Connector;

public class DepartmentDAO {
Connection con = null;
	
	public DepartmentDAO() {
		Connector kon = new Connector();
		try {
			con = kon.open();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


}
	public List<Department> getAll() {
		// TODO Auto-generated method stub
		List<Department> result = new ArrayList<Department>();
		String query ="Select * from departments";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				Department dept =new Department();
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setLocationId(rs.getString("location_id"));
				dept.setManagerId(rs.getString("manager_id"));
				
				result.add(dept);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	public Department getID(int id) {
		// TODO Auto-generated method stub
		//List<Department> result = new ArrayList<Department>();
		Department deptr =  new Department();
		String query ="Select * from departments where department_id="+id;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				
				deptr.setDepartmentId(rs.getInt("department_id"));
				deptr.setDepartmentName(rs.getString("department_name"));
				deptr.setLocationId(rs.getString("location_id"));
				deptr.setManagerId(rs.getString("manager_id"));
				
				
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return deptr;
	}
	public int insertData(Department dpt) {
	String query ="INSERT INTO departments values "
			+ "(departments_seq.NEXTVAL,?,?,?)";
	PreparedStatement empInsert;
	int result1 = 0;
	try {
		
		empInsert = con.prepareStatement(query);
		//stmt = con.createStatement();
		//rs = stmt.executeQuery(query);
		//empInsert.setInt(1, dpt.getDepartmentId());
		empInsert.setString(1, dpt.getDepartmentName());
		empInsert.setString(2, dpt.getManagerId());
		empInsert.setString(3, dpt.getLocationId());
			
			result1 = empInsert.executeUpdate();
			
	}catch (SQLException e){
		e.printStackTrace();
	}		
	return result1;
}



	
}