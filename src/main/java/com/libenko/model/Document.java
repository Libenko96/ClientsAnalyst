package com.libenko.model;

import java.time.LocalDate;
import java.util.Objects;

public class Document {
  private String type;
  private int number;
  private String series;
  private String given;
  private LocalDate givenDate;

  public Document(String type, int number, String series, String given, LocalDate givenDate) {
    this.type = type;
    this.number = number;
    this.series = series;
    this.given = given;
    this.givenDate = givenDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Document)) return false;
    Document document = (Document) o;
    return number == document.number &&
        Objects.equals(type, document.type) &&
        Objects.equals(series, document.series) &&
        Objects.equals(given, document.given) &&
        Objects.equals(givenDate, document.givenDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, number, series, given, givenDate);
  }

  public String getType() {
    return type;
  }

  public int getNumber() {
    return number;
  }

  public String getSeries() {
    return series;
  }

  public String getGiven() {
    return given;
  }

  public LocalDate getGivenDate() {
    return givenDate;
  }

  @Override
  public String toString() {
    return "Document{" +
        "type='" + type + '\'' +
        ", number=" + number +
        ", series='" + series + '\'' +
        ", given='" + given + '\'' +
        ", givenDate=" + givenDate +
        '}';
  }
}
