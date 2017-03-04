package devesh.ephrine.gpat;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
    public void website(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://ephrine.blogspot.com")); //Google play store
        startActivity(intent);

   }
    public void pro(View view) {


        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setData(Uri.parse("market://details?id=devesh.ephrine.gpat.pro")); //Google play store
        startActivity(intent);

    }
    public void contact(View view) {


        Intent intent = new Intent(this, WebActivity.class);
        startActivity(intent);

    }

}
