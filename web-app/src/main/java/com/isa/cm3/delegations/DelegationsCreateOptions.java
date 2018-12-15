package com.isa.cm3.delegations;

import com.isa.cm3.freemarker.MapModelGenerator;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class DelegationsCreateOptions {

    @Inject
    private MapModelGenerator mapModelGenerator;

    @Inject
    private DictionaryCreationDateAddition dictionaryCreationDateAddition;

    @Inject
    private DictionaryNameAddition dictionaryNameAddition;

    @Inject
    private DictionarySurnameAddition dictionarySurnameAddition;

    @Inject
    private DictionaryDestinationCountryAddition dictionaryDestinationCountryAddition;

    public void createOptionsTemplate() {
        mapModelGenerator.setModel("dates", dictionaryCreationDateAddition.getDictionaryCreationDates());
        mapModelGenerator.setModel("names", dictionaryNameAddition.getDictionaryNames());
        mapModelGenerator.setModel("surnames", dictionarySurnameAddition.getDictionarySurnames());
        mapModelGenerator.setModel("countries", dictionaryDestinationCountryAddition.getDictionaryDestinationCountries());
    }

    public void createDefaultOptionTemplate(String choiceCreationDate, String choiceName, String choiceSurname, String choiceCountry, String choiceStatus) {
        mapModelGenerator.setModel("datesOption", choiceCreationDate);
        mapModelGenerator.setModel("namesOption", choiceName);
        mapModelGenerator.setModel("surnamesOption", choiceSurname);
        mapModelGenerator.setModel("countriesOption", choiceCountry);
        mapModelGenerator.setModel("statusOption", choiceStatus);
    }

    public void addOptionsTemplate() {
        dictionaryCreationDateAddition.addDictionaryCreationDates();
        dictionaryNameAddition.addDictionaryNames();
        dictionarySurnameAddition.addDictionarySurnames();
        dictionaryDestinationCountryAddition.addDictionaryDestinationCountries();
    }
}
