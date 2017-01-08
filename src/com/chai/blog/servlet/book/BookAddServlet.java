package com.chai.blog.servlet.book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chai.blog.pojo.Book;
import com.chai.blog.pojo.Path;
import com.chai.blog.service.FileService;
import com.chai.blog.service.BookService;


/**
 * Servlet implementation class BookAddServlet
 */

public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAddServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String ip = request.getHeader("x-forwarded-for");    
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
	        ip = request.getHeader("Proxy-Client-IP");    
	    }    
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
	        ip = request.getHeader("WL-Proxy-Client-IP");    
	    }    
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
	        ip = request.getRemoteAddr();    
	    }
	    System.out.println(ip);
		
		HttpSession ses = request.getSession();		
		String email = (String)request.getParameter("email");		
		String content = (String)request.getParameter("content");		
		
		BookService bookService = new BookService();
		FileService fService = new FileService();
		
		String type = "Book";
		String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/");
		Path path = fService.getFilePath(type, realPath);
		
		Book book = new Book();		
		book.setPath(path.getFilePath().replace("\\", "\\\\"));
		book.setEmail(email);
		book.setTime(path.getTime());
		boolean bookFlag = bookService.addBook(book);
		
		boolean fileFlag = fService.addFile(path, content);
		
		if(bookFlag == true && fileFlag == true)
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./pages/Book/add_success.jsp");
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
