import java.sql.*;

public class lib {
   
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://sql6.freemysqlhosting.net/sql6400624";

   static final String USER = "sql6400624";
   static final String PASS = "djZTpQeLFb";
   
   public static void main(String[] args) {
   System.out.println("Hello WOrld");
 
   Connection conn = null;
   Statement stmt = null;
   
   try{
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      System.out.println("Creating statement...");
      stmt = conn.createStatement();

      
      String sql = "SELECT BookName FROM Books where BookType=1";
      ResultSet rs = stmt.executeQuery(sql);
      System.out.println("All the books with digital type are as follows: ");
      while(rs.next()){
         String BookName = rs.getString("BookName");
         System.out.println("BookName: " + BookName);
      }


      sql = "SELECT BookName FROM Books ORDER BY BookName";
      rs = stmt.executeQuery(sql);
      System.out.println("All the books in ascending order are as follows ");
      while(rs.next()){
         String BookName = rs.getString("BookName");
         System.out.println("BookName: " + BookName);
      }
      

      sql = "SELECT * from Books WHERE Author LIKE 'C%'";
      rs = stmt.executeQuery(sql);
      System.out.println("All the authors with names starting from C are as follows ");
      while(rs.next()){
         String BookName = rs.getString("Author");
         System.out.println("Author: " + BookName);
      }
      rs.close();

   }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){
      
      e.printStackTrace();
   }finally{
      
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
   System.out.println("Goodbye!");
}
}