
package connection;

import java.sql.DriverManager;
import java.sql.Statement;

public class Connection {
   public static Statement statementObject(){
        
         try{
           Class.forName("com.mysql.jdbc.Driver");
           System.out.println("Driver loaded");
       }catch(Exception e){
           System.out.println("driver not loaded");
       }
       java.sql.Connection con=null;
       try{
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/colzproj","root","");
           System.out.println("database connected");
       }catch(Exception e){
           System.out.println("database not connected");
       }
       
       Statement st=null;
       
       try{
           st=con.createStatement();  
       }catch(Exception e){
           System.out.println("query not executed");
       }
        return st;
    }  
}
