import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigDecimal;

public class CurrencyConverterTest {

    @Test
    public void testConvertBRLtoUSD() {
        //Given
        Currencies expectedCurrency = Currencies.USD;
        BigDecimal expectedValue = new BigDecimal("100.00");

        BigDecimal brl = new BigDecimal("330.00");

        CurrencyConverter instance = new CurrencyConverter();
        Currency currency = new Currency(brl, Currencies.BRL);

        //When
        Currency returned = instance.convert(currency, expectedCurrency);

        //Then
        assertEquals(expectedValue, returned.getValue());
        assertEquals(expectedCurrency, returned.getCurrencies());
    }

    @Test
    public void testConvertUSDtoBRL() {
        //Given
        Currencies expectedCurrency = Currencies.BRL;
        BigDecimal expectedValue = new BigDecimal("660.00");

        BigDecimal usd = new BigDecimal("200.00");

        CurrencyConverter instance = new CurrencyConverter();
        Currency currency = new Currency(usd, Currencies.USD);

        //When
        Currency returned = instance.convert(currency, expectedCurrency);

        //Then
        assertEquals(expectedValue, returned.getValue());
        assertEquals(expectedCurrency, returned.getCurrencies());
    }
}
