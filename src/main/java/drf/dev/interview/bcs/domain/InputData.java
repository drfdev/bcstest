package drf.dev.interview.bcs.domain;

public class InputData {
    private final Stock[] stocks;

    public InputData(Stock[] stocks) {
        this.stocks = stocks;
    }

    public Stock[] getStocks() {
        return stocks;
    }
}
