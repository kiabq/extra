/**
 * Stock Class
 */
public class Stock {
    private String symbol, name;
    private double priorClosingPrice, currentPrice;

    /**
     * Stock constructor will create a Stock object with provided arguments.
     * @param symbol
     * @param name
     * @param priorClosingPrice
     * @param currentPrice
     */
    Stock(String symbol, String name, double priorClosingPrice, double currentPrice) {
        this.symbol = symbol;
        this.name = name;
        this.priorClosingPrice = priorClosingPrice;
        this.currentPrice = currentPrice;
    }

    /**
     * setSymbol sets the symbol of a stock.
     * @param symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * getSymbol returns the symbol of a stock.
     * @return the stock symbol
     */
    public String getSymbol() {
        return this.symbol;
    }

    /**
     * setName sets the name of a stock.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getName returns the name of a stock.
     * @return the stock name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * getPriorClosingPrice returns the previous closing price of a stock.
     * @return the stock's previous closing price.
     */
    public double getPriorClosingPrice() {
        return this.priorClosingPrice;
    }

    /**
     * getCurrentPrice returns the current price of a stock.
     * @return the stock's current price.
     */
    public double getCurrentPrice() {
        return this.currentPrice;
    }

    /**
     * getChangePercent will return the percentage difference between a stock
     * previous price and current price.
     * @param  prior
     * @param  current
     * @return the percentage change 
     */
    public double getChangePercent(double prior, double current) {
        return (current / prior * 100) - 100;
    }
}