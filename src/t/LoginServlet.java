package t;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	        PrintWriter out = response.getWriter();
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        ServletContext ctx = request.getServletContext();
	        String server = ctx.getInitParameter("server");
	        String dbname = ctx.getInitParameter("dbname");
	        String dbuser = ctx.getInitParameter("dbuser");
	        String dbpwd = ctx.getInitParameter("dbpwd");       
	        DBOper db = new DBOper();
	        db.getConn(server, dbname, dbuser, dbpwd);
	        String sql1 = "select username from user where username = ?";
	        ResultSet rs1 = db.executeQuery(sql1,new String[]{username});
	        String sql2 = "SELECT password FROM user WHERE password = ?";
	        ResultSet rs2 = db.executeQuery(sql2,new String[]{password});
	        if(username == "" || password == "") {
	        	out.print("<html>");
        		out.print("<head>");
        		out.print("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>");
        		out.print("<title登录信息为空</title>");
        		out.print("<link href='css/style.css' rel='stylesheet' type='text/css'>");
        		out.print("</head>");
        		out.print("<body>");
        		out.print("<div class='wrapper'>");
        		out.print("<form action='login.jsp' method='post'>");
        		out.print(" <div class='header'>登录信息为空</div><br>");
                out.print("<ul>");
                out.print("<li>");
                out.print("<input type=\"submit\" value=\"重新登陆\">");
                out.print("</li>");
                out.print("</ul>");
                out.print("</form>");
                out.print("<div class=\"footer\">");            
                out.print("<a href=\"\">Copyright ©2018 Guo YuHao</a>");
                out.print("</div>");
                out.print("</div>");
                out.print("</body>");
                out.print("</html>");
                return;
	        }
	        try {
	            if(rs1 != null && rs1.next()){
	            	if(rs2 != null && rs2.next()) {
	            	UserDao ud = new UserDao();
	            	ud.getConn(server, dbname, dbuser, dbpwd);
	            	User user = ud.getUserByName(username);
	                HttpSession session = request.getSession();
	                session.setAttribute("user",user);
	            	response.sendRedirect(request.getContextPath()+"/choose.jsp");
	            	return ;
	            	}
	            	else {
	            		out.print("<html>");
	            		out.print("<head>");
	            		out.print("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>");
	            		out.print("<title>密码错误</title>");
	            		out.print("<link href='css/style.css' rel='stylesheet' type='text/css'>");
	            		out.print("</head>");
	            		out.print("<body>");
	            		out.print("<div class='wrapper'>");
	            		out.print("<form action='login.jsp' method='post'>");
	            		out.print(" <div class='header'>密码错误</div><br>");
	                    out.print("<ul>");
	                    out.print("<li>");
	                    out.print("<input type=\"submit\" value=\"重新登陆\">");
	                    out.print("</li>");
	                    out.print("</ul>");
	                    out.print("</form>");
	                    out.print("<div class=\"footer\">");            
	                    out.print("<a href=\"\">Copyright ©2018 Guo YuHao</a>");
	                    out.print("</div>");
	                    out.print("</div>");
	                    out.print("</body>");
	                    out.print("</body>");
	                    out.print("</html>");
	                    return ;
	            	}
	            }else{
	            	out.print("<html>");
            		out.print("<head>");
            		out.print("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>");
            		out.print("<title>用户不存在</title>");
            		out.print("<link href='css/style.css' rel='stylesheet' type='text/css'>");
            		out.print("</head>");
            		out.print("<body>");
            		out.print("<div class='wrapper'>");
            		out.print("<form action='addUser.jsp' method='post'>");
            		out.print(" <div class='header'>用户不存在</div><br>");
                    out.print("<ul>");
                    out.print("<li>");
                    out.print("<input type=\"submit\" value=\"注册\">");
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
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }

	}

