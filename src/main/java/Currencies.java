import java.math.BigDecimal;

public enum Currencies {
    BIT("0.1"), USD("1"), EUR("1.5"), BRL("3.3"), JLP("1"), CTL("3.3");

    private final BigDecimal ratio;

    Currencies(final String ratio) {
        this.ratio = new BigDecimal(ratio);
    }

    public BigDecimal getRatio() {
        return ratio;
    }
}
