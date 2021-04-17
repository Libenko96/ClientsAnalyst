package com.libenko.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Account {
  private String iban;
  private LocalDateTime openDate;

  public Account(String iban, LocalDateTime openDate) {
    this.iban = iban;
    this.openDate = openDate;
  }

  public String getIban() {
    return iban;
  }

  public LocalDateTime getOpenDate() {
    return openDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Account)) return false;
    Account account = (Account) o;
    return Objects.equals(iban, account.iban) &&
        Objects.equals(openDate, account.openDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(iban, openDate);
  }

  @Override
  public String toString() {
    return "Account{" +
        "iban='" + iban + '\'' +
        ", openDate=" + openDate +
        '}';
  }
}
