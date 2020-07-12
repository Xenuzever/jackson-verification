package org.example.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Content {

  private String title;

  private String description;

  @JacksonXmlElementWrapper
  private Item item;
  static final List<Item> staticItems = new ArrayList<>();

  public void setItem(Item item) {
    staticItems.add(item);
  }

  public List<Item> getItems() {
    return staticItems;
  }
}
