package ru.vkanz.howtouseretrofit2

import com.google.gson.annotations.SerializedName

class QuoteResponse {
    @SerializedName("quoteText")
    var quoteText: String? = null
    @SerializedName("quoteAuthor")
    var quoteAuthor: String? = null
    @SerializedName("senderName")
    var senderName: String? = null
    @SerializedName("senderLink")
    var senderLink: String? = null
    @SerializedName("quoteLink")
    var quoteLink: String? = null
}
