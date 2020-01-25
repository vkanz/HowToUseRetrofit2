package ru.vkanz.howtouseretrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var tv_quote: TextView

    companion object {
      val baseUrl = "http://api.forismatic.com/"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_quote = findViewById(R.id.tv_qoute)
        findViewById<View>(R.id.button).setOnClickListener {getQuote()}
    }

    private fun getQuote() {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(QuoteService::class.java)
        val call = service.getQuote()
        call.enqueue(object: Callback<QuoteResponse> {
            override fun onResponse(call: Call<QuoteResponse>, response: Response<QuoteResponse>) {
                if (response.code() == 200) {
                    val quoteResponse: QuoteResponse = response.body()
                    tv_quote.text = getString(R.string.fmt_quote,
                        quoteResponse.quoteText, quoteResponse.quoteAuthor)
                }
            }

            override fun onFailure(call: Call<QuoteResponse>?, t: Throwable) {
                tv_quote.text = t.message
            }
        })
    }
}
