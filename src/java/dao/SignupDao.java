/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Signup;

public class SignupDao {
          
      public String select(String email){
          String password = null;
       Statement st=Connection.statementObject();
       String sql="Select password from signup where email='"+email+"'";
          try {
              ResultSet rs=st.executeQuery(sql);
              rs.next();
             password= rs.getString("password");
          } catch (Exception e) {
              System.out.println(sql);
              System.out.println(e);
          }
          return password;
      }
      public int selind(String email){
          int index=0;
           Statement st=Connection.statementObject();
       String sql="Select session from signup where email='"+email+"'";
  
       try {
           ResultSet rs=st.executeQuery(sql);
              rs.next();
             index= rs.getInt("session");
             System.out.println(index);
             
          } catch (Exception e) {
              System.out.println(e);
          }
       return index;
      }
       public void update(String email){
       Statement st=Connection.statementObject();
       String sql="Update signup set session="+2+" where email='"+email+"'";
       try{
          st.executeUpdate(sql);
           System.out.println("data inserted");
          
       }catch(Exception e){
           System.out.println(sql);
           System.out.println(e);
       }
    
       }
       
       public int updatepass(String p,String m){
         Statement st=Connection.statementObject();
       String sql="Update signup set password='"+p+"' where email='"+m+"'";
       try{
          st.executeUpdate(sql);
           System.out.println("data updated");
          
       }catch(Exception e){
           System.out.println(sql);
           System.out.println(e);
       }
       return 0;
       }
}    
