public class CustomUnsupportedOperationException extends UnsupportedOperationException{
    private String message;
    public CustomUnsupportedOperationException(String message)
    {
        super(message);
        this.message = message;
    }

}
