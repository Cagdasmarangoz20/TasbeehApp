package com.cagdasmarangoz.tasbeehapp

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cagdasmarangoz.tasbeehapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var count = 0
    var highScorer = 0
    var mediaPlayer: MediaPlayer? = null
    var value=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            val sharedPreferences = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)
            val saveScore = sharedPreferences.getString("STRING_KEY", null)
         highScorer = saveScore!!.toInt()

            highScore.text = highScorer.toString()
            rButton.setOnClickListener {
                count = 0
                value = 1
                textArabic.text = getString(R.string.Sübhanallah)
                numberText.text = count.toString()


            }
            pushButton.setOnClickListener {

                value++

                when (value) {
                    1 -> textArabic.text =getString(R.string.Sübhanallah)
                    33 -> textArabic.text = getString(R.string.Elhamdülillah)
                    66 -> textArabic.text = getString(R.string.Allahu_ekber)
                    100 -> value = 0
                }

                count++
                mediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.alert)
                mediaPlayer?.start()
                numberText.text = count.toString()
                highScorer++
                highScore.text = highScorer.toString()

                saveData(highScorer.toString())




            }




    }

        loadData()
    }

    private fun saveData(value:String) {
        val sharedPreferences = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("STRING_KEY", value)
        editor.commit()
    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)
        val saveScore = sharedPreferences.getString("STRING_KEY", null)
        binding.highScore.text = saveScore.toString()

    }
}