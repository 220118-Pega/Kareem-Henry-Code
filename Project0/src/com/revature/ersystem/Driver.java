/**
 * 
 */
package com.revature.ersystem;

import com.revature.ersystem.model.*;
import com.revature.ersystem.store.*;

import io.javalin.Javalin;

public class Driver {

	public static void main(String[] args) {
		RequestDAO requestDAO = new RequestDAO();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		ManagerDAO managerDAO = new ManagerDAO();
		
		Javalin app = Javalin.create().start(7000);
		
		
		app.get("/", ctx -> ctx.result("Expense Reimburstment API"));
		
		
		app.get("/managers", ctx -> ctx.jsonStream(managerDAO.getAllManagers()));
		app.get("/manager/{id}", ctx -> {
			String stringMid = ctx.pathParam("id").toString();
			int mid = Integer.parseInt(stringMid);
			Manager managerById = managerDAO.getManagerById(mid);
			ctx.jsonStream(managerById);
		});
		
		app.post("/model/manager", ctx -> ManagerDAO.addManager(ctx.bodyStreamAsClass(Manager.class)));

		
		
		app.get("/employees", ctx -> ctx.jsonStream(employeeDAO.getAllEmployees()));
		app.get("/employee/{id}", ctx -> {
			String stringEid = ctx.pathParam("id").toString();
			int eid = Integer.parseInt(stringEid);
			Employee employeeById = EmployeeDAO.getEmployeeById(eid);
			ctx.jsonStream(employeeById);
		});
		
		app.post("/model/employee", ctx -> EmployeeDAO.addEmployee(ctx.bodyStreamAsClass(Employee.class)));
		
		
		app.get("/requests", ctx -> ctx.jsonStream(requestDAO.getAllRequests()));
		app.get("/request/{id}", ctx -> {
			String stringRid = ctx.pathParam("id");
			int rid = Integer.parseInt(stringRid);
			Request ticketById = requestDAO.getTicketById(rid);
			ctx.jsonStream(ticketById);
		});
		
		
		app.post("/model/request", ctx -> RequestDAO.addRequest(ctx.bodyStreamAsClass(Request.class)));
		
		
	}

}