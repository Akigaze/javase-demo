package demo.javase.lock;

public class LatestMessage {
  private String id;
  private Integer version;

  public LatestMessage(String id, Integer version) {
    this.id = id;
    this.version = version;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public int getVersion() {
    return 0;
  }

}
