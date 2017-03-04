package devesh.ephrine.gpat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class SyllabusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

AdLoad();

    }

    public void phychem(View v){
        setContentView(R.layout.syllabus_web);

        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fsyllabus%2Fphychem.html?alt=media&token=cd25b0f2-e7a0-4945-b351-1ae856ef3498");
        webload();
        AdLoad();


    }
    public void pp(View v){
        setContentView(R.layout.syllabus_web);
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fsyllabus%2FPHYSICAL%20PHARMACY.html?alt=media&token=f2a70c0e-5fba-4041-86bc-10e22877bc03");
		webload();
        AdLoad();

    }
    public void oc(View v){
        setContentView(R.layout.syllabus_web);
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fsyllabus%2FORGANIC%20CHEMISTRY.html?alt=media&token=0afb0d74-0c1d-4485-87e4-ea2899432a16");
        webload();
        AdLoad();

    }

    public void pchem(View v){
        setContentView(R.layout.syllabus_web);
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fsyllabus%2FPHARMACEUTICAL%20CHEMISTRY.html?alt=media&token=3f218699-bd4c-4f11-9386-23f253d11f3a");
        webload();
        AdLoad();

            }
    public void pceutics(View v){
        setContentView(R.layout.syllabus_web);
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fsyllabus%2FPHARMACEUTICS.html?alt=media&token=cc85a781-7d42-4c0f-82d3-db9f6d8a2336");
        webload();
        AdLoad();

    }
    public void pcology(View v){
        setContentView(R.layout.syllabus_web);
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fsyllabus%2FPHARMACOLOGY.html?alt=media&token=0abae41b-dd54-4663-b961-ac7ede0dbbfc");
        webload();
        AdLoad();


    }
    public void pa(View v){
        setContentView(R.layout.syllabus_web);
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fsyllabus%2FPHARMACEUTICAL%20ANALYSIS.html?alt=media&token=d17f8904-1a36-4cec-8adf-1e8469ca67c1");
        webload();
        AdLoad();

    }
    public void biochem(View v){
        setContentView(R.layout.syllabus_web);
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fsyllabus%2FBIOCHEMISTRY.html?alt=media&token=91ff03e5-ee32-428c-b9ea-9e2494398328");
        webload();
        AdLoad();

    }
    public void biotech(View v){
        setContentView(R.layout.syllabus_web);
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fsyllabus%2FBIOTECHNOLOGY.html?alt=media&token=d50c66be-1aa8-489d-a775-fa34d3cf6a72");
        webload();
        AdLoad();

    }
    public void pathophy(View v){
        setContentView(R.layout.syllabus_web);
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fsyllabus%2FPATHOPHYSIOLOGY.html?alt=media&token=78e9a017-76f9-4e13-a6aa-f3605e6def84");
        webload();
        AdLoad();

    }
    public void bnp(View v){
        setContentView(R.layout.syllabus_web);
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fsyllabus%2FBIOPHARMACEUTICS%20AND%20PHARMACOKINETICS.html?alt=media&token=1d1bc6fa-6d20-4cf5-9471-ac6baf643f57");
        webload();
        AdLoad();

    }
    public void cpt(View v){
        setContentView(R.layout.syllabus_web);
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fsyllabus%2FCLINICAL%20PHARMACY%20AND%20THERAPEUTICS.html?alt=media&token=16269149-691c-4c2c-aba8-0e814b8a6a00");
        webload();
        AdLoad();


    }
    public void pe(View v){
        setContentView(R.layout.syllabus_web);
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fsyllabus%2FPHARMACEUTICAL%20ENGINEERING.html?alt=media&token=d04b07a7-f4dc-4ea3-903c-27ab0116a100");
        webload();
        AdLoad();

    }
    public void pm(View v){
        setContentView(R.layout.syllabus_web);
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fsyllabus%2FPHARMACEUTICAL%20MANAGEMENT.html?alt=media&token=a58363fb-825f-446e-91a3-8c4cda615a78");
        webload();
        AdLoad();


    }

    public void pj(View v){
        setContentView(R.layout.syllabus_web);
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fsyllabus%2FPHARMACEUTICAL%20JURISPRUDENCE.html?alt=media&token=e962d574-5fbe-4c39-83dc-d5c345122231");
        webload();
        AdLoad();


    }
    public void dhp(View v){
        setContentView(R.layout.syllabus_web);
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fsyllabus%2FDISPENSING.html?alt=media&token=be7776d9-36cc-4308-9705-eaa393bfabb7");
webload();
        AdLoad();

    }
    public void aph(View v){
        setContentView(R.layout.syllabus_web);
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fsyllabus%2FANATOMY.html?alt=media&token=f83d1a37-32e4-42e6-9b77-5dfb0660af8d");
        webload();
        AdLoad();

    }
    public void microbio(View v){
        setContentView(R.layout.syllabus_web);
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fsyllabus%2FMICROBIOLOGY.html?alt=media&token=3e86353e-4bfa-4e33-a933-a507b4614e03");
        webload();
        AdLoad();


    }

    public void pcogno(View v){

        setContentView(R.layout.syllabus_web);
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fsyllabus%2FPHARMACOGNOSY.html?alt=media&token=748ebdd9-3d8c-4aa7-9fac-3ade544d4755");
        webload();
        AdLoad();

    }

    public void webload(){

        WebView myWebView = (WebView) findViewById(R.id.webview1);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebChromeClient(new WebChromeClient());
        // myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebViewClient(new MyWebViewClient());
      //  myWebView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
       // myWebView.setInitialScale(50);
        myWebView.getSettings().setBuiltInZoomControls(true);
isInternetOn();
    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon ) {
            // TODO Auto-generated method stub
       //     LinearLayout loading =(LinearLayout)findViewById(R.id.loading);

       //     loading.setVisibility(View.VISIBLE);

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            //super.onPageFinished(view, url);
           // LinearLayout loading =(LinearLayout)findViewById(R.id.loading);

          //  loading.setVisibility(View.GONE);
        }

    }

    public void pro(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fpdf%2FGPAT-Syllabus-2017.pdf?alt=media&token=4b3967ca-a8d3-4835-9782-05d5b16bb983")); //pdf
        startActivity(intent);

    }

    public final boolean isInternetOn() {

        // get Connectivity Manager object to check connection
        ConnectivityManager connec =
                (ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if ( connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED ) {

            // if connected with internet

            Toast.makeText(this, " Loading... ", Toast.LENGTH_LONG).show();
            return true;

        } else if (
                connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED  ) {
            WebView myWebView = (WebView) findViewById(R.id.webview1);
             myWebView.setVisibility(View.GONE);
            ImageView nonet=(ImageView)findViewById(R.id.imageView8);
            nonet.setVisibility(View.VISIBLE);
            Toast.makeText(this, " Please Connect to internet ", Toast.LENGTH_LONG).show();
            return false;
        }
        return false;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        if(activeNetworkInfo!=null){

            WebView myWebView = (WebView) findViewById(R.id.webview1);
           // myWebView.setVisibility(View.GONE);
            ImageView nonet=(ImageView)findViewById(R.id.imageView8);
          nonet.setVisibility(View.VISIBLE);

        }

        return activeNetworkInfo != null && activeNetworkInfo.isConnected();


    }

    public boolean installed = false;

    public void AdLoad(){

        String APPID=getString(R.string.MY_APP_ID);

        MobileAds.initialize(getApplicationContext(), APPID);

        AdView mAdView = (AdView) findViewById(R.id.adView);


        isAppInstalled("devesh.ephrine.gpat.pro");

        if(installed==true){
            mAdView.setVisibility(View.GONE);
            Log.e("GPAT"," AD Disabled");

        }else {


            Bundle extras = new FacebookAdapter.FacebookExtrasBundleBuilder()
                    .setNativeAdChoicesIconExpandable(false)
                    .build();

            AdRequest adRequest = new AdRequest.Builder()
                    .addNetworkExtrasBundle(FacebookAdapter.class, extras)
                    .build();
         //   AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
            Log.e("GPAT"," AD Loaded");

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




}
