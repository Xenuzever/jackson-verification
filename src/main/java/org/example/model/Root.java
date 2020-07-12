package org.example.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class Root {

  @JacksonXmlProperty(isAttribute = true)
  private String version;

  @JacksonXmlElementWrapper
  private Content content;

  public Root() {
    Content.getStaticItems().clear();
  }

  // For Debug
  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder()
        .append("root:")
        .append(System.lineSeparator())
        .append("\t").append("version:").append(getVersion())
        .append(System.lineSeparator())
        .append("\t").append("content:")
        .append(System.lineSeparator())
        .append("\t\t").append("titile:").append(content.getTitle())
        .append(System.lineSeparator())
        .append("\t\t").append("description:").append(content.getDescription());

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
