package com.example.cartolafilmes.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cartolafilmes.R
import com.example.cartolafilmes.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details_movies.*

class DetailsMovies : AppCompatActivity() {

    private var movie : Movie? = null;
    private lateinit var favoriteItemMenu: MenuItem;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movies)

        movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)

        title_movie.text = movie?.title
        overview_movie.text = movie?.overview
        date_movie.text = movie?.releaseDate
        vote_movie.text = movie?.voteAverage
        val backgroundImagePath = BASE_URL_BACK + movie?.backdropPath
        val posterImagePath = BASE_URL_BACK + movie?.posterPath
        Picasso.get().load(backgroundImagePath).into(backdrop_movie)
        Picasso.get().load(posterImagePath).into(poster_movie)
}
    companion object {
        const val BASE_URL_BACK = "https://image.tmdb.org/t/p/original"
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        favoriteItemMenu = menu?.findItem(R.id.ic_addFavorite)!!
        return true
    }
}