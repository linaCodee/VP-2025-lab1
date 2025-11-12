package mk.ukim.finki.wp.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.enums.BookCover;
import mk.ukim.finki.wp.lab.service.AuthorService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//Со зборови:
//
//@RequestParam → се користи за филтрирање, пребарување или опционални параметри
//
//@PathVariable → се користи за идентификација на конкретен ресурс
@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }
    @GetMapping()
    public String getBooksPage(@RequestParam(required = false) String error, @RequestParam(required = false) String title, @RequestParam(required = false) Integer rating, Model model, HttpServletRequest req){
        if (error!=null){
            model.addAttribute("error",error);
        }
        List<Book> books=bookService.listAll();
        if ((title!=null && !title.isBlank()) || rating!=null){
            books=bookService.searchBooks(title,rating);
        }
        else {
            books=bookService.listAll();
        }

        model.addAttribute("books",books);
        model.addAttribute("title",title);
        model.addAttribute("rating",rating);
        return "listBooks";
    }
    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.delete(id);
        return "redirect:/books";
    }
    @GetMapping("/add-form")
    public String addProductPage(Model model){
        model.addAttribute("bookCovers",BookCover.values());
        model.addAttribute("authors",authorService.findAll());
        return "add-form";
    }

    @PostMapping
    public String saveBook(@RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId){
        bookService.create(title,genre,averageRating,authorId);
        return "redirect:/books";
    }

//    @PostMapping("/like/{id}")
//    public String likeBook(@PathVariable Long id){
//        bookService.likeBook(id);
//        return "redirect:/books";
//    }
//    @PostMapping
//    public String saveBook(@RequestParam String title,
//                           @RequestParam String genre,
//                           @RequestParam Double averageRating,
//                           @RequestParam Long authorId,
//                           @RequestParam(required = false) LocalDate dateCreated){
//        bookService.create(title,genre,averageRating,authorId,dateCreated);
//        return "redirect:/books";
//    }
    @GetMapping("/edit-form/{id}")
    public String editBookPage(@PathVariable Long id, Model model){
        model.addAttribute("book",bookService.findById(id));
        model.addAttribute("bookCovers",BookCover.values());
        model.addAttribute("authors",authorService.findAll());
        return "add-form";
    }

//    @PostMapping("/{id}")
//    public String updateProduct(@PathVariable Long id,
//                                @RequestParam String title,
//                                @RequestParam String genre,
//                                @RequestParam Double averageRating,
//                                @RequestParam Long authorId,
//                                @RequestParam(required = false) LocalDate dateCreated){
//        bookService.update(id,title,genre,averageRating,authorId,dateCreated);
//        return "redirect:/books";
//    }

    @PostMapping("/{id}")
    public String updateProduct(@PathVariable Long id,
                                @RequestParam String title,
                                @RequestParam String genre,
                                @RequestParam Double averageRating,
                                @RequestParam Long authorId){
        bookService.update(id,title,genre,averageRating,authorId);
        return "redirect:/books";
    }
}
