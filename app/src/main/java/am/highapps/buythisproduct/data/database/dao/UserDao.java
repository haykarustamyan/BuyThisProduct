package am.highapps.buythisproduct.data.database.dao;

import am.highapps.buythisproduct.data.database.entity.Product;
import am.highapps.buythisproduct.data.database.entity.User;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;

@Dao
public interface UserDao {

  @Query("SELECT * FROM user WHERE `key`=:key")
  User get(String key);

  @Insert
  long insert(User user);

  @Update(onConflict = OnConflictStrategy.REPLACE)
  int update(User user);

  @Delete
  void delete(User user);

  @Query("DELETE FROM product WHERE id=:id")
  void delete(long id);

}
