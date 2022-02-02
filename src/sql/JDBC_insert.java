package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_insert {
	
	 private final String url = "jdbc:postgresql://localhost/Company";
	    private final String user = "postgres";
	    private final String password = "admin";
	    //private static final String DELETE_USERS_SQL = "delete from user1 where name=?";
	    //private static final String UPDATE_USERS_SQL = "UPDATE user1 SET name=?,address=? WHERE name=?";
	    private static final String INSERT_USERS_SQL = "INSERT INTO user1" +"  (name, address) VALUES " +" (?, ?);";
		private static final String String = null;

	    public static void main(String[] argv) throws SQLException {
	    	JDBC_insert createTableExample = new JDBC_insert();
	        createTableExample.insertRecord();
	    }

	    public void insertRecord() throws SQLException {
	        System.out.println(INSERT_USERS_SQL);
	        // Step 1: Establishing a Connection
	        try (Connection connection = DriverManager.getConnection(url, user, password);

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	           
	            preparedStatement.setString(1, "SUMAN");
	            preparedStatement.setString(2, "pune");
	            //preparedStatement.setString(3, "Suman");
	            preparedStatement.executeUpdate();
	            //("UPDATE user1  SET name='"+'Shri'+"' WHERE address='"+'pune'+"'");
	            //String SQL = "Update user1 SET name = 'Suman' WHERE address = 'Kop' ";
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            //preparedStatement.executeUpdate();
	        } catch (SQLException e) {

	            // print SQL exception information
	            //printSQLException(e);
	        }

	        // Step 4: try-with-resource statement will auto close the connection.
	    }

	   /* public static void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }*/
	}
