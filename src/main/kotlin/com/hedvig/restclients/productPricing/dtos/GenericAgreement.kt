package com.hedvig.restclients.productPricing.dtos

import java.time.LocalDate
import java.util.UUID
import javax.money.MonetaryAmount

data class GenericAgreement (
    val id: UUID,
    val fromDate: LocalDate?,
    val toDate: LocalDate?,
    val basePremium: MonetaryAmount,
    val certificateUrl: String?,
    val status: AgreementStatus,
    val typeOfContract: TypeOfContract?,
    val address: Address?,
    val numberCoInsured: Int?,
    val squareMeters: Long?,
    val ancillaryArea: Long?,
    val yearOfConstruction: Int?,
    val numberOfBathrooms: Int?,
    val extraBuildings: List<ExtraBuildingDto>?,
    val isSubleted: Boolean?,
    val lineOfBusinessName: String
)