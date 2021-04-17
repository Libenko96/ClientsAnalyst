package com.libenko.validate;

import com.libenko.exception.DocsValidatorException;
import com.libenko.model.Client;
import com.libenko.model.Document;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DocsValidatorImpl implements DocsValidator {

  private static final int PASSPORT_GIVEN_YEAR = 16;
  private static final int GIVEN_DAY = 30;
  private static final int ID_CARD_GIVEN_YEAR = 14;
  private static final String PASSPORT_TYPE = "PASSPORT";
  private static final String ID_CARD_TYPE = "IDCARD";
  private static final LocalDate PASSPORT_MIN_GIVE_DATE = LocalDate.of(1992, 1, 1);
  private static final LocalDate ID_CARD_MIN_GIVE_DATE = LocalDate.of(2016, 1, 1);

  @Override
  public void validateClientDocs(Client client) {
    LocalDate birthday = client.getBirthday();
    for (int i = 0; i < client.getDocuments().size(); i++) {
      Document document = client.getDocuments().get(i);
      checkGiveDate(document);
      validateForBirthday(birthday, document);
    }
  }

  private void validateForBirthday(LocalDate birthday, Document document) {
    long diff = Date.valueOf(document.getGivenDate()).getTime() -
        Date.valueOf(birthday).getTime();
    if (diff < getValidTime(document.getType())) {
      throw new DocsValidatorException(document + " non valid given date for clients birthday");
    }
  }

  private long getValidTime(String type) {
    return (ChronoUnit.YEARS.getDuration().toMillis() * getGivenYear(type))
        - (ChronoUnit.DAYS.getDuration().toMillis() * GIVEN_DAY);
  }

  private void checkGiveDate(Document document) {
    if (document.getGivenDate().compareTo(getGivenMinDate(document.getType())) < 0) {
      throw new DocsValidatorException(document + " given date not valid");
    }
  }

  private LocalDate getGivenMinDate(String type) {
    if (type.equals(PASSPORT_TYPE)) {
      return PASSPORT_MIN_GIVE_DATE;
    } else if (type.equals(ID_CARD_TYPE)) {
      return ID_CARD_MIN_GIVE_DATE;
    }
    throw new DocsValidatorException(type + " this type not valid");
  }


  private int getGivenYear(String type) {
    if (type.equals(PASSPORT_TYPE)) {
      return PASSPORT_GIVEN_YEAR;
    } else if (type.equals(ID_CARD_TYPE)) {
      return ID_CARD_GIVEN_YEAR;
    }
    throw new DocsValidatorException(type + " this type not valid");
  }
}
