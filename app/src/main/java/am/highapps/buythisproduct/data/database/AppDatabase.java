package am.highapps.buythisproduct.data.database;

import am.highapps.buythisproduct.data.database.dao.ProductDao;
import am.highapps.buythisproduct.data.database.dao.UserDao;
import am.highapps.buythisproduct.data.database.entity.DateConverter;
import am.highapps.buythisproduct.data.database.entity.Product;
import am.highapps.buythisproduct.data.database.entity.User;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

@Database(entities = {User.class,Product.class}, version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

  public static final String DATABASE_NAME = "buythisproduct.db";

  private static AppDatabase sInstance;

  public abstract UserDao mUserDao();
  public abstract ProductDao mProductDao();

  public static AppDatabase getInstance(final Context context) {
    if (sInstance == null) {
      synchronized (AppDatabase.class) {
        if (sInstance == null) {
          sInstance = Room.databaseBuilder(context.getApplicationContext(),
              AppDatabase.class, AppDatabase.DATABASE_NAME).build();
        }
      }
    }
    return sInstance;
  }

}
