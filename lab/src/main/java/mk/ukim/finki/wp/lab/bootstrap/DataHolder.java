package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.model.enums.BookCover;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books=null;
    public static List<Author> authors=null;
    public static List<BookReservation> bookReservations=null;
    @PostConstruct
    public void init(){
        authors=new ArrayList<>();
        authors.add(new Author("Sarah","Janet Maas","England","Sarah J. Maas is an American author best known for her fantasy series Throne of Glass, A Court of Thorns and Roses, and Crescent City, which blend epic magic, romance, and strong female protagonists."));
        authors.add(new Author("Ana","Huang","USA","Ana Huang is a Chinese‑American romance author who began writing as a child to practice English and has become a #1 New York Times and USA Today bestselling writer of steamy new‑adult and contemporary romance novels."));
        authors.add(new Author("Susan Elizabeth","Phillips","USA","Susan Elizabeth Phillips is an American romance novelist, born December 11, 1944 in Cincinnati, Ohio, whose books—published in over 30 languages—redefined the genre by introducing the “sports romance” and earned her multiple awards including the Romance Writers of America Lifetime Achievement."));

        books=new ArrayList<>();
        books.add(new Book("Twisted Games","Romance",4.1,authors.get(1)));
        books.add(new Book("A Court Of Thorns And Roses","Fantasy",4.2,authors.get(0)));
        books.add(new Book("A Court Of Mist And Fury","Fantasy",4.6,authors.get(0)));
        books.add(new Book("Dream A Little Dream","Fiction",4.2,authors.get(2)));
        books.add(new Book("Twisted Lies","Romance", 4.3,authors.get(1)));
        books.add(new Book("King Of Ashes","Thriller", 4.1,authors.get(0)));
        books.add(new Book("This Heart Of Mine","Fiction",4.1,authors.get(2)));
        books.add(new Book("Empire Of Storms","Fantasy",4.6,authors.get(0)));
        books.add(new Book("King Of Pride","Romance",3.7,authors.get(1)));
        books.add(new Book("Kiss An Angel","Fiction",4.0,authors.get(2)));

//        books=new ArrayList<>();
//        books.add(new Book("Twisted Games","Romance",4.1,authors.get(1), LocalDate.now()));
//        books.add(new Book("A Court Of Thorns And Roses","Fantasy",4.2,authors.get(0),LocalDate.now()));
//        books.add(new Book("A Court Of Mist And Fury","Fantasy",4.6,authors.get(0),LocalDate.now()));
//        books.add(new Book("Dream A Little Dream","Fiction",4.2,authors.get(2),LocalDate.now()));
//        books.add(new Book("Twisted Lies","Romance", 4.3,authors.get(1),LocalDate.now()));
//        books.add(new Book("King Of Ashes","Thriller", 4.1,authors.get(0),LocalDate.now()));
//        books.add(new Book("This Heart Of Mine","Fiction",4.1,authors.get(2),LocalDate.now()));
//        books.add(new Book("Empire Of Storms","Fantasy",4.6,authors.get(0),LocalDate.now()));
//        books.add(new Book("King Of Pride","Romance",3.7,authors.get(1),LocalDate.now()));
//        books.add(new Book("Kiss An Angel","Fiction",4.0,authors.get(2),LocalDate.now()));

//        books=new ArrayList<>();
//        books.add(new Book("Twisted Games","Romance",BookCover.UNKNOWN,4.1,authors.get(1)));
//        books.add(new Book("A Court Of Thorns And Roses","Fantasy",BookCover.HARD,4.2,authors.get(0)));
//        books.add(new Book("A Court Of Mist And Fury","Fantasy",BookCover.UNKNOWN,4.6,authors.get(0)));
//        books.add(new Book("Dream A Little Dream","Fiction",BookCover.SOFT,4.2,authors.get(2)));
//        books.add(new Book("Twisted Lies","Romance", BookCover.HARD,4.3,authors.get(1)));
//        books.add(new Book("King Of Ashes","Thriller", BookCover.HARD,4.1,authors.get(0)));
//        books.add(new Book("This Heart Of Mine","Fiction",BookCover.SOFT,4.1,authors.get(2)));
//        books.add(new Book("Empire Of Storms","Fantasy",BookCover.HARD,4.6,authors.get(0)));
//        books.add(new Book("King Of Pride","Romance",BookCover.SOFT,3.7,authors.get(1)));
//        books.add(new Book("Kiss An Angel","Fiction",BookCover.SOFT,4.0,authors.get(2)));

        bookReservations=new ArrayList<>();


    }
}
