package es.unileon.ulebank.brokerage;

import es.unileon.ulebank.brokerage.handler.HandlerShare;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import java.util.ArrayList;
import java.util.Iterator;

public class BagSimulator {
    
    private static ArrayList<Enterprise> hardcodedEnterprises;
    private static BagSimulator instance = null;
    
    private BagSimulator() {
        BagSimulator.hardcodedEnterprises = new ArrayList<>();
        try {
            BagSimulator.hardcodedEnterprises.add(
                    new Enterprise(new HandlerShare("GOOGL", "Google, Inc.", "Bag"), 300, 10000)
            );
            
            BagSimulator.hardcodedEnterprises.add(
                    new Enterprise(new HandlerShare("APPLE", "Apple, Inc.", "Bag"), 1, 10000)
            );
            
            BagSimulator.hardcodedEnterprises.add(
                    new Enterprise(new HandlerShare("FRBRD", "Fury Bird, Inc.", "Bag"), 1000, 2)
            );
        } catch (MalformedHandlerException ex) {
            // TODO something
        }
    }
    
    public BagSimulator getInstance() {
        if (BagSimulator.instance == null) {
            BagSimulator.instance = new BagSimulator();
        }
        
        return BagSimulator.instance;
    }
    
    /**
     * Returns a enterprise matching the given ID. If its not found, a default one will be created with that ID.
     * @param enterpriseID
     * @return a enterprise matching the given ID. If its not found, a default one will be created with that ID.
     */
    public Enterprise getEnterpriseHandler(Handler enterpriseID) {
        Enterprise wanted = new Enterprise(enterpriseID, 0, 0);
        
        if (!BagSimulator.hardcodedEnterprises.isEmpty()) {
            Iterator<Enterprise> it = BagSimulator.hardcodedEnterprises.iterator();
            Enterprise e;
            boolean found = false;
            
            do {
                e = it.next();
                if (e.getEnterpriseID().compareTo(enterpriseID) != 0) {
                    found = true;
                    wanted = e;
                }
            } while (it.hasNext() && !found);
        }
        
        return wanted;
    }
}
