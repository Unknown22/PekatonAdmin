package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PracownikDao;
import dao.SprintDao;
import dao.ZadanieDao;
import model.Pracownik;
import model.Sprint;
import model.Zadanie;

/**
 * Servlet implementation class PracownikController
 */
@WebServlet("/SprintController")
public class SprintController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String PAGE_SPRINT_LIST = "/sprinty.jsp";
	private Sprint sprint;
	private SprintDao dao;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SprintController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward = "";
		String action = request.getParameter("action");
		System.out.println("ZadanieController - action:"  + action);
		dao = new SprintDao();
		
		switch (action) {
		case "listSprinty":
			forward = PAGE_SPRINT_LIST;
			List<Sprint> sprinty = new ArrayList<Sprint>();
			
			System.out.println("LIST SPRINTY: ");
			
			sprinty =  dao.getSprintAll();
			
			for (Sprint sprint : sprinty) {
				System.out.println(sprint);
			}
			
			request.setAttribute("sprinty", sprinty);
			
			break;
		case "deleteSprint":
			showAllParams(request);
			
			int id = Integer.parseInt(request.getParameter("id"));
			dao.deleteSprintByID(id);
			forward = PAGE_SPRINT_LIST;
			request.setAttribute("sprinty", dao.getSprintAll());
			break;
			
		
		default:
			break;
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("\nPassed parameters POST:");
		Enumeration<String> paramNames = request.getParameterNames();
	
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			System.out.print(paramName + ": ");
			String paramValue = request.getParameter(paramName);
			System.out.println(paramValue);
		}
		
		Sprint sprint = new Sprint(0, request.getParameter("poczatek"), request.getParameter("koniec"));
		
		dao = new SprintDao();
		
		dao.addSprint(sprint);
		
		
		
		response.sendRedirect("indexSprinty.jsp");
	}

	
	public void showAllParams(HttpServletRequest request){
		System.out.println("\nPassed parameters:");
		Enumeration<String> paramNames = request.getParameterNames();
	
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			System.out.print(paramName + ": ");
			String paramValue = request.getParameter(paramName);
			System.out.println(paramValue);
		}
	}
}
