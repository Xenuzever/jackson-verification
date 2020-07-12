package org.example.model.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement
public class RSS {

  @JacksonXmlProperty(isAttribute = true)
  private String version;

  @JacksonXmlElementWrapper
  private Channel channel;

  // For Debug
  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder()
        .append("root:")
        .append(System.lineSeparator())
        .append("\t").append("version:").append(getVersion())
        .append(System.lineSeparator())
        .append("\t").append("channel:")
        .append(System.lineSeparator())
        .append("\t\t").append("titile:").append(channel.getTitle())
        .append(System.lineSeparator())
        .append("\t\t").append("description:").append(channel.getDescription());

    for (Item item : channel.getItems()) {
      builder.append(System.lineSeparator())
          .append("\t\t").append("item:")
          .append(System.lineSeparator())
          .append("\t\t\t").append("title:").append(item.getTitle())
          .append(System.lineSeparator())
          .append("\t\t\t").append("guid:").append(item.getGuid())
          .append(System.lineSeparator())
          .append("\t\t\t").append("pubDate:").append(item.getPubDate())
          .append(System.lineSeparator())
          .append("\t\t\t").append("description:").append(item.getDescription())
          .append(System.lineSeparator())
          .append("\t\t\t").append("link:").append(item.getLink());
    }

    return builder.toString();
  }
}
