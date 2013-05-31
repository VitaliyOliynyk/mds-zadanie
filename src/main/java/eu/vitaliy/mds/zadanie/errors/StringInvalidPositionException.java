package eu.vitaliy.mds.zadanie.errors;

public class StringInvalidPositionException extends RuntimeException {
    public StringInvalidPositionException(int position)
    {
        System.err.println("String invalid position exception: " + position);
    }
}
