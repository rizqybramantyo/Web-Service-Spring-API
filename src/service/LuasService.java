package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import function.DepartmentDAO;
import model.Department;
import model.Persegi;
import model.Segitiga;

@Path("luas")
public class LuasService {
	
	@GET
	@Path("persegi/{sisi}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getParameter(@PathParam("sisi")int sisi) {
	
		Persegi psg = new Persegi();
		return "Luasnya adalah = "+psg.getLuas(sisi);
	}
	
	@GET
	@Path("segitiga/{alas}/{tinggi}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getParameter(@PathParam("alas")int alas,@PathParam("tinggi")int tinggi) {
	
		Segitiga sgt = new Segitiga();
		return "Luasnya adalah = "+sgt.getLuas(alas,tinggi);
	}

}
