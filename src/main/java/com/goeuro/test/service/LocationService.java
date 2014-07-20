package com.goeuro.test.service;

import com.goeuro.test.connector.LocationConnector;
import com.goeuro.test.data.Location;
import com.goeuro.test.generator.CSVFileGenerator;

import java.util.List;
import java.util.logging.Logger;

public class LocationService {
    private final static Logger logger = Logger.getLogger(LocationService.class.getName());
    private static LocationConnector locationConnector;
    private static CSVFileGenerator csvFileGenerator;

    public static void main(String[] args) {
        String searchInput = args[0];
        String url = "http://api.goeuro.com/api/v2/position/suggest/en/" + searchInput;
        logger.info("search URL is " + url);
        locationConnector = new LocationConnector();
        csvFileGenerator = new CSVFileGenerator();
        List<Location> locations = locationConnector.getLocation(url);
        csvFileGenerator.generateCSV(locations,searchInput);
    }
}
