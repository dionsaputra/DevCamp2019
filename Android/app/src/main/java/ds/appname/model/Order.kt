package ds.appname.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Order(
    @SerializedName("id") val id: String,
    @SerializedName("order_id") val orderId: String,
    @SerializedName("date_time") val dateTime: Date,
    @SerializedName("customer_name") val customerName: String,
    @SerializedName("customer_phone") val customerPhone: String,
    @SerializedName("customer_address") val customerAddress: String
)