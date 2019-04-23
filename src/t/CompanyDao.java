package t;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao extends DBOper{
	public List<Company> getCompany(){
        List<Company>companyList = new ArrayList<Company>();
        Company company = new Company();
        String sql = "select * from company";
        try{
            ResultSet rs = this.executeQuery(sql,null);
            while(rs.next()){
            	company.setCompanyname(rs.getString("companyname"));
            	company.setName(rs.getString("name"));
            	company.setIp(rs.getString("ip"));
            	company.setTime(rs.getString("time"));
            	company.setUsername(rs.getString("username"));
            	companyList.add(company);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.closeAll();
        }
        return companyList;
    }
    public List<Company> getCompanyByCompanyName(String companyname){
    	List<Company> companyList = new ArrayList<Company>();
        Company company = new Company();
        String sql = "select * from company where¡¡companyname = ?";
        try{            
            ResultSet rs = this.executeQuery(sql, new String[]{companyname});
            while(rs.next()){
            	company.setIp(rs.getString("ip"));
                company.setTime(rs.getString("time"));
                company.setName(rs.getString("name"));
            	company.setUsername(rs.getString("username"));
            	companyList.add(company);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.closeAll();
        }
        return companyList;
    }
    public boolean addCompany(Company company){
        boolean r = false;
        String sql = "insert into company(companyname,name,time,ip,username)values(?,?,?,?,?) ";
        try{
            int num = this.executeUpdate(sql,new String[]{company.getCompanyname(),company.getName(),company.getTime(),company.getIp(),company.getUsername()});
            if(num > 0){
                r = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.closeAll();
        }
        return r;
    }
}
