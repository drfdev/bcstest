package drf.dev.interview.bcs.domain;

public class Quote {
    private String symbol; // refers to the stock ticker.
    private String companyName; // refers to the company name.
    private String primaryExchange; // refers to the primary listings exchange.
    private String sector; // refers to the sector of the stock.
    private String calculationPrice; // refers to the source of the latest price.
            // ("tops", "sip", "previousclose" or "close")
    private double open; // refers to the official open price
    private double openTime; // refers to the official listing exchange time for the open
    private double close; // refers to the official close price
    private double closeTime; // refers to the official listing exchange time for the close
    private double high; // refers to the market-wide highest price from the SIP. 15 minute delayed
    private double low; // refers to the market-wide lowest price from the SIP. 15 minute delayed
    private double latestPrice; // refers to the latest price being the IEX real time price, the 15 minute delayed market price, or the previous close price.
    private String latestSource; // refers to the source of latestPrice.
            // ("IEX real time price", "15 minute delayed price", "Close" or "Previous close")
    private String latestTime; // refers to a human readable time of the latestPrice. The format will vary based on latestSource.
    private double latestUpdate; // refers to the update time of latestPrice in milliseconds since midnight Jan 1, 1970.
    private double latestVolume; // refers to the total market volume of the stock.
    private double iexRealtimePrice; // refers to last sale price of the stock on IEX. (Refer to the attribution section above.)
    private double iexRealtimeSize; // refers to last sale size of the stock on IEX.
    private double iexLastUpdated; // refers to the last update time of the data in milliseconds since midnight Jan 1, 1970 UTC or -1 or 0. If the value is -1 or 0, IEX has not quoted the symbol in the trading day.
    private double delayedPrice; // refers to the 15 minute delayed market price during normal market hours 9:30 - 16:00.
    private double delayedPriceTime; // refers to the time of the delayed market price during normal market hours 9:30 - 16:00.
    private double extendedPrice; // refers to the 15 minute delayed market price outside normal market hours 8:00 - 9:30 and 16:00 - 17:00.
    private double extendedChange; // is calculated using extendedPrice from calculationPrice.
    private double extendedChangePercent; // is calculated using extendedPrice from calculationPrice.
    private double extendedPriceTime; // refers to the time of the delayed market price outside normal market hours 8:00 - 9:30 and 16:00 - 17:00.
    private double change; // is calculated using calculationPrice from previousClose.
    private double changePercent; // is calculated using calculationPrice from previousClose.
    private double iexMarketPercent; // refers to IEX’s percentage of the market in the stock.
    private double iexVolume; // refers to shares traded in the stock on IEX.
    private double avgTotalVolume; // refers to the 30 day average volume on all markets.
    private double iexBidPrice; // refers to the best bid price on IEX.
    private double iexBidSize; // refers to amount of shares on the bid on IEX.
    private double iexAskPrice; // refers to the best ask price on IEX.
    private double iexAskSize; // refers to amount of shares on the ask on IEX.
    private double marketCap; // is calculated in real time using calculationPrice.
    private double peRatio; // is calculated in real time using calculationPrice.
    private double week52High; // refers to the adjusted 52 week high.
    private double week52Low; // refers to the adjusted 52 week low.
    private double ytdChange; // refers to the price change percentage from start of year to previous close.

    private Stock stock;
    private double assetValue;

    public Quote() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPrimaryExchange() {
        return primaryExchange;
    }

