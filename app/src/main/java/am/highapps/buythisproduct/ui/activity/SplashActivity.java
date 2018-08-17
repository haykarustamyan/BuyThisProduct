package am.highapps.buythisproduct.ui.activity;

import am.highapps.buythisproduct.R;
import am.highapps.buythisproduct.data.InjectorUtils;
import am.highapps.buythisproduct.data.database.entity.User;
import am.highapps.buythisproduct.firebase.FirebaseApi;
import am.highapps.buythisproduct.util.VersionUtils;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends BaseActivity {

  private static final String TAG = SplashActivity.class.getSimpleName();

  FirebaseApi mFirebaseApi;
  private FirebaseAuth mAuth;


  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mAuth = FirebaseAuth.getInstance();

    mFirebaseApi = FirebaseApi.getInstance();
    if (VersionUtils.isAfter21()) {
      getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
    }
    // if user isn't authorized then suggest him to authorize
//        if (!appSharedHelper.isSavedRememberMe()) {
//            startSecondActivity();
//        } else {
//            startMainActivity();
//        }
    FirebaseUser user = mFirebaseApi.getFirebaseUser();
    if (user == null) {
      signInAnonymously();
    } else {
      startMainActivity();
    }
  }

  @Override
  protected int getLayoutResource() {
    return R.layout.activity_splash;
  }

  private void startMainActivity() {
    Intent intent = new Intent(this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
    startActivity(intent);
    finish();
  }

//  private void startSecondActivity() {
//    Intent intent = new Intent(this, LandingActivity.class);
//    startActivity(intent);
//    finish();
//  }

  private void signInAnonymously() {
    mFirebaseApi.getFirebaseAuth().signInAnonymously()
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
          @Override
          public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
              // Sign in success, update UI with the signed-in user's information
              Log.d(TAG, "signInAnonymously:success");
              FirebaseUser firebaseUser = mFirebaseApi.getFirebaseAuth().getCurrentUser();
              User user = new User(firebaseUser.getUid());

              InjectorUtils.provideRepository(getApplicationContext()).saveUser(user);

              startMainActivity();
            } else {
              // If sign in fails, display a message to the user.
              Log.w(TAG, "signInAnonymously:failure", task.getException());
              Toast.makeText(SplashActivity.this, "Authentication failed.",
                  Toast.LENGTH_SHORT).show();
//              updateUI(null);
            }


          }
        });
  }

}
//com.google.firebase.FirebaseException: An internal error has occurred.
// [ Identity Toolkit API has not been used in project 1091739881494 before or it is disabled.
// Enable it by visiting https://console.developers.google.com/apis/api/identitytoolkit.googleapis.com/overview?project=1091739881494 then retry.
// If you enabled this API recently, wait a few minutes for the action to propagate to our systems and retry. ]