package api;

public abstract class AbstractRequest {

    private final boolean succeed;
    private final Error[] errors;

    protected AbstractRequest(boolean succeed, Error... errors) {
        this.succeed = succeed;
        this.errors = errors;
    }

    public static class Error {

        private final int errorCode;
        private final String errorMessage;

        public Error(int errorCode, String errorMessage) {
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }
    }

}
