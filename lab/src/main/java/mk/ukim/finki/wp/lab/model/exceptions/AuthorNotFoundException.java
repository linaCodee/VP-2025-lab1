package mk.ukim.finki.wp.lab.model.exceptions;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(Long id){
        super(String.format("Author with id %d not found",id));
    }
}
