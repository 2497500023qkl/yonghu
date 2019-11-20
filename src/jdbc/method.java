package jdbc;

import java.sql.*;
import user.member;
public class method {

    PreparedStatement ps=null;
    String zheng="^[1]{1}[0-9]{10}$";
    Connection conn=null;
    public String cha() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qkl","root","1234");
        String sql= "SELECT *FROM jdbc";
        String s="";
        ps=conn.prepareStatement(sql);
        ResultSet a=ps.executeQuery();
        while (a.next()){
            s += ("姓名"+a.getString("username")+"电话"+a.getInt("dianhua")+"\n");
        }
        return s;
    };
    public String zeng(member ber) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String s="";
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qkl","root","1234");
        String sql= "INSERT into jdbc(username,dianhua) values(?,?)";
        ps=conn.prepareStatement(sql);
        if(!ber.getPhone().matches(zheng)){
            return "手机号错误";
        }
        ps.setString(1, ber.getUsername());
        ps.setString(2, ber.getPhone());
        if(ps.executeUpdate()>0){
            s="成功";
        }else{
            s="失败";
        }
        return s;
    };
    public String gai(String name,member ber) throws SQLException, ClassNotFoundException {
        if(!ber.getPhone().matches(zheng)){
            return "手机号错误";
        }
        Class.forName("com.mysql.jdbc.Driver");
        String s="";
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qkl","root","1234");
        String sql= "UPDATE jdbc SET username=?,dianhua=? WHERE username=?";
        ps=conn.prepareStatement(sql);
        ps.setString(3, name);
        ps.setString(1, ber.getUsername());
        ps.setString(2, ber.getPhone());
        if(ps.executeUpdate()>0){
            s="成功";
        }else{
            s="失败";
        }
        return s;
    };
    public String shan(String name) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String s="";
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qkl","root","1234");
        String sql= "delete from jdbc where username=?";
        ps=conn.prepareStatement(sql);
        ps.setString(1, name);
        if(ps.executeUpdate()>0){
            s="成功";
        }else{
            s="失败";
        }
        return s;
    };

}
