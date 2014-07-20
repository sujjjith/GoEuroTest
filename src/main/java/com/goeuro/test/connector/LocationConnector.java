package com.goeuro.test.connector;

import com.goeuro.test.data.Location;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class LocationConnector {
    private final static Logger logger = Logger.getLogger(LocationConnector.class.getName());
    private RestTemplate restTemplate;

    public LocationConnector(){
        this.restTemplate = new RestTemplate();
    }

    public List<Location> getLocation(String url) {
        List<Location> locations;
        try {
            logger.info("connecting to the server...");
            locations = Arrays.asList(restTemplate.getForObject(url, Location[].class));
        } catch (RestClientException e) {
            logger.warning("no results found for given search input string");
            locations = new ArrayList<Location>();
    }
        return locations;
    }
}



