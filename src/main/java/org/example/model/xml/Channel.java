package org.example.model.xml;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Channel {

  private String generator;

  private String title;

  private String link;

  private String language;

  private String webMaster;

  private String copyright;

  private String lastBuildDate;

  private String description;

  private List<Item> items = new ArrayList<>();

  public void setItem(Item item) {
    items.add(item);
  }
}
