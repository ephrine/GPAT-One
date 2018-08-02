package devesh.ephrine.gpat;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MainActivity extends Activity {
    public boolean installed = false;
    InterstitialAd mInterstitialAd;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private CallbackManager mCallbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);
        FacebookSdk.sdkInitialize(getApplicationContext());
        usercheck();
        View loading = (View) findViewById(R.id.loadingHome);
        loading.setVisibility(View.GONE);
        isInternetOn();

        intAD();

        AdLoad();

// printKeyHash();
    }

    private void printKeyHash() {
        // Add code to print out the key hash
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "devesh.ephrine.gpat",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("--------------------", "----------");

                Log.d("KeyHash1:-----------", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("KeyHash2:", e.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.d("KeyHash3:", e.toString());
        }
    }

    public void share(View v) {

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Boost your GPAT study with GPAT #1 app. Download @ https://play.google.com/store/apps/details?id=devesh.ephrine.gpat");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);

    }

    public void about(View v) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void privacy(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://ephrine.blogspot.com/p/privacy-policy.html")); //Google play store
        startActivity(intent);
    }

    public void logout(View v) {

        FirebaseAuth.getInstance().signOut();
        LoginManager.getInstance().logOut();
        if (installed = true) {
            finish();
        } else if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            Log.e("GPAT", " INT ADLoad------------------------");
        }


    }

    public void qp(View v) {
        Intent intent = new Intent(this, QPActivity.class);
        startActivity(intent);
    }

    public void syllabus(View v) {
        Intent intent = new Intent(this, SyllabusActivity.class);
        startActivity(intent);
    }

    public void notes(View v) {
        Toast.makeText(this, "Loading Study Notes!! ", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, NotesActivity.class);
        startActivity(intent);
    }

    public void books(View v) {
        // Toast.makeText(this, "Get Important Books for GPAT Exam... Coming Soon!!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, BookActivity.class);
        startActivity(intent);
    }


    public final boolean isInternetOn() {

        // get Connectivity Manager object to check connection
        ConnectivityManager connec =
                (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if (connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {

            // if connected with internet
            // Toast.makeText(this, " Connected ", Toast.LENGTH_LONG).show();
            View Error = (View) findViewById(R.id.noNet);
            Error.setVisibility(View.GONE);

            return true;

        } else if (
                connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED) {
            View Error = (View) findViewById(R.id.noNet);
            Error.setVisibility(View.VISIBLE);

            Toast.makeText(this, "Please Connect to Internet...", Toast.LENGTH_LONG).show();

            return false;
        }
        return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //    Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.about:
                Intent ab = new Intent(this, AboutActivity.class);
                startActivity(ab);
                break;
            case R.id.share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Boost your GPAT study with GPAT #1 app. Download @ https://play.google.com/store/apps/details?id=devesh.ephrine.gpat");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;


            default:
                break;
        }

        return true;
    }

    public void usercheck() {
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("User status", "onAuthStateChanged:signed_in:" + user.getUid());
                    AccountLoad();
                    AdLoad();
                    AskPermissions();


                } else {
                    // User is signed out
                    Log.d("User status", "onAuthStateChanged:signed_out");
                    View Log = (View) findViewById(R.id.LoginXML);
                    Log.setVisibility(View.VISIBLE);

                    View home = (View) findViewById(R.id.HomeXML);
                    home.setVisibility(View.GONE);
                    FBFirebase();
                }
            }
        };
    }


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }


    public void AccountLoad() {
        mAuth = FirebaseAuth.getInstance();
        View Log = (View) findViewById(R.id.LoginXML);
        Log.setVisibility(View.GONE);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            //  String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();


            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            // String uid = user.getUid();
            String picURL = photoUrl.toString();

            TextView UserName = (TextView) findViewById(R.id.textViewHomeUserName);
            ImageView ProfilePic = (ImageView) findViewById(R.id.imageViewPic);

            Glide.with(this).load(picURL).into(ProfilePic);
            UserName.setText(name);


        }
    }


    public void FBFirebase() {
        mAuth = FirebaseAuth.getInstance();

        // Initialize Facebook Login button
        mCallbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email", "public_profile");
        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("GPAT #1 FB", "facebook:onSuccess:" + loginResult);
                handleFacebookAccessToken(loginResult.getAccessToken());
                View loading = (View) findViewById(R.id.loadingHome);
                loading.setVisibility(View.VISIBLE);


            }

            @Override
            public void onCancel() {
                Log.d("GPAT", "facebook:onCancel");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d("GPAT", "facebook:onError", error);
            }

        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result back to the Facebook SDK
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d("GPAT", "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("GPAT", "signInWithCredential:onComplete:" + task.isSuccessful());

                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        if (user != null) {
                            // Name, email address, and profile photo Url
                            View home = (View) findViewById(R.id.HomeXML);
                            home.setVisibility(View.VISIBLE);
                            View loading = (View) findViewById(R.id.loadingHome);
                            loading.setVisibility(View.GONE);
                            usercheck();
                        }
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w("GPAT", "signInWithCredential", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            if (installed == true) {
                Log.e("GPAT", " INT AD Disabled");

                finish();

            } else if (mInterstitialAd.isLoaded()) {
                finish();
                mInterstitialAd.show();

                Log.e("GPAT", " INT ADLoad------------------------");
            } else {
                finish();
                Log.e("GPAT", " INT AD Disabled (NO KEY)");

            }
            // your code
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }


    public void intAD() {

        if (installed == true) {

        } else {

            String intAdID = getString(R.string.Ad_Int_ad_id);

            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId(intAdID);
            Log.e("GPAT Load AD", " INT AD Disabled (NO KEY)");

            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    requestNewInterstitial();
                    finish();
                }
            });

            requestNewInterstitial();
        }
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .build();

        mInterstitialAd.loadAd(adRequest);
    }


    public void AdLoad() {

        String APPID = getString(R.string.AdMob_APP_ID);

        MobileAds.initialize(getApplicationContext(), APPID);

        AdView mAdView = (AdView) findViewById(R.id.adView);


        isAppInstalled("devesh.ephrine.gpat.pro");

        if (installed == true) {
            mAdView.setVisibility(View.GONE);
            Log.e("GPAT", " AD Disabled");

        } else {

            Bundle extras = new FacebookAdapter.FacebookExtrasBundleBuilder()
                    .setNativeAdChoicesIconExpandable(false)
                    .build();

            AdRequest adRequest = new AdRequest.Builder()
                    .addNetworkExtrasBundle(FacebookAdapter.class, extras)
                    .build();


            // AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
            Log.e("GPAT", " AD Loaded");

        }


    }


    private boolean isAppInstalled(String uri) {
        PackageManager pm = getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            installed = false;
        }
        return installed;
    }


    public void AskPermissions() {
        //Permissions
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                    1);

            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    1);

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(MainActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


}
