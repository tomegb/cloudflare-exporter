package api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CloudflareCollector {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    private final String cloudflareToken;
    private final String cloudflareEmail;

    public CloudflareCollector(String cloudflareEmail, String cloudflareToken) {
        this.cloudflareEmail = cloudflareEmail;
        this.cloudflareToken = cloudflareToken;
    }

    public void loadData() {

    }

}
