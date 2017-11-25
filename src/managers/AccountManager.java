package managers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utilities.DatabaseConnection;

@WebListener
public class AccountManager implements ServletContextListener {
	
	private Connection conn;
	
	@Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("accountManager", this);
    }

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		sce.getServletContext().removeAttribute("accountManager");
	}
	
	public boolean verifyAccountInfo(String username, String password) throws SQLException {
		boolean verified = false;
		if(username == null || password == null) {
			return false;
		}
		try {
			conn = DatabaseConnection.getMySQLConnection();
			conn.setAutoCommit(false);
			Statement statement = conn.createStatement();
			String query = String.format("SELECT * FROM accounts WHERE username = '%s' AND password = '%s'", username, password);
			ResultSet result = statement.executeQuery(query);
			if(result.next() == true) {
				verified = true;
			}
			conn.commit();
			conn.close();
		} catch(Exception ex) {
			ex.printStackTrace();
			if(conn != null) {
				conn.rollback();
				conn.close();
			}
		}
		return verified;
	}
}
