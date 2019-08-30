package ds.appname.repository

import com.google.gson.GsonBuilder
import ds.appname.model.Order
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Endpoint {

    companion object Factory {
        private val BASE_URL = "http://172.32.1.86:8000"
        private var instance: Retrofit? = null

        fun getEndpoint(): Endpoint {
            if (instance == null) {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                val okHttpClient =
                    OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
                val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()
                val callAdapterFactory = RxJava2CallAdapterFactory.create()
                instance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(callAdapterFactory)
                    .client(okHttpClient)
                    .build()
            }
            return instance!!.create(Endpoint::class.java)
        }
    }

    @GET("/order/")
    fun orderList(): Single<List<Order>>
}