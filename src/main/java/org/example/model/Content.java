package org.example.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Content {

  private String title;

  private String description;

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
