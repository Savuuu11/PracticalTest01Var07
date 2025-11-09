package ro.pub.cs.systems.eim.practicaltest01var07

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Button

class PracticalTest01Var07SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var07_secondary)
        val input1 = findViewById<EditText>(R.id.input1)
        val input2 = findViewById<EditText>(R.id.input2)
        val input3 = findViewById<EditText>(R.id.input3)
        val input4 = findViewById<EditText>(R.id.input4)

        val intent = intent
        if (intent != null) {
            if (intent.hasExtra("input1")) {
                input1.setText(intent.getStringExtra("input1"))
            }
            if (intent.hasExtra("input2")) {
                input2.setText(intent.getStringExtra("input2"))
            }
            if (intent.hasExtra("input3")) {
                input3.setText(intent.getStringExtra("input3"))
            }
            if (intent.hasExtra("input4")) {
                input4.setText(intent.getStringExtra("input4"))
            }

        }

        val PROD = findViewById<Button>(R.id.PROD)
        PROD.setOnClickListener {
            val result = input1.text.toString().toInt() * input2.text.toString().toInt() * input3.text.toString().toInt() * input4.text.toString().toInt()
            val intent = intent
            intent.putExtra("PROD_RESULT", result.toString())
            setResult(RESULT_OK, intent)
            finish()

        }

        val SUM = findViewById<Button>(R.id.SUM)
        SUM.setOnClickListener {
            val result = input1.text.toString().toInt() + input2.text.toString().toInt() + input3.text.toString().toInt() + input4.text.toString().toInt()
            val intent = intent
            intent.putExtra("SUM_RESULT", result.toString())
            setResult(RESULT_OK, intent)
            finish()

        }



    }
}
