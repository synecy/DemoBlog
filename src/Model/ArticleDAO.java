package Model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class ArticleDAO {

	
	public ArticleDAO() {
	}
	

	public ArrayList<HashMap<String, String>> getArticles() {
		DatabaseConnection connection = new DatabaseConnection();
		ArrayList<HashMap<String, String>> queryResults = new ArrayList<HashMap<String, String>>();
		queryResults.clear();
		String sqlQueryString = "SELECT * FROM demoblog_articles INNER JOIN demoblog_users ON demoblog_articles.Author_id = demoblog_users.UID ORDER BY ID DESC;";
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.getConnection().createStatement();
			resultSet = statement.executeQuery(sqlQueryString);
			while(resultSet.next()) {
				HashMap<String, String> resultLine = new HashMap<String, String>();
				try {
					ResultSetMetaData metaData = resultSet.getMetaData();
					for (int i = 1; i <= metaData.getColumnCount(); i++) {
						resultLine.put( metaData.getColumnName(i), resultSet.getString(i) );
					}
				} catch (SQLException e) {
					connection.handleError("Error executing SQL query.", e);
				}	
				queryResults.add(resultLine);
			}
		} catch (SQLException e) {
			connection.handleError("Error executing SQL query.", e);
		} finally {
			try {
				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				connection.handleError("Error ending SQL query.", e);
			}
		}
		connection.disconnect();
		return queryResults;
	}
	
	
	public boolean postArticle( Article article ) {
		DatabaseConnection connection = new DatabaseConnection();
		String sqlQueryString = "INSERT INTO demoblog_articles ( Title, Content, Postdate, Author_id ) VALUES ( ' " + article.getTitle() + " ', ' " + article.getContent() + " ', ' " + article.getDate() + " ', ' " + article.getAuthorId() + " ');";
		Statement statement = null;
		
		try {
			statement = connection.getConnection().createStatement();
			statement.executeUpdate(sqlQueryString);
		} catch (SQLException e) {
			connection.handleError("Error executing SQL query.", e);
			return false;
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				connection.handleError("Error ending SQL query.", e);
				return false;
			}
		}
		connection.disconnect();
		return true;
	}
	
	
	public boolean deleteArticle( int id ) {
		DatabaseConnection connection = new DatabaseConnection();
		String sqlQueryString = "DELETE FROM demoblog_articles WHERE ID = ' " + id + " ';";
		Statement statement = null;
		
		try {
			statement = connection.getConnection().createStatement();
			statement.executeUpdate(sqlQueryString);
		} catch (SQLException e) {
			connection.handleError("Error executing SQL query.", e);
			return false;
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				connection.handleError("Error ending SQL query.", e);
				return false;
			}
		}
		connection.disconnect();
		return true;
	}
	
	
}
