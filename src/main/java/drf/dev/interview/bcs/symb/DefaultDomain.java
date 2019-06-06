package drf.dev.interview.bcs.symb;

import drf.dev.interview.bcs.domain.InputData;
import drf.dev.interview.bcs.domain.Stock;

import static drf.dev.interview.bcs.symb.DefaultSymbols.*;

public final class DefaultDomain {
    private static final InputData defInputData = new InputData(
            new Stock[] {
                    new Stock(AAPL.getDefaultSymbol(), AAPL.getDefaultVolume()),
                    new Stock(HOG.getDefaultSymbol(), HOG.getDefaultVolume()),
                    new Stock(MDSO.getDefaultSymbol(), MDSO.getDefaultVolume()),
                    new Stock(IDRA.getDefaultSymbol(), IDRA.getDefaultVolume()),
                    new Stock(MRSN.getDefaultSymbol(), MRSN.getDefaultVolume())
            }
    );

    private DefaultDomain() {
        throw new AssertionError();
    }

    public static InputData defaultInputData() {
        return defInputData;
    }
}
