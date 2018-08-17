package am.highapps.buythisproduct.app;

import am.highapps.buythisproduct.R;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.support.multidex.MultiDexApplication;
import com.google.firebase.analytics.FirebaseAnalytics;

public class App extends MultiDexApplication {

  private static final String TAG = App.class.getName();
  private static App instance;
  private static FirebaseAnalytics mFirebaseAnalytics = null;
//  private static SharedHelper appSharedHelper;
  private static Context context;
  public boolean isSimulator;

  // ===========================================================
  // Fields
  // ===========================================================

  // ===========================================================
  // Methods for/from SuperClass/Interfaces
  // ===========================================================

  public static App getInstance() {
    return instance;
  }


  @Override
  public void onCreate() {
    super.onCreate();
    initApplication();
    mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    context = getBaseContext();
    isSimulator = true;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      createNotificationChannel();
    }
  }

  private void initApplication() {
    instance = this;

//    appSharedHelper = SharedHelper.getInstance();

    }

//  public static SharedHelper getAppSharedHelper() {
//    return appSharedHelper;
//  }

  public static FirebaseAnalytics getFirebaseAnalytics() {
    return mFirebaseAnalytics;
  }

  private void createNotificationChannel() {
    // Create the NotificationChannel, but only on API 26+ because
    // the NotificationChannel class is new and not in the support library
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      CharSequence name = getString(R.string.app_name);
      String description = getString(R.string.app_name);
      int importance = NotificationManager.IMPORTANCE_DEFAULT;
      NotificationChannel channel = new NotificationChannel("1", name, importance);
      channel.setDescription(description);
      // Register the channel with the system; you can't change the importance
      // or other notification behaviors after this
      NotificationManager notificationManager = getSystemService(NotificationManager.class);
      notificationManager.createNotificationChannel(channel);
    }
  }

}

