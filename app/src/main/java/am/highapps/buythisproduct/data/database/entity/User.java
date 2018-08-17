package am.highapps.buythisproduct.data.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class User {

  @PrimaryKey
  private String key;
  private String homeId;

  public User(String key) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  @Override
  public String toString() {
    return "User{" +
        ", key='" + key + '\'' +
        '}';
  }
}
