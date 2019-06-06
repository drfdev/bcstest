package drf.dev.interview.bcs.control;

import drf.dev.interview.bcs.domain.*;
import drf.dev.interview.bcs.support.InputDataEditor;
import drf.dev.interview.bcs.support.ServiceCaller;
import drf.dev.interview.bcs.symb.DefaultDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class BcsTestController {
    private static Logger logger = LoggerFactory.getLogger(BcsTestController.class);

    public BcsTestController() {
        // empty
    }

    @InitBinder
    public void unitBinder(WebDataBinder binder) {
        binder.registerCustomEditor(InputData.class, new InputDataEditor());
    }

    @RequestMapping(value = "/bcstest",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Result bcstest(
            @RequestParam(value = "json", required = false) InputData json
    ) {
        logger.info("CALL: bcstest");
        InputData data = null;
        if (Objects.nonNull(json)) {
//            logger.info(Arrays.toString(json.getStocks()));
            data = json;
        } else {
            // Если ничего нет, взять значение по умолчанию
            data = DefaultDomain.defaultInputData();
        }

        Stock[] stocks = data.getStocks();

        List<Quote> quotes = ServiceCaller.callStockService(stocks);

        /*Map<Stock, Quote> map = IntStream.range(0, stocks.length)
                .boxed()
                .collect(Collectors.toMap(i -> stocks[i],
                        i -> quotes.stream()
                                .filter(q -> q.getSymbol().equals(stocks[i].getSymbol()))
                                .findFirst()
                        )
                );*/

        // Рассчитать для каждой акции ее текущую стоимость (assetValue) в составе портфеля
        // по формуле volume * latestPrice.
        /*for (Stock stock : stocks) {
            *//* double sum = quotes.stream()
                    .filter(q -> q.getSymbol().equals(stock.getSymbol())) // Найдем все совпадающие по symbol
                    .map(Quote::getLatestPrice) // возьмем у них lastestPrive
                    .mapToDouble(lp -> lp * stock.getVolume()) // умножим эту цену на volume
                    .sum(); // просуммируем
             *//*
            stock.setAssetValue(sum);
//            logger.debug(stock.getSymbol() + sum);
            String sector = quotes.stream()
                    .filter(q -> q.getSymbol().equals(stock.getSymbol()))
        }*/
        /*for (Stock stock : stocks) {
            Quote quote = quotes.stream()
                    .filter(q -> q.getSymbol().equals(stock.getSymbol()))
                    .findFirst()
//                    .orElse(null);
                    .get();
            stock.setQuote(quote);
            double assetValue = quote.getLatestPrice() * stock.getVolume();
            stock.setAssetValue(assetValue);
        }*/
        for (Quote quote : quotes) {
            double assetValue = ( quote.getStock().getVolume() * quote.getLatestPrice() );
            quote.setAssetValue(assetValue);
        }

        // Посчитать суммарную стоимость портфеля (value), выполнив sum(assetValue) по всем акциям
        /*double value = Arrays.stream(stocks)
                .mapToDouble(Stock::getAssetValue)
                .sum();*/
        double value = quotes.stream()
                .mapToDouble(q -> (q.getStock().getVolume() * q.getLatestPrice()))
                .sum();

        // Посчитать процентное соотношение стоимости акций для каждого сектора (proportion),
        // используя формулу: sum(assetValue) in sector / value
        Map<String, List<Quote>> sectors = quotes.stream()
                .collect(Collectors.groupingBy(Quote::getSector));

        Allocation[] allocations = new Allocation[sectors.keySet().size()];
        int index = 0;

        for (String sector : sectors.keySet()) {
            List<Quote> quotesBySector = sectors.get(sector);
            double sumInSector = quotesBySector.stream()
                    .mapToDouble(Quote::getAssetValue)
                    .sum();
            double proportionInSector = ( sumInSector / value );
            Allocation allocationInSector = new Allocation(sector, sumInSector, proportionInSector);
            allocations[index ++] = allocationInSector;
        }

        return new Result(value, allocations);
    }

}
