package com.chai.blog.servlet.book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chai.blog.pojo.Book;
import com.chai.blog.pojo.Path;
import com.chai.blog.service.FileService;
import com.chai.blog.service.BookService;


/**
 * Servlet implementation class BookAddServlet
 */

public class BookEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookEditServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String email = (String)request.getParameter("email");
		String content = (String)request.getParameter("content");
		String ID = (String)request.getParameter("book_id");
		
		int id = Integer.parseInt(ID);
		
		FileService fService = new FileService();
		Path path = new Path();
		
		String type = "Book";
		String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/");
		path = fService.getFilePath(type, realPath);
		
		
		Book book = new Book();
		book.setId(id);
		book.setPath(path.getFilePath().replace("\\", "\\\\"));
		book.setTime(path.getTime());
		book.setEmail(email);				
		BookService nService = new BookService();
		
		boolean bookFlag = nService.updateBook(book);
		boolean fFlag = fService.addFile(path, content);
		if(bookFlag == true && fFlag == true)
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/Admin/Book/edit_success.jsp");
			requestDispatcher.forward(request,response);
		}
		
		
		
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
