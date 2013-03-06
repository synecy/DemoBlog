package Controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Article;
import Model.ArticleDAO;


@WebServlet("/PostArticle")
public class PostArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PostArticle() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		String content = request.getParameter("message");
		
		
		Article article = new Article();
		
		article.setAuthorId(1);
		article.setContent(content);
		article.setTitle(title);
		
		
		GregorianCalendar cal = new GregorianCalendar();
		String currentDate = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DATE);
		article.setDate(currentDate);
		
		
		ArticleDAO dao = new ArticleDAO();
		
		dao.postArticle(article);
		
		RequestDispatcher disp = request.getRequestDispatcher("viewArticle.jsp?new=post");
		disp.forward(request, response);
	}

}


