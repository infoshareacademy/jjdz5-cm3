package delegations;

import console.ConsolePrinter;
import console.ConsoleReader;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class DelegationAdd {

    DelegationRepository delegationRepository = new DelegationRepository();
    ConsolePrinter consolePrinter = new ConsolePrinter();
    ConsoleReader consoleReader = new ConsoleReader();
    Destination destination = new Destination();
    Delegation delegation = new Delegation();
    Employee employee = new Employee(  );


    public void delegationAdd() {

        //wprowadzanie danych przez uzytkownika
        consolePrinter.printLine("Podaj date tworzenia delegacji (RRRR-MM-DD): ");
        delegation.setCreationDate( consoleReader.getDate() );

        consolePrinter.printLine("Podaj imie: ");
        employee.setEmployeeName(consoleReader.getStringOneWord());

        consolePrinter.printLine("Podaj nazwisko: ");
        employee.setEmployeeSurname(consoleReader.getStringOneWord());

        delegation.setEmployee( employee );

        consolePrinter.printLine("Podaj date rozpoczecia delegacji (RRRR-MM-DD): ");
        delegation.setStartDate(consoleReader.getDate());

        consolePrinter.printLine("Podaj date zakonczenia delegacji (RRRR-MM-DD): ");
        delegation.setEndDate(consoleReader.getDate());

        consolePrinter.printLine("Podaj kraj wyjazdu: ");
        destination.setDestinationCountry(consoleReader.getStringMoreWords());

        consolePrinter.printLine("Podaj miasto: ");
        destination.setDestinationCity(consoleReader.getStringMoreWords());

        consolePrinter.printLine("Podaj nazwe firmy: ");
        destination.setDestinationCompany(consoleReader.getString());

        consolePrinter.printLine("Podaj adres firmy: ");
        destination.setDestinationCompanyAddress(consoleReader.getString());

        delegation.setDestination( destination );

        consolePrinter.printLine("Podaj cel delegacji: ");
        delegation.setPurpose(consoleReader.getString());

        delegation.setStatus("TOACCEPT");

        consolePrinter.printLine("Podaj miejsce wyjazdu (miasto): ");
        delegation.setStartPoint(consoleReader.getStringMoreWords());



        Delegation newDelegation = new Delegation(delegation.getCreationDate(), delegation.getStartDate(),
                delegation.getEndDate(), delegation.getPurpose(), delegation.getStatus(),
                delegation.getStartPoint(), delegation.getEmployee(),delegation.getDestination());

                delegationRepository.addListDelegation( newDelegation );

        System.out.println("Delegacja: " + newDelegation);



//                public Delegation(LocalDate creationDate,
//                LocalDate startDate,
//                LocalDate endDate,
//                String purpose,
//                String status,
//                String startPoint,
//                Employee employee,
//                Destination destination) {
//            this.creationDate = creationDate;
//            this.startDate = startDate;
//            this.endDate = endDate;
//            this.purpose = purpose;
//            this.status = status;
//            this.startPoint = startPoint;
//            this.employee = employee;
//            this.destination = destination;




    }
}


//    public String addEmployee() {
//
//        Employee employee = new Employee();
//        System.out.println("Podaj imie: ");
//        String name = employee.setEmployeeName(insertData());
//        System.out.println("Podaj nazwisko: ");
//        String surname = employee.setEmployeeSurname(insertData());
//        System.out.println();
//        String employeeData = name + ":" + surname + ":";
//        return employeeData;
//    }
//    public String addDelegationDetails() {
//        System.out.println();
//        System.out.println("                        Dane szczegolowe                        ");
//        System.out.println("________________________________________________________________");
//        System.out.println();
//        Delegation delegation = new Delegation();
//        System.out.println("Podaj date tworzenia delegacji (DD-MM-RRRR): ");
//        String date = delegation.setCreationDate(insertData());
//        System.out.println("Podaj date rozpoczecia delegacji (DD-MM-RRRR): ");
//        String start = delegation.setStartDate(insertData());
//        System.out.println("Podaj date powrotu (DD-MM-RRRR): ");
//        String end = delegation.setEndDate(insertData());
//        System.out.println("Podaj miejsce wyjazdu: ");
//        String startPlace = delegation.setStartPoint(insertData());
//        System.out.println("Podaj przyczyne wyjazdu delegacyjnego: ");
//        String purpose = delegation.setPurpose(insertData());
//        String delegationDetailsData = date + ":" + start + ":" + end + ":" + startPlace + ":" + purpose + ":";
//        return delegationDetailsData;
//    }
//    public String addDestination() {
//        System.out.println();
//        System.out.println("                       Szczegoly delegacji                      ");
//        System.out.println("________________________________________________________________");
//        System.out.println();
//        Destination destination = new Destination();
//        System.out.println("Podaj kraj: ");
//        String country = destination.setDestinationCountry(insertData());
//        System.out.println("Podaj miasto: ");
//        String city = destination.setDestinationCity(insertData());
//        System.out.println("Podaj nazwe firmy: ");
//        String companyName = destination.setDestinationCompany(insertData());
//        System.out.println("Podaj adres firmy ");
//        String adress = destination.setDestinationCompanyAddress(insertData());
//        System.out.println();
//        String destinationData = country + ":" + city + ":" + companyName + ":" + adress + ":";
//        return destinationData;
//    }
////    public void showDelegation() {
////        System.out.println("Imie pracownika: " + name);
////        System.out.println("Nazwisko pracownika: " + surname);
////
////        System.out.println("Data utworzenia delegacji: " + date);
////        System.out.println("Data wyjazdu: " + start);
////        System.out.println("Data powrotu: " + end);
////        System.out.println("Miejsce wyjazdu: + startPlace);
////        System.out.println("Przyczyta wjazdu: " + purpose);
////
////        System.out.println("Docelowy kraj: " + );
////        System.out.println("Miasto: " + city);
////        System.out.println("Nazwa firmy: " + companyName);
////        System.out.println("Adres firmy: " + adress);
////
////
////    }
//}