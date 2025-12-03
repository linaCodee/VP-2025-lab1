//package mk.ukim.finki.wp.lab.web.servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.model.Book;
//import mk.ukim.finki.wp.lab.service.BookService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.LinkedList;
//import java.util.List;
//
//@WebServlet(name = "BookListServlet",urlPatterns = "/listBooks")
//public class BookListServlet extends HttpServlet {
//    private final BookService bookService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public BookListServlet(BookService bookService, SpringTemplateEngine springTemplateEngine) {
//        this.bookService = bookService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange= JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req,resp);
//        WebContext context=new WebContext(webExchange);
//        context.setVariable("books",this.bookService.listAll());
//        context.setVariable("errorMessage",req.getParameter("errorMessage"));
//
//        List<Book> lastVisitedBooks = (List<Book>) req.getSession().getAttribute("lastVisitedBooks");
//        context.setVariable("lastVisitedBooks", lastVisitedBooks);
//
//
//
//        springTemplateEngine.process("listBooks.html",context,resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange=JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req,resp);
//        WebContext context=new WebContext(webExchange);
//
//
//        String title=req.getParameter("title");
//        String ratingP=req.getParameter("rating");
//        Double rating=null;
//
//        try {
//
//                rating = Double.valueOf(ratingP);
//
//        } catch (IllegalArgumentException e){
//            context.setVariable("books",this.bookService.listAll());
//            context.setVariable("title",title);
//            context.setVariable("rating",ratingP);
//            context.setVariable("errorMessage","Invalid input for rating (must be a number).");
//            springTemplateEngine.process("listBooks.html",context,resp.getWriter());
//            return;
//        }
//        List<Book> filtered=this.bookService.searchBooks(title,rating);
//        context.setVariable("books", filtered);
//        context.setVariable("title",title);
//        context.setVariable("rating",ratingP);
//        context.setVariable("errorMessage","Invalid input for rating (must be a number).");
//
//
//        springTemplateEngine.process("listBooks.html",context,resp.getWriter());
//
//    }
//
//    //    @Override
////    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        String text=req.getParameter("text");
////        String ratingP=req.getParameter("rating");
////        Double rating=null;
////
////        if (ratingP!=null && !ratingP.isEmpty()){
////            rating=Double.valueOf(ratingP);
////
////        }
////        List<Book> filteredBooks;
////        try {
////            filteredBooks=this.bookService.searchBooks(text,rating);
////        } catch (IllegalArgumentException e){
////            resp.sendRedirect("/listBooks");
////            return;
////        }
////        IWebExchange webExchange=JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req,resp);
////        WebContext webContext=new WebContext(webExchange);
////        webContext.setVariable("filteredBooks",filteredBooks);
////        springTemplateEngine.process("listBooks.html",webContext,resp.getWriter());
////    }
//}
