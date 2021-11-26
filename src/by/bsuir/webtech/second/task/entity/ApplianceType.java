package by.bsuir.webtech.second.task.entity;

/**
 * Enum representing the type of {@link Appliance}.
 */
public enum ApplianceType {
    TEAPOT("teapot"),
    FRIDGE("fridge"),
    MICROWAVE("microwave");

    private final String name;

    ApplianceType(String name) {
        this.name = name;
    }

    /**
     * Get name of appliance type.
     *
     * @return appliance type name
     */
    public String getName() {
        return name;
    }
}
