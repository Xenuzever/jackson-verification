package org.example.model.sample;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Content {

  private String title;

  private String description;

  private List<Item> items = new ArrayList<>();

  public void setItem(Item item) {
    items.add(item);
  }
}
