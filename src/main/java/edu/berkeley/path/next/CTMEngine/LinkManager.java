package edu.berkeley.path.next.CTMEngine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * create a big bundle of links. Set numberOfLinks to desired count.
 */


public class LinkManager {

    public java.util.List<LinkDataRaw> getLinkList() {

        final Logger logger = LogManager.getLogger(LinkManager.class.getName());

        logger.info("LinkManager initialized ");

        java.util.List<LinkDataRaw> links = new ArrayList<LinkDataRaw>();

        Point point1 = new Point();
        point1.setElevation(1.1);
        point1.setLatitude(2.2);
        point1.setLongitude(3.3);

        Point point2 = new Point();
        point2.setElevation(4.4);
        point2.setLatitude(5.5);
        point2.setLongitude(6.6);

        List<String> roadNames = Arrays.asList("Shattuck", "Telegraph", "College");
        List<Point> points = Arrays.asList(point1, point2);

        // how many links to put into the list
        int numberOfLinks = 50000;

        long x = 0;
        String msg = "status";
        while (x < numberOfLinks) {
            LinkDataRaw ldr = new LinkDataRaw();

            // fill the link with canned numbers
            ldr.setBeginNodeId(1L);
            ldr.setCapacity(50L);
            ldr.setEndNodeId(x);
            ldr.setIsSink(false);
            ldr.setIsSource(false);
            ldr.setIsValid(true);
            ldr.setLaneOffset(5.5);
            ldr.setLanes(5.0);
            ldr.setLength(5.0);
            ldr.setLinkid((double)x);
            ldr.setLinkName("LinkName");
            ldr.setNetworkid(5.0);
            ldr.setRunid(5.0);
            ldr.setSpeedLimit(75.0);
            ldr.setVehiclecount(100.0);
            ldr.setRoadNames(roadNames);
            ldr.setPoints(points);

            // add this link to the list
            links.add(ldr);
            // increment
            x++;
        }

        logger.info("LinkManager returning links ");
        return links;
    }

}
