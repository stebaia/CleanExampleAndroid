package com.sbaiardi.cleanexampleandroid.ui.presentation.screen.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.sbaiardi.cleanexampleandroid.R
import com.sbaiardi.cleanexampleandroid.ui.AppThemeColor

@Composable
fun HomeTopBar(
) {
    val context = LocalContext.current
    TopAppBar(
        backgroundColor = MaterialTheme.colors.AppThemeColor,
        title = {
            Text(
                text = stringResource(R.string.app_name),
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h5
            )
        },
        elevation = 0.dp,
        actions = {

            IconButton(onClick = { showMessage(context = context) }) {
                Icon(
                    painter = painterResource(id = R.drawable.github),
                    contentDescription = "Favourite Icon",
                    tint = Black
                )
            }
        }
    )
}

fun showMessage(context: Context) {
    val browserIntent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse("https://github.com/stebaia")
    )
    ContextCompat.startActivity(context, browserIntent, null)
}