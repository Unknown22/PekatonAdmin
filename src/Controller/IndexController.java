package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward = "";
		
		String action = request.getParameter("action");
		
		if(action.equals("getNumbers"))
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
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
