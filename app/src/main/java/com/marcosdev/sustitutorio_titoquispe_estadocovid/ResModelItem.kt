package com.marcosdev.sustitutorio_titoquispe_estadocovid

import com.google.gson.annotations.SerializedName

data class ResModelItem(
    @SerializedName("Active Cases_text")
    val ActiveCases_text: String,

    @SerializedName("Country_text")
    val Country_text: String,

    @SerializedName("Last Update")
    val LastUpdate: String,

    @SerializedName("New Cases_text")
    val NewCases_text: String,

    @SerializedName("New Deaths_text")
    val NewDeaths_text: String,

    @SerializedName("Total Cases_text")
    val TotalCases_text: String,

    @SerializedName("Total Deaths_text")
    val TotalDeaths_text: String,

    @SerializedName("Total Recovered_text")
    val TotalRecovered_text: String
)