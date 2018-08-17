package am.highapps.buythisproduct.data.database.dao;

import am.highapps.buythisproduct.data.database.entity.Product;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;

@Dao
public interface ProductDao {

  @Query("SELECT * FROM product")
  LiveData<List<Product>> getAllProducts();

  @Query("SELECT * FROM product WHERE id=:id")
  Product get(long id);

  @Insert
  long insert(Product product);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertAll(List<Product> products);

  @Update(onConflict = OnConflictStrategy.REPLACE)
  int update(Product product);

  @Delete
  void delete(Product car);

  @Query("DELETE FROM product WHERE id=:id")
  void delete(long id);

}
