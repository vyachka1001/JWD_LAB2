package by.bsuir.webtech.second.task.entity;

/**
 * Represents an appliance.
 */
public class Appliance {
    /**
     * Appliance price.
     */
    protected final long price;
    /**
     * Appliance power.
     */
    protected final long power;

    /**
     * Default appliance constructor
     *
     * @param price price
     * @param power power
     */
    public Appliance(long price, long power) {
        this.price = price;
        this.power = power;
    }

    /**
     * Get price of an appliance
     *
     * @return price
     */
    public long getPrice() {
        return price;
    }

    /**
     * Get power of and appliance.
     *
     * @return power
     */
    public long getPower() {
        return power;
    }
}
