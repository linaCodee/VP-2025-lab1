package mk.ukim.finki.wp.lab.repository.mock.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryBookRepository implements mk.ukim.finki.wp.lab.repository.mock.InMemoryBookRepository {
    @Override
    public List<Book> findAll() {
        return DataHolder.books;
    }

    @Override
    public List<Book> searchBooks(String text, double rating) {
        return DataHolder.books.stream().filter(b->b.getTitle().toLowerCase().contains(text.toLowerCase()) && b.getAverageRating()>=rating).toList();
    }

    @Override
    public void delete(Long id) {
        DataHolder.books.removeIf(b->b.getId().equals(id));
    }

    @Override
    public Book save(Book book) {
        delete(book.getId());
        DataHolder.books.add(book);
        return book;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return DataHolder.books.stream().filter(b->b.getId().equals(id)).findFirst();
    }
}
