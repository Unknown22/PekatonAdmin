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
@WebServlet("/ZadanieController")
public class ZadanieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String PAGE_ZADANIA_LIST = "/zadania.jsp";
	private String PAGE_ZADANIA_ADD = "/zadanieAdd.jsp";
	
	private Zadanie zadanie;
	private ZadanieDao dao;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZadanieController() {
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
		dao = new ZadanieDao();
		
		System.out.println("\nPassed parameters:");
		Enumeration<String> paramNames = request.getParameterNames();
	
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			System.out.print(paramName + ": ");
			String paramValue = request.getParameter(paramName);
			System.out.println(paramValue);
		}
		
		switch (action) {
		case "listZadania":
			forward = PAGE_ZADANIA_LIST;
			List<Zadanie> zadania = new ArrayList<Zadanie>();
			
			System.out.println("LIST ZADANIA: ");
			
			zadania =  dao.getZadaniaAll();
			
			for (Zadanie zadanie : zadania) {
				System.out.println(zadanie);
			}
			
			request.setAttribute("zadania", zadania);
			
			break;
		case "zeSprintu":
			forward = PAGE_ZADANIA_LIST;
			List<Zadanie> zadania1 = new ArrayList<Zadanie>();
			int id1 = Integer.parseInt(request.getParameter("idS"));
			System.out.println("LIST SPrintu: ");
			
			zadania1 =  dao.getZadaniaBySprint(id1);
			
			for (Zadanie zadanie : zadania1) {
				System.out.println(zadanie);
			}
			
			request.setAttribute("zadania", zadania1);
			
			break;
		case "deleteZadanie":
			showAllParams(request);
			
			int id = Integer.parseInt(request.getParameter("id"));
			dao.deleteZadanieByID(id);
			forward = PAGE_ZADANIA_LIST;
			request.setAttribute("zadania", dao.getZadaniaAll());
			break;
			
		case "getSprintsPracownikList":
			
			showAllParams(request);
			
			forward = PAGE_ZADANIA_ADD;
			
			SprintDao dao = new SprintDao();
			List<Sprint> sprinty = new ArrayList<Sprint>();
			System.out.println("LIST SPRINTY: ");
			sprinty =  dao.getSprintAll();
			for (Sprint sprint : sprinty) {
				System.out.println(sprint);
			}
			
			request.setAttribute("sprinty", sprinty);
			
			
			PracownikDao pracownikDao = new PracownikDao();
			List<Pracownik> pracownicy = new ArrayList<Pracownik>();
			System.out.println("LIST Pracownicy: ");
			pracownicy =  pracownikDao.getAllPracownik();
			for (Pracownik pracownik : pracownicy) {
				System.out.println(pracownik);
			}
			
			request.setAttribute("pracownicy", pracownicy);
			
			break;
			
		case "verifiedZadanie":
			showAllParams(request);
			
			int idZ = Integer.parseInt(request.getParameter("id"));
			ZadanieDao daoZad = new ZadanieDao();
			daoZad.verifyZadanie(idZ);
			
			forward = PAGE_ZADANIA_LIST;
			request.setAttribute("zadania", daoZad.getZadaniaAll());
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
		
		//zadanie = new Zadanie(0, request.getParameter("opis"), Integer.parseInt(request.getParameter("doswiadczenie")), request.getParameter("zleceniodawca"), 0, 0);
		

		zadanie = new Zadanie(0, request.getParameter("opis"), Integer.parseInt(request.getParameter("doswiadczenie")), request.getParameter("zleceniodawca"), Integer.parseInt(request.getParameter("pracownikID")), "", 0, 1, "", "");
		dao = new ZadanieDao();
		
		boolean result = dao.addZadanie(zadanie);
		
		if(result){
			System.out.println("DODANO " + zadanie);
			response.sendRedirect("indexZadania.jsp");
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
