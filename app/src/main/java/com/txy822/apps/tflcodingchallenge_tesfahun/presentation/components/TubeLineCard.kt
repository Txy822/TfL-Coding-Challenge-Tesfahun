package com.txy822.apps.tflcodingchallenge_tesfahun.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.txy822.apps.tflcodingchallenge_tesfahun.domain.model.TubeLineStatusModel


@Composable
fun TubeLineCard(
    tubeLineStatus: TubeLineStatusModel
) {
    val title = tubeLineStatus.name

    val tubeLineNameMap = hashMapOf(
        "bakerloo" to "#894E24",
        "central" to "#DC241F",
        "circle" to "#FFCE00",
        "district" to "#007229",
        "hammersmith-city" to "#D799AF",
        "jubilee" to "#697278",
        "metropolitan" to "#751056",
        "northern" to "#000000",
        "piccadilly" to "#001AA8",
        "victoria" to "#01A0E2",
        "waterloo-city" to "#76D0BD"
    )

    Column(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RectangleShape,
            elevation = 1.dp,
            border = BorderStroke(0.5.dp, Color.LightGray)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.height(IntrinsicSize.Min)
                    .semantics(mergeDescendants = true) {}
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(10.dp)
                        .background(
                            Color(
                                android.graphics.Color.parseColor
                                    (tubeLineNameMap[tubeLineStatus.id] ?: "#000000")
                            ),
                        )
                )
                Text(
                    text = title,
                    modifier = Modifier
                        .padding(top = 6.dp, bottom = 6.dp, start = 10.dp),
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.weight(1f))

                val status = tubeLineStatus.lineStatuses.joinToString("\n") {
                    it.statusSeverityDescription
                }
                val reason = tubeLineStatus.lineStatuses.joinToString("\n") {it.reason.toString()}
                if(reason.isNotBlank()&&!reason.isEmpty()&&reason.length>5){

                    Text(
                        text = reason,
                        modifier = Modifier
                            .padding(top = 6.dp, bottom = 6.dp, end = 20.dp),
                        textAlign = TextAlign.End,
                        fontSize = 16.sp
                    )
                }
                else {

                    Text(
                        text = status,
                        modifier = Modifier
                            .padding(top = 6.dp, bottom = 6.dp, end = 20.dp),
                        textAlign = TextAlign.End,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}
