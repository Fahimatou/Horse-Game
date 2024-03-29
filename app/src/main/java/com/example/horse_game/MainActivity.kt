package com.example.horse_game

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {

    private var couleurObtenue: Int = Color.GRAY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val cheval = findViewById<ImageView>(R.id.chevalImageView)

        if (savedInstanceState == null) {
            couleurObtenue = couleurAléatoire()
        } else {
            couleurObtenue = savedInstanceState.getInt("couleurAleatoire", Color.GRAY)
        }
        cheval.setColorFilter(couleurObtenue)


    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("couleurAleatoire", couleurObtenue)
        outState.putString("message",findViewById<TextView>(R.id.verifierTextView).text.toString())

    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        couleurObtenue = savedInstanceState.getInt("couleurAleatoire", couleurObtenue)
        val cheval = findViewById<ImageView>(R.id.chevalImageView)
        cheval.setColorFilter(couleurObtenue)

        val message = savedInstanceState.getString("message")
        findViewById<TextView>(R.id.verifierTextView).text = message


    }


    private fun couleurAléatoire(): Int {
        val rand = Random()

        return when (rand.nextInt(6)) {
            0 -> Color.BLUE
            1 -> Color.GREEN
            2 -> Color.RED
            3 -> Color.YELLOW
            4 -> Color.MAGENTA
            else -> Color.GRAY
        }

    }

    fun restartButtonOnClick (v: View){
        val contenuMessage = findViewById<(TextView)>(R.id.verifierTextView)

        contenuMessage.setText("")

        couleurObtenue = couleurAléatoire()
        val cheval = findViewById<ImageView>(R.id.chevalImageView)
        cheval.setColorFilter(couleurObtenue)

    }
    fun verificationColor (buttonColor: Int){
        val verifierTextView = findViewById<TextView>(R.id.verifierTextView)

        if (buttonColor == couleurObtenue){
            verifierTextView.text = "CORRECT"
        } else {
            verifierTextView.text = "INCORRECT"
        }
    }



    fun blueButtonOnClick (v: View?){
        verificationColor(Color.BLUE)
    }
    fun greenButtonOnClick (v: View?){
        verificationColor(Color.GREEN)
    }
    fun redButtonOnClick (v: View?){
        verificationColor(Color.RED)
    }
    fun yellowButtonOnClick (v: View?){
        verificationColor(Color.YELLOW)
    }
    fun magentaButtonOnClick (v: View?){
        verificationColor(Color.MAGENTA)
    }
    fun grayButtonOnClick (v: View?){
        verificationColor(Color.GRAY)

    }


}