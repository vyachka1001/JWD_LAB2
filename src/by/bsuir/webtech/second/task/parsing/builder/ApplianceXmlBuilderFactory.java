package by.bsuir.webtech.second.task.parsing.builder;

import by.bsuir.webtech.second.task.entity.ApplianceType;
import by.bsuir.webtech.second.task.parsing.builder.impl.FridgeXmlBuilder;
import by.bsuir.webtech.second.task.parsing.builder.impl.MicrowaveXmlBuilder;
import by.bsuir.webtech.second.task.parsing.builder.impl.TeapotXmlBuilder;

/**
 * Factory that provides appliance xml builders
 */
public class ApplianceXmlBuilderFactory {
    private static final ApplianceXmlBuilderFactory APPLIANCE_FACTORY = new ApplianceXmlBuilderFactory();

    private ApplianceXmlBuilderFactory() {
    }

    /**
     * Get singleton instance of {@link ApplianceXmlBuilderFactory}.
     *
     * @return singleton instance of {@link ApplianceXmlBuilderFactory}
     */
    public static ApplianceXmlBuilderFactory getInstance() {
        return APPLIANCE_FACTORY;
    }

    /**
     * Get appliance xml builder.
     *
     * @param applianceType type of appliance that needs to be build
     * @return appliance xml builder
     */
    public ApplianceXmlBuilder getApplianceXmlBuilder(ApplianceType applianceType) {
        switch (applianceType) {
            case TEAPOT:
                return new TeapotXmlBuilder();
            case FRIDGE:
                return new FridgeXmlBuilder();
            case MICROWAVE:
                return new MicrowaveXmlBuilder();
            default:
                throw new EnumConstantNotPresentException(ApplianceType.class, applianceType.getName());
        }
    }
}
