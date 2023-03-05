package mk.ukim.finki.mymovie.data.movie

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import mk.ukim.finki.mymovie.models.MovieItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

//private const val BASE_URL = "https://localhost:3000"
private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL).build()


interface FakeApi{
    @GET("posts")
    fun getAllData(): Call<List<MovieItem>>
}

object Api{
    val retrofitService: FakeApi by lazy{retrofit.create(FakeApi::class.java)}
}