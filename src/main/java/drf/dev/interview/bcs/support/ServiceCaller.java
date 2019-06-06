package drf.dev.interview.bcs.support;

import drf.dev.interview.bcs.domain.Quote;
import drf.dev.interview.bcs.domain.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public final class ServiceCaller {
    private static Logger logger = LoggerFactory.getLogger(ServiceCaller.class);
    private static final String SERVICE_TEMPLATE_URL = "https://api.iextrading.com/1.0/stock/%s/quote";

    private ServiceCaller() {
        throw new AssertionError();
    }

    public static List<Quote> callStockService(Stock[] stocks) {
        List<Quote> result = new ArrayList<>(stocks.length);

        RestTemplate restTemplate = new RestTemplate();
        for (Stock stock : stocks) {
            String url = String.format(SERVICE_TEMPLATE_URL, stock.getSymbol());
            logger.info(
                    String.format("Call stock [%s]", url)
            );
            Quote q = restTemplate.getForObject(url, Quote.class);
            q.setStock(stock);
            result.add(q);
        }

        return result;
    }
}
