package by.bsuir.webtech.second.task.parsing;

import by.bsuir.webtech.second.task.entity.Appliance;
import by.bsuir.webtech.second.task.entity.ApplianceType;
import by.bsuir.webtech.second.task.parsing.builder.ApplianceBuilderException;
import by.bsuir.webtech.second.task.parsing.builder.ApplianceXmlBuilder;
import by.bsuir.webtech.second.task.parsing.builder.ApplianceXmlBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * An appliance XML DOM {@link Parser} implementation.
 */
public class ApplianceDomParser implements Parser<Appliance, ApplianceType> {
    /**
     * Parse the appliance xml file.
     *
     * @param path path to file
     * @return map of appliance-type-to-appliance values
     * @throws ParserException in case of errors during parsing
     */
    @Override
    public Map<ApplianceType, List<Appliance>> parse(String path) throws ParserException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            Document document = buildDocument(path, documentBuilderFactory);
            NodeList appliances = getNodesList(document);
            return getApplianceMap(appliances);
        } catch (ParserConfigurationException | SAXException | IOException | ParserException | ApplianceBuilderException e) {
            throw new ParserException(e.getMessage(), e);
        }
    }

    private EnumMap<ApplianceType, List<Appliance>> getApplianceMap(NodeList appliances) throws ApplianceBuilderException {
        EnumMap<ApplianceType, List<Appliance>> applianceMap = new EnumMap<>(ApplianceType.class);
        for (int i = 0; i < appliances.getLength(); i++) {
            processNode(appliances.item(i), applianceMap);
        }
        return applianceMap;
    }

    private NodeList getNodesList(Document document) throws ParserException {
        NodeList appliances = document.getElementsByTagName(ApplianceXmlTags.APPLIANCES_TAG_NAME);
        Node root = appliances.item(0);
        if (root == null) {
            throw new ParserException("No appropriate root tag found.");
        }
        return root.getChildNodes();
    }

    private Document buildDocument(String path, DocumentBuilderFactory documentBuilderFactory) throws ParserConfigurationException, SAXException, IOException {
        documentBuilderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File(path));
        document.getDocumentElement().normalize();
        return document;
    }

    private void processNode(Node node, EnumMap<ApplianceType, List<Appliance>> applianceMap) throws ApplianceBuilderException {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            Optional<ApplianceType> optionalAppliance = getOptionalApplianceType(element);
            if (optionalAppliance.isPresent()) {
                buildAppliance(applianceMap, optionalAppliance.get(), element);
            }
        }
    }

    private void buildAppliance(EnumMap<ApplianceType, List<Appliance>> applianceMap, ApplianceType applianceType, Element element) throws ApplianceBuilderException {
        ApplianceXmlBuilder applianceXmlBuilder = ApplianceXmlBuilderFactory.getInstance().getApplianceXmlBuilder(applianceType);
        Appliance appliance = applianceXmlBuilder.build(element);
        applianceMap.computeIfAbsent(applianceType, key -> new ArrayList<>());
        applianceMap.get(applianceType).add(appliance);
    }

    private Optional<ApplianceType> getOptionalApplianceType(Element element) {
        return Arrays.stream(ApplianceType.values())
                .filter(applianceType -> applianceType.getName().equals(element.getTagName()))
                .findFirst();
    }
}
