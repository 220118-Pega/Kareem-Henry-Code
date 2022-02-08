/**
 * 
 */
package main.resources;

import com.revature.ersystem.model.Request;
import com.revature.ersystem.store.RequestDAO;

import io.javalin.Javalin;

public class Driver {

	public static void main(String[] args) {
		RequestDAO requestDAO = new RequestDAO();
		Javalin app = Javalin.create().start(7000);
		app.get("/main/resources", ctx -> ctx.result("Driver Test"));
		app.get("./request", ctx -> ctx.jsonStream(requestDAO.getAllRequest()));
		app.get("/request/{id}", ctx -> {
			String stringId = ctx.pathParam("id");
			int id = Integer.parseInt(stringId);
			Request ticketById = requestDAO.getTicketById(id);
			ctx.jsonStream(ticketById);
		});
		app.post("/model/Request", ctx -> RequestDAO.addRequest(ctx.bodyStreamAsClass(Request.class)));
	}

}