package api;

public class ApiResponse {

    private final int cases;
    private final int deaths;
    private final int recovered;

    public ApiResponse(int cases, int deaths, int recovered) {
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
    }

    public int getCases() {
        return cases;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getRecovered() {
        return recovered;
    }
}
