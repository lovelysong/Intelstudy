package t;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class ChooseServlet
 */
@WebServlet("/ChooseServlet")
public class ChooseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChooseServlet() {
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
		String[] companys = request.getParameterValues("company");
		HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String ip = request.getRemoteAddr();
        Calendar cal = Calendar.getInstance();
        java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String cdate = sdf.format(cal.getTime());
        int j = 0;
        PrintWriter out = response.getWriter();
        ServletContext ctx1 = request.getServletContext();
        String server1 = ctx1.getInitParameter("server");
        String dbname1 = ctx1.getInitParameter("dbname");
        String dbuser1 = ctx1.getInitParameter("dbuser");
        String dbpwd1 = ctx1.getInitParameter("dbpwd");       
        DBOper db = new DBOper();
        db.getConn(server1, dbname1, dbuser1, dbpwd1);
        String sql1 = "select username from company where username = ?";
        ResultSet rs1 = db.executeQuery(sql1,new String[]{user.getUsername()});
        try {
			if(rs1 != null && rs1.next()){
				out.print("<html>");
				out.print("<head>");
        		out.print("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>");
        		out.print("<title>错误界面</title>");
        		out.print("<link href='css/style.css' rel='stylesheet' type='text/css'>");
        		out.print("</head>");
        		out.print("<body>");
        		out.print("<div class='wrapper'>");
        		out.print("<form action='./ShowServlet' method='post'>");
                out.print(" <div class='header'>该用户已经投过票</div><br>");
                out.print("<ul>");
                out.print("<li>");
                out.print("<input type=\"submit\" value=\"查看结果\"><br>");
                out.print("</li>");
                out.print("</ul>");
                out.print("</form>");
                out.print("<div class=\"footer\">");            
                out.print("<a href=\"login.jsp\">重新登录</a>");
                out.print("</div>");
                out.print("</div>");
                out.print("</body>");
                out.print("</html>");
                return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        System.out.println(name +"\n"+ ip+"\n" +cdate);
		for(int i = 0;i < companys.length;i++) {
			if(companys[i].equals("MicroSoft")) {
		        ServletContext ctx = this.getServletContext();
		        String server = ctx.getInitParameter("server");
		        String dbname = ctx.getInitParameter("dbname");
		        String dbuser = ctx.getInitParameter("dbuser");
		        String dbpwd = ctx.getInitParameter("dbpwd");
		        CompanyDao dao = new CompanyDao();
		        dao.getConn(server, dbname, dbuser, dbpwd);
				Company com = new Company();
				com.setCompanyname("MicroSoft");
				com.setIp(ip);
				com.setName(user.getName());
				com.setTime(cdate);
				com.setUsername(user.getUsername());
				dao.addCompany(com);
				j++;
			}
			if(companys[i].equals("Sun")) {
		        ServletContext ctx = this.getServletContext();
		        String server = ctx.getInitParameter("server");
		        String dbname = ctx.getInitParameter("dbname");
		        String dbuser = ctx.getInitParameter("dbuser");
		        String dbpwd = ctx.getInitParameter("dbpwd");
		        CompanyDao dao = new CompanyDao();
		        dao.getConn(server, dbname, dbuser, dbpwd);
				Company com = new Company();
				com.setCompanyname("Sun");
				com.setIp(ip);
				com.setName(user.getName());
				com.setTime(cdate);
				com.setUsername(user.getUsername());
				dao.addCompany(com);
				j++;
			}
			if(companys[i].equals("IBM")) {
		        ServletContext ctx = this.getServletContext();
		        String server = ctx.getInitParameter("server");
		        String dbname = ctx.getInitParameter("dbname");
		        String dbuser = ctx.getInitParameter("dbuser");
		        String dbpwd = ctx.getInitParameter("dbpwd");
		        CompanyDao dao = new CompanyDao();
		        dao.getConn(server, dbname, dbuser, dbpwd);
				Company com = new Company();
				com.setCompanyname("IBM");
				com.setIp(ip);
				com.setName(user.getName());
				com.setTime(cdate);
				com.setUsername(user.getUsername());
				dao.addCompany(com);
				j++;
			}
			if(companys[i].equals("Oracle")) {
		        ServletContext ctx = this.getServletContext();
		        String server = ctx.getInitParameter("server");
		        String dbname = ctx.getInitParameter("dbname");
		        String dbuser = ctx.getInitParameter("dbuser");
		        String dbpwd = ctx.getInitParameter("dbpwd");
		        CompanyDao dao = new CompanyDao();
		        dao.getConn(server, dbname, dbuser, dbpwd);
				Company com = new Company();
				com.setCompanyname("Oracle");
				com.setIp(ip);
				com.setName(user.getName());
				com.setTime(cdate);
				com.setUsername(user.getUsername());
				dao.addCompany(com);
				j++;
			}
		}
		if(j == companys.length) {
			out.print("<html>");
    		out.print("<head>");
    		out.print("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>");
    		out.print("<title>投票成功</title>");
    		out.print("<link href='css/style.css' rel='stylesheet' type='text/css'>");
    		out.print("</head>");
    		out.print("<body>");
    		out.print("<div class='wrapper'>");
    		out.print("<form action='./ShowServlet' method='post'>");
    		out.print(" <div class='header'>投票成功</div><br>");
            out.print("<ul>");
            out.print("<li>");
            out.print("<input type=\"submit\" value=\"查看结果\">");
            out.print("</li>");
            out.print("</ul>");
            out.print("</form>");
            out.print("<div class=\"footer\">");            
            out.print("<a href=\"\">Copyright ©2018 Guo YuHao</a>");
            out.print("</div>");
            out.print("</div>");
            out.print("</body>");
            out.print("</html>");
		}
		
		}
	}

