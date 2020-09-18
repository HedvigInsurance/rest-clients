package com.hedvig.restclients.productPricing.dtos

import java.util.UUID

data class ExtraBuildingDto(
    val id: UUID?,
    val type: ExtraBuildingType,
    val area: Int,
    val hasWaterConnected: Boolean,
    val displayName: String?
)