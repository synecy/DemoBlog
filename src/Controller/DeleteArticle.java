package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.ArticleDAO;


@WebServlet("/DeleteArticle")
public class DeleteArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DeleteArticle() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postIDStr = request.getParameter("deleteId");
		int postID = Integer.parseInt(postIDStr);
		
		ArticleDAO dao = new ArticleDAO();
		dao.deleteArticle(postID);
		
		RequestDispatcher disp = request.getRequestDispatcher("viewArticle.jsp?new=post");
		disp.forward(request, response);
	}

}




