package ro.pub.cs.systems.eim.practicaltest01var07

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.Button
import android.widget.Toast


class PracticalTest01Var07MainActivity : AppCompatActivity() {

    private val REQUEST_CODE_SECONDARY = 1

    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var input3: EditText
    private lateinit var input4: EditText

    private var lastSumResult: String? = null
    private var lastProdResult: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var07_main)

        input1 = findViewById(R.id.input1)
        input2 = findViewById(R.id.input2)
        input3 = findViewById(R.id.input3)
        input4 = findViewById(R.id.input4)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, PracticalTest01Var07SecondaryActivity::class.java)
            intent.putExtra("input1", input1.text.toString())
            intent.putExtra("input2", input2.text.toString())
            intent.putExtra("input3", input3.text.toString())
            intent.putExtra("input4", input4.text.toString())

            if (input1.text.toString().isNotEmpty() && input1.text.toString() != "0" &&
                input2.text.toString().isNotEmpty() && input2.text.toString() != "0" &&
                input3.text.toString().isNotEmpty() && input3.text.toString() != "0" &&
                input4.text.toString().isNotEmpty() && input4.text.toString() != "0") {

                startActivityForResult(intent, REQUEST_CODE_SECONDARY)
                }
        }

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("input1_text")) {
                input1.setText(savedInstanceState.getString("input1_text"))
            }
            if (savedInstanceState.containsKey("input2_text")) {
                input2.setText(savedInstanceState.getString("input2_text"))
            }
            if (savedInstanceState.containsKey("input3_text")) {
                input3.setText(savedInstanceState.getString("input3_text"))
            }
            if (savedInstanceState.containsKey("input4_text")) {
                input4.setText(savedInstanceState.getString("input4_text"))
            }
            if (savedInstanceState.containsKey("last_sum_result")) {
                lastSumResult = savedInstanceState.getString("last_sum_result")
                Toast.makeText(this, "Restored Sum: $lastSumResult", Toast.LENGTH_SHORT).show()
            }
            if (savedInstanceState.containsKey("last_prod_result")) {
                lastProdResult = savedInstanceState.getString("last_prod_result")
                Toast.makeText(this, "Restored Product: $lastProdResult", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("input1_text", input1.text.toString())
        outState.putString("input2_text", input2.text.toString())
        outState.putString("input3_text", input3.text.toString())
        outState.putString("input4_text", input4.text.toString())
        lastSumResult?.let {
            outState.putString("last_sum_result", it)
        }
        lastProdResult?.let {
            outState.putString("last_prod_result", it)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_SECONDARY && data != null) {
            lastSumResult = data.getStringExtra("SUM_RESULT")
            lastProdResult = data.getStringExtra("PROD_RESULT")

            lastSumResult?.let {
                Toast.makeText(this, "Sum Result: $it", Toast.LENGTH_SHORT).show()
            }
            lastProdResult?.let {
                Toast.makeText(this, "Product Result: $it", Toast.LENGTH_SHORT).show()
            }
        }
    }
}