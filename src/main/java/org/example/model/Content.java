package org.example.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Content {

  private String title;

  private String description;

  @JacksonXmlProperty(localName = "item")
  @JacksonXmlElementWrapper(useWrapping = false)
  static final List<Item> items = new ArrayList<>();

  public Content() {
    items.clear();
  }

  public void setItem(Item item) {
    items.add(item);
  }

  public List<Item> getItems() {
    return items;
  }
}
