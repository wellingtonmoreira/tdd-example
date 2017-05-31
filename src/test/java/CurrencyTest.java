import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CurrencyTest {

    @Test
    public void testConstructBRLSuccess() {
        //Given
        BigDecimal value = new BigDecimal("100.00");
        Currencies currencies = Currencies.BRL;

        //When
        Currency instance = new Currency(value, currencies);

        //Then
        assertEquals(value, instance.getValue());
        assertEquals(currencies, instance.getCurrencies());
    }

    @Test
    public void testConstructUSDSuccess() {
        //Given
        BigDecimal value = new BigDecimal("50.00");
        Currencies currencies = Currencies.USD;

        //When
        Currency instance = new Currency(value, currencies);

        //Then
        assertEquals(value, instance.getValue());
        assertEquals(currencies, instance.getCurrencies());
    }

    @Test
    public void testConvertUSDToBRL() {
        //Given
        BigDecimal value = new BigDecimal("150.00");
        BigDecimal expectedValue = new BigDecimal("495.00");

        Currency currency = new Currency(value, Currencies.USD);

        //When
        Currency returned = currency.convert(Currencies.BRL);

        //Then
        assertEquals(expectedValue, returned.getValue());
        assertEquals(Currencies.BRL, returned.getCurrencies());
    }

    @Test
    public void testConvertBRLToUSD() {
        //Given
        BigDecimal value = new BigDecimal("495.00");
        BigDecimal expectedValue = new BigDecimal("150.00");

        Currency currency = new Currency(value, Currencies.BRL);

        //When
        Currency returned = currency.convert(Currencies.USD);

        //Then
        assertEquals(expectedValue, returned.getValue());
        assertEquals(Currencies.USD, returned.getCurrencies());
    }

    @Test
    public void testBRLToUSD() {
        BigDecimal value = new BigDecimal("495.00");
        BigDecimal expectedValue = new BigDecimal("150.00");

        Currencies brl = Currencies.BRL;
        Currency currency = new Currency(value, brl);


        assertEquals(expectedValue, currency.convertValues(brl.getRatio(), value, Currencies.USD.getRatio()));
    }

    @Test
    public void testUSDToBRL() {
        BigDecimal value = new BigDecimal("150.0");
        BigDecimal expectedValue = new BigDecimal("495.00");

        Currencies usd = Currencies.USD;
        Currency currency = new Currency(value, usd);


        assertEquals(expectedValue, currency.convertValues(usd.getRatio(), value, Currencies.BRL.getRatio()));
    }

    @Test
    public void testBRLToEUR() {
        BigDecimal value = new BigDecimal("660.0");
        BigDecimal expectedValue = new BigDecimal("300.00");

        Currencies brl = Currencies.BRL;
        Currency currency = new Currency(value, brl);


        assertEquals(expectedValue, currency.convertValues(brl.getRatio(), value, Currencies.EUR.getRatio()));
    }

    @Test
    public void testUSDToBIT() {
        BigDecimal value = new BigDecimal("100.0");
        BigDecimal expectedValue = new BigDecimal("10.00");

        Currencies usd = Currencies.USD;
        Currency currency = new Currency(value, usd);


        assertEquals(expectedValue, currency.convertValues(usd.getRatio(), value, Currencies.BIT.getRatio()));
    }

    @Test
    public void testBITToUSD() {
        BigDecimal value = new BigDecimal("90.0");
        BigDecimal expectedValue = new BigDecimal("900.00");

        Currencies bit = Currencies.BIT;
        Currency currency = new Currency(value, bit);


        assertEquals(expectedValue, currency.convertValues(bit.getRatio(), value, Currencies.USD.getRatio()));
    }

    @Test
    public void testBRLToBIT() {
        BigDecimal value = new BigDecimal("330.0");
        BigDecimal expectedValue = new BigDecimal("10.00");

        Currencies brl = Currencies.BRL;
        Currency currency = new Currency(value, brl);


        assertEquals(expectedValue, currency.convertValues(brl.getRatio(), value, Currencies.BIT.getRatio()));
    }

    @Test
    public void testBITToBRL() {
        BigDecimal value = new BigDecimal("30.0");
        BigDecimal expectedValue = new BigDecimal("990.00");

        Currencies bit = Currencies.BIT;
        Currency currency = new Currency(value, bit);


        assertEquals(expectedValue, currency.convertValues(bit.getRatio(), value, Currencies.BRL.getRatio()));
    }

    @Test
    public void testUSDToJLP() {
        BigDecimal value = new BigDecimal("100.0");
        BigDecimal expectedValue = new BigDecimal("100.0");

        Currencies usd = Currencies.USD;
        Currency currency = new Currency(value, usd);


        assertEquals(expectedValue, currency.convertValues(usd.getRatio(), value, Currencies.JLP.getRatio()));
    }

    @Test
    public void testJLPToUSD() {
        BigDecimal value = new BigDecimal("9999.0");
        BigDecimal expectedValue = new BigDecimal("9999.0");

        Currencies jlp = Currencies.JLP;
        Currency currency = new Currency(value, jlp);


        assertEquals(expectedValue, currency.convertValues(jlp.getRatio(), value, Currencies.USD.getRatio()));
    }

    @Test
    public void testCTLToBRL() {
        BigDecimal value = new BigDecimal("100.0");
        BigDecimal expectedValue = new BigDecimal("100.0");

        Currencies ctl = Currencies.CTL;
        Currency currency = new Currency(value, ctl);


        assertEquals(expectedValue, currency.convertValues(ctl.getRatio(), value, Currencies.BRL.getRatio()));
    }

    @Test
    public void testBRLToCTL() {
        BigDecimal value = new BigDecimal("9999.0");
        BigDecimal expectedValue = new BigDecimal("9999.0");

        Currencies brl = Currencies.BRL;
        Currency currency = new Currency(value, brl);


        assertEquals(expectedValue, currency.convertValues(brl.getRatio(), value, Currencies.CTL.getRatio()));
    }
}
