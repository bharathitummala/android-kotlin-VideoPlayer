package com.example.videoplayerapp

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.videoplayerapp.ui.theme.VideoPlayerAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // displaying videos from local storage
        val videoView: VideoView = findViewById(R.id.videoView)
        videoView.setVideoPath(
            "android.resource://"
                +packageName+"/" +R.raw.mountains)

       val mediaController = MediaController(this)
        mediaController.setMediaPlayer(videoView)
        videoView.setMediaController(mediaController)
        videoView.start()

        // Displaying videos from internet
        val videoView2 = findViewById<VideoView>(R.id.videoView2)
        val videoUri = Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4")
        videoView2.setVideoURI(videoUri)

        val mediaController2 = MediaController(this)
        mediaController2.setAnchorView(videoView2)
        videoView2.setMediaController(mediaController2)

        videoView2.start()



    }
}



