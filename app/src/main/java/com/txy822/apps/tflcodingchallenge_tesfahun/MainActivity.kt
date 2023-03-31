package com.txy822.apps.tflcodingchallenge_tesfahun

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.txy822.apps.tflcodingchallenge_tesfahun.presentation.TfLScreen
import com.txy822.apps.tflcodingchallenge_tesfahun.presentation.ui.theme.TfLCodingChallengeTesfahunTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TfLCodingChallengeTesfahunTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TfLTubeLineStatus()
                }
            }
        }
    }
}

@Composable
fun TfLTubeLineStatus(){
TfLScreen()
}
