package com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.dto


import com.google.gson.annotations.SerializedName

data class LineStatuse(
    @SerializedName("created")
    val created: String,
    @SerializedName("disruption")
    val disruption: Disruption,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lineId")
    val lineId: String,
    @SerializedName("reason")
    val reason: String,
    @SerializedName("statusSeverity")
    val statusSeverity: Int,
    @SerializedName("statusSeverityDescription")
    val statusSeverityDescription: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("validityPeriods")
    val validityPeriods: List<ValidityPeriod>
)
