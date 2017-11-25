package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Account;
import managers.AccountManager;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
       
    public LoginServlet() {
        super();
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	AccountManager ac = (AccountManager) request.getServletContext().getAttribute("accountManager");
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	String homepage = "/WEB-INF/jsp/Index.jsp";
		Account account = (Account) session.getAttribute("account");
    	boolean verified = false;
    	
		if(account == null) {
			account = new Account();
		}
		else if(account.isLoggedIn() == true) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(homepage);
    		dispatcher.forward(request, response);
		}
		try {
			verified = ac.verifyAccountInfo(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	if(verified == false) {
    		//show errors
    		
    	}
    	else {
    		account.setLoggedIn(true);
    		session.setAttribute("account", account);
    		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(homepage);
    		dispatcher.forward(request, response);
    	}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
