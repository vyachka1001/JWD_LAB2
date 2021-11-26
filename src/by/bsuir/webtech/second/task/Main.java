package by.bsuir.webtech.second.task;

import by.bsuir.webtech.second.task.dao.ApplianceDao;
import by.bsuir.webtech.second.task.dao.Dao;
import by.bsuir.webtech.second.task.director.ApplianceDirector;
import by.bsuir.webtech.second.task.entity.Appliance;
import by.bsuir.webtech.second.task.entity.ApplianceType;
import by.bsuir.webtech.second.task.logic.ApplianceService;
import by.bsuir.webtech.second.task.logic.impl.ApplianceServiceImpl;
import by.bsuir.webtech.second.task.parsing.ApplianceDomParser;
import by.bsuir.webtech.second.task.parsing.Parser;

/**
 * Program entry point.
 * Declares the dependencies and runs the {@link ApplianceDirector}.
 */
public class Main {
    public static void main(String[] args) {
        Parser<Appliance, ApplianceType> parser = new ApplianceDomParser();
        Dao<Appliance, ApplianceType> dao = ApplianceDao.getInstance();
        ApplianceService service = new ApplianceServiceImpl(dao);

        ApplianceDirector director = new ApplianceDirector(parser, service, dao);
        director.process();
    }
}
