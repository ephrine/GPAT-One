package devesh.ephrine.gpat;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);
        WebView myWebView = (WebView) findViewById(R.id.webview2);
        myWebView.loadUrl("https://docs.google.com/forms/d/1yyrMxyLQi8BlNi9YL9Uzw7gIT304Jp2R3uz0l-DBHz0/edit?usp=sharing");

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //myWebView.setWebChromeClient(new WebChromeClient());
        // myWebView.setWebViewClient(new WebViewClient());
        // myWebView.setWebViewClient(new MyWebViewClient());
        //  myWebView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        // myWebView.setInitialScale(50);
        myWebView.getSettings().setBuiltInZoomControls(true);
        isInternetOn();
    }
 /*   private class MyChromeClient extends WebChromeClient {

        public void onPageStarted(WebView view, String url, Bitmap favicon ) {
            // TODO Auto-generated method stub
            //     LinearLayout loading =(LinearLayout)findViewById(R.id.loading);

            //     loading.setVisibility(View.VISIBLE);

        }


        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            //super.onPageFinished(view, url);
            // LinearLayout loading =(LinearLayout)findViewById(R.id.loading);

            //  loading.setVisibility(View.GONE);
        }

    }  */

    public final boolean isInternetOn() {

        // get Connectivity Manager object to check connection
        ConnectivityManager connec =
                (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if (connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED) {

            // if connected with internet

            Toast.makeText(this, " Loading... ", Toast.LENGTH_LONG).show();
            return true;

        } else if (
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED) {
            WebView myWebView = (WebView) findViewById(R.id.webview1);
            myWebView.setVisibility(View.GONE);
            ImageView nonet = (ImageView) findViewById(R.id.imageView8);
            nonet.setVisibility(View.VISIBLE);
            Toast.makeText(this, " Please Connect to internet ", Toast.LENGTH_LONG).show();
            return false;
        }
        return false;
    }


}
