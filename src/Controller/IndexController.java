package Controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import model.Login;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String PAGE_INDEX = "/index.jsp";
	private dao.utils utils;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward = "";
		HttpSession sesja = request.getSession();
		String action = request.getParameter("action");

		if (action.equals("wyloguj")){
			System.out.println("WYLOGUJ");
			sesja.invalidate();
			forward = "login.html";
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		}
		
			forward = PAGE_INDEX;
			utils = new dao.utils();

			int liczbaPracownikow = utils.getLiczbaPracownikow();
			int liczbaZadan = utils.getLiczbaZadan();
			int liczbaSprintow = utils.getLiczbaSprintow();
			int liczbaZadan0 = utils.getLiczbaZadanByStatus(0);
			int liczbaZadan1 = utils.getLiczbaZadanByStatus(1);
			int liczbaZadan2 = utils.getLiczbaZadanByStatus(2);

			request.setAttribute("liczbaPracownikow", liczbaPracownikow);
			request.setAttribute("liczbaZadan", liczbaZadan);
			request.setAttribute("liczbaSprintow", liczbaSprintow);
			request.setAttribute("liczbaZadan0", liczbaZadan0);
			request.setAttribute("liczbaZadan1", liczbaZadan1);
			request.setAttribute("liczbaZadan2", liczbaZadan2);

			
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		System.out.println("\nPassed parameters:");
//		Enumeration<String> paramNames = request.getParameterNames();
//	
//		while (paramNames.hasMoreElements()) {
//			String paramName = (String) paramNames.nextElement();
//			System.out.print(paramName + ": ");
//			String paramValue = request.getParameter(paramName);
//			System.out.println(paramValue);
//		}
		HttpSession sesja = request.getSession();

		LoginDao loginDao = new LoginDao();
		String log = request.getParameter("log");
		String pass = request.getParameter("pass");
		Login user = new Login();
		user.setLogin(log);
		user.setPassword(pass);
		
		boolean result = loginDao.validate(user);
		
		System.out.println(log + " : " + pass + " - " + result);
		
		if(result){
			sesja.setAttribute("user", user);
			response.sendRedirect("indexIndex.jsp");
		}
			
		else
			response.sendRedirect("login.html");
		
	}

}
