package mk.ukim.finki.wp.lab.model.exceptions;

public class InvalidBookReservation extends RuntimeException {
    public InvalidBookReservation(){
        super("Invalid book reservation");
    }
}
