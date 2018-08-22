package delegations;

import console.ConsolePrinter;
import console.ConsoleReader;
import properties.Properties;

import java.time.LocalDate;

public class DelegationAdd {

    private final DelegationPreview delegationPreview = new DelegationPreview();
    private final DelegationRepository delegationRepository = new DelegationRepository();
    private final ConsolePrinter consolePrinter = new ConsolePrinter();
    private final ConsoleReader consoleReader = new ConsoleReader();
    private final Destination destination = new Destination();
    private final Delegation delegation = new Delegation();
    private final Employee employee = new Employee();


    public void delegationAdd() {

        //wprowadzanie danych przez uzytkownika
        delegation.setCreationDate(LocalDate.now());

        consolePrinter.printLine("Podaj imię: ");
        employee.setEmployeeName(consoleReader.getStringOneWord());

        consolePrinter.printLine("Podaj nazwisko: ");
        employee.setEmployeeSurname(consoleReader.getStringOneWord());

        delegation.setEmployee(employee);

        consolePrinter.printLine("Podaj datę rozpoczęcia delegacji (RRRR-MM-DD): ");

        delegation.setStartDate(consoleReader.getDateStart());

        consolePrinter.printLine("Podaj datę zakończenia delegacji (RRRR-MM-DD): ");

        delegation.setEndDate(consoleReader.getDateStart());

        if (!isStartDateBeforeEndDate()) {
            consolePrinter.printLine ("Data zakończenia delegacji nie może być wcześniejsza niż data jej rozpoczęcia: " + delegation.getStartDate());
            consolePrinter.printLine("Sprobuj jeszcze raz.");
            delegation.setEndDate(consoleReader.getDateStart());
        }

        consolePrinter.printLine("Podaj kraj wyjazdu (domyślnie: " + Properties.userDelegationCountry + "): ");
        consolePrinter.printLine("Jesli akceptujesz kraj, wcisnij ENTER, jesli chcesz go zmienic wpisz ponizej");

        destination.setDestinationCountry(consoleReader.getStringDefaultCountry ());

        consolePrinter.printLine("Podaj miasto: ");
        destination.setDestinationCity(consoleReader.getStringMoreWords());

        consolePrinter.printLine("Podaj nazwę firmy: ");
        destination.setDestinationCompany(consoleReader.getStringMoreWordsLow());

        consolePrinter.printLine("Podaj adres firmy: ");
        destination.setDestinationCompanyAddress(consoleReader.getStringMoreWordsLow());

        delegation.setDestination(destination);

        consolePrinter.printLine("Podaj cel delegacji: ");
        delegation.setPurpose(consoleReader.getStringOneWordLow());

        delegation.setDelegationStatus(DelegationStatus.TOACCEPT);

        consolePrinter.printLine("Podaj miejsce wyjazdu (miasto): ");
        delegation.setStartPoint(consoleReader.getStringMoreWords());

        delegation.setFileLineNumber(delegationPreview.delegationMaxId());

        Delegation newDelegation = new Delegation(delegation.getFileLineNumber(), delegation.getCreationDate(), delegation.getEmployee(), delegation.getStartDate(),
                delegation.getEndDate(), delegation.getDestination(), delegation.getPurpose(), delegation.getDelegationStatus(),
                delegation.getStartPoint());


        consolePrinter.printLine("=======================================================");
        consolePrinter.printLine("Data utworzenia: " + delegation.getCreationDate());
        consolePrinter.printLine("Imię i nazwisko: " + delegation.getEmployee().getEmployeeName() + " " + delegation.getEmployee().getEmployeeSurname());
        consolePrinter.printLine("Delegacja od: " + delegation.getStartDate() + " do: " + delegation.getEndDate());
        consolePrinter.printLine("Kraj: " + delegation.getDestination().getDestinationCountry());
        consolePrinter.printLine("Miasto: " + delegation.getDestination().getDestinationCity());
        consolePrinter.printLine("Firma i jej adres: " + delegation.getDestination().getDestinationCompany() + "," + delegation.getDestination().getDestinationCompanyAddress());
        consolePrinter.printLine("Cel delegacji: " + delegation.getPurpose());
        consolePrinter.printLine("Wyjazd z miasta: " + delegation.getStartPoint());
        consolePrinter.printLine("=======================================================");
        consolePrinter.printLine("");

        consolePrinter.printLine("| Czy chcesz zapisać powyższą delegację?");
        consolePrinter.printLine("| 1. Zapisz delegację | 2. Nie zapisuj delegacji |");

        delegationRepository.addDelegation(newDelegation);

    }

    public boolean isStartDateBeforeEndDate() {
        if (delegation.getEndDate().isAfter(delegation.getStartDate().minusDays(1))){
            return true;
        }else
            return false;
    }





}


