package com.txy822.apps.tflcodingchallenge_tesfahun.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.txy822.apps.tflcodingchallenge_tesfahun.R
import com.txy822.apps.tflcodingchallenge_tesfahun.presentation.components.CustomCircularProgressBar
import com.txy822.apps.tflcodingchallenge_tesfahun.presentation.components.LineTopAppBar
import com.txy822.apps.tflcodingchallenge_tesfahun.presentation.components.TubeLineCard


@Composable
fun TfLScreen(
) {
    val viewModel: TflViewModel = hiltViewModel()

    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 15.dp)
            .padding(start = 10.dp, end = 10.dp), horizontalAlignment = Alignment.CenterHorizontally

    ) {
        LineTopAppBar()
        if (state.isLoading) {
            Column(modifier = Modifier) {
                // Text(text = "Loading...")
                CustomCircularProgressBar()
            }
        } else if (state.error.isNotBlank()) {
            Column(modifier = Modifier.weight(1f).padding( 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Text(text = "Error Occurred! Please check your network connection!",
                fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                    )
            }
        } else {
            Column(
                modifier =Modifier.weight(1f)
                    .padding(top = 15.dp)
            ) {

                LazyColumn() {
                    items(state.lineStatus) { tubeLineStatus ->
                        Row() {
                            TubeLineCard(tubeLineStatus = tubeLineStatus)
                        }
                    }
                }
            }
        }
        Column(
        ) {
            logo()
        }
    }
}
@Composable
fun logo(
){
    val borderWidth = 4.dp
    Image(
        painter = painterResource(id = R.drawable.tfl_icon),
        contentDescription = stringResource(id = R.string.icon_content_description),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(100.dp)
            .padding(borderWidth)
            .clip(CircleShape)
    )
}



