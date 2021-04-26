package com.example.cartolafilmes.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cartolafilmes.R
import com.example.cartolafilmes.model.Movie
import com.example.cartolafilmes.viewmodel.MoviesViewModel
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private lateinit var mainActivityViewModel : MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivityViewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        mainActivityViewModel.getMovies()
        mainActivityViewModel.observeMovies(this){handleMovies(it)}
    }

private fun handleMovies(movies: List<Movie>){
    rv_list?.layoutManager = GridLayoutManager(context,2)
    rv_list?.adapter = context?.let { MoviesAdapter(movies, it) }
}

}