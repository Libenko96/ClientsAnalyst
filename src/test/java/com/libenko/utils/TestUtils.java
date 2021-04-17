package com.libenko.utils;

import com.libenko.model.Account;
import com.libenko.model.Client;
import com.libenko.model.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class TestUtils {
  private static final Document DOCUMENT = new Document("PASSPORT", 856234, "AA", "Центр РВ", LocalDate.of(1993, 7, 14));
  private static final Document DOCUMENT2 = new Document("PASSPORT", 673456, "AH", "Центр РВ", LocalDate.of(2005, 12, 21));
  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE_TIME;
  public static final Client CLIENT = Client.builder()
      .withId(30834232)
      .withName("Василий")
      .withSurname("Сало")
      .withAccount(new Account("UA903052887990004149123456765", LocalDateTime.parse("2007-11-13T00:00:00+03:00", FORMATTER)))
      .withBirthday(LocalDate.of(1967, 1, 16))
      .withGender("M")
      .withDocuments(Arrays.asList(DOCUMENT, DOCUMENT2))
      .build();
  private static final Document DOCUMENT3 = new Document("PASSPORT", 673456, "AH", "Центр РВ", LocalDate.of(2007, 2, 23));
  public static final Client CLIENT_2 = Client.builder()
      .withId(1084732)
      .withName("Мария")
      .withSurname("Коваленко")
      .withAccount(new Account("UA903052992990004149123456789", LocalDateTime.parse("2010-06-22T00:00:00+03:00", FORMATTER)))
      .withBirthday(LocalDate.of(1991, 12, 4))
      .withGender("F")
      .withDocuments(Arrays.asList(DOCUMENT3))
      .build();
  private static final Document DOCUMENT4 = new Document("IDCARD", 673456453, "AH", "1042", LocalDate.of(2018, 5, 19));
  public static final Client CLIENT_3 = Client.builder()
      .withId(1084732)
      .withName("Анатолий")
      .withSurname("Василенко")
      .withAccount(new Account("UA903052887990004149123456123", LocalDateTime.parse("2020-08-02T00:00:00+03:00", FORMATTER)))
      .withBirthday(LocalDate.of(2004, 3, 25))
      .withGender("M")
      .withDocuments(Arrays.asList(DOCUMENT4))
      .build();
  private static final Document DOCUMENT5 = new Document("PASSPORT", 673456, "AH", "Центр РВ", LocalDate.of(2012, 6, 30));
  private static final Document DOCUMENT6 = new Document("PASSPORT", 673456, "AH", "Центр РВ", LocalDate.of(2011, 2, 23));
  private static final Document DOCUMENT7 = new Document("IDCARD", 673456, "AH", "Центр РВ", LocalDate.of(2012, 8, 1));
  public static final Client CLIENT_4 = Client.builder()
      .withId(1084732)
      .withName("Name")
      .withSurname("Surname")
      .withAccount(new Account("UA903052992990004149123455789", LocalDateTime.parse("2015-06-22T00:00:00+03:00", FORMATTER)))
      .withBirthday(LocalDate.of(1996, 7, 31))
      .withGender("M")
      .withDocuments(Arrays.asList(DOCUMENT5, DOCUMENT6, DOCUMENT7))
      .build();
  public static final List<Client> CLIENTS = Arrays.asList(CLIENT, CLIENT_2, CLIENT_3, CLIENT_4);
  public static final List<Client> ORDERED_CLIENTS = Arrays.asList(CLIENT, CLIENT_2, CLIENT_4, CLIENT_3);
  public static final Client CLIENT_5 = Client.builder()
      .withId(1084732)
      .withName("Name")
      .withSurname("Surname")
      .withAccount(new Account("UA903052992990004149123455789", LocalDateTime.parse("2015-06-22T00:00:00+03:00", FORMATTER)))
      .withBirthday(LocalDate.of(1996, 7, 31))
      .withGender("M")
      .withDocuments(Arrays.asList(DOCUMENT7))
      .build();
  public static final Client CLIENT_6 = Client.builder()
      .withId(30834232)
      .withName("Василий")
      .withSurname("Сало")
      .withAccount(new Account("UA903052887990004149123456765", LocalDateTime.parse("2007-11-13T00:00:00+03:00", FORMATTER)))
      .withBirthday(LocalDate.of(1967, 1, 16))
      .withGender("M")
      .withDocuments(Arrays.asList(DOCUMENT2))
      .build();
  public static final Client CLIENT_7 = Client.builder()
      .withId(1084732)
      .withName("Name")
      .withSurname("Surname")
      .withAccount(new Account("UA903052992990004149123455789", LocalDateTime.parse("2015-06-22T00:00:00+03:00", FORMATTER)))
      .withBirthday(LocalDate.of(1996, 7, 31))
      .withGender("M")
      .withDocuments(Arrays.asList(DOCUMENT5))
      .build();
  private static final Document DOCUMENT8 = new Document("IDCARD", 673456, "AH", "Центр РВ", LocalDate.of(2015, 12, 31));
  public static final Client CLIENT_8 = Client.builder()
      .withId(1084732)
      .withName("Name")
      .withSurname("Surname")
      .withAccount(new Account("UA903052992990004149123455789", LocalDateTime.parse("2015-06-22T00:00:00+03:00", FORMATTER)))
      .withBirthday(LocalDate.of(1996, 7, 31))
      .withGender("M")
      .withDocuments(Arrays.asList(DOCUMENT8))
      .build();
  private static final Document DOCUMENT9 = new Document("PASSPORT", 673456, "AH", "Центр РВ", LocalDate.of(1991, 12, 31));
  public static final Client CLIENT_9 = Client.builder()
      .withId(1084732)
      .withName("Name")
      .withSurname("Surname")
      .withAccount(new Account("UA903052992990004149123455789", LocalDateTime.parse("2015-06-22T00:00:00+03:00", FORMATTER)))
      .withBirthday(LocalDate.of(1969, 7, 31))
      .withGender("M")
      .withDocuments(Arrays.asList(DOCUMENT9))
      .build();
  private static final Document DOCUMENT10 = new Document("IDCARD", 673456, "AH", "Центр РВ", LocalDate.of(2016, 1, 1));
  public static final Client CLIENT_10 = Client.builder()
      .withId(1084732)
      .withName("Name")
      .withSurname("Surname")
      .withAccount(new Account("UA903052992990004149123455789", LocalDateTime.parse("2015-06-22T00:00:00+03:00", FORMATTER)))
      .withBirthday(LocalDate.of(2002, 7, 31))
      .withGender("M")
      .withDocuments(Arrays.asList(DOCUMENT10))
      .build();
  public static final List<Client> CLIENTS_WITH_ACTUAL_DOCS = Arrays.asList(CLIENT_6, CLIENT_2, CLIENT_3, CLIENT_5);
}
