package com.example.calculatorforall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast

class FlipACoin : AppCompatActivity() {
    private lateinit var coin:ImageView
    private lateinit var switchOff:ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flip_acoin)
        coin = findViewById(R.id.coin)
        switchOff = findViewById(R.id.switch_off)

        onCoinTap()

        switchOff.setOnClickListener {
            val intent = Intent(this, switch_off::class.java)
            startActivity(intent)
            }
    }

    private fun onCoinTap() {
        coin.setOnClickListener{
            val randomNumber = (1..2).random()

            if(randomNumber == 1){
                flipTheCoin(R.drawable.tails_icon, "Tails")
            }   else{
                flipTheCoin(R.drawable.nails_icon, "Heads")
            }
        }
    }

    private fun flipTheCoin(imageId: Int, coinSide: String) {
        coin.animate().apply{
            duration = 1000
            rotationYBy(1800f)
            coin.isClickable = false
        }.withEndAction {
            coin.setImageResource(imageId)
            Toast.makeText(this,coinSide,Toast.LENGTH_SHORT).show()
            coin.isClickable = true
        }.start()

    }
}