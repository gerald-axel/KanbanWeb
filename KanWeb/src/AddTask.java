import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer= response.getWriter();
		writer.print("<html>"
				+ "<head>"
				+"<title>Add Task</title>"
				+ "</head>"
				+"<body>"
				+"<form method=\"POST\">"
				+"<table>"
				+"<tr>"
				+"<td>Tittle:</td>"
				+"<td>"
				+"<input type=\"text\" name=\"title\"/>"
				+"</td>"
				+"</tr>"
				
				+"<tr>"
				+"<td>Description:</td>"
				+"<td>"
				+"<input type=\"text\" name=\"description\"/>"
				+"</td>"
				+"</tr>"
				
				+"<tr>"
				+"<td>Category:</td>"
				+"<td>"
				+"<input type=\"text\" name=\"category\"/>"
				+"</td>"
				+"</tr>"
				

				+"<tr>"
				+"<td>Owner:</td>"
				+"<td>"
				+"<input type=\"text\" name=\"owner\"/>"
				+"</td>"
				+"</tr>"
				
				+"<tr>"
				+"<td>Prioridad:</td>"
				+"<td>"
				+"<input type=\"text\" name=\"priority\"/>"
				+"</td>"
				+"</tr>"
				
				+"<tr>"
				+"<td>State:</td>"
				+"<td>"
				+"<select name=\"state\">"
				+"<option value=\"BACKLOG\"selected>BackloG</option>"
				+"<option value=\"TO_DO\">To do</option>"
				+"<option value=\"IN_PROGRESS\">In progress</option>"
				+"<option value=\"DONE\">done</option>"
				+"</select>"	
				+"</td>"
				+"</tr>"
				
				+"<tr>"
				+"<td>Due Date:</td>"
				+"<td>"
				+"<input type=\"text\" name=\"duedate\"/>" 
				+"</td>"
				+"</tr>"
				
				+"<tr>"
				+"<td colspan=\"2\">"
				+"<input type=\"submit\" value=\"Add\"/>"
				+"</td>"
				+"<tr>"


				+"</table>"
				+"</form>"
				+"</body>"
				+"</html>");
	} 
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {		
		
		Task t=new Task();

		t.setTitle(request.getParameter("title"));
		t.setDescription(request.getParameter("description"));
		t.setOwner(request.getParameter("owner"));
		t.setCategory(new Category(request.getParameter("category")));		
		
		SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
		
		try {
			t.setDueDate(formatter.parse(request.getParameter("duedate")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			t.setState(State.valueOf(request.getParameter("state")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			t.setPriority(Short.parseShort(request.getParameter("priority")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Program.dashboard.add(t);
		
		response.setContentType("text/html");
		PrintWriter writer= response.getWriter();

		writer.print("<html>"
		+"<body>"
		+"Title: " +request.getParameter("title")
		+"<br>"
		+"Description: "+request.getParameter("description")
		+"<br>"
		+"Owner: "+request.getParameter("owner")
		+"<br>"
		+"Category: "+request.getParameter("category")
		+"<br>"
		+"Due Date: "+request.getParameter("duedate")
		+"<br>"
		+"Priority: "+request.getParameter("priority")
		+"<br>"
		+"State: "+request.getParameter("state")
		+ "</table>"
		+"</body>"
		+"</html>");
	}

}
