package by.bsuir.webtech.second.task.entity;

/**
 * Represents a microwave.
 * See {@link Appliance} for more.
 */
public class Microwave extends Appliance {
    /**
     * Property indicating whether the microwave has timer or not.
     */
    private final boolean hasTimer;

    /**
     * Default microwave constructor.
     *
     * @param price    price
     * @param power    power
     * @param hasTimer has timer or not
     */
    public Microwave(long price, long power, boolean hasTimer) {
        super(price, power);
        this.hasTimer = hasTimer;
    }

    /**
     * Whether microwave has timer or not.
     *
     * @return has timer or not
     */
    public boolean isHasTimer() {
        return hasTimer;
    }

    @Override
    public String toString() {
        return "Microwave{" +
                "price=" + price + ", " +
                "power=" + power + ", " +
                "hasTimer=" + hasTimer +
                "}";
    }
}
