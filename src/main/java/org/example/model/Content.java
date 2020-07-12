package org.example.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.Getter;

@Data
public class Content {

  private String title;

  private String description;

  @JacksonXmlProperty(localName = "item")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Item> items;

  @Getter(lazy = true)
  private static final List<Item> staticItems = new ArrayList<>();

  public void setItems(List<Item> items) {
    if (items != null) {
      getStaticItems().addAll(items);
    }
    this.items = getStaticItems();
  }
}
