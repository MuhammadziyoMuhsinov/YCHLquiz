package com.fenix.ychlquiz

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fenix.ychlquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer.create(this,R.raw.audio)
        mediaPlayer.start()

    }

    override fun onDestroy() {
        super.onDestroy()
        if (mediaPlayer.isPlaying){
            mediaPlayer.stop()
        }
    }

    override fun onStop() {
        super.onStop()
        if (mediaPlayer.isPlaying){
            mediaPlayer.stop()
        }
    }

    override fun onRestart() {
        super.onRestart()
        mediaPlayer = MediaPlayer.create(this,R.raw.audio)
        mediaPlayer.start()
    }
}