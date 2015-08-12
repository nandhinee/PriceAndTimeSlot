package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public Connection con = null;
    public static DBConnection dbc;
    public DBConnection() {
	  	try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost/pricecloud","root","root");
	  	} catch(Exception e) {
			e.printStackTrace();
		}
	}
    public static DBConnection getInstance(){
    	if(dbc==null){
    		synchronized (DBConnection.class) {
				if(dbc==null)
					dbc=new DBConnection();
			}
    	}
    	return dbc;
	}
    public Connection getConnection() {
    	return con;
    }
}