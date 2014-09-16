package edu.berkeley.path.next.persistService;

import edu.berkeley.path.next.CTMEngine.LinkDataRaw;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * This class represents a connection to a repository. When the addLinkData method
 * is called by the model runner service it creates a link data object and
 * persists it in the repository.
 */


public class LinkDataPersistController {


    /**
     * Autowired annotation denotes member to be conncted by Spring's dependency injection
     * facilities Fields are injected right after construction of a bean, before any
     * config methods are invoked.
     */
    @Autowired
    private DBChannel repository;

    public String addLinkData(java.util.List<LinkDataRaw> links) {


        java.util.List<LinkData> linkToStore = new ArrayList<LinkData>();

        // only persist a limited number of the link set
        int linkCountToPersist = 10;

        // transfer the data into the DAO
        for (int i=0; i<linkCountToPersist; i++) {
            LinkData linkData = new LinkData();
            LinkDataRaw rawlink = links.get(i);

            linkData.setCapacity(rawlink.getCapacity());
            linkData.setLinkid(rawlink.getLinkid());
            linkData.setNetworkid(rawlink.getNetworkid());
            linkData.setRunid(rawlink.getRunid());
            linkData.setVehiclecount(rawlink.getVehiclecount());
            linkData.setBeginNodeId(rawlink.getBeginNodeId());
            linkData.setEndNodeId(rawlink.getEndNodeId());
            linkData.setIsSink(rawlink.getIsSink());
            linkData.setIsSource(rawlink.getIsSource());
            linkData.setIsValid(rawlink.getIsValid());
            linkData.setEndNodeId(rawlink.getEndNodeId());
            linkData.setLaneOffset(rawlink.getLaneOffset());
            linkData.setVehiclecount(rawlink.getVehiclecount());
            linkData.setLanes(rawlink.getLanes());
            linkData.setLength(rawlink.getLength());
            linkData.setSpeedLimit(rawlink.getSpeedLimit());
            linkData.setTypeName(rawlink.getTypeName());

            //add this DAO to the list of objects to persist
            linkToStore.add(linkData);

        }

        repository.storeLinkData(linkToStore);

        return "/result.jsp";
    }

}
