package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DB {

	// Criando variavel de conexao com o banco de dados
	private static Connection conn = null;

	public static Connection getConnection() {

		if (conn == null) {
			try {
				// Pegando as propriedades do banco de dados
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				//Dizendo que a variavel que foi criada esta recebendo as propriedades do banco
				conn = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}

		return conn;
	}
	
	public static void closeConnection() {
		//Se minha variavel for diferente de nulo então fecha
		if(conn != null) {
			try {
			conn.close();
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		}
	}

	private static Properties loadProperties() {

		// Instaciando o banco de dados, fazendo referencia ao file db.properties
		try (FileInputStream fs = new FileInputStream("db.properties")) {

			Properties props = new Properties();
			props.load(fs);
			return props;

		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
		
	}
	public static void closeStatement (Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	

}
