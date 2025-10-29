package mk.ukim.finki.wp.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "BookReservationServlet", urlPatterns = "/bookReservation")
public class BookReservationServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final BookReservationService bookReservationService;
    private final BookService bookService;
    public BookReservationServlet(SpringTemplateEngine springTemplateEngine, BookReservationService bookReservationService, BookService bookService) {
        this.springTemplateEngine = springTemplateEngine;
        this.bookReservationService = bookReservationService;
        this.bookService = bookService;
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        String bookTitle = req.getParameter("title");
        String readerName = req.getParameter("readerName");
        String readerAddress = req.getParameter("readerAddress");
        int numCopies = Integer.parseInt(req.getParameter("numCopies"));
        String title=req.getParameter("title");
//        if (title==null || title.isBlank()){
//            resp.sendRedirect("/listBooks?errorMessage=Please select a book to reserve");
//            return;
//        }

        Book book = bookService.listAll().stream().filter(b -> b.getTitle().equals(bookTitle)).findFirst().orElse(null);
//
//        context.setVariable("ratingStr",book.getGenre().toString());
//        context.setVariable("genre",book.getAverageRating());
      if (book!=null) {
          List<Book> lastVisitedBook = (List<Book>) req.getSession().getAttribute("lastVisitedBooks");
          if (lastVisitedBook == null) {
              lastVisitedBook = new LinkedList<>();
          }
          //  List<Book> lastVisitedBook=(List<Book>) req.getSession().setAttribute("lastVisitedBooks", lastVisitedBook);

          lastVisitedBook.remove(book);
          lastVisitedBook.add(0, book);
          if (lastVisitedBook.size() > 3) {
              lastVisitedBook = lastVisitedBook.subList(0, 3);
          }
          req.getSession().setAttribute("lastVisitedBooks", lastVisitedBook);
      }
        context.setVariable("readerAddress",readerAddress);
        context.setVariable("numCopies",numCopies);
        context.setVariable("readerName",readerName);
        context.setVariable("title",bookTitle);


        springTemplateEngine.process("reservationConfirmation.html",context,resp.getWriter());
    }
}
