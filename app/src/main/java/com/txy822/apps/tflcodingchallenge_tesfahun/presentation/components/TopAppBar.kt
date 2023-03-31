package com.txy822.apps.tflcodingchallenge_tesfahun.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.txy822.apps.tflcodingchallenge_tesfahun.R

@Composable
fun LineTopAppBar() {
    TopAppBar(

        modifier = Modifier.clip(shape = RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
        ,
        title = {
            Text(

                text = stringResource(R.string.line_status_update),
                color = colorResource(id = R.color.white),

                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        },
        backgroundColor = colorResource(id = R.color.dark_blue),
        elevation = 4.dp
    )
}