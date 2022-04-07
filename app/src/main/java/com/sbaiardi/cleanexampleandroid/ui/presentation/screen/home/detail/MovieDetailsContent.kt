package com.sbaiardi.cleanexampleandroid.ui.presentation.screen.home.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.sbaiardi.cleanexampleandroid.BuildConfig
import com.sbaiardi.cleanexampleandroid.R
import com.sbaiardi.cleanexampleandroid.ui.AppThemeColor
import com.sbaiardi.cleanexampleandroid.ui.presentation.components.RatingComponent
import com.sbaiardi.cleanexampleandroid.ui.presentation.screen.showMessage
import com.sbaiardi.domain.model.Movie


@Composable
fun MovieDetailsContent(movie: Movie, navController: NavController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Favourite Icon",
                    tint = Color.Black
                )
            }
        }
        movie.title?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            elevation = 16.dp,
            shape = RoundedCornerShape(20.dp)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = BuildConfig.POSTER_URL + movie.posterPath,
                    builder = {
                        crossfade(true)
                        scale(Scale.FIT)
                    }
                ),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                contentScale = ContentScale.FillWidth
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Overview",
                style = MaterialTheme.typography.subtitle1
            )
            movie.rating?.let { RatingComponent(rating = it)}
        }

        movie.overview?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.body2
            )
        }

    }

}