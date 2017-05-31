import java.math.BigDecimal;

public class Currency {

    private final BigDecimal value;
    private final Currencies currencies;

    public Currency(final BigDecimal value, final Currencies currencies) {
        this.value = value;
        this.currencies = currencies;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Currencies getCurrencies() {
        return currencies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Currency currency = (Currency) o;

        if (value != null ? !value.equals(currency.value) : currency.value != null) return false;
        return currencies == currency.currencies;

    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (currencies != null ? currencies.hashCode() : 0);
        return result;
    }

    public Currency convert(final Currencies to) {
        final BigDecimal newValue = convertValues(currencies.getRatio(), value, to.getRatio());
        return new Currency(newValue, to);
    }

    BigDecimal convertValues(BigDecimal ratioFrom, BigDecimal valueFrom, BigDecimal ratioTo) {
        if (ratioFrom.compareTo(ratioTo) == 0) return valueFrom;
        else if (!ratioFrom.equals(Currencies.USD.getRatio()) || ratioFrom.compareTo(ratioTo) > 0)
            return valueFrom
                .divide(ratioFrom, 2, BigDecimal.ROUND_HALF_UP)
                .multiply(ratioTo).setScale(2, BigDecimal.ROUND_HALF_UP);

        return valueFrom.multiply(ratioTo).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
