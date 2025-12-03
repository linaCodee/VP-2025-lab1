package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.exceptions.BookNotFoundException;
import mk.ukim.finki.wp.lab.repository.jpa.BookRepository;
import mk.ukim.finki.wp.lab.repository.mock.InMemoryBookRepository;
import mk.ukim.finki.wp.lab.service.AuthorService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

//    @Override
//    public List<Book> searchBooks(String text, double rating) {
//        return this.bookRepository.searchBooks(text,rating);
//    }

    @Override
    public List<Book> searchBooks(Long authorId) {
        return this.bookRepository.findAllByAuthor_Id(authorId);
    }
    @Override
    public void delete(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(()->new BookNotFoundException(id));
    }

    @Override
    public Book update(Long id, String title, String genre, double averageRating, Long authorId) {
        if (title==null || title.isEmpty() ||
        genre==null || genre.isEmpty() ||
        averageRating<0 || authorId==null){
            throw new IllegalArgumentException();
        }

        Book book=findById(id);
        Author author=authorService.findById(authorId);
        book.setTitle(title);
        book.setGenre(genre);
        book.setAverageRating(averageRating);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @Override
    public Book create(String title, String genre, double averageRating, Long authorId) {
        if (title==null || title.isEmpty() ||
        genre==null || genre.isEmpty() ||
        averageRating<=0 || authorId==null){
            throw new IllegalArgumentException();
        }

        Author author=authorService.findById(authorId);
        Book book=new Book(title,genre,averageRating,author);

        return bookRepository.save(book);
    }

//    @Override
//    public Book likeBook(Long id) {
//        Book book=findById(id);
//        book.setLikes(book.getLikes()+1);
//        return bookRepository.save(book);
//    }
//    @Override
//    public Book update(Long id, String title, String genre, double averageRating, Long authorId, LocalDate dateCreated) {
//        if (title==null || title.isEmpty() ||
//                genre==null || genre.isEmpty() ||
//                averageRating<0 || authorId==null){
//            throw new IllegalArgumentException();
//        }
//        Book book=findById(id);
//        Author author=authorService.findById(authorId);
//        book.setTitle(title);
//        book.setGenre(genre);
//        book.setAverageRating(averageRating);
//        book.setAuthor(author);
//
//        if (dateCreated!=null){
//            book.setDateCreated(dateCreated);
//        }
//        return bookRepository.save(book);
//    }
//
//    @Override
//    public Book create(String title, String genre, double averageRating, Long authorId, LocalDate dateCreated) {
//        if (title==null || title.isEmpty() ||
//        genre==null || genre.isEmpty() ||
//        averageRating<0 || authorId==null){
//            throw new IllegalArgumentException();
//        }
//        Author author=authorService.findById(authorId);
//        Book book=new Book(title,genre,averageRating,author,dateCreated);
//        book.setDateCreated(dateCreated!=null ? dateCreated : LocalDate.now());
//        return bookRepository.save(book);
//    }

//    @Override
//    public Book update(Long id, String title, String genre, BookCover bookCover, double averageRating, Long authorId) {
//        if (title==null || title.isEmpty() ||
//        genre==null || genre.isEmpty() ||
//        bookCover==null || authorId ==null ||
//        averageRating<0){
//            throw new IllegalArgumentException();
//        }
//        Book book=findById(id);
//        Author author=authorService.findById(authorId);
//
//        book.setTitle(title);
//        book.setGenre(genre);
//        book.setBookCover(bookCover);
//        book.setAuthor(author);
//        book.setAverageRating(averageRating);
//
//        return bookRepository.save(book);
//    }
//
//    @Override
//    public Book create(String title, String genre, BookCover bookCover, double averageRating, Long authorId) {
//        if (title==null || title.isEmpty() ||
//                genre==null || genre.isEmpty() ||
//                bookCover==null || authorId ==null ||
//                averageRating<0){
//            throw new IllegalArgumentException();
//        }
//        Author author=authorService.findById(authorId);
//
//        Book book=new Book(title,genre,bookCover,averageRating,author);
//        return bookRepository.save(book);
//    }


}
