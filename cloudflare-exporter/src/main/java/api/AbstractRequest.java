package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class AbstractRequest {

    private static final String CLOUDFLARE_API_LINK = "https://api.cloudflare.com/client/v4/";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

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
