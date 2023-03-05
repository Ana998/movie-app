package mk.ukim.finki.mymovie.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mk.ukim.finki.mymovie.R
import mk.ukim.finki.mymovie.models.MovieItem
import org.w3c.dom.Text

class MovieAdapter(private val data: List<MovieItem>) : RecyclerView.Adapter<MovieAdapter.MyViewHolder>()  {

    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){

        fun bind(movieItem: MovieItem){
            val id = view.findViewById<TextView>(R.id.movieId)
            val title = view.findViewById<TextView>(R.id.title)
            //val director = view.findViewById<TextView>(R.id.director)
            //val description = view.findViewById<TextView>(R.id.description)
            val body = view.findViewById<TextView>(R.id.body)

            id.text = movieItem.id.toString()
            title.text = movieItem.title
            body.text = movieItem.body
            /*director.text = movieItem.director
            description.text = movieItem.description*/

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.fragment_movie_list, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }


}


