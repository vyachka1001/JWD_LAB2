package by.bsuir.webtech.second.task.director;

import by.bsuir.webtech.second.task.dao.Dao;
import by.bsuir.webtech.second.task.entity.Appliance;
import by.bsuir.webtech.second.task.entity.ApplianceType;
import by.bsuir.webtech.second.task.logic.ApplianceService;
import by.bsuir.webtech.second.task.parsing.Parser;
import by.bsuir.webtech.second.task.parsing.ParserException;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Director that controls the flow of appliance
 * loading, saving and extracting.
 */
public class ApplianceDirector {
    private static final Logger logger = Logger.getLogger(ApplianceDirector.class.getName());
    private static final String PATH_TO_APPLIANCES_XML = "./appliances.xml";

    private final Parser<Appliance, ApplianceType> parser;
    private final ApplianceService applianceService;
    private final Dao<Appliance, ApplianceType> applianceDao;

    /**
     * @param parser           parser for parsing appliance data.
     * @param applianceService service for operating appliances.
     * @param applianceDao     appliance DAO for data saving.
     */
    public ApplianceDirector(Parser<Appliance, ApplianceType> parser, ApplianceService applianceService, Dao<Appliance, ApplianceType> applianceDao) {
        this.parser = parser;
        this.applianceService = applianceService;
        this.applianceDao = applianceDao;
    }

    /**
     * Run the flow for appliances.
     */
    public void process() {
        Map<ApplianceType, List<Appliance>> applianceMap;
        try {
            applianceMap = parser.parse(PATH_TO_APPLIANCES_XML);
            applianceDao.saveAll(applianceMap);
        } catch (ParserException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return;
        }

        logger.log(Level.INFO, "Appliances loaded: {0}\n", applianceMap);
        List<Appliance> teapots = applianceService.getAllTeapots();

        logger.log(Level.INFO, "Teapots: {0}\n", teapots);
        Optional<Appliance> cheapestAppliance = applianceService.getCheapestAppliance();
        if (cheapestAppliance.isPresent()) {
            logger.log(Level.INFO, "Cheapest appliance: {0}\n", cheapestAppliance.get());
            return;
        }

        logger.log(Level.INFO, "No appliances found.\n");
    }
}
