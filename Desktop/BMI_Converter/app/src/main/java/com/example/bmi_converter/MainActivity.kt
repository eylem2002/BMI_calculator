package com.example.bmi_converter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var heightnum:EditText = findViewById(R.id.editTextNumberHeight)
        var Weightnum:EditText = findViewById(R.id.editTextNumberWeight)
        var Bmi:Button = findViewById(R.id.buttonBMI)
        var Result:TextView = findViewById(R.id.textViewBMI)


        var t1:TextView=findViewById(R.id.textViewUN)
        var t2:TextView=findViewById(R.id.textViewNO)
        var t3:TextView=findViewById(R.id.textViewOV)
        var t4:TextView=findViewById(R.id.textViewOB)

        var met:TextView=findViewById(R.id.textViewHeight)////
        var kg:TextView=findViewById(R.id.textViewWeight)////
       // meter = cm / 100.0;
       // kilometer = cm / 100000.0;

////
        var cal:Button = findViewById(R.id.buttonCal)
        var R_cal:TextView = findViewById(R.id.textViewcal)
        var radlow:RadioButton=findViewById(R.id.radioButtonLow)
        var radModer:RadioButton=findViewById(R.id.radioButtonModerate)
        var radHe:RadioButton=findViewById(R.id.radioButtonheavy)

        var radmale:RadioButton=findViewById(R.id.radioButtonmale)
        var radfe:RadioButton=findViewById(R.id.radioButtonfemale)
////


        Bmi.setOnClickListener(View.OnClickListener {

            val H=heightnum.getText().toString().toDouble()
            val W=Weightnum.getText().toString().toDouble()

            val Res_meter=  H /// 100.0;
            val Res_KG   =  W

            val Re = (Res_KG/(Res_meter * Res_meter ));

            Result.setText(Re.toString())
            met.setText(Res_meter.toString()+"m")
            kg.setText(Res_KG.toString()+"Kg")


            if(Re <18.5){// Under Weight
                t1.setBackgroundColor(Color.RED)
                t2.setBackgroundResource(0)
                t3.setBackgroundColor(0)
                t4.setBackgroundColor(0)
            }
            else if(Re>=18.5 && Re<=24.9) {
                t2.setBackgroundColor(Color.GREEN)
                t1.setBackgroundResource(0)
                t3.setBackgroundColor(0)
                t4.setBackgroundColor(0)

            }
                else if (Re>=25 && Re<=29.9) {
                t3.setBackgroundColor(Color.YELLOW)
                t1.setBackgroundResource(0)
                t2.setBackgroundColor(0)
                t4.setBackgroundColor(0)

                }
            else {
                t4.setBackgroundColor(Color.RED)
                t1.setBackgroundResource(0)
                t2.setBackgroundColor(0)
                t3.setBackgroundColor(0)
            }
/////////
            cal.setOnClickListener(View.OnClickListener {






                if(radlow.isChecked && radfe.isChecked) {
                    val R_low_fe =  W*24*0.8
                    R_cal.setText(R_low_fe.toString())
                }
                else if (radlow.isChecked && radmale.isChecked) {
                    val R_low_ma=  W*24*1.1
                    R_cal.setText(R_low_ma.toString())
                }
                else if(radModer.isChecked && radfe.isChecked){
                    val R_moderate_fe=  W*24*0.9
                    R_cal.setText(R_moderate_fe.toString())
                }
                else if(radModer.isChecked && radmale.isChecked){
                    val R_moderate_ma=  W*24*1.2
                    R_cal.setText(R_moderate_ma.toString())
                }
                else if(radHe.isChecked && radfe.isChecked){
                    val R_heavy_fe=  W*24*1.0
                    R_cal.setText(R_heavy_fe.toString())
                }
                else if(radHe.isChecked && radmale.isChecked){
                    val R_heavy_ma=  W*24*1.3
                    R_cal.setText(R_heavy_ma.toString())
                }


            })

////////
        })
        //part 2 cal
        //  Bmi.setOnClickListener







    }


}