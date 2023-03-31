package com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Disruption(
    @SerializedName("affectedRoutes")
    val affectedRoutes: List<Any>,
    @SerializedName("affectedStops")
    val affectedStops: List<Any>,
    @SerializedName("category")
    val category: String,
    @SerializedName("categoryDescription")
    val categoryDescription: String,
    @SerializedName("closureText")
    val closureText: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("type")
    val type: String
)