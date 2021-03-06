package com.sbaiardi.cleanexampleandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sbaiardi.cleanexampleandroid.ui.presentation.navigation.NavGraph
import com.sbaiardi.cleanexampleandroid.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}