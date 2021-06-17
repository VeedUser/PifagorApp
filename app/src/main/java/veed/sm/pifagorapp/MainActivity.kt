package veed.sm.pifagorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import veed.sm.pifagorapp.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickResult(view: View){

        if(!isFieldEmpty()){
            val result = getString(R.string.result_Info) + getResult()
            binding.resultTextView.text = result
        }

    }

    private fun isFieldEmpty(): Boolean{
        binding.apply {
            if(aEditText.text.isNullOrEmpty()) aEditText.error = resources.getString(R.string.error)
            if(bEditText.text.isNullOrEmpty()) bEditText.error = resources.getString(R.string.error)
            return aEditText.text.isNullOrEmpty() || bEditText.text.isNullOrEmpty()

        }

    }

    private fun getResult(): String{
        val a: Double
        val b: Double
        binding.apply {
            a = aEditText.text.toString().toDouble()
            b = bEditText.text.toString().toDouble()
        }
        return sqrt((a.pow(2) + b.pow(2))).toString()
    }

}