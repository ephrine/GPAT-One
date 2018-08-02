package devesh.ephrine.gpat;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginActivity extends AppCompatActivity {
    public String EmailTx;
    public String DisplayNameTx;
    public String UID;
    public View Loadingview;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private CallbackManager mCallbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        //   callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_login);

        final Intent i = new Intent(getBaseContext(), MainActivity.class);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("GPAT #1", "onAuthStateChanged:signed_in:" + user.getUid());
                    //    startActivity(i);
//finish();
                } else {
                    // User is signed out
                    Log.d("GPAT #1", "onAuthStateChanged:signed_out");
                }

            }
        };
        FBFirebase();
//        printKeyHash();


//        loginButton = (LoginButton)findViewById(R.id.login_button);
/*
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {


                Log.i("GPAT #1 FB Userid: ",loginResult.getAccessToken().getUserId());
                Log.i("GPAT #1 Auth token",loginResult.getAccessToken().getToken());
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException e) {

            }
        });


        new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(
                    final Profile oldProfile,
                    final Profile currentProfile) {
                updateUI();
            }
        };



*/
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
            Log.d("--------------------", "----------");

            Log.d("KeyHash2:", e.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.d("--------------------", "----------");

            Log.d("KeyHash3:", e.toString());
        }
    }


/*
    private void updateUI() {
        Profile profile = Profile.getCurrentProfile();
        if (profile != null) {
          //  profilePictureView.setProfileId(profile.getId());
            Log.i("GPAT #1 FB User Name: ",profile.getFirstName());
            Log.i("GPAT #1 FB User LName: ",profile.getLastName() );
            Log.i("GPAT #1 FB User LName: ",profile.getLastName() );


            com.facebook.accountkit.AccessToken accessToken = AccountKit.getCurrentAccessToken();

            if (accessToken != null) {
                //Handle Returning User
                AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
                    @Override
                    public void onSuccess(final Account account) {
                        // Get Account Kit ID
                        String accountKitId = account.getId();

                        // Get phone number
                        PhoneNumber phoneNumber = account.getPhoneNumber();
                        String phoneNumberString = phoneNumber.toString();

                        // Get email
                        String email = account.getEmail();

                        Log.i("GPAT #1 FB AccKit ID ",accountKitId);
                        Log.i("GPAT #1 phone number ",phoneNumberString);
                        Log.i("GPAT #1 FB email ",email);

                    }

                    @Override
                    public void onError(final AccountKitError error) {
                        // Handle Error
                    }
                });


            } else {
                //Handle new or logged out user
            }
        } else {
            //profilePictureView.setProfileId(null);
          //  userNameView.setText(getString(R.string.welcome));
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

*/


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
            }

            @Override
            public void onCancel() {
                Log.d("GPAT", "facebook:onCancel");
                // ...
            }

            @Override
            public void onError(FacebookException error) {
                Log.d("GPAT", "facebook:onError", error);
                // ...
            }
        });

// ...


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
                            String name = user.getDisplayName();
                            String email = user.getEmail();
                            // Uri photoUrl = user.getPhotoUrl();
                            Log.d("GPAT", "FB USERNAME: " + name);
                            Log.d("GPAT", "FB EMAIL: " + email);

                            // Check if user's email is verified
                            //boolean emailVerified = user.isEmailVerified();

                            // The user's ID, unique to the Firebase project. Do NOT use this value to
                            // authenticate with your backend server, if you have one. Use
                            // FirebaseUser.getToken() instead.
                            String uid = user.getUid();
                            Log.d("GPAT", "FB UID: " + uid);
                            String pic = user.getPhotoUrl().toString();
                            Log.d("GPAT", "FB pic: " + pic);
                            Intent i = new Intent(getBaseContext(), MainActivity.class);
                            startActivity(i);


                        }
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w("GPAT", "signInWithCredential", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
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


/*    public void LoginAcc(View v){
        EmailET=(EditText)findViewById(R.id.editTextemail);
        PasswordET=(EditText)findViewById(R.id.editTextPassword);
        EmailTx=EmailET.getText().toString();
        PasswordTx=PasswordET.getText().toString();

        mAuth.signInWithEmailAndPassword(EmailTx, PasswordTx)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("GPAT #1", "signInWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w("GPAT #1", "signInWithEmail", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });



    }



    public void createaccount(View v){

        LoadingShow();

        EmailET=(EditText)findViewById(R.id.editTextemail);

        FirstNameET=(EditText)findViewById(R.id.editTextFname);

        LastNameET=(EditText)findViewById(R.id.editTextLname);
        PasswordET=(EditText)findViewById(R.id.editTextPassword);

        //-------
        EmailTx=EmailET.getText().toString();
        FirstNameTx=FirstNameET.getText().toString();
        LastNameTx=LastNameET.getText().toString();
        PasswordTx=PasswordET.getText().toString();

        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(EmailTx, PasswordTx)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("GPAT #1", "createUserWithEmail:onComplete:" + task.isSuccessful());

                        DatabaseEntery();



                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Error: Failed to create account.",
                                    Toast.LENGTH_SHORT).show();
                            LoadingHide();
                        }

                    }
                });


    }

    public void DatabaseEntery(){


        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {

                    // User is signed in
                    Log.d("GPAT #1", "onAuthStateChanged:signed_in:" + user.getUid());

                    UID=user.getUid();

                    // Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();

                    // First Name
                    DatabaseReference Fname = database.getReference("GPAT/ACCOUNTS/"+UID+"/FNAME");
                    Fname.setValue(FirstNameTx);

                    //Last Name
                    DatabaseReference Lname = database.getReference("GPAT/ACCOUNTS/"+UID+"/LNAME");
                    Lname.setValue(LastNameTx);

                    //Email ID
                    DatabaseReference emailID = database.getReference("GPAT/ACCOUNTS/"+UID+"/EMAILID");
                    emailID.setValue(EmailTx);

                    //MAC Address
                    String macaddress=getMacAddr().toString();
                    DatabaseReference mac = database.getReference("GPAT/ACCOUNTS/"+UID+"/MAC");
                    mac.setValue(macaddress);


                    LoadingHide();


                } else {
                    // User is signed out
                    Log.d("GPAT #1", "onAuthStateChanged:signed_out");
                    LoadingHide();
                }
            }
        };


    }

    public static String getMacAddr() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(Integer.toHexString(b & 0xFF) + ":");
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
            //handle exception
        }
        return "";
    }

    public void LoadingHide(){

        Loadingview=(View)findViewById(R.id.loadingLogin);
        Loadingview.setVisibility(View.GONE);

    }

    public void LoadingShow(){

        Loadingview=(View)findViewById(R.id.loadingLogin);
        Loadingview.setVisibility(View.VISIBLE);

    }

    public void DisplayCreateAcc(View v){

        LLSignin=(LinearLayout)findViewById(R.id.LLSignIN);
        LLSignup=(LinearLayout)findViewById(R.id.LLCreateAccount);
        LLUserName=(LinearLayout)findViewById(R.id.LLUserName);

        LLSignup.setVisibility(View.VISIBLE);
        LLUserName.setVisibility(View.VISIBLE);
        LLSignin.setVisibility(View.GONE);

    }

    public void DisplaySigninAcc(View v){

        LLSignin=(LinearLayout)findViewById(R.id.LLSignIN);
        LLSignup=(LinearLayout)findViewById(R.id.LLCreateAccount);
        LLUserName=(LinearLayout)findViewById(R.id.LLUserName);

        LLSignup.setVisibility(View.GONE);
        LLUserName.setVisibility(View.GONE);
        LLSignin.setVisibility(View.VISIBLE);


    }

*/

}
