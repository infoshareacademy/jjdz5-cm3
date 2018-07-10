package delegations;

public class PreviewDelegation {

    public void previewDelegation(Delegation myDelegation) {
        String previewEmployee = "";
        System.out.println("przegladanie delegacji test");

        myDelegation.setEmployee( new Employee ("Michał" , "Michalek"));
        System.out.println (myDelegation.getEmployee ().getEmployeeName () );



    }
}
