package am.highapps.buythisproduct.data;

import am.highapps.buythisproduct.app.AppExecutors;
import am.highapps.buythisproduct.data.database.AppDatabase;
import am.highapps.buythisproduct.data.database.entity.User;
import am.highapps.buythisproduct.data.network.AppNetworkService;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppRepository {

  private static final String TAG = AppRepository.class.getSimpleName();

  // For Singleton instantiation
  private static final Object LOCK = new Object();
  private static AppRepository sInstance;
  private final AppDatabase mAppDatabase;
  private final AppNetworkService mAppNetworkService;
  private final AppExecutors mExecutors;
  private boolean mInitialized = false;

  private AppRepository(AppDatabase appDatabase,
      AppNetworkService appNetworkService,
      AppExecutors executors) {
    mAppDatabase = appDatabase;
    mAppNetworkService = appNetworkService;
    mExecutors = executors;

    // As long as the repository exists, observe the network LiveData.
    // If that LiveData changes, update the appDatabase.
//    LiveData<WeatherEntry[]> networkData = mWeatherNetworkDataSource.getCurrentWeatherForecasts();
//    networkData.observeForever(new Observer<WeatherEntry[]>() {
//      @Override
//      public void onChanged(@Nullable WeatherEntry[] newForecastsFromNetwork) {
//        mExecutors.diskIO().execute(() -> {
//          // Deletes old historical data
//          AppRepository.this.deleteOldData();
//          Log.d(LOG_TAG, "Old weather deleted");
//          // Insert our new weather data into Sunshine's appDatabase
//          mAppDatabase.bulkInsert(newForecastsFromNetwork);
//          Log.d(LOG_TAG, "New values inserted");
//        });
//      }
//    });
  }

  public synchronized static AppRepository getInstance(
      AppDatabase appDatabase, AppNetworkService appNetworkService,
      AppExecutors executors) {
    if (sInstance == null) {
      synchronized (LOCK) {
        sInstance = new AppRepository(appDatabase, appNetworkService,
            executors);
      }
    }
    return sInstance;
  }

  public void saveUser(User user) {

    mExecutors.diskIO().execute(new Runnable() {
      @Override
      public void run() {
        mAppDatabase.mUserDao().insert(user);
      }
    });
  }

}
