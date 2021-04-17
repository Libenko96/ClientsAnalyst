package com.libenko.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Client implements Comparable<Client> {
  private long id;
  private String name;
  private String surname;
  private LocalDate birthday;
  private String gender;
  private List<Document> documents;
  private Account account;

  private Client(Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.surname = builder.surname;
    this.birthday = builder.birthday;
    this.gender = builder.gender;
    this.documents = builder.documents;
    this.account = builder.account;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public String getGender() {
    return gender;
  }

  public List<Document> getDocuments() {
    return documents;
  }

  public Account getAccount() {
    return account;
  }

  public void setDocuments(List<Document> documents) {
    this.documents = documents;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Client)) return false;
    Client client = (Client) o;
    return Objects.equals(id, client.id) &&
        Objects.equals(gender, client.gender) &&
        Objects.equals(name, client.name) &&
        Objects.equals(surname, client.surname) &&
        Objects.equals(birthday, client.birthday) &&
        Objects.equals(documents, client.documents) &&
        Objects.equals(account, client.account);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname, birthday, gender, documents, account);
  }

  @Override
  public int compareTo(Client client) {
    LocalDateTime input = client.getAccount().getOpenDate();
    return account.getOpenDate().compareTo(input);
  }

  public static class Builder {
    private long id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private String gender;
    private List<Document> documents;
    private Account account;

    private Builder() {
    }

    public Builder withId(long id) {
      this.id = id;
      return this;
    }

    public Builder withName(String name) {
      this.name = name;
      return this;
    }

    public Builder withSurname(String surname) {
      this.surname = surname;
      return this;
    }

    public Builder withBirthday(LocalDate birthday) {
      this.birthday = birthday;
      return this;
    }

    public Builder withGender(String gender) {
      this.gender = gender;
      return this;
    }

    public Builder withDocuments(List<Document> documents) {
      this.documents = documents;
      return this;
    }

    public Builder withAccount(Account account) {
      this.account = account;
      return this;
    }

    public Client build() {
      return new Client(this);
    }
  }

  @Override
  public String toString() {
    return "Client{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", birthday=" + birthday +
        ", gender='" + gender + '\'' +
        ", documents=" + documents +
        ", account=" + account +
        '}';
  }
}
