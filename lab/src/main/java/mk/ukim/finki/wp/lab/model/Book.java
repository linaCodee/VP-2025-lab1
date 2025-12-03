package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.wp.lab.model.enums.BookCover;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    @ManyToOne
    private Author author;
    private double averageRating;
    private LocalDate dateCreated;
    private BookCover bookCover;
    private int likes;

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public BookCover getBookCover() {
        return bookCover;
    }

    public void setBookCover(BookCover bookCover) {
        this.bookCover = bookCover;
    }

    public Author getAuthor() {
        return author;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public Book() {
    }

    public Book(String title, String genre, double averageRating,Author author) {
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
        this.author=author;
       // this.likes=0;
    }
//    public Book(String title, String genre, BookCover bookCover,double averageRating,Author author) {
//        this.id=(long)(Math.random()*1000);
//        this.title = title;
//        this.bookCover=bookCover;
//        this.genre = genre;
//        this.averageRating = averageRating;
//        this.author=author;
//    }
//    public Book(String title, String genre, double averageRating, Author author, LocalDate localDateTime) {
//        this.id=(long)(Math.random()*1000);
//        this.title = title;
//        this.dateCreated=localDateTime;
//        this.genre = genre;
//        this.averageRating = averageRating;
//        this.author=author;
//    }

}
