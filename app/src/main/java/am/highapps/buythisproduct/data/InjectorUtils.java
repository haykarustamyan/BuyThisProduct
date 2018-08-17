package am.highapps.buythisproduct.data;

import am.highapps.buythisproduct.app.AppExecutors;
import am.highapps.buythisproduct.data.database.AppDatabase;
import am.highapps.buythisproduct.data.network.ApiFactory;
import am.highapps.buythisproduct.data.network.AppNetworkService;
import android.content.Context;

public class InjectorUtils {

 public static AppRepository provideRepository(Context context) {
        AppDatabase database = AppDatabase.getInstance(context.getApplicationContext());
        AppExecutors executors = AppExecutors.getInstance();
        AppNetworkService appNetworkService =  ApiFactory.getAppNetworkService();
        return AppRepository.getInstance(database, appNetworkService, executors);
    }

}