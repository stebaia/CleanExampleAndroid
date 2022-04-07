package com.sbaiardi.cleanexampleandroid.ui.presentation.components


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sbaiardi.cleanexampleandroid.R


@Composable
fun RatingComponent(rating: String){
    Row(
        modifier = Modifier.padding(end = 20.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_round_star_purple500_24),
            contentDescription = null,
            modifier = Modifier
                .padding(
                    end = 2.dp,
                )
        )
        Text(text = rating, style = MaterialTheme.typography.body2)
    }
}
