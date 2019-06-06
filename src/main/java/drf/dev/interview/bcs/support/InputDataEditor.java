package drf.dev.interview.bcs.support;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import drf.dev.interview.bcs.domain.InputData;
import drf.dev.interview.bcs.domain.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputDataEditor extends PropertyEditorSupport {
    private static Logger logger = LoggerFactory.getLogger(InputDataEditor.class);
    public InputDataEditor() {
        // empty
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        ObjectMapper mapper = new ObjectMapper();

        InputData value = null;

        try {
            JsonNode root = mapper.readTree(text);
            JsonNode arrayNode = root.get("stocks");
            List<Stock> stocks = new ArrayList<>();
            if (arrayNode.isArray()) {
//                stocks = new Stock[arrayNode.size()];
                for (JsonNode stock : arrayNode) {
                    String symbol = stock.get("symbol").asText();
                    long volume = stock.get("volume").asLong();

                    Stock item = new Stock(symbol, volume);
                    stocks.add(item);
                }
            }
            value = new InputData(stocks.toArray(new Stock[stocks.size()]));
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }

        setValue(value);
    }
}
