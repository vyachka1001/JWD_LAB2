package by.bsuir.webtech.second.task.parsing.builder.impl;

import by.bsuir.webtech.second.task.entity.Appliance;
import by.bsuir.webtech.second.task.entity.Microwave;
import by.bsuir.webtech.second.task.parsing.ApplianceXmlAttributes;
import by.bsuir.webtech.second.task.parsing.ApplianceXmlTags;
import by.bsuir.webtech.second.task.parsing.builder.ApplianceBuilderException;
import by.bsuir.webtech.second.task.parsing.builder.ApplianceXmlBuilder;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * A microwave {@link ApplianceXmlBuilder} implementation.
 */
public class MicrowaveXmlBuilder implements ApplianceXmlBuilder {
    @Override
    public Appliance build(Element element) throws ApplianceBuilderException {
        long price = 0;
        long power = 0;
        String attribute = element.getAttribute(ApplianceXmlAttributes.HAS_TIMER_ATTRIBUTE_NAME);
        boolean hasTimer = Boolean.parseBoolean(attribute);

        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element nodeElement = (Element) node;
                String tagName = nodeElement.getTagName();
                try {
                    long parsedValue = Long.parseLong(nodeElement.getTextContent());
                    switch (tagName) {
                        case ApplianceXmlTags.PRICE_TAG_NAME:
                            price = parsedValue;
                            break;
                        case ApplianceXmlTags.POWER_TAG_NAME:
                            power = parsedValue;
                            break;
                    }
                } catch (NumberFormatException e) {
                    throw new ApplianceBuilderException(e.getMessage(), e);
                }
            }
        }
        return new Microwave(price, power, hasTimer);
    }
}
