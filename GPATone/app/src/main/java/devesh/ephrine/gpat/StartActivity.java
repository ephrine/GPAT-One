package devesh.ephrine.gpat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        //   VideoView video = (VideoView) findViewById(R.id.videoView);
        // Load and start the movie
        //  Uri video1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vid);
        //  video.setVideoURI(video1);
        // video.start();


        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(2 * 1000);

                    // After 2 seconds redirect to another intent

                    //  VideoView video = (VideoView) findViewById(R.id.videoView);

                    // video.stopPlayback();

                    // Remove activity
                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);
                    finish();


                } catch (Exception e) {


                }
            }
        };

        // start thread
        background.start();

    }


}
