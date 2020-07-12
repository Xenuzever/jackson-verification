# Jackson Verification

Jackson Dataformat XML の検証用プロジェクト。

## 事象
以下の構造を XmlMapper にて解析すると、item が１つしか取得できない事象が発生する。
```xml
<root version="2.0">
  <content>
    <title>XML Title</title>
    <description>XML Description</description>
    <item>
      <title>Item - 1</title>
      <description>Description for item 1 ...</description>
      <link url="https://exmaple.org/1">LINK1</link>
    </item>
    <item>
      <title>Item - 2</title>
      <description>Description for item 2 ...</description>
      <link url="https://exmaple.org/2">LINK2</link>
    </item>
    <item>
      <title>Item - 3</title>
      <description>Description for item 3 ...</description>
      <link url="https://exmaple.org/3">LINK3</link>
    </item>
  </content>
</root>
```

この際、Item を保持する Java オブジェクトには以下が定義されている。
```java
@JacksonXmlProperty(localName = "item")
@JacksonXmlElementWrapper(useWrapping = false)
private List<Item> items;

public void setItems(List<Item> items) {
  this.items = items;
}
```

上記だと、item を解析する度にサイズが１の Item リストを毎回当該フィールドに設定してしまう。   
よって、最後に解析した item のみを保持したリストが残り、item を１つしか取得できなくなる。

## 解決策

item に対応するフィールドは作成せず、item を複数保持するフィールドのみを作る。  
このとき、`@JacksonXmlProperty(localName = "item")` は敢えて指定しない。

item の setter を作成し、その中で当該フィールドに add する。
```java
private List<Item> items = new ArrayList<>();

public void setItem(Item item) {
  items.add(item);
}
```

Jackson は xml の要素に対応する setter を積極的に使用するので、期待通りの挙動をする。
