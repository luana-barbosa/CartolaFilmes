package com.example.cartolafilmes.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    var title: String = "",

    var overview: String = "",

    var releaseDate: String = "",

    var backdropPath: String = "",

    var posterPath: String = "",

    var voteAverage: String = "",

    var popularity: String = ""
): Parcelable
