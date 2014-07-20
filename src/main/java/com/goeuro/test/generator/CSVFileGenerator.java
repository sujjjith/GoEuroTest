package com.goeuro.test.generator;

import au.com.bytecode.opencsv.CSVWriter;
import com.goeuro.test.data.Location;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CSVFileGenerator {
    private final static Logger logger = Logger.getLogger(CSVFileGenerator.class.getName());
    private CSVWriter csvWriter;

    public void generateCSV(List<Location> locations, String searchInput){
        if(locations.size() > 0){
            try {
                String path = System.getProperty("user.dir");
                logger.info("Generating " + searchInput +".csv file at " + path );
                csvWriter = new CSVWriter(new FileWriter(searchInput + ".csv"), ',');
                List<String[]> locationsData = new ArrayList<String[]>();
                for(Location location : locations){
                    String[] locationData = new String[]{location.get_type(),
                            String.valueOf(location.get_id()),
                            location.getKey(),
                            location.getName(),
                            location.getFullName(),
                            location.getIata_airport_code(),
                            location.getType(),
                            location.getCountry(),
                            String.valueOf(location.getGeo_position().getLatitude()),
                            String.valueOf(location.getGeo_position().getLongitude()),
                            String.valueOf(location.getLocation_id()),
                            String.valueOf(location.isInEurope()),
                            location.getCountryCode(),
                            String.valueOf(location.isCoreCountry()),
                            String.valueOf(location.getDistance())};
                    locationsData.add(locationData);
                }
                csvWriter.writeAll(locationsData);
                csvWriter.close();
                } catch (IOException e) {
                e.printStackTrace();
            }
        }else
            logger.warning("No results found for this location " + searchInput);

    }
}
