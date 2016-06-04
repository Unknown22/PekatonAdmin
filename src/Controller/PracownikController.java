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
import model.Pracownik;

/**
 * Servlet implementation class PracownikController
 */
@WebServlet("/PracownikController")
public class PracownikController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String PAGE_PRACOWNICY_LIST = "/pracownicy.jsp";
	private Pracownik pracownik;
	private PracownikDao dao;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PracownikController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward = "";
		String action = request.getParameter("action");
		System.out.println("PracownikController - action:"  + action);
		dao = new PracownikDao();
		
		switch (action) {
		case "listPracownicy":
			forward = PAGE_PRACOWNICY_LIST;
			List<Pracownik> pracownicy = new ArrayList<Pracownik>();
			
//			System.out.println("LIST PRACOWNICY: ");
			
//			pracownicy = dao.getAllPracownik();
//			
//			for (Pracownik pracownik : pracownicy) {
//				System.out.println(pracownik);
//			}
			
			request.setAttribute("pracownicy", dao.getAllPracownik());
			
			break;
		case "deletePracownik":
			showAllParams(request);
			
			int id = Integer.parseInt(request.getParameter("id"));
			dao.deletePracownik(id);
			forward = PAGE_PRACOWNICY_LIST;
			request.setAttribute("pracownicy", dao.getAllPracownik());
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
		
		pracownik = new Pracownik(0, request.getParameter("login"), request.getParameter("haslo"), request.getParameter("stanowisko"), 0);
		dao = new PracownikDao();
		
		boolean result = dao.addPracownik(pracownik);
		
		if(result){
			System.out.println("DODANO " + pracownik);
			response.sendRedirect("indexPracownicy.jsp");
		}
		
		
		
		
		//doGet(request, response);
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
