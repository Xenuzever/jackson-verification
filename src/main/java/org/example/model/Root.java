package org.example.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;

@Data
public class Root {

  @JacksonXmlElementWrapper
  private Content content;

  public Root() {
    Content.staticItems.clear();
  }

  // For Debug
  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder()
        .append("content:")
        .append(System.lineSeparator())
        .append("\t").append("titile:").append(content.getTitle())
        .append(System.lineSeparator())
        .append("\t").append("description:").append(content.getDescription());

    for (Item item : content.getItems()) {
      builder.append(System.lineSeparator())
          .append("\t\t").append("item:")
          .append(System.lineSeparator())
          .append("\t\t\t").append("title:").append(item.getTitle())
          .append(System.lineSeparator())
          .append("\t\t\t").append("description:").append(item.getDescription())
          .append(System.lineSeparator())
          .append("\t\t\t").append("link:").append(item.getLink());
    }

    return builder.toString();
  }
}
