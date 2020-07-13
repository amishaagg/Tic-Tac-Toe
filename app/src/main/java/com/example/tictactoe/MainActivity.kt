package com.example.tictactoe

import android.media.AsyncPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var PLAYER=true;
    var TURN_COUNT=0
    var boardStatus=Array(3){IntArray(3)}
    lateinit var Board:Array<Array<Button>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Board= arrayOf(
            arrayOf(btn1,btn2,btn3),
            arrayOf(btn4,btn5,btn6),
            arrayOf(btn7,btn8,btn9)
        )
        initialiseBoardStatus()
        resetbtn.setOnClickListener{
            initialiseBoardStatus()
            PLAYER=true;
            TURN_COUNT=0
        }
        btn1.setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?) {
                updateValue(row=0,col=0,player=PLAYER)
                var win=winner()
                if(win==1 || win==0){
                    disable()
                    tv.text=if(win==1)"PLAYER X WINNER"
                    else {
                        "PLAYER O WINNER"
                    }
                }
            }
        })
        btn2.setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?) {
                updateValue(row=0,col=1,player=PLAYER)
                var win=winner()
                if(win==1 || win==0){
                    disable()
                    tv.text=if(win==1)"PLAYER X WINNER"
                    else {
                        "PLAYER O WINNER"
                    }
                }
            }
        })
        btn3.setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?) {
                updateValue(row=0,col=2,player=PLAYER)
                var win=winner()
                if(win==1 || win==0){
                    disable()
                    tv.text=if(win==1)"PLAYER X WINNER"
                    else {
                        "PLAYER O WINNER"
                    }
                }

            }
        })
        btn4.setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?) {
                updateValue(row=1,col=0,player=PLAYER)
                var win=winner()
                if(win==1 || win==0){
                    disable()
                    tv.text=if(win==1)"PLAYER X WINNER"
                    else {
                        "PLAYER O WINNER"
                    }
                }
            }
        })
        btn5.setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?) {
                updateValue(row=1,col=1,player=PLAYER)
                var win=winner()
                if(win==1 || win==0){
                    disable()
                    tv.text=if(win==1)"PLAYER X WINNER"
                    else {
                        "PLAYER O WINNER"
                    }
                }
            }
        })
        btn6.setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?) {
                updateValue(row=1,col=2,player=PLAYER)
                var win=winner()
                if(win==1 || win==0){
                    disable()
                    tv.text=if(win==1)"PLAYER X WINNER"
                    else {
                        "PLAYER O WINNER"
                    }
                }
            }
        })
        btn7.setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?) {
                updateValue(row=2,col=0,player=PLAYER)
                var win=winner()
                if(win==1 || win==0){
                    disable()
                    tv.text=if(win==1)"PLAYER X WINNER"
                    else {
                        "PLAYER O WINNER"
                    }
                }
            }
        })
        btn8.setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?) {
                updateValue(row=2,col=1,player=PLAYER)
                var win=winner()
                if(win==1 || win==0){
                    disable()
                    tv.text=if(win==1)"PLAYER X WINNER"
                    else {
                        "PLAYER O WINNER"
                    }
                }
            }
        })
        btn9.setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?) {
                updateValue(row=2,col=2,player=PLAYER)
                var win=winner()
                if(win==1 || win==0){
                    disable()
                    tv.text=if(win==1)"PLAYER X WINNER"
                    else {
                        "PLAYER O WINNER"
                    }
                }

            }
        })
    }
    private fun disable(){
        for(i in Board){
            for(button in i){
                button.isEnabled=false
            }
        }
    }

    private fun winner():Int{

        var num=1;
        var boo=false;
        for(i in 0..2){
            if(boardStatus[i][0]==num && boardStatus[i][1]==num && boardStatus[i][2]==num)return 1
        }
        for(i in 0..2){
            if(boardStatus[0][i]==num && boardStatus[1][i]==num && boardStatus[2][i]==num)return 1
        }

            if(boardStatus[1][1]==num && boardStatus[0][0]==num && boardStatus[2][2]==num)return 1

            if(boardStatus[1][1]==num && boardStatus[0][2]==num && boardStatus[2][0]==num)return 1
        num=0;

        for(i in 0..2){
            if(boardStatus[i][0]==num && boardStatus[i][1]==num && boardStatus[i][2]==num)return 0
        }
        for(i in 0..2){
            if(boardStatus[0][i]==num && boardStatus[1][i]==num && boardStatus[2][i]==num)return 0
        }

        if(boardStatus[1][1]==num && boardStatus[0][0]==num && boardStatus[2][2]==num)return 0

        if(boardStatus[1][1]==num && boardStatus[0][2]==num && boardStatus[2][0]==num)return 0
        return -1;

    }

    private fun updateValue(row: Int, col: Int, player: Boolean) {
        var t=if(PLAYER)"X"
        else{
            "O"
        }
        var value=if(PLAYER)1
        else{
            0
        }
        Board[row][col].text=t
        boardStatus[row][col]=value
        Board[row][col].isEnabled=false
        PLAYER=!PLAYER
        TURN_COUNT++
        tv.text=if(TURN_COUNT==9)"GAME DRAW"
        else if(PLAYER)"PLAYER X-TURN"
        else{
            "PLAYER O-TURN"
        }
    }

    private fun initialiseBoardStatus() {
        for(i in 0..2){
            for(j in 0..2){
                tv.text="PLAYER X TURN"
                boardStatus[i][j]=-1;
                Board[i][j].text=""
                Board[i][j].isEnabled=true
            }
        }
    }


}