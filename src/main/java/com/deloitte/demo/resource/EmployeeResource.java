package com.deloitte.demo.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.deloitte.demo.model.Employee;
import com.deloitte.demo.service.EmployeeService;

@Path("/employee")
public class EmployeeResource {

	private EmployeeService empService = new EmployeeService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeById(@PathParam("id") int employeeId) {
		Employee employee = empService.getEmployeeById(employeeId);
		if (employee != null) {
			return Response.ok(employee).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("Employee not found").build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEmployee(Employee employee) {
		Employee newEmployee = empService.addEmployee(employee);
		return Response.status(Response.Status.CREATED).entity(newEmployee).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmployee(@PathParam("id") int employeeId, Employee employee) {
		employee.setId(employeeId); // Ensure the ID is set correctly
		Employee updatedEmployee = empService.updateEmployee(employee);
		if (updatedEmployee != null) {
			return Response.ok(updatedEmployee).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("Employee not found").build();
		}
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEmployee(@PathParam("id") int employeeId) {
		empService.deleteEmployee(employeeId);
		return Response.status(Response.Status.NO_CONTENT).build();
	}

}