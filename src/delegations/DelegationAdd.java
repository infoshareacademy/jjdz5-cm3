package delegations;

import console.ConsolePrinter;
import console.ConsoleReader;

public class DelegationAdd {

    ConsolePrinter consolePrinter = new ConsolePrinter();
    ConsoleReader consoleReader = new ConsoleReader();
    Delegation delegation = new Delegation();
    Employee employee = new Employee(  );


    public void delegationAdd() {

        consolePrinter.printLine("Podaj date tworzenia delegacji (RRRR-MM-DD): ");
        delegation.setCreationDate( consoleReader.getDate() );
        consolePrinter.printLine("Podaj imie: ");
        employee.setEmployeeName(consoleReader.readLine());

        consolePrinter.printLine( "Data utworzenia delegacji: " + delegation.getCreationDate() );
        consolePrinter.printLine("Imie: " + employee.getEmployeeName());



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