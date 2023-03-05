package mk.ukim.finki.mymovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mk.ukim.finki.mymovie.adapters.MovieAdapter
import mk.ukim.finki.mymovie.data.movie.Api
import mk.ukim.finki.mymovie.data.movie.FakeApi
import mk.ukim.finki.mymovie.dialogs.AddNewMovieFragment
import mk.ukim.finki.mymovie.fragments.MovieListFragment
import mk.ukim.finki.mymovie.fragments.MovieViewModel
import mk.ukim.finki.mymovie.models.MovieItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), AddNewMovieFragment.AddNewMovieDialogListener {


    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var movieAdapter: RecyclerView.Adapter<*>
    //private val movieViewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //manager = LinearLayoutManager(this)


        if(savedInstanceState == null){
            supportFragmentManager.commit{
                replace(R.id.fragment_container_view, MovieListFragment())
                setReorderingAllowed(true)
                getAllData()
            }
        }

    }

    fun getAllData(){

        Api.retrofitService.getAllData().enqueue(object: Callback<List<MovieItem>> {
            override fun onResponse(
                call: Call<List<MovieItem>>,
                response: Response<List<MovieItem>>
            ) {
                if(response.isSuccessful){
                    recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply{
                        movieAdapter = MovieAdapter(response.body()!!)
                        //layoutManager = manager
                        adapter = movieAdapter
                    }
                }
            }

            override fun onFailure(call: Call<List<MovieItem>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    override fun onDialogPositiveClick() {
        TODO("Not yet implemented")
    }

    override fun onDialogNegativeClick() {
        TODO("Not yet implemented")
    }


}