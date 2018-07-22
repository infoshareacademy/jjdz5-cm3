package delegations;

import console.ConsolePrinter;
import console.ConsoleReader;


import java.time.LocalDate;



public class DelegationAdd {

    DelegationRepository delegationRepository = new DelegationRepository();
    ConsolePrinter consolePrinter = new ConsolePrinter();
    ConsoleReader consoleReader = new ConsoleReader();
    Destination destination = new Destination();
    Delegation delegation = new Delegation();
    Employee employee = new Employee();



    public void delegationAdd() {

        //wprowadzanie danych przez uzytkownika
        delegation.setCreationDate( LocalDate.now() );

        consolePrinter.printLine( "Podaj imie: " );
        employee.setEmployeeName( consoleReader.getStringOneWord() );

        consolePrinter.printLine( "Podaj nazwisko: " );
        employee.setEmployeeSurname( consoleReader.getStringOneWord() );

        delegation.setEmployee( employee );

        consolePrinter.printLine( "Podaj date rozpoczecia delegacji (RRRR-MM-DD): " );

        delegation.setStartDate( consoleReader.getDateStart() );

        consolePrinter.printLine( "Podaj date zakonczenia delegacji (RRRR-MM-DD): " );

        delegation.setEndDate( consoleReader.getDateStart());

        if (!delegation.getEndDate().isAfter( delegation.getStartDate() )) {
            System.out.println("Data zakonczenia delegacji powinna byc pozniejsza niz data jej rozpoczecia.");
            System.out.println("Sprobuj jeszcze raz.");
            delegation.setEndDate( consoleReader.getDateStart());
        }


        consolePrinter.printLine( "Podaj kraj wyjazdu: " );
        destination.setDestinationCountry( consoleReader.getStringMoreWords() );

        consolePrinter.printLine( "Podaj miasto: " );
        destination.setDestinationCity( consoleReader.getStringMoreWords() );

        consolePrinter.printLine( "Podaj nazwe firmy: " );
        destination.setDestinationCompany( consoleReader.getString() );

        consolePrinter.printLine( "Podaj adres firmy: " );
        destination.setDestinationCompanyAddress( consoleReader.getString() );

        delegation.setDestination( destination );

        consolePrinter.printLine( "Podaj cel delegacji: " );
        delegation.setPurpose( consoleReader.getString() );

        delegation.setDelegationStatus( DelegationStatus.TOACCEPT );

        consolePrinter.printLine( "Podaj miejsce wyjazdu (miasto): " );
        delegation.setStartPoint( consoleReader.getStringMoreWords() );

        Delegation newDelegation = new Delegation( delegation.getCreationDate(), delegation.getEmployee(), delegation.getStartDate(),
                delegation.getEndDate(),  delegation.getDestination(), delegation.getPurpose(), delegation.getDelegationStatus(),
                delegation.getStartPoint());

        consolePrinter.printLine("Czy chcesz zapisac delegacje?");
        consolePrinter.printLine("Wpisz 1 - ZAPISZ || Wpisz 2- ODRZUC");
        delegationRepository.addDelegation( newDelegation );

    }


}


