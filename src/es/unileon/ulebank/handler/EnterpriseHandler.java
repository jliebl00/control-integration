/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.handler;


/**
 *
 * @author Gonzalo
 */
public class EnterpriseHandler implements Handler{

    int cif;

    public EnterpriseHandler(int cif) {
        this.cif = cif;
    }
    
    @Override
    public int compareTo(Handler another) {
        return toString().compareTo(another.toString());
    }
    
    @Override
    public String toString(){
        return Integer.toString(cif);
    }
    
}
