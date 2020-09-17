package com.hedvig.restclients.underwriter.dtos

data class ExtraBuildingDto(
    val type: ExtraBuildingType,
    val area: Int,
    val hasWaterConnected: Boolean
)