    public void setPrimaryExchange(String primaryExchange) {
        this.primaryExchange = primaryExchange;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCalculationPrice() {
        return calculationPrice;
    }

    public void setCalculationPrice(String calculationPrice) {
        this.calculationPrice = calculationPrice;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getOpenTime() {
        return openTime;
    }

    public void setOpenTime(double openTime) {
        this.openTime = openTime;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(double closeTime) {
        this.closeTime = closeTime;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(double latestPrice) {
        this.latestPrice = latestPrice;
    }

    public String getLatestSource() {
        return latestSource;
    }

    public void setLatestSource(String latestSource) {
        this.latestSource = latestSource;
    }

    public String getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime;
    }

    public double getLatestUpdate() {
        return latestUpdate;
    }

    public void setLatestUpdate(double latestUpdate) {
        this.latestUpdate = latestUpdate;
    }

    public double getLatestVolume() {
        return latestVolume;
    }

    public void setLatestVolume(double latestVolume) {
        this.latestVolume = latestVolume;
    }

    public double getIexRealtimePrice() {
        return iexRealtimePrice;
    }

    public void setIexRealtimePrice(double iexRealtimePrice) {
        this.iexRealtimePrice = iexRealtimePrice;
    }

    public double getIexRealtimeSize() {
        return iexRealtimeSize;
    }

    public void setIexRealtimeSize(double iexRealtimeSize) {
        this.iexRealtimeSize = iexRealtimeSize;
    }

    public double getIexLastUpdated() {
        return iexLastUpdated;
    }

    public void setIexLastUpdated(double iexLastUpdated) {
        this.iexLastUpdated = iexLastUpdated;
    }

    public double getDelayedPrice() {
        return delayedPrice;
    }

    public void setDelayedPrice(double delayedPrice) {
        this.delayedPrice = delayedPrice;
    }

    public double getDelayedPriceTime() {
        return delayedPriceTime;
    }

    public void setDelayedPriceTime(double delayedPriceTime) {
        this.delayedPriceTime = delayedPriceTime;
    }

    public double getExtendedPrice() {
        return extendedPrice;
    }

    public void setExtendedPrice(double extendedPrice) {
        this.extendedPrice = extendedPrice;
    }

    public double getExtendedChange() {
        return extendedChange;
    }

    public void setExtendedChange(double extendedChange) {
        this.extendedChange = extendedChange;
    }

    public double getExtendedChangePercent() {
        return extendedChangePercent;
    }

    public void setExtendedChangePercent(double extendedChangePercent) {
        this.extendedChangePercent = extendedChangePercent;
    }

    public double getExtendedPriceTime() {
        return extendedPriceTime;
    }

    public void setExtendedPriceTime(double extendedPriceTime) {
        this.extendedPriceTime = extendedPriceTime;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(double changePercent) {
        this.changePercent = changePercent;
    }

    public double getIexMarketPercent() {
        return iexMarketPercent;
    }

    public void setIexMarketPercent(double iexMarketPercent) {
        this.iexMarketPercent = iexMarketPercent;
    }

    public double getIexVolume() {
        return iexVolume;
    }

    public void setIexVolume(double iexVolume) {
        this.iexVolume = iexVolume;
    }

    public double getAvgTotalVolume() {
        return avgTotalVolume;
    }

    public void setAvgTotalVolume(double avgTotalVolume) {
        this.avgTotalVolume = avgTotalVolume;
    }

    public double getIexBidPrice() {
        return iexBidPrice;
    }

    public void setIexBidPrice(double iexBidPrice) {
        this.iexBidPrice = iexBidPrice;
    }

    public double getIexBidSize() {
        return iexBidSize;
    }

    public void setIexBidSize(double iexBidSize) {
        this.iexBidSize = iexBidSize;
    }

    public double getIexAskPrice() {
        return iexAskPrice;
    }

    public void setIexAskPrice(double iexAskPrice) {
        this.iexAskPrice = iexAskPrice;
    }

    public double getIexAskSize() {
        return iexAskSize;
    }

    public void setIexAskSize(double iexAskSize) {
        this.iexAskSize = iexAskSize;
    }

    public double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
    }

    public double getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(double peRatio) {
        this.peRatio = peRatio;
    }

    public double getWeek52High() {
        return week52High;
    }

    public void setWeek52High(double week52High) {
        this.week52High = week52High;
    }

    public double getWeek52Low() {
        return week52Low;
    }

    public void setWeek52Low(double week52Low) {
        this.week52Low = week52Low;
    }

    public double getYtdChange() {
        return ytdChange;
    }

    public void setYtdChange(double ytdChange) {
        this.ytdChange = ytdChange;
    }

    public double getAssetValue() {
        return assetValue;
    }

    public void setAssetValue(double assetValue) {
        this.assetValue = assetValue;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
