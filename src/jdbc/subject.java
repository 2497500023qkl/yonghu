package jdbc;

import user.member;

import java.sql.*;
import java.util.Scanner;

public class subject {
    public  static void main(String [] args){
        String s=null;
        method me=new method();
        member ber=new member();
        Scanner shu=new Scanner(System.in);
        try{
            for(;;){
                String c=shu.next();
                if(c.equals("查看")){
                    s=me.cha();
                    System.out.print(s+"\n");
                }else if(c.equals("添加")){
                    System.out.println("依次输入用户名和电话");
                    ber.setUsername(shu.next());
                    ber.setPhone(shu.next());
                    s=me.zeng(ber);
                    System.out.print(s+"\n");
                }else if(c.equals("修改")){
                    System.out.println("依次输入用户名和电话之后是被修改的用户名");
                    ber.setUsername(shu.next());
                    ber.setPhone(shu.next());
                    s=me.gai(shu.next(),ber);
                    System.out.print(s+"\n");
                }else if(c.equals("删除")){
                    System.out.println("要删除的用户名");
                    s=me.shan(shu.next());
                    System.out.print(s+"\n");
                }else{
                    break;
                }
            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
