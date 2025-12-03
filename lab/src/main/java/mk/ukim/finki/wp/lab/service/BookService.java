package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.enums.BookCover;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface BookService {
    List<Book> listAll();
   // List<Book> searchBooks(String text, double rating);
    List<Book> searchBooks(Long authorId);
    void delete(Long id);
    Book findById(Long id);
    Book update(Long id,
                String title,
                String genre,
                double averageRating,
                Long authorId);
    Book create(String title, String genre, double averageRating, Long author);
//    Book likeBook(Long id);
//    Book update(Long id,
//                String title,
//                String genre,
//                double averageRating,
//                Long authorId,
//                LocalDate dateCreated);
//    Book create(String title, String genre, double averageRating, Long author,LocalDate dateCreated);

//    Book update(Long id,
//                String title,
//                String genre,
//                BookCover bookCover,
//                double averageRating,
//                Long authorId);
//    Book create(String title, String genre, BookCover bookCover, double averageRating, Long authorId);
}
