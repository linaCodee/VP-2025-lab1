package mk.ukim.finki.wp.lab.model.exceptions;

public class RatingIsEmptyExpectation extends RuntimeException{
    public RatingIsEmptyExpectation(){
        super("Rating is empty expectation");
    }
}
