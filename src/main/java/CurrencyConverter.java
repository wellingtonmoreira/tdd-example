import java.math.BigDecimal;

public class CurrencyConverter {
    public Currency convert(final Currency currency, final Currencies to) {
        return currency.convert(to);
    }
}
