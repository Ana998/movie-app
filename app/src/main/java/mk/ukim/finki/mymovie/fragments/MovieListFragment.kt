package mk.ukim.finki.mymovie.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mk.ukim.finki.mymovie.R
import mk.ukim.finki.mymovie.adapters.MovieAdapter
import mk.ukim.finki.mymovie.databinding.FragmentMovieListBinding
import mk.ukim.finki.mymovie.models.MovieItem

class MovieListFragment : Fragment(R.layout.fragment_movie_list) {

    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMovieListBinding.bind(view)

        binding.btnGoToSecondFragment.setOnClickListener(){
            parentFragmentManager.commit {
                replace(R.id.fragment_container_view, MovieDetailsFragment())
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }
    }
}