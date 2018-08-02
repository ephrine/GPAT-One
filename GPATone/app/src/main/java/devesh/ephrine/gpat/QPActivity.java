package devesh.ephrine.gpat;

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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class QPActivity extends AppCompatActivity {

    public String pgno;
    public String opt;
    public boolean installed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qp);
        AdLoad();

    }

    public void qp15(View v) {
        opt = "qp15";
        setContentView(R.layout.qpweb);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-001.jpg?alt=media&token=3f5080df-f44d-4f9b-adf6-6833443de6ef");
        pgno = "1";
        webLoad();
        TextView Txpg = (TextView) findViewById(R.id.textView);

        Txpg.setText("Page no:" + pgno + " /19");


        AdLoad();


    }

    public void qp12(View v) {
        opt = "qp12";
        setContentView(R.layout.qpweb);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-001.jpg?alt=media&token=8f6ec460-0ad3-40ef-952b-cd31637af282");
        pgno = "1";

        webLoad();
        TextView Txpg = (TextView) findViewById(R.id.textView);
        Txpg.setText("Page no:" + pgno + " /36");
        AdLoad();

    }

    public void qp11(View v) {
        opt = "qp11";
        setContentView(R.layout.qpweb);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-001.jpg?alt=media&token=de36f86d-abbc-4bf2-b73b-c5df6c683a0b");
        pgno = "1";

        webLoad();
        TextView Txpg = (TextView) findViewById(R.id.textView);
        Txpg.setText("Page no:" + pgno + " /19");
        AdLoad();

    }

    public void qp10(View v) {
        opt = "qp10";
        pgno = "1";

        setContentView(R.layout.qpweb);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-001.jpg?alt=media&token=71f08220-b339-4f77-b9c7-308d628d1d2f");
        webLoad();
        TextView Txpg = (TextView) findViewById(R.id.textView);
        Txpg.setText("Page no:" + pgno + " /17");


        AdLoad();
    }

    public void qp09(View v) {
        opt = "qp09";
        pgno = "1";

        setContentView(R.layout.qpweb);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-001.jpg?alt=media&token=e83d36e3-dae8-458d-bd0f-4f9321890b21");
        webLoad();
        TextView Txpg = (TextView) findViewById(R.id.textView);
        Txpg.setText("Page no:" + pgno + " /13");
        AdLoad();
    }

    public void qp08(View v) {
        opt = "qp08";
        pgno = "1";

        setContentView(R.layout.qpweb);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-001.jpg?alt=media&token=2c8b4202-b17a-4f47-93c5-8ae7d349438b");
        webLoad();
        TextView Txpg = (TextView) findViewById(R.id.textView);
        Txpg.setText("Page no:" + pgno + " /16");


        AdLoad();

    }

    public void webLoad() {
        WebView myWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebChromeClient(new WebChromeClient());
        // myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebViewClient(new MyWebViewClient());
        myWebView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        myWebView.setInitialScale(50);
        myWebView.getSettings().setBuiltInZoomControls(true);
        isInternetOn();

    }
    // NAV Buttons ---------------------------------

    public void prev(View v) {
        TextView Txpg = (TextView) findViewById(R.id.textView);
        Txpg.setText("Page no:" + pgno);

        if (opt.equals("qp15")) {
            qp15prev();
        } else if (opt.equals("qp12")) {
            qp12prev();
        } else if (opt.equals("qp11")) {
            qp11prev();
        } else if (opt.equals("qp10")) {
            qp10prev();
        } else if (opt.equals("qp09")) {
            qp09prev();
        } else if (opt.equals("qp08")) {
            qp08prev();
        }

    }

    public void next(View v) {
        TextView Txpg = (TextView) findViewById(R.id.textView);
        Txpg.setText("Page no:" + pgno);
        if (opt.equals("qp15")) {
            qp15nxt();
        } else if (opt.equals("qp12")) {
            qp12nxt();
        } else if (opt.equals("qp11")) {
            qp11nxt();
        } else if (opt.equals("qp10")) {
            qp10nxt();
        } else if (opt.equals("qp09")) {
            qp09nxt();
        } else if (opt.equals("qp08")) {
            qp08nxt();
        }

    }

    // QP 2015 NAV --------------------------------------------
    public void qp15nxt() {

        if (pgno == "1") {
            pgno = "2";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-002.jpg?alt=media&token=516d7ad3-8895-4c9e-a1ce-91507c89e7ef"); //ch3pg2
        } else if (pgno == "2") {
            pgno = "3";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-003.jpg?alt=media&token=67855783-fe9c-4723-95c5-0dd93da68cb2"); //ch3pg3
        } else if (pgno == "3") {
            pgno = "4";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-004.jpg?alt=media&token=28e0965a-9384-4fdb-be09-3c547862c8ad"); //ch3pg4
        } else if (pgno == "4") {
            pgno = "5";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-005.jpg?alt=media&token=7a2c2d74-7fea-4c1b-8c81-cb8a54ab8c9a"); //ch3pg5
        } else if (pgno == "5") {
            pgno = "6";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-006.jpg?alt=media&token=70346a93-8f37-4382-9c1b-5ddcc2c64059"); //ch3pg6
        } else if (pgno == "6") {
            pgno = "7";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-007.jpg?alt=media&token=5733698c-8b69-48ed-abfd-528ac8afe575"); //ch3pg7
        } else if (pgno == "7") {
            pgno = "8";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-008.jpg?alt=media&token=06f28256-4080-4eaa-a820-fd42c0565985"); //ch3pg8
        } else if (pgno == "8") {
            pgno = "9";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-009.jpg?alt=media&token=3826c067-c522-4ba1-87f1-4e42dd8169cf"); //ch3pg9
        } else if (pgno == "9") {
            pgno = "10";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-010.jpg?alt=media&token=2f58a7c2-c918-4cf6-a60c-fc49e4f6501b"); //ch3pg10
        } else if (pgno == "10") {
            pgno = "11";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-011.jpg?alt=media&token=2c9d291d-a0dd-4d5e-a6db-064c7ade6806"); //ch3pg11
        } else if (pgno == "11") {
            pgno = "12";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-012.jpg?alt=media&token=a216dd9a-b259-4b41-ae1b-d28b1e5174c7"); //ch3pg12
        } else if (pgno == "12") {
            pgno = "13";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-013.jpg?alt=media&token=3beae741-8855-4dea-b352-ae5f7db544a5"); //ch3pg13
        } else if (pgno == "13") {
            pgno = "14";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-014.jpg?alt=media&token=1de5b954-5e26-4ed1-859f-b9803fef77d4"); //ch3pg13
        } else if (pgno == "14") {
            pgno = "15";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-015.jpg?alt=media&token=eddc0d3e-55d4-4179-a7d6-34518c0ec6c9"); //ch3pg13

        } else if (pgno == "15") {
            pgno = "16";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-016.jpg?alt=media&token=c5221d8b-1dee-44b3-bd40-f5fd47b3302c"); //ch3pg13

        } else if (pgno == "16") {
            pgno = "17";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-017.jpg?alt=media&token=e6f3c785-44a2-4521-87fb-5c7fff2a8f39"); //ch3pg13

        } else if (pgno == "17") {
            pgno = "18";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-018.jpg?alt=media&token=2c184bb3-ff33-4fb8-8374-a1d1af2936e8"); //ch3pg13

        } else if (pgno == "18") {
            pgno = "19";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-019.jpg?alt=media&token=48e5a80b-7e97-4784-ad5a-c3f2f276ac01"); //ch3pg13

        }
        TextView Txpg = (TextView) findViewById(R.id.textView);
        Txpg.setText("Page no:" + pgno + "/19");

    }

    public void qp15prev() {

        if (pgno == "3") {
            pgno = "2";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-002.jpg?alt=media&token=516d7ad3-8895-4c9e-a1ce-91507c89e7ef"); //ch3pg2
        } else if (pgno == "4") {
            pgno = "3";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-003.jpg?alt=media&token=67855783-fe9c-4723-95c5-0dd93da68cb2"); //ch3pg3
        } else if (pgno == "5") {
            pgno = "4";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-004.jpg?alt=media&token=28e0965a-9384-4fdb-be09-3c547862c8ad"); //ch3pg4
        } else if (pgno == "6") {
            pgno = "5";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-005.jpg?alt=media&token=7a2c2d74-7fea-4c1b-8c81-cb8a54ab8c9a"); //ch3pg5
        } else if (pgno == "7") {
            pgno = "6";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-006.jpg?alt=media&token=70346a93-8f37-4382-9c1b-5ddcc2c64059"); //ch3pg6
        } else if (pgno == "8") {
            pgno = "7";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-007.jpg?alt=media&token=5733698c-8b69-48ed-abfd-528ac8afe575"); //ch3pg7
        } else if (pgno == "9") {
            pgno = "8";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-008.jpg?alt=media&token=06f28256-4080-4eaa-a820-fd42c0565985"); //ch3pg8
        } else if (pgno == "10") {
            pgno = "9";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-009.jpg?alt=media&token=3826c067-c522-4ba1-87f1-4e42dd8169cf"); //ch3pg9
        } else if (pgno == "11") {
            pgno = "10";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-010.jpg?alt=media&token=2f58a7c2-c918-4cf6-a60c-fc49e4f6501b"); //ch3pg10
        } else if (pgno == "12") {
            pgno = "11";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-011.jpg?alt=media&token=2c9d291d-a0dd-4d5e-a6db-064c7ade6806"); //ch3pg11
        } else if (pgno == "13") {
            pgno = "12";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-012.jpg?alt=media&token=a216dd9a-b259-4b41-ae1b-d28b1e5174c7"); //ch3pg12
        } else if (pgno == "14") {
            pgno = "13";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-013.jpg?alt=media&token=3beae741-8855-4dea-b352-ae5f7db544a5"); //ch3pg13
        } else if (pgno == "15") {
            pgno = "14";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-014.jpg?alt=media&token=1de5b954-5e26-4ed1-859f-b9803fef77d4"); //ch3pg13
        } else if (pgno == "16") {
            pgno = "15";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-015.jpg?alt=media&token=eddc0d3e-55d4-4179-a7d6-34518c0ec6c9"); //ch3pg13

        } else if (pgno == "17") {
            pgno = "16";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-016.jpg?alt=media&token=c5221d8b-1dee-44b3-bd40-f5fd47b3302c"); //ch3pg13

        } else if (pgno == "18") {
            pgno = "17";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-017.jpg?alt=media&token=e6f3c785-44a2-4521-87fb-5c7fff2a8f39"); //ch3pg13

        } else if (pgno == "19") {//-- Last pg
            pgno = "18";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-018.jpg?alt=media&token=2c184bb3-ff33-4fb8-8374-a1d1af2936e8"); //ch3pg13

        } else if (pgno == "2") {// first pg
            pgno = "1";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2015%2FGPAT-2015-solved-question-paper-page-001.jpg?alt=media&token=3f5080df-f44d-4f9b-adf6-6833443de6ef");

        }
        TextView Txpg = (TextView) findViewById(R.id.textView);
        Txpg.setText("Page no:" + pgno + " /19");

    }
    //---------------------------------------------------------------------------

    // QP 12 NAV BUTTON--------------------------
    public void qp12nxt() {

        if (pgno == "1") {
            pgno = "2";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-002.jpg?alt=media&token=7ee0a6f2-2bee-44a1-8f8b-01ed2fd9c419"); //ch3pg2
        } else if (pgno == "2") {
            pgno = "3";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-003.jpg?alt=media&token=52476b1d-70e1-4e75-b293-c4d56bfdcac3"); //ch3pg3
        } else if (pgno == "3") {
            pgno = "4";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-004.jpg?alt=media&token=d2feb8a5-d92b-4e94-942b-db14a7a20824"); //ch3pg4
        } else if (pgno == "4") {
            pgno = "5";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-005.jpg?alt=media&token=51f4b812-8fdd-4314-a0ee-a2cbbd2cd25a"); //ch3pg5
        } else if (pgno == "5") {
            pgno = "6";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-006.jpg?alt=media&token=5e330963-2709-42b5-ac17-ecbcc05d1bcc"); //ch3pg6
        } else if (pgno == "6") {
            pgno = "7";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-007.jpg?alt=media&token=87c39f65-419a-4a10-a6d8-2a87b55dd315"); //ch3pg7
        } else if (pgno == "7") {
            pgno = "8";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-008.jpg?alt=media&token=09b56afe-599b-4690-9b48-42caa551fd8a"); //ch3pg8
        } else if (pgno == "8") {
            pgno = "9";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-009.jpg?alt=media&token=bfb701d0-7f9e-4d9c-b9a7-fbedcf6e8ced"); //ch3pg9
        } else if (pgno == "9") {
            pgno = "10";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-010.jpg?alt=media&token=db504a17-b9a8-49b5-9036-03ea40b62b72"); //ch3pg10
        } else if (pgno == "10") {
            pgno = "11";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-011.jpg?alt=media&token=36e7bfc4-7449-4ec6-b00c-65856efd00d1"); //ch3pg11
        } else if (pgno == "11") {
            pgno = "12";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-012.jpg?alt=media&token=f1a4bf76-39d5-4719-b421-f4c825632ac0"); //ch3pg12
        } else if (pgno == "12") {
            pgno = "13";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-013.jpg?alt=media&token=49a40ef2-1884-4d34-bb22-70e6146e57a9"); //ch3pg13
        } else if (pgno == "13") {
            pgno = "14";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-014.jpg?alt=media&token=c5e15b45-a969-4632-9bff-a687162e3483"); //ch3pg13
        } else if (pgno == "14") {
            pgno = "15";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-015.jpg?alt=media&token=e0f5e01e-e834-480c-9b1a-a5952bb6ddba"); //ch3pg13
        } else if (pgno == "15") {
            pgno = "16";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-016.jpg?alt=media&token=6ee59956-06ac-4f2f-9c91-8387f9ab90ba"); //ch3pg13
        } else if (pgno == "16") {
            pgno = "17";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-017.jpg?alt=media&token=4089c333-6abe-479c-b35e-92e013821273"); //ch3pg13
        } else if (pgno == "17") {
            pgno = "18";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-018.jpg?alt=media&token=08ffc6ec-9e62-44b2-84dd-a4c01e4e8425"); //ch3pg13
        } else if (pgno == "18") {
            pgno = "19";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-019.jpg?alt=media&token=1bc31e9d-342d-4a46-82d1-8db518faf3ff"); //ch3pg13
        } else if (pgno == "19") {
            pgno = "20";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-020.jpg?alt=media&token=ebea164a-b9e9-4ff7-bb5b-9e011ac1e5bb"); //ch3pg13
        } else if (pgno == "20") {
            pgno = "21";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-021.jpg?alt=media&token=64d36fa7-8201-43f3-bd93-80962ea91303"); //ch3pg13
        } else if (pgno == "21") {
            pgno = "22";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-022.jpg?alt=media&token=1a7f7bf7-213c-4b67-985c-b42a3e261a3b"); //ch3pg13
        } else if (pgno == "22") {
            pgno = "23";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-023.jpg?alt=media&token=982327de-08c6-4757-9d61-b1aeb19f0afa"); //ch3pg13
        } else if (pgno == "23") {
            pgno = "24";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-024.jpg?alt=media&token=03ed7bbe-39c0-41dc-91ee-55c633c52929"); //ch3pg13
        } else if (pgno == "24") {
            pgno = "25";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-025.jpg?alt=media&token=e5bd8ec9-b7d7-4006-8072-cca5a6ad9a86"); //ch3pg13
        } else if (pgno == "25") {
            pgno = "26";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-026.jpg?alt=media&token=ca857117-76cf-4a07-b8bd-1f818e44113a"); //ch3pg13
        } else if (pgno == "26") {
            pgno = "27";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-027.jpg?alt=media&token=2c638f3a-0b8a-4805-bdd8-5c70181ee215"); //ch3pg13
        } else if (pgno == "27") {
            pgno = "28";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-028.jpg?alt=media&token=0302e2e4-771f-4e87-8a64-b558dec69d50"); //ch3pg13
        } else if (pgno == "28") {
            pgno = "29";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-029.jpg?alt=media&token=b5bcde1a-43fe-440c-aade-60d74a147a92"); //ch3pg13
        } else if (pgno == "29") {
            pgno = "30";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-030.jpg?alt=media&token=8e5d5ecd-10ec-4576-8c9f-8b49eb895b2b"); //ch3pg13
        } else if (pgno == "30") {
            pgno = "31";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-031.jpg?alt=media&token=af6e2679-9170-477f-8410-9b5adc8bb048"); //ch3pg13
        } else if (pgno == "31") {
            pgno = "32";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-032.jpg?alt=media&token=b1bbd6ea-63b0-405f-9483-eb1f3c12f97d"); //ch3pg13
        } else if (pgno == "32") {
            pgno = "33";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-033.jpg?alt=media&token=ee9ff962-ad1c-41d4-8013-7fb04c391ac2"); //ch3pg13
        } else if (pgno == "33") {
            pgno = "34";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-034.jpg?alt=media&token=347a5faf-56e4-4c8b-b18d-48be0ca151fd"); //ch3pg13
        } else if (pgno == "34") {
            pgno = "35";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-035.jpg?alt=media&token=7f4d66f8-2545-4653-a0ee-a6b811538acc"); //ch3pg13
        } else if (pgno == "35") {
            pgno = "36";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-036.jpg?alt=media&token=4b04d5ef-bd88-4b42-9aac-7108c51a8e3f"); //ch3pg13
        }
        TextView Txpg = (TextView) findViewById(R.id.textView);
        Txpg.setText("Page no:" + pgno + " /36");
    }

    public void qp12prev() {

        if (pgno == "3") {
            pgno = "2";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-002.jpg?alt=media&token=7ee0a6f2-2bee-44a1-8f8b-01ed2fd9c419"); //ch3pg2
        } else if (pgno == "4") {
            pgno = "3";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-003.jpg?alt=media&token=52476b1d-70e1-4e75-b293-c4d56bfdcac3"); //ch3pg3
        } else if (pgno == "5") {
            pgno = "4";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-004.jpg?alt=media&token=d2feb8a5-d92b-4e94-942b-db14a7a20824"); //ch3pg4
        } else if (pgno == "6") {
            pgno = "5";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-005.jpg?alt=media&token=51f4b812-8fdd-4314-a0ee-a2cbbd2cd25a"); //ch3pg5
        } else if (pgno == "7") {
            pgno = "6";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-006.jpg?alt=media&token=5e330963-2709-42b5-ac17-ecbcc05d1bcc"); //ch3pg6
        } else if (pgno == "8") {
            pgno = "7";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-007.jpg?alt=media&token=87c39f65-419a-4a10-a6d8-2a87b55dd315"); //ch3pg7
        } else if (pgno == "9") {
            pgno = "8";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-008.jpg?alt=media&token=09b56afe-599b-4690-9b48-42caa551fd8a"); //ch3pg8
        } else if (pgno == "10") {
            pgno = "9";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-009.jpg?alt=media&token=bfb701d0-7f9e-4d9c-b9a7-fbedcf6e8ced"); //ch3pg9
        } else if (pgno == "11") {
            pgno = "10";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-010.jpg?alt=media&token=db504a17-b9a8-49b5-9036-03ea40b62b72"); //ch3pg10
        } else if (pgno == "12") {
            pgno = "11";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-011.jpg?alt=media&token=36e7bfc4-7449-4ec6-b00c-65856efd00d1"); //ch3pg11
        } else if (pgno == "13") {
            pgno = "12";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-012.jpg?alt=media&token=f1a4bf76-39d5-4719-b421-f4c825632ac0"); //ch3pg12
        } else if (pgno == "14") {
            pgno = "13";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-013.jpg?alt=media&token=49a40ef2-1884-4d34-bb22-70e6146e57a9"); //ch3pg13
        } else if (pgno == "15") {
            pgno = "14";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-014.jpg?alt=media&token=c5e15b45-a969-4632-9bff-a687162e3483"); //ch3pg13
        } else if (pgno == "16") {
            pgno = "15";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-015.jpg?alt=media&token=e0f5e01e-e834-480c-9b1a-a5952bb6ddba"); //ch3pg13
        } else if (pgno == "17") {
            pgno = "16";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-016.jpg?alt=media&token=6ee59956-06ac-4f2f-9c91-8387f9ab90ba"); //ch3pg13
        } else if (pgno == "18") {
            pgno = "17";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-017.jpg?alt=media&token=4089c333-6abe-479c-b35e-92e013821273"); //ch3pg13
        } else if (pgno == "19") {
            pgno = "18";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-018.jpg?alt=media&token=08ffc6ec-9e62-44b2-84dd-a4c01e4e8425"); //ch3pg13
        } else if (pgno == "20") {
            pgno = "19";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-019.jpg?alt=media&token=1bc31e9d-342d-4a46-82d1-8db518faf3ff"); //ch3pg13
        } else if (pgno == "21") {
            pgno = "20";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-020.jpg?alt=media&token=ebea164a-b9e9-4ff7-bb5b-9e011ac1e5bb"); //ch3pg13
        } else if (pgno == "22") {
            pgno = "21";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-021.jpg?alt=media&token=64d36fa7-8201-43f3-bd93-80962ea91303"); //ch3pg13
        } else if (pgno == "23") {
            pgno = "22";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-022.jpg?alt=media&token=1a7f7bf7-213c-4b67-985c-b42a3e261a3b"); //ch3pg13
        } else if (pgno == "24") {
            pgno = "23";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-023.jpg?alt=media&token=982327de-08c6-4757-9d61-b1aeb19f0afa"); //ch3pg13
        } else if (pgno == "25") {
            pgno = "24";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-024.jpg?alt=media&token=03ed7bbe-39c0-41dc-91ee-55c633c52929"); //ch3pg13
        } else if (pgno == "26") {
            pgno = "25";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-025.jpg?alt=media&token=e5bd8ec9-b7d7-4006-8072-cca5a6ad9a86"); //ch3pg13
        } else if (pgno == "27") {
            pgno = "26";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-026.jpg?alt=media&token=ca857117-76cf-4a07-b8bd-1f818e44113a"); //ch3pg13
        } else if (pgno == "28") {
            pgno = "27";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-027.jpg?alt=media&token=2c638f3a-0b8a-4805-bdd8-5c70181ee215"); //ch3pg13
        } else if (pgno == "29") {
            pgno = "28";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-028.jpg?alt=media&token=0302e2e4-771f-4e87-8a64-b558dec69d50"); //ch3pg13
        } else if (pgno == "30") {
            pgno = "29";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-029.jpg?alt=media&token=b5bcde1a-43fe-440c-aade-60d74a147a92"); //ch3pg13
        } else if (pgno == "31") {
            pgno = "30";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-030.jpg?alt=media&token=8e5d5ecd-10ec-4576-8c9f-8b49eb895b2b"); //ch3pg13
        } else if (pgno == "32") {
            pgno = "31";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-031.jpg?alt=media&token=af6e2679-9170-477f-8410-9b5adc8bb048"); //ch3pg13
        } else if (pgno == "33") {
            pgno = "32";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-032.jpg?alt=media&token=b1bbd6ea-63b0-405f-9483-eb1f3c12f97d"); //ch3pg13
        } else if (pgno == "34") {
            pgno = "33";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-033.jpg?alt=media&token=ee9ff962-ad1c-41d4-8013-7fb04c391ac2"); //ch3pg13
        } else if (pgno == "35") {
            pgno = "34";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-034.jpg?alt=media&token=347a5faf-56e4-4c8b-b18d-48be0ca151fd"); //ch3pg13
        } else if (pgno == "36") {
            pgno = "35";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-035.jpg?alt=media&token=7f4d66f8-2545-4653-a0ee-a6b811538acc"); //ch3pg13
        } else if (pgno == "2") {
            pgno = "1";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2012%2FGPAT-2012-Answer-Key-page-001.jpg?alt=media&token=8f6ec460-0ad3-40ef-952b-cd31637af282");
        }
        TextView Txpg = (TextView) findViewById(R.id.textView);
        Txpg.setText("Page no:" + pgno + " /36");
    }


    // QP 11 NAV BUTTON--------------------------
    public void qp11nxt() {

        if (pgno == "1") {
            pgno = "2";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-002.jpg?alt=media&token=bbae839e-a942-48b2-a5d7-587e65f90a39"); //ch3pg2
        } else if (pgno == "2") {
            pgno = "3";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-003.jpg?alt=media&token=7438d472-4f38-42eb-a423-d912bfdc2748"); //ch3pg3
        } else if (pgno == "3") {
            pgno = "4";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-004.jpg?alt=media&token=43d94ef0-85a4-4c64-81bf-b7849f84a683"); //ch3pg4
        } else if (pgno == "4") {
            pgno = "5";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-005.jpg?alt=media&token=7681bf51-9873-4d1f-9e5b-67bc8bcd850e"); //ch3pg5
        } else if (pgno == "5") {
            pgno = "6";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-006.jpg?alt=media&token=8f9378b6-5776-43bd-90f2-dc583e35c978"); //ch3pg6
        } else if (pgno == "6") {
            pgno = "7";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-007.jpg?alt=media&token=0b488db9-c750-4f2e-bccc-8c1ae3d7eaa8"); //ch3pg7
        } else if (pgno == "7") {
            pgno = "8";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-008.jpg?alt=media&token=48a9be29-95c4-492c-b3c4-d33d97300296"); //ch3pg8
        } else if (pgno == "8") {
            pgno = "9";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-009.jpg?alt=media&token=6bce8bde-174e-4b2e-b0f0-cb69e19090ff"); //ch3pg9
        } else if (pgno == "9") {
            pgno = "10";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-010.jpg?alt=media&token=690e06cb-8f0e-4c32-9199-685467e4ad27"); //ch3pg10
        } else if (pgno == "10") {
            pgno = "11";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-011.jpg?alt=media&token=b2186301-6145-41d7-a146-3917989ae050"); //ch3pg11
        } else if (pgno == "11") {
            pgno = "12";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-012.jpg?alt=media&token=f48564b3-41a7-4ec6-ad4b-fdd83560d7d3"); //ch3pg12
        } else if (pgno == "12") {
            pgno = "13";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-013.jpg?alt=media&token=b3365474-7737-4627-b5cd-cc71361e7481"); //ch3pg13
        } else if (pgno == "13") {
            pgno = "14";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-014.jpg?alt=media&token=294bfc38-c96b-4fc4-957a-736ae2faf33f"); //ch3pg13
        } else if (pgno == "14") {
            pgno = "15";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-015.jpg?alt=media&token=93502f4c-927d-4c09-94b2-43758e68b9a2"); //ch3pg13
        } else if (pgno == "15") {
            pgno = "16";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-016.jpg?alt=media&token=3830bb20-3a3f-468d-95ee-c6927be03cea"); //ch3pg13
        } else if (pgno == "16") {
            pgno = "17";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-017.jpg?alt=media&token=fb26ff2d-05f6-40b4-b734-b0256950ee9b"); //ch3pg13
        } else if (pgno == "17") {
            pgno = "18";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-018.jpg?alt=media&token=ee7f07dd-17f2-4f9d-b3f6-c3cb55fdc869"); //ch3pg13
        } else if (pgno == "18") {
            pgno = "19";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-019.jpg?alt=media&token=8818790d-28a4-4161-b8f5-1405ffd3a642"); //ch3pg13
        }
        TextView Txpg = (TextView) findViewById(R.id.textView);
        Txpg.setText("Page no:" + pgno + " /19");
    }

    public void qp11prev() {

        if (pgno == "3") {
            pgno = "2";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-002.jpg?alt=media&token=bbae839e-a942-48b2-a5d7-587e65f90a39"); //ch3pg2
        } else if (pgno == "4") {
            pgno = "3";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-003.jpg?alt=media&token=7438d472-4f38-42eb-a423-d912bfdc2748"); //ch3pg3
        } else if (pgno == "5") {
            pgno = "4";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-004.jpg?alt=media&token=43d94ef0-85a4-4c64-81bf-b7849f84a683"); //ch3pg4
        } else if (pgno == "6") {
            pgno = "5";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-005.jpg?alt=media&token=7681bf51-9873-4d1f-9e5b-67bc8bcd850e"); //ch3pg5
        } else if (pgno == "7") {
            pgno = "6";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-006.jpg?alt=media&token=8f9378b6-5776-43bd-90f2-dc583e35c978"); //ch3pg6
        } else if (pgno == "8") {
            pgno = "7";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-007.jpg?alt=media&token=0b488db9-c750-4f2e-bccc-8c1ae3d7eaa8"); //ch3pg7
        } else if (pgno == "9") {
            pgno = "8";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-008.jpg?alt=media&token=48a9be29-95c4-492c-b3c4-d33d97300296"); //ch3pg8
        } else if (pgno == "10") {
            pgno = "9";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-009.jpg?alt=media&token=6bce8bde-174e-4b2e-b0f0-cb69e19090ff"); //ch3pg9
        } else if (pgno == "11") {
            pgno = "10";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-010.jpg?alt=media&token=690e06cb-8f0e-4c32-9199-685467e4ad27"); //ch3pg10
        } else if (pgno == "12") {
            pgno = "11";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-011.jpg?alt=media&token=b2186301-6145-41d7-a146-3917989ae050"); //ch3pg11
        } else if (pgno == "13") {
            pgno = "12";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-012.jpg?alt=media&token=f48564b3-41a7-4ec6-ad4b-fdd83560d7d3"); //ch3pg12
        } else if (pgno == "14") {
            pgno = "13";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-013.jpg?alt=media&token=b3365474-7737-4627-b5cd-cc71361e7481"); //ch3pg13
        } else if (pgno == "15") {
            pgno = "14";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-014.jpg?alt=media&token=294bfc38-c96b-4fc4-957a-736ae2faf33f"); //ch3pg13
        } else if (pgno == "16") {
            pgno = "15";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-015.jpg?alt=media&token=93502f4c-927d-4c09-94b2-43758e68b9a2"); //ch3pg13
        } else if (pgno == "17") {
            pgno = "16";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-016.jpg?alt=media&token=3830bb20-3a3f-468d-95ee-c6927be03cea"); //ch3pg13
        } else if (pgno == "18") {
            pgno = "17";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-017.jpg?alt=media&token=fb26ff2d-05f6-40b4-b734-b0256950ee9b"); //ch3pg13
        } else if (pgno == "19") {
            pgno = "18";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-018.jpg?alt=media&token=ee7f07dd-17f2-4f9d-b3f6-c3cb55fdc869"); //ch3pg13
        } else if (pgno == "2") {
            pgno = "1";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2011%2FGPAT-2011-Answer-Key-page-001.jpg?alt=media&token=de36f86d-abbc-4bf2-b73b-c5df6c683a0b"); //ch3pg13
        }
        TextView Txpg = (TextView) findViewById(R.id.textView);
        Txpg.setText("Page no:" + pgno + " /19");
    }

    // QP 10 NAV BUTTON--------------------------
    public void qp10nxt() {

        if (pgno == "1") {
            pgno = "2";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-002.jpg?alt=media&token=b6eed583-8acf-43df-a79d-40a4b753f9d1"); //ch3pg2
        } else if (pgno == "2") {
            pgno = "3";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-003.jpg?alt=media&token=c4eb37f1-a4fc-433c-960f-d871e2728b4d"); //ch3pg3
        } else if (pgno == "3") {
            pgno = "4";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-004.jpg?alt=media&token=ac84aa8a-637c-4a22-872c-ab5da64fedcf"); //ch3pg4
        } else if (pgno == "4") {
            pgno = "5";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-005.jpg?alt=media&token=0a9d5261-73e1-45ea-b623-50f9fde1811a"); //ch3pg5
        } else if (pgno == "5") {
            pgno = "6";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-006.jpg?alt=media&token=39bb54b3-5471-4ed1-9518-7e0c6056fd8d"); //ch3pg6
        } else if (pgno == "6") {
            pgno = "7";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-007.jpg?alt=media&token=5f810a63-f6a9-49f6-aaff-08956525c631"); //ch3pg7
        } else if (pgno == "7") {
            pgno = "8";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-008.jpg?alt=media&token=168d4237-1621-428b-912f-3eb382191965"); //ch3pg8
        } else if (pgno == "8") {
            pgno = "9";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-009.jpg?alt=media&token=63de7a4a-12c2-4526-bde9-bcc8d2602b29"); //ch3pg9
        } else if (pgno == "9") {
            pgno = "10";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-010.jpg?alt=media&token=b35dfdfb-272c-43bb-9907-d41d67441d8b"); //ch3pg10
        } else if (pgno == "10") {
            pgno = "11";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-011.jpg?alt=media&token=3919b4a0-0eb0-4031-803b-346617d80c26"); //ch3pg11
        } else if (pgno == "11") {
            pgno = "12";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-012.jpg?alt=media&token=afc71079-d28c-45e4-8ac6-ebcf6f400499"); //ch3pg12
        } else if (pgno == "12") {
            pgno = "13";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-013.jpg?alt=media&token=8fc2dce7-392f-482d-a211-5bc9902fc37c"); //ch3pg13
        } else if (pgno == "13") {
            pgno = "14";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-014.jpg?alt=media&token=d5bdb833-9220-43d2-bbc5-ad5e4f716abf"); //ch3pg13
        } else if (pgno == "14") {
            pgno = "15";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-015.jpg?alt=media&token=dc07485e-1f24-4702-910f-adb3a39dcd7c"); //ch3pg13
        } else if (pgno == "15") {
            pgno = "16";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-016.jpg?alt=media&token=410ca12c-f96b-4361-b262-13fffccbbccb"); //ch3pg13
        } else if (pgno == "16") {
            pgno = "17";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-017.jpg?alt=media&token=9344df43-06ff-4ad7-ad87-234c6164d223"); //ch3pg13
        }
        TextView Txpg = (TextView) findViewById(R.id.textView);
        Txpg.setText("Page no:" + pgno + " /17");
    }

    public void qp10prev() {

        if (pgno == "3") {
            pgno = "2";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-002.jpg?alt=media&token=b6eed583-8acf-43df-a79d-40a4b753f9d1"); //ch3pg2
        } else if (pgno == "4") {
            pgno = "3";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-003.jpg?alt=media&token=c4eb37f1-a4fc-433c-960f-d871e2728b4d"); //ch3pg3
        } else if (pgno == "5") {
            pgno = "4";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-004.jpg?alt=media&token=ac84aa8a-637c-4a22-872c-ab5da64fedcf"); //ch3pg4
        } else if (pgno == "6") {
            pgno = "5";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-005.jpg?alt=media&token=0a9d5261-73e1-45ea-b623-50f9fde1811a"); //ch3pg5
        } else if (pgno == "7") {
            pgno = "6";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-006.jpg?alt=media&token=39bb54b3-5471-4ed1-9518-7e0c6056fd8d"); //ch3pg6
        } else if (pgno == "8") {
            pgno = "7";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-007.jpg?alt=media&token=5f810a63-f6a9-49f6-aaff-08956525c631"); //ch3pg7
        } else if (pgno == "9") {
            pgno = "8";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-008.jpg?alt=media&token=168d4237-1621-428b-912f-3eb382191965"); //ch3pg8
        } else if (pgno == "10") {
            pgno = "9";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-009.jpg?alt=media&token=63de7a4a-12c2-4526-bde9-bcc8d2602b29"); //ch3pg9
        } else if (pgno == "11") {
            pgno = "10";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-010.jpg?alt=media&token=b35dfdfb-272c-43bb-9907-d41d67441d8b"); //ch3pg10
        } else if (pgno == "12") {
            pgno = "11";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-011.jpg?alt=media&token=3919b4a0-0eb0-4031-803b-346617d80c26"); //ch3pg11
        } else if (pgno == "13") {
            pgno = "12";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-012.jpg?alt=media&token=afc71079-d28c-45e4-8ac6-ebcf6f400499"); //ch3pg12
        } else if (pgno == "14") {
            pgno = "13";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-013.jpg?alt=media&token=8fc2dce7-392f-482d-a211-5bc9902fc37c"); //ch3pg13
        } else if (pgno == "15") {
            pgno = "14";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-014.jpg?alt=media&token=d5bdb833-9220-43d2-bbc5-ad5e4f716abf"); //ch3pg13
        } else if (pgno == "16") {
            pgno = "15";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-015.jpg?alt=media&token=dc07485e-1f24-4702-910f-adb3a39dcd7c"); //ch3pg13
        } else if (pgno == "17") {
            pgno = "16";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-016.jpg?alt=media&token=410ca12c-f96b-4361-b262-13fffccbbccb"); //ch3pg13
        } else if (pgno == "2") {
            pgno = "1";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2010%2FGPAT-2010-Answer-Key-page-001.jpg?alt=media&token=71f08220-b339-4f77-b9c7-308d628d1d2f"); //ch3pg13
        }
        TextView Txpg = (TextView) findViewById(R.id.textView);
        Txpg.setText("Page no:" + pgno + " /17");
    }

    // QP 09 NAV BUTTON--------------------------
    public void qp09nxt() {

        if (pgno == "1") {
            pgno = "2";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-002.jpg?alt=media&token=98f4ea68-55bb-4fe9-9b19-29f6cf476e07"); //ch3pg2
        } else if (pgno == "2") {
            pgno = "3";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-003.jpg?alt=media&token=903d6b98-39e8-4848-bb44-6632481e6375"); //ch3pg3
        } else if (pgno == "3") {
            pgno = "4";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-004.jpg?alt=media&token=7167a0a1-52b0-4ea0-a926-aa1777a13f1e"); //ch3pg4
        } else if (pgno == "4") {
            pgno = "5";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-005.jpg?alt=media&token=fedf2bd2-2909-480e-be91-14af7d93541c"); //ch3pg5
        } else if (pgno == "5") {
            pgno = "6";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-006.jpg?alt=media&token=b7e3b49a-da01-4d15-be1d-2aacb78e6bca"); //ch3pg6
        } else if (pgno == "6") {
            pgno = "7";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-007.jpg?alt=media&token=3a465d42-caa3-4c47-9a2e-52b0707fd674"); //ch3pg7
        } else if (pgno == "7") {
            pgno = "8";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-008.jpg?alt=media&token=255878d8-97a0-455a-9dae-4de32f191b40"); //ch3pg8
        } else if (pgno == "8") {
            pgno = "9";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-009.jpg?alt=media&token=6f189d29-6ccc-44f8-9402-a28efdc55681"); //ch3pg9
        } else if (pgno == "9") {
            pgno = "10";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-010.jpg?alt=media&token=0cd84da2-41ca-463e-be56-039f9c315ccf"); //ch3pg10
        } else if (pgno == "10") {
            pgno = "11";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-011.jpg?alt=media&token=29a85c47-dc65-4a63-bf84-05991dd667f1"); //ch3pg11
        } else if (pgno == "11") {
            pgno = "12";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-012.jpg?alt=media&token=1e91c29a-174c-49f7-b433-fad2bde6beda"); //ch3pg12
        } else if (pgno == "12") {
            pgno = "13";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-013.jpg?alt=media&token=6a8e29df-afed-4572-bb9a-39a57d1b0e7d"); //ch3pg13
        }
        TextView Txpg = (TextView) findViewById(R.id.textView);
        Txpg.setText("Page no:" + pgno + " /13");
    }

    public void qp09prev() {

        if (pgno == "3") {
            pgno = "2";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-002.jpg?alt=media&token=98f4ea68-55bb-4fe9-9b19-29f6cf476e07"); //ch3pg2
        } else if (pgno == "4") {
            pgno = "3";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-003.jpg?alt=media&token=903d6b98-39e8-4848-bb44-6632481e6375"); //ch3pg3
        } else if (pgno == "5") {
            pgno = "4";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-004.jpg?alt=media&token=7167a0a1-52b0-4ea0-a926-aa1777a13f1e"); //ch3pg4
        } else if (pgno == "6") {
            pgno = "5";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-005.jpg?alt=media&token=fedf2bd2-2909-480e-be91-14af7d93541c"); //ch3pg5
        } else if (pgno == "7") {
            pgno = "6";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-006.jpg?alt=media&token=b7e3b49a-da01-4d15-be1d-2aacb78e6bca"); //ch3pg6
        } else if (pgno == "8") {
            pgno = "7";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-007.jpg?alt=media&token=3a465d42-caa3-4c47-9a2e-52b0707fd674"); //ch3pg7
        } else if (pgno == "9") {
            pgno = "8";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-008.jpg?alt=media&token=255878d8-97a0-455a-9dae-4de32f191b40"); //ch3pg8
        } else if (pgno == "10") {
            pgno = "9";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-009.jpg?alt=media&token=6f189d29-6ccc-44f8-9402-a28efdc55681"); //ch3pg9
        } else if (pgno == "11") {
            pgno = "10";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-010.jpg?alt=media&token=0cd84da2-41ca-463e-be56-039f9c315ccf"); //ch3pg10
        } else if (pgno == "12") {
            pgno = "11";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-011.jpg?alt=media&token=29a85c47-dc65-4a63-bf84-05991dd667f1"); //ch3pg11
        } else if (pgno == "13") {
            pgno = "12";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-012.jpg?alt=media&token=1e91c29a-174c-49f7-b433-fad2bde6beda"); //ch3pg12
        } else if (pgno == "2") {
            pgno = "1";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2009%2FGATE-Question-paper-2009-page-001.jpg?alt=media&token=e83d36e3-dae8-458d-bd0f-4f9321890b21"); //ch3pg13
        }
        TextView Txpg = (TextView) findViewById(R.id.textView);
        Txpg.setText("Page no:" + pgno + " /13");
    }

    // QP 08 NAV BUTTON--------------------------
    public void qp08nxt() {

        if (pgno == "1") {
            pgno = "2";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-002.jpg?alt=media&token=80d42b11-3ef0-4e80-82ca-d79f36dc7aa1"); //ch3pg2
        } else if (pgno == "2") {
            pgno = "3";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-003.jpg?alt=media&token=a2ce2ac2-d355-46a5-a3cf-d641d0f8d94b"); //ch3pg3
        } else if (pgno == "3") {
            pgno = "4";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-004.jpg?alt=media&token=aa7e14d1-99b3-4d29-973e-df5b0653b747"); //ch3pg4
        } else if (pgno == "4") {
            pgno = "5";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-005.jpg?alt=media&token=7af1097e-13ba-440e-b2da-5bd736132a4d"); //ch3pg5
        } else if (pgno == "5") {
            pgno = "6";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-006.jpg?alt=media&token=36c5d334-0997-478d-817c-0bd6169f3c72"); //ch3pg6
        } else if (pgno == "6") {
            pgno = "7";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-007.jpg?alt=media&token=5aa8e5c4-1df8-4afc-96be-c78dd3a56afb"); //ch3pg7
        } else if (pgno == "7") {
            pgno = "8";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-008.jpg?alt=media&token=92b90a52-70cd-4025-a5c4-56311bc5e0ec"); //ch3pg8
        } else if (pgno == "8") {
            pgno = "9";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-009.jpg?alt=media&token=044c948a-96a1-41fe-b30b-524532c58b56"); //ch3pg9
        } else if (pgno == "9") {
            pgno = "10";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-010.jpg?alt=media&token=6f977856-302b-4cf8-b855-f094bb6495cb"); //ch3pg10
        } else if (pgno == "10") {
            pgno = "11";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-011.jpg?alt=media&token=07684cd9-0633-434c-8d4b-82c1a22c81eb"); //ch3pg11
        } else if (pgno == "11") {
            pgno = "12";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-012.jpg?alt=media&token=f5c750e2-0583-4a9e-ae41-dc207453f456"); //ch3pg12
        } else if (pgno == "12") {
            pgno = "13";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-013.jpg?alt=media&token=b34b7e7f-832e-472b-b832-d9e6ea57741f"); //ch3pg13
        } else if (pgno == "13") {
            pgno = "14";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-014.jpg?alt=media&token=97806d25-f634-4b89-830b-a5c10cbc9b17"); //ch3pg13
        } else if (pgno == "14") {
            pgno = "15";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-015.jpg?alt=media&token=205887bd-5092-45e9-a565-219815d008e0"); //ch3pg13
        } else if (pgno == "15") {
            pgno = "16";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-016.jpg?alt=media&token=fd3e72ea-c8ec-4b63-b2b3-796e30393e7a"); //ch3pg13
        }
        TextView Txpg = (TextView) findViewById(R.id.textView);
        Txpg.setText("Page no:" + pgno + " /16");
    }

    public void qp08prev() {


        if (pgno == "3") {
            pgno = "2";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-002.jpg?alt=media&token=80d42b11-3ef0-4e80-82ca-d79f36dc7aa1"); //ch3pg2
        } else if (pgno == "4") {
            pgno = "3";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-003.jpg?alt=media&token=a2ce2ac2-d355-46a5-a3cf-d641d0f8d94b"); //ch3pg3
        } else if (pgno == "5") {
            pgno = "4";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-004.jpg?alt=media&token=aa7e14d1-99b3-4d29-973e-df5b0653b747"); //ch3pg4
        } else if (pgno == "6") {
            pgno = "5";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-005.jpg?alt=media&token=7af1097e-13ba-440e-b2da-5bd736132a4d"); //ch3pg5
        } else if (pgno == "7") {
            pgno = "6";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-006.jpg?alt=media&token=36c5d334-0997-478d-817c-0bd6169f3c72"); //ch3pg6
        } else if (pgno == "8") {
            pgno = "7";
            WebView myWebView = (WebView) findViewById(R.id.webview);

            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-007.jpg?alt=media&token=5aa8e5c4-1df8-4afc-96be-c78dd3a56afb"); //ch3pg7
        } else if (pgno == "9") {
            pgno = "8";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-008.jpg?alt=media&token=92b90a52-70cd-4025-a5c4-56311bc5e0ec"); //ch3pg8
        } else if (pgno == "10") {
            pgno = "9";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-009.jpg?alt=media&token=044c948a-96a1-41fe-b30b-524532c58b56"); //ch3pg9
        } else if (pgno == "11") {
            pgno = "10";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-010.jpg?alt=media&token=6f977856-302b-4cf8-b855-f094bb6495cb"); //ch3pg10
        } else if (pgno == "12") {
            pgno = "11";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-011.jpg?alt=media&token=07684cd9-0633-434c-8d4b-82c1a22c81eb"); //ch3pg11
        } else if (pgno == "13") {
            pgno = "12";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-012.jpg?alt=media&token=f5c750e2-0583-4a9e-ae41-dc207453f456"); //ch3pg12
        } else if (pgno == "14") {
            pgno = "13";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-013.jpg?alt=media&token=b34b7e7f-832e-472b-b832-d9e6ea57741f"); //ch3pg13
        } else if (pgno == "15") {
            pgno = "14";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-014.jpg?alt=media&token=97806d25-f634-4b89-830b-a5c10cbc9b17"); //ch3pg13
        } else if (pgno == "16") {
            pgno = "15";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-015.jpg?alt=media&token=205887bd-5092-45e9-a565-219815d008e0"); //ch3pg13
        } else if (pgno == "2") {
            pgno = "1";
            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.loadUrl("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2FQP2008%2FGATE-Question-paper-2008-page-001.jpg?alt=media&token=2c8b4202-b17a-4f47-93c5-8ae7d349438b"); //ch3pg13
        }
        TextView Txpg = (TextView) findViewById(R.id.textView);
        Txpg.setText("Page no:" + pgno + " /16");
    }

    public void pdf(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);

        if (opt.equals("qp15")) {
            intent.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fpdf%2FGPAT-2015-solved-question-paper.pdf?alt=media&token=1fb4b91e-091d-4063-93a4-fffe679ee911")); //pdf


        } else if (opt.equals("qp12")) {
            intent.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fpdf%2FGPAT-2012-Answer-Key.pdf?alt=media&token=5f5b9627-ba8b-4f6f-92eb-eb0c2b4aa620")); //pdf

        } else if (opt.equals("qp11")) {
            intent.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fpdf%2FGPAT-2011-Answer-Key.pdf?alt=media&token=05544628-6fd7-4d05-aa6b-ae3c62f6026a")); //pdf

        } else if (opt.equals("qp10")) {
            intent.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fpdf%2FGPAT-2010-Answer-Key.pdf?alt=media&token=28d52a97-9ab5-4850-9851-19d144a1064d")); //pdf

        } else if (opt.equals("qp09")) {
            intent.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fpdf%2FGATE-Question-paper-2009.pdf?alt=media&token=fa758c3a-f21f-4909-b3f5-63d0ae940170")); //pdf

        } else if (opt.equals("qp08")) {
            intent.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/admob-app-id-7252308654.appspot.com/o/GPAT%2Fpdf%2FGATE-Question-paper-2008.pdf?alt=media&token=0a259349-63eb-41d8-9ca8-822b74047fca")); //pdf

        }
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

            Toast.makeText(this, " Loading... ", Toast.LENGTH_LONG).show();
            return true;

        } else if (
                connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED) {


            WebView myWebView = (WebView) findViewById(R.id.webview);
            myWebView.setVisibility(View.GONE);

            Toast.makeText(this, " Please Connect to internet ", Toast.LENGTH_LONG).show();
            return false;
        }
        return false;
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

            //   AdRequest adRequest = new AdRequest.Builder().build();
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

    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            LinearLayout loading = (LinearLayout) findViewById(R.id.loading);

            loading.setVisibility(View.VISIBLE);

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            //super.onPageFinished(view, url);
            LinearLayout loading = (LinearLayout) findViewById(R.id.loading);

            loading.setVisibility(View.GONE);
        }

    }


}
