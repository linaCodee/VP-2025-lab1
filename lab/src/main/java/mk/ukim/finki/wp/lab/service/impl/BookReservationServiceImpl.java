package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.model.exceptions.InvalidBookReservation;
import mk.ukim.finki.wp.lab.repository.mock.InMemoryBookReservationRepository;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import org.springframework.stereotype.Service;

@Service
public class BookReservationServiceImpl implements BookReservationService {
    private final InMemoryBookReservationRepository bookReservationRepository;

    public BookReservationServiceImpl(InMemoryBookReservationRepository bookReservationRepository) {
        this.bookReservationRepository = bookReservationRepository;
    }

    @Override
    public BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, int numberOfCopies) {
        if (bookTitle==null || bookTitle.isEmpty() || readerName==null || readerName.isEmpty() || readerAddress==null || readerAddress.isEmpty() || numberOfCopies>=0){
            throw new InvalidBookReservation();
        }
        return this.bookReservationRepository.save(new BookReservation(bookTitle,readerName,readerAddress, numberOfCopies));
    }
}
