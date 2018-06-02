package RegrasDeNegocio;

public class RegraNegocioException extends Exception {
    
    private static final long serialVersionUID = 1L;

    public RegraNegocioException() {
        super();
    }

    public RegraNegocioException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RegraNegocioException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegraNegocioException(String message) {
        super(message);
    }

    public RegraNegocioException(Throwable cause) {
        super(cause);
    }
    
}
