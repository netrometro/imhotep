package br.upe.init;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.upe.dao.db.DBConection;
import br.upe.models.User;

public class Main {

	public static void main(String[] args) throws SQLException {
		//createTables();
		insertData();
	}
	
	public static void createTables() throws SQLException {
		Connection conn = null;
		try {
			conn = DBConection.open();
			
			String sqlCreatetables = "CREATE TABLE " + User.TABLE_NAME
				+"("
				+ User.ID +" integer NOT NULL,"
				+ User.EMAIL +" character varying(100) NOT NULL,"
				+ User.FIRST_NAME +" character varying(50) NOT NULL,"
				+ User.LAST_NAME +" character varying(50) NOT NULL,"
				+ User.CPF +" character varying(30) NOT NULL,"
				+ User.BIRTH_DATE +" character varying(30) NOT NULL,"
				+ User.PASSWORD +" character varying(50) NOT NULL );" 
				//+ "ALTER SEQUENCE "+User.ID+" OWNED BY "+User.TABLE_NAME+"."+User.ID+";"
				//+"CONSTRAINT user_pkey PRIMARY KEY ("+ User.ID +"),"
				//+"CONSTRAINT user_cpf UNIQUE ("+ User.CPF +")"
				//+"CONSTRAINT user_email UNIQUE ("+ User.EMAIL +")"
				;
			
	        PreparedStatement ps = null;
				        
	        ps = conn.prepareStatement(sqlCreatetables);
	        ResultSet rs = ps.executeQuery();
            
	        System.out.println(rs.toString());
	        
	        
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
	}
	
	public static void insertData() throws SQLException {
		Connection conn = null;
		
		try {
			conn = DBConection.open();
			
			String sqlCreateData = "insert into " + User.TABLE_NAME
				+"("
				+ User.ID +", "
				+ User.EMAIL +","+  User.FIRST_NAME+","+  User.LAST_NAME+","+  User.CPF+","
				+ User.BIRTH_DATE +","+ User.PASSWORD
				+ ") "
				+"values (1, 'teste@email.com', 'umName', 'outroName', '123.123.123-12', '01/02/2021 20:25:00', 'teste');";
				        
			PreparedStatement ps = null;
	        
			ps = conn.prepareStatement(sqlCreateData);
	        ResultSet rs1 = ps.executeQuery();
            
	        System.out.println(rs1.toString());
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
	}
	
}
