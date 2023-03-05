package mk.ukim.finki.mymovie.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mk.ukim.finki.mymovie.R
import mk.ukim.finki.mymovie.databinding.FragmentMovieDetailsBinding
import mk.ukim.finki.mymovie.databinding.FragmentMovieListBinding
import mk.ukim.finki.mymovie.dialogs.AddNewMovieFragment

class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {

    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMovieDetailsBinding.bind(view)

        binding.addMovie.setOnClickListener{
            AddNewMovieFragment().show(childFragmentManager, "add-movie-dialog")
        }
    }
}