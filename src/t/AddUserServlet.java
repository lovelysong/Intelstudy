package t;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
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
	    request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset = utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        PrintWriter out = response.getWriter();
        ServletContext ctx = this.getServletContext();
        String server = ctx.getInitParameter("server");
        String dbname = ctx.getInitParameter("dbname");
        String dbuser = ctx.getInitParameter("dbuser");
        String dbpwd = ctx.getInitParameter("dbpwd");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        UserDao dao = new UserDao();
        dao.getConn(server, dbname, dbuser, dbpwd);
        if(username == ""||name == ""||password == "") {
			out.print("<html>");
    		out.print("<head>");
    		out.print("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>");
    		out.print("<title>注册失败</title>");
    		out.print("<link href='css/style.css' rel='stylesheet' type='text/css'>");
    		out.print("</head>");
    		out.print("<body>");
    		out.print("<div class='wrapper'>");
    		out.print("<form action='addUser.jsp' method='post'>");
    		out.print(" <div class='header'>各类信息不能为空</div><br>");
            out.print("<ul>");
            out.print("<li>");
            out.print("<input type=\"submit\" value=\"重新注册\">");
            out.print("</li>");
            out.print("</ul>");
            out.print("</form>");
            out.print("<div class=\"footer\">");            
            out.print("<a href=\"\">Copyright ©2018 Guo YuHao</a>");
            out.print("</div>");
            out.print("</div>");
            out.print("</body>");
            out.print("</html>");
            return ;
        }
        if(dao.addUser(user)){
        	response.sendRedirect(request.getContextPath()+"/login.jsp");
        	return ; 
        }
	}

}
