package am.highapps.buythisproduct.data.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import java.util.Objects;

@Entity(tableName = "product")
public class Product {

  @PrimaryKey(autoGenerate = true)
  private int id;
  private String name;
  private double price;
  private String image;
  private String description;
  private int category;
  private int count;
  private int unit;

  @ColumnInfo(name = "should_remind")
  private boolean shouldRemind;

  @ColumnInfo(name = "exp_date")
  private Date expDate;

  public Product(int id, String name, double price, String image, String description, int category,
      int count, int unit, boolean shouldRemind, Date expDate) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.image = image;
    this.description = description;
    this.category = category;
    this.count = count;
    this.unit = unit;
    this.shouldRemind = shouldRemind;
    this.expDate = expDate;
  }

  @Ignore
  public Product(String name, double price, String image, String description, int category,
      int count,
      int unit, boolean shouldRemind, Date expDate) {
    this.name = name;
    this.price = price;
    this.image = image;
    this.description = description;
    this.category = category;
    this.count = count;
    this.unit = unit;
    this.shouldRemind = shouldRemind;
    this.expDate = expDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getCategory() {
    return category;
  }

  public void setCategory(int category) {
    this.category = category;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getUnit() {
    return unit;
  }

  public void setUnit(int unit) {
    this.unit = unit;
  }

  public boolean isShouldRemind() {
    return shouldRemind;
  }

  public void setShouldRemind(boolean shouldRemind) {
    this.shouldRemind = shouldRemind;
  }

  public Date getExpDate() {
    return expDate;
  }

  public void setExpDate(Date expDate) {
    this.expDate = expDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Product)) {
      return false;
    }
    Product product = (Product) o;
    return getId() == product.getId() &&
        Double.compare(product.getPrice(), getPrice()) == 0 &&
        getCategory() == product.getCategory() &&
        getCount() == product.getCount() &&
        getUnit() == product.getUnit() &&
        isShouldRemind() == product.isShouldRemind() &&
        Objects.equals(getName(), product.getName()) &&
        Objects.equals(getImage(), product.getImage()) &&
        Objects.equals(getDescription(), product.getDescription()) &&
        Objects.equals(getExpDate(), product.getExpDate());
  }

  @Override
  public int hashCode() {

    return Objects
        .hash(getId(), getName(), getPrice(), getImage(), getDescription(), getCategory(),
            getCount(),
            getUnit(), isShouldRemind(), getExpDate());
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", price=" + price +
        ", image='" + image + '\'' +
        ", description='" + description + '\'' +
        ", category=" + category +
        ", count=" + count +
        ", unit=" + unit +
        ", shouldRemind=" + shouldRemind +
        ", expDate=" + expDate +
        '}';
  }
}
