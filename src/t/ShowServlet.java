package t;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset = utf-8");
        ServletContext ctx = request.getServletContext();
        String server = ctx.getInitParameter("server");
        String dbname = ctx.getInitParameter("dbname");
        String dbuser = ctx.getInitParameter("dbuser");
        String dbpwd = ctx.getInitParameter("dbpwd");       
        DBOper db = new DBOper();
        db.getConn(server, dbname, dbuser, dbpwd);
        String sql1 = "SELECT COUNT(*) FROM company WHERE companyname = \"MicroSoft\"";
        ResultSet rs1 = db.executeQuery(sql1,null);
        try {
			rs1.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int a = 0;
		try {
			a = rs1.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String sql2 = "SELECT COUNT(*) FROM company WHERE companyname = ?";
        ResultSet rs2 = db.executeQuery(sql2,new String[]{"Sun"});
        try {
			rs2.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int b = 0;
        try {
			b = rs2.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String sql3 = "SELECT COUNT(*) FROM company WHERE companyname = ?";
        ResultSet rs3 = db.executeQuery(sql3,new String[]{"IBM"});
        try {
			rs3.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int c = 0;
        try {
			c = rs3.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String sql4 = "SELECT COUNT(*) FROM company WHERE companyname = ?";
        ResultSet rs4 = db.executeQuery(sql4,new String[]{"Oracle"});
        try {
			rs4.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int d = 0;
        try {
			d = rs4.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.getSession().setAttribute("a", a);
		request.getSession().setAttribute("b", b);
        request.getSession().setAttribute("c", c);
        request.getSession().setAttribute("d", d);
        response.sendRedirect(request.getContextPath()+"/show.jsp");
	}

}
