package com.comet.androidstreamingui;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import com.comet.androidstreamingui.library.VLCVideoPlayer;

public class MainActivity extends Activity implements View.OnClickListener {

    private String mUrl = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4";
    private VLCVideoPlayer videoPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        videoPlayer = (VLCVideoPlayer)findViewById(R.id.videoPlayer);
        videoPlayer.setSource(Uri.parse(mUrl));
        videoPlayer.setLoop(true);
        videoPlayer.play();
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onPause() {
        super.onPause();
        videoPlayer.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        videoPlayer.play();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }
}
