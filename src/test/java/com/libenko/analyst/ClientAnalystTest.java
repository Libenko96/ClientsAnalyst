package com.libenko.analyst;

import com.libenko.exception.DocsValidatorException;
import com.libenko.model.Client;
import com.libenko.utils.TestUtils;
import com.libenko.validate.DocsValidator;
import com.libenko.validate.DocsValidatorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Set;

class ClientAnalystTest {
  private DocsValidator docsValidator = new DocsValidatorImpl();
  private ClientAnalyst clientAnalyst = new ClientAnalyst(docsValidator);

  @Test
  void removeNonActualDocsTest() {
    clientAnalyst.removeNonActualDocs(TestUtils.CLIENTS);

    Assertions.assertEquals(TestUtils.CLIENTS, TestUtils.CLIENTS_WITH_ACTUAL_DOCS);
  }

  @Test
  void getSortedClientsTest() {
    Set<Client> clients = clientAnalyst.getSortedClients(TestUtils.CLIENTS);

    Assertions.assertEquals(TestUtils.ORDERED_CLIENTS, new ArrayList<>(clients));
  }

  @Test
  void validateShouldThrowExceptionForPassport() {
    Exception exception = Assertions.assertThrows(DocsValidatorException.class, () ->
        clientAnalyst.validateClientDocs(TestUtils.CLIENT_7));
    Assertions.assertEquals(exception.getMessage(), "Document{type='PASSPORT', number=673456, series='AH'," +
        " given='Центр РВ', givenDate=2012-06-30} non valid given date for clients birthday");
  }

  @Test
  void validateShouldThrowExceptionForIdCard() {
    Exception exception = Assertions.assertThrows(DocsValidatorException.class, () ->
        clientAnalyst.validateClientDocs(TestUtils.CLIENT_10));
    Assertions.assertEquals(exception.getMessage(), "Document{type='IDCARD', number=673456, series='AH'," +
        " given='Центр РВ', givenDate=2016-01-01} non valid given date for clients birthday");
  }

  @Test
  void validateIdCardGivenDateShouldThrowException() {
    Exception exception = Assertions.assertThrows(DocsValidatorException.class, () ->
        clientAnalyst.validateClientDocs(TestUtils.CLIENT_8));
    Assertions.assertEquals(exception.getMessage(), "Document{type='IDCARD', number=673456, series='AH'," +
        " given='Центр РВ', givenDate=2015-12-31} given date not valid");
  }

  @Test
  void validatePassportGivenDateShouldThrowException() {
    Exception exception = Assertions.assertThrows(DocsValidatorException.class, () ->
        clientAnalyst.validateClientDocs(TestUtils.CLIENT_9));
    Assertions.assertEquals(exception.getMessage(), "Document{type='PASSPORT', number=673456, series='AH'," +
        " given='Центр РВ', givenDate=1991-12-31} given date not valid");
  }

  @Test
  void validateShouldNonThrowException() {
    Assertions.assertDoesNotThrow(() -> clientAnalyst.validateClientDocs(TestUtils.CLIENT_3));
  }
}
