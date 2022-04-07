package com.sbaiardi.cleanexampleandroid.ui.presentation.screen.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.sbaiardi.cleanexampleandroid.BuildConfig
import com.sbaiardi.cleanexampleandroid.ui.ItemBackgroundColor
import com.sbaiardi.cleanexampleandroid.ui.presentation.components.RatingComponent
import com.sbaiardi.cleanexampleandroid.ui.presentation.navigation.Screen
import com.sbaiardi.cleanexampleandroid.util.Tool
import com.sbaiardi.domain.model.Movie

@Composable
fun MovieListContent(allMovies: LazyPagingItems<Movie>, navController: NavHostController) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 4.dp)
    ) {
        items(
            items = allMovies,
            key = { movie ->
                movie.pk
            }
        ) { movie ->
            if (movie != null) {
                MovieListItem(movie = movie, navController = navController)
            }
        }
    }
}


@Composable
fun MovieListItem(movie: Movie, navController: NavHostController) {
    Card(
        modifier = Modifier
            .padding(top = 12.dp)
            .height(120.dp)
            .fillMaxWidth(),

        elevation = 8.dp,

        shape = RoundedCornerShape(20.dp)
    ) {
        Box(
            Modifier.background(
               Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colors.ItemBackgroundColor,
                            MaterialTheme.colors.ItemBackgroundColor,
                        )
               ),
            )
        ) {
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Max)
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate(route = Screen.MovieDetails.passMovieId(movie.movieId.toString()))
                    },

                verticalAlignment = Alignment.CenterVertically
            ) {
                movie.posterPath?.let {
                    Image(
                        modifier = Modifier
                            .padding(20.dp)
                            .height(80.dp)
                            .width(60.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        painter = rememberImagePainter(
                            data = BuildConfig.POSTER_URL + movie.posterPath, builder = {
                                crossfade(true)
                                scale(Scale.FIT)
                            }),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                    )
                }
                Column(
                    Modifier
                        .height(IntrinsicSize.Max)
                        .padding(
                            end = 8.dp,
                        )) {
                    movie.title?.let { Text(text = it, style = MaterialTheme.typography.body1) }
                    //Spacer(modifier = Modifier.height(4.dp))
                    /*movie.overview?.let {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.body2,
                            maxLines = 4,
                            overflow = TextOverflow.Ellipsis
                        )
                    }*/
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Movie", style = MaterialTheme.typography.body2)
                        movie.rating?.let { RatingComponent(rating = it)}
                    }

                }
            }
        }

    }
}