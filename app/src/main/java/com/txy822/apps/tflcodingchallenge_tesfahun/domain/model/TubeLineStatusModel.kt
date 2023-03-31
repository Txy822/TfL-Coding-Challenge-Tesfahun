package com.txy822.apps.tflcodingchallenge_tesfahun.domain.model

import com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.dto.LineStatuse

data class TubeLineStatusModel(
    val id:String,
    val name:String,
    val lineStatuses: List<LineStatuseModel>,
    )
/*
    @SerializedName("created")
    val created: String,
    @SerializedName("crowding")
    val crowding: Crowding,
    @SerializedName("disruptions")
    val disruptions: List<Any>,
    @SerializedName("id")
    val id: String,
    @SerializedName("lineStatuses")
    val lineStatuses: List<LineStatuse>,
    @SerializedName("modeName")
    val modeName: String,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("routeSections")
    val routeSections: List<Any>,
    @SerializedName("serviceTypes")
    val serviceTypes: List<ServiceType>,
    @SerializedName("type")
    val type: String
 */