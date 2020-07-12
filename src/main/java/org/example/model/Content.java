package org.example.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Content {

  static List<Item> staticItems;

  {
    staticItems = new ArrayList<>();
  }

  private String title;

  private String description;

  @JacksonXmlProperty(localName = "item")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Item> items;

  public void setItems(List<Item> items) {
    if (items != null) {
      staticItems.addAll(items);
    }
    this.items = staticItems;
  }
}
