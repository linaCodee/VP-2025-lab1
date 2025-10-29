package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books=null;
    public static List<BookReservation> bookReservations=null;
    @PostConstruct
    public void init(){
        books=new ArrayList<>();
        books.add(new Book("Twisted Games","Romance",4.1));
        books.add(new Book("A Court Of Thorns And Roses","Fantasy",4.2));
        books.add(new Book("A Court Of Mist And Fury","Fantasy",4.6));
        books.add(new Book("Dream A Little Dream","Fiction",4.2));
        books.add(new Book("Twisted Lies","Romance",4.3));
        books.add(new Book("King Of Ashes","Thriller",4.1));
        books.add(new Book("The Book Club Hotel","Fiction",4.0));
        books.add(new Book("Empire Of Storms","Fantasy",4.6));
        books.add(new Book("Without Merit","Thriller",3.7));
        books.add(new Book("The Art Of Uncertain","Philosophy",4.0));

        bookReservations=new ArrayList<>();
    }
}
