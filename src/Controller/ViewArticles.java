package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ArticleDAO;



@WebServlet("/ViewArticles")
public class ViewArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewArticles() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session = request.getSession();
		
		ArticleDAO dao = new ArticleDAO();
		ArrayList<HashMap<String, String>> articles = dao.getArticles();
		
		session.setAttribute("articleCount", articles.size() );
		
		ArrayList<HashMap<String, String>> articleList = new ArrayList<HashMap<String, String>>();
		
		for ( int i = 0; i < articles.size() ; i++ ) {
			HashMap<String, String> Innerlist = new HashMap<String, String>();
			
			Innerlist.put( "msgId", articles.get(i).get("ID").toString() );
			Innerlist.put( "title", articles.get(i).get("Title").toString() );
			Innerlist.put( "author", articles.get(i).get("Nickname").toString() );
			Innerlist.put( "date", articles.get(i).get("Postdate").toString() );
			Innerlist.put( "content", articles.get(i).get("Content").toString() );
			
			articleList.add(Innerlist);
		}
		
		session.setAttribute("articleList", articleList );

		RequestDispatcher disp = request.getRequestDispatcher("viewArticle.jsp");
		disp.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}



