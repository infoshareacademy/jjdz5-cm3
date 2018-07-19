package delegations;

import java.util.ArrayList;
import java.util.List;

import delegations.*;

public class DelegationRepository {
    
    public final static List<Delegation> listDelegations = new ArrayList<> ();
    
    public void addListDelegation(Delegation delegation){
        listDelegations.add (delegation);

    }
}
