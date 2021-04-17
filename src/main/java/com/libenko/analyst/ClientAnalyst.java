package com.libenko.analyst;

import com.libenko.model.Client;
import com.libenko.model.Document;
import com.libenko.validate.DocsValidator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class ClientAnalyst {

  private final DocsValidator docsValidator;

  public ClientAnalyst(DocsValidator docsValidator) {
    this.docsValidator = docsValidator;
  }

  public SortedSet<Client> getSortedClients(List<Client> clients) {
    return new TreeSet<>(clients);
  }

  public void removeNonActualDocs(List<Client> clients) {
    for (Client client : clients) {
      List<Document> documents = client.getDocuments();
      if (documents.size() > 1) {
        documents.sort(getDocsComparator());
        client.setDocuments(Arrays.asList(documents.get(documents.size() - 1)));
      }
    }
  }

  private Comparator<Document> getDocsComparator() {
    return Comparator.comparing(Document::getGivenDate);
  }

  public void validateClientDocs(Client client) {
    docsValidator.validateClientDocs(client);
  }
}
