package servlet;

import java.io.File;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Repositorio {
	static File archivo = Paths.get(".").toAbsolutePath().normalize().toFile();
	static String ruta = archivo.toString() + "/src/main/resources/";

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver"; //org.h2.Driver
    static final String DB_URL = "jdbc:h2:" + ruta + "DBtest";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public static void main (String[] args) {
    	crearTablaIdiomas();
    }

    public static void crearTablaPaises(){
       	Connection conn = null;
           Statement stmt = null;

           try {
               //STEP 2: Register JDBC driver
               Class.forName("org.h2.Driver");

               //STEP 3: Open a connection
               System.out.println("Connecting to a selected database...");
               conn = DriverManager.getConnection(DB_URL, USER, PASS);
               System.out.println("Connected database successfully...");

               //STEP 4: Execute a query
               System.out.println("Creating table in given database...");
               stmt = conn.createStatement();

               String sql = "CREATE TABLE IF NOT EXISTS Paises " +
                       " (Nombre VARCHAR(255), " +
                       " Idioma VARCHAR(255), PRIMARY KEY (Nombre))";

               stmt.executeUpdate(sql);
               System.out.println("Created table in given database...");
           } catch (SQLException se) {
               //Handle errors for JDBC
               se.printStackTrace();
           } catch (Exception e) {
               //Handle errors for Class.forName
               e.printStackTrace();
           } finally {
               //finally block used to close resources
        	   closeStm(conn, stmt);
               closeCon(conn);
           } // end try
       }

    public static void crearTablaIdiomas(){
       	Connection conn = null;
           Statement stmt = null;

           try {
               //STEP 2: Register JDBC driver
               Class.forName("org.h2.Driver");

               //STEP 3: Open a connection
               System.out.println("Connecting to a selected database...");
               conn = DriverManager.getConnection(DB_URL, USER, PASS);
               System.out.println("Connected database successfully...");

               //STEP 4: Execute a query
               System.out.println("Creating table in given database...");
               stmt = conn.createStatement();

               String sql = "CREATE TABLE IF NOT EXISTS Idiomas " +
                       " (Idioma VARCHAR(255), PRIMARY KEY (Idioma))";

               stmt.executeUpdate(sql);
               System.out.println("Created table in given database...");
           } catch (SQLException se) {
               //Handle errors for JDBC
               se.printStackTrace();
           } catch (Exception e) {
               //Handle errors for Class.forName
               e.printStackTrace();
           } finally {
               //finally block used to close resources
        	   closeStm(conn, stmt);
               closeCon(conn);
           } // end try
       }

    public static void insertarTablaPaises(String name, String idioma){
    	Connection conn = null;
        Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.h2.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = "REPLACE INTO Paises (Nombre,Idioma) VALUES ('" + name + "', '" + idioma + "')";

            ;

            stmt.executeUpdate(sql);
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            closeStm(conn, stmt);
            closeCon(conn);
        } // end try

    }

    public static void insertarTablaIdiomas(String idioma){
    	Connection conn = null;
        Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.h2.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = "REPLACE INTO Idiomas (Idioma) VALUES ('" + idioma + "')";

            ;

            stmt.executeUpdate(sql);
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            closeStm(conn, stmt);
            closeCon(conn);
        } // end try

    }

    public static List listarPaises(){
    	Connection conn = null;
    	List<Paises> listPaises= new ArrayList<Paises>();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.h2.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
             stmt = conn.createStatement();

    			prepareStatement = conn.prepareStatement("SELECT * FROM Paises");
    			resultSet = prepareStatement.executeQuery();
    			while(resultSet.next()){
    				Paises userInDatabase = new Paises();
    				userInDatabase.setNombre(resultSet.getString(1));
    				userInDatabase.setIdioma(resultSet.getString(2));

    				listPaises.add(userInDatabase);
    			}

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            closeStm(conn, stmt);
            closeCon(conn);
            closeRs(resultSet);
        } // end try
        return listPaises;
   }

    public static List listarIdiomas(){
    	Connection conn = null;
    	List<Idiomas> listIdiomas= new ArrayList<Idiomas>();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.h2.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
             stmt = conn.createStatement();

    			prepareStatement = conn.prepareStatement("SELECT * FROM Idiomas");
    			resultSet = prepareStatement.executeQuery();
    			while(resultSet.next()){
    				Idiomas userInDatabase = new Idiomas();
    				userInDatabase.setIdiomas(resultSet.getString(1));

    				listIdiomas.add(userInDatabase);
    			}

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            closeStm(conn, stmt);
            closeCon(conn);
            closeRs(resultSet);
        } // end try
        return listIdiomas;
   }

    public static void BorrarTablaPaises(String idioma){
    	Connection conn = null;
        Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.h2.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = "DELETE FROM Paises WHERE Idioma = '" + idioma + "'";
                   ;

            stmt.executeUpdate(sql);

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            closeStm(conn, stmt);
            closeCon(conn);
        } // end try
	} // end JDBCExample

    public static void BorrarTablaIdiomas(String idioma){
    	Connection conn = null;
        Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.h2.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = "DELETE FROM Idiomas WHERE Idioma = '" + idioma + "'";
                   ;

            stmt.executeUpdate(sql);

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            closeStm(conn, stmt);
            closeCon(conn);
        } // end try
	} // end JDBCExample

	private static void closeCon(Connection conn) {
		try {
		    if (conn!= null)
		        conn.close();
		} catch (SQLException se) {
		    se.printStackTrace();
		} // end finally try
	}

	private static void closeStm(Connection conn, Statement stmt) {
		try {
		    if (stmt!=null)
		        conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} // do nothing
	}


	private static void closeRs(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


}



