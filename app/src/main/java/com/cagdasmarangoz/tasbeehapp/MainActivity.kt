package com.cagdasmarangoz.tasbeehapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cagdasmarangoz.tasbeehapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var count=0
    var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            pushButton.setOnClickListener {
                count++
                mediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.alert)
                mediaPlayer?.start()
                numberText.text=count.toString()
            }
            rButton.setOnClickListener {
                count=0
                numberText.text=count.toString()
            }
        }
    }
}