package delegations;

public class Delegation {

    private String creationDate ;
    private String startDate ;
    private String endDate ;
    private String purpose ;
    private String status ;
    private String startPoint ;


    /*Obiekty z klas zawierających pola i metody */
    private Employee          employee          = new Employee();
    private Destination       destination       = new Destination();
    private AddDelegation     addDelegation     = new AddDelegation();
    private AcceptDelegation  acceptDelegation  = new AcceptDelegation();
    private DiscardDelegation discardDelegation = new DiscardDelegation();
    private PreviewDelegation previewDelegation = new PreviewDelegation();

    public Delegation() {
    }


}
