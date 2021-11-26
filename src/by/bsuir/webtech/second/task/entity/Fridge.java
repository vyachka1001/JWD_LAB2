package by.bsuir.webtech.second.task.entity;

/**
 * Represents a fridge.
 * See {@link Appliance} for more.
 */
public class Fridge extends Appliance {
    /**
     * Fridge autonomous cold storage time.
     */
    private final long autonomousColdStorageTime;

    /**
     * Default fridge constructor.
     *
     * @param price                     price
     * @param power                     power
     * @param autonomousColdStorageTime autonomous cold storage time
     */
    public Fridge(long price, long power, long autonomousColdStorageTime) {
        super(price, power);
        this.autonomousColdStorageTime = autonomousColdStorageTime;
    }

    /**
     * Get autonomous cold storage time.
     *
     * @return autonomous cold storage time
     */
    public long getAutonomousColdStorageTime() {
        return autonomousColdStorageTime;
    }

    @Override
    public String toString() {
        return "Fridge{" +
                "price=" + price + ", " +
                "power=" + power + ", " +
                "autonomousColdStorageTime=" + autonomousColdStorageTime +
                "}";
    }
}
