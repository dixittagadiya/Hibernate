package controller;

import java.io.IOException;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

@WebServlet("/reg")
public class RegistrationController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Student st = new Student();
		String id = req.getParameter("id");
		if(id.equals("") || id.equals(null))
		{
			
		}
		else
		{
			st.setId(Integer.parseInt(id));
		}
		st.setUname(req.getParameter("uname"));
		st.setEmail(req.getParameter("email"));
		st.setPass(req.getParameter("pass"));
		st.setPhone(req.getParameter("phone"));
		
		StudentDao dao = new StudentDao();
		int i = dao.addOrUpdate(st);
		if(i>0)
		{
			if(id.equals("") || id.equals(null))
			{
				req.setAttribute("msg", "reg Successfull");
			}
			else
			{
				req.setAttribute("msg", "update Successfull");
			}
			req.getRequestDispatcher("Index.jsp").forward(req, resp);
		}
		
	}
}
