package t;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends DBOper{
	public List<User> getUser(){
        List<User>userList = new ArrayList<User>();
        User user = new User();
        String sql = "select * from user";
        try{
            ResultSet rs = this.executeQuery(sql,null);
            while(rs.next()){
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                userList.add(user);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.closeAll();
        }
        return userList;
    }
    //根据用户名获取用户
    public User getUserByName(String username){
        User user = null;
        String sql = "select * from user where username = ?";
        try{            
            ResultSet rs = this.executeQuery(sql,new String[]{username});
            if(rs.next()){
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.closeAll();
        }
        return user;
    }
    //修改用户信息
    public boolean editUser(User user){
        boolean r = false;
        String sql = "update user set userpass = ?,name = ? where username = ?";
        try{
            int num = this.executeUpdate(sql, new String[]{user.getPassword(),user.getName(),user.getUsername()});
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
    //添加用户
    public boolean addUser(User user){
        boolean r = false;
        String sql = "insert into user(username,password,name)values(?,?,?) ";
        try{
            int num = this.executeUpdate(sql,new String[]{user.getUsername(),user.getPassword(),user.getName()});
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
    //删除指定用户
    public boolean delUser(String name){
        boolean r = false;
        String sql = "DELETE FROM user WHERE username = ?";
        try{
            int num = this.executeUpdate(sql,new String[]{name});
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
