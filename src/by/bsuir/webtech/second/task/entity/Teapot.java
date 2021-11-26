package by.bsuir.webtech.second.task.entity;

/**
 * Represents a teapot.
 * See {@link Appliance} for more.
 */
public class Teapot extends Appliance {
    /**
     * Teapot volume
     */
    private final long volume;

    /**
     * Default microwave constructor.
     *
     * @param price  price
     * @param power  power
     * @param volume volume
     */
    public Teapot(long price, long power, long volume) {
        super(price, power);
        this.volume = volume;
    }

    /**
     * Get teapot volume.
     *
     * @return volume
     */
    public long getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Teapot{" +
                "price=" + price + ", " +
                "power=" + power + ", " +
                "volume=" + volume +
                "}";
    }
}
