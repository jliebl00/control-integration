/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.client.types;

import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.handler.EnterpriseHandler;

/**
 *
 * @author Gonzalo
 */
public class Enterprise extends Client{

    public Enterprise(int cifNumber) {
        super(new EnterpriseHandler(cifNumber));
    }
    
    
}
