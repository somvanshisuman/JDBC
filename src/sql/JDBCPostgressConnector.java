package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

 class JDBCPostgressConnector {



Connection con= null;
PreparedStatement ptstmt = null;
Statement stmt = null;
public static void main(String args[]) {

try{

Class.forName("org.postgresql.Driver"); // step - loading driver
Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/Company","postgres","admin"); //step 2 creating connection
Statement stmt=con.createStatement() ;//step - 3 - creating stement
ResultSet rs=stmt.executeQuery("select * from STUDENT1"); //10 rows, two column in table step 4 - execting query and getting result set
while(rs.next()) { // iterating 
String lastname = rs.getString(1);
String firstname = rs.getString(2);
System.out.println(lastname+" "+firstname+" "+rs.getString(3));

}
JDBCPostgressConnector connector = new JDBCPostgressConnector();
// connector.insert(con);
con.close();
}catch(Exception e){e.printStackTrace();}
}
}