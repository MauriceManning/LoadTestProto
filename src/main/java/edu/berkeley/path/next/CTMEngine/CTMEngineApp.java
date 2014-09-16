/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.berkeley.path.next.CTMEngine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * This application models a traffic manager service that publishes traffic status
 * every three seconds. It is decoupled from what services subscribe to that data feed.
 */

public class CTMEngineApp {


    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("ctm-engine.xml");
        context.start();

        final Logger logger = LogManager.getLogger(CTMEngineApp.class.getName());

        logger.info("trafficMonitorApp initialized ");

        JmsPublish jmsPublish = context.getBean(JmsPublish.class);

        // linkManager creates the data to publish representing ccFramework output
        LinkManager linkManager = context.getBean(LinkManager.class);

        logger.info("trafficMonitorApp initialized ");

        //get a list of output links that we will publish over and over
        java.util.List<LinkDataRaw> links = new ArrayList<LinkDataRaw>();
        links = linkManager.getLinkList();

        logger.info("trafficMonitorApp links to publish: " + links.size());

        //counters
        int x = 0;
        int oneHour = 216000;
        int oneMinute = 3600;

        while (x < oneMinute) {
            //use SLF interface which provides for parameterized logging
            logger.info("CTMEngineApp sendLinkList counter:  " + x);
            jmsPublish.sendLinkList(links);
            //sleep for a third of a second
            //Thread.sleep(10);
            x++;
        }
    }


}
