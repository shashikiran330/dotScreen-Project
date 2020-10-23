package myproject.athome.tictactoe

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()
    private var player1Count = 0
    private var player2Count = 0
    private var playingPlayer = 1
    private var setPlayer = 1
    var score = 0
    var winningPlayer = ""
    var ps1: TextView? = null
     var ps2: TextView?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ps1= findViewById(R.id.ps1)
        ps2= findViewById(R.id.ps2)

        startTimeCounter()
    }


    private fun startTimeCounter() {
        val countTime: TextView = findViewById(R.id.timer)

        object : CountDownTimer(180000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                var counter = 5
                var diff = millisUntilFinished

                val secInMilli: Long = 1000
                val minInMilli = secInMilli * 60

                val min = diff / minInMilli
                diff %= minInMilli

                val sec = diff / secInMilli
                countTime.text = "$min : $sec "
                counter--
            }

            override fun onFinish() {
                countTime.text = "Time Up!!!"
                onAlertDialog()
            }
        }.start()
    }



    fun buttonClick(view: View) {

        val btnSelected: Button = view as Button
        var btnId = 0
        when (btnSelected.id) {

            R.id.button1 -> btnId = 1
            R.id.button2 -> btnId = 2
            R.id.button3 -> btnId = 3

            R.id.button4 -> btnId = 4
            R.id.button5 -> btnId = 5
            R.id.button6 -> btnId = 6

            R.id.button7 -> btnId = 7
            R.id.button8 -> btnId = 8
            R.id.button9 -> btnId = 9
        }
        playGame(btnId, btnSelected)

    }


    private fun playGame(btnId: Int, btnSelected: Button) {

        pa1.visibility = View.INVISIBLE
        pa2.visibility = View.INVISIBLE

        if (playingPlayer == 1) {

            btnSelected.text = "X"
            btnSelected.setBackgroundColor(Color.GREEN)
            player1.add(btnId)
            pa2.visibility = View.VISIBLE
            pa1.visibility = View.INVISIBLE
            playingPlayer = 2

        } else {
            btnSelected.text = "0"
            btnSelected.setBackgroundColor(Color.RED)
            player2.add(btnId)
            pa1.visibility = View.VISIBLE
            pa2.visibility = View.INVISIBLE
            playingPlayer = 1
        }

        btnSelected.isEnabled = false
        checkWinner()
    }

    private fun checkWinner() {
        var winner = -1


        //row1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        //row2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        //row3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        //col1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        //col2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        //col3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        //cross1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        //cross2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        if (winner != -1) {

            if (winner == 1) {
                Toast.makeText(this, "Player 1 Wins!!", Toast.LENGTH_SHORT).show()
                player1Count++
                ps1?.text = player1Count.toString()
                winningPlayer = "Player1"
                restartGame()
            } else if (winner == 2) {
                Toast.makeText(this, "Player 2 Wins!!", Toast.LENGTH_SHORT).show()
                player2Count++
                ps2?.text = player2Count.toString()
                winningPlayer = "Player2"
                restartGame()
            }
        }
    }

    fun restartGame() {

        button1.setBackgroundResource(android.R.drawable.btn_default)
        button2.setBackgroundResource(android.R.drawable.btn_default)
        button3.setBackgroundResource(android.R.drawable.btn_default)
        button4.setBackgroundResource(android.R.drawable.btn_default)
        button5.setBackgroundResource(android.R.drawable.btn_default)
        button6.setBackgroundResource(android.R.drawable.btn_default)
        button7.setBackgroundResource(android.R.drawable.btn_default)
        button8.setBackgroundResource(android.R.drawable.btn_default)
        button9.setBackgroundResource(android.R.drawable.btn_default)


        button1.text = ""
        button2.text = ""
        button3.text = ""
        button4.text = ""
        button5.text = ""
        button6.text = ""
        button7.text = ""
        button8.text = ""
        button9.text = ""

        player1.clear()
        player2.clear()
        playingPlayer = 1

        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true

        setPlayer = 1
        PVP.setBackgroundColor(Color.CYAN)
    }

    private fun onAlertDialog() {


        val builder = AlertDialog.Builder(this)
        builder.setTitle("Game Over")

        builder.setMessage("The Winner is $winningPlayer - ${ps1?.text} | ${ps2?.text}")

        builder.setPositiveButton("OK", null)

        val dialog = builder.create()
        dialog.show()

    }

}
