package com.hedvig.restclients.underwriter.dtos

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.hedvig.restclients.underwriter.dtos.AddressDto
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(
    JsonSubTypes.Type(value = AgreementQuote.SwedishApartmentQuote::class, name = "SwedishApartment"),
    JsonSubTypes.Type(value = AgreementQuote.SwedishHouseQuote::class, name = "SwedishHouse"),
    JsonSubTypes.Type(value = AgreementQuote.NorwegianHomeContentQuote::class, name = "NorwegianHomeContent"),
    JsonSubTypes.Type(value = AgreementQuote.NorwegianTravelQuote::class, name = "NorwegianTravel")
)
sealed class AgreementQuote {
  abstract val quoteId: UUID
  abstract val fromDate: LocalDate?
  abstract val toDate: LocalDate?
  abstract val premium: BigDecimal
  abstract val currency: String
  abstract val currentInsurer: String?

  data class SwedishApartmentQuote(
      override val quoteId: UUID,
      override val fromDate: LocalDate?,
      override val toDate: LocalDate?,
      override val premium: BigDecimal,
      override val currency: String,
      override val currentInsurer: String?,
      val address: AddressDto,
      val coInsured: List<CoInsuredDto>,
      val squareMeters: Long,
      val lineOfBusiness: SwedishApartmentLineOfBusiness
  ) : AgreementQuote()

  data class SwedishHouseQuote(
      override val quoteId: UUID,
      override val fromDate: LocalDate?,
      override val toDate: LocalDate?,
      override val premium: BigDecimal,
      override val currency: String,
      override val currentInsurer: String?,
      val address: AddressDto,
      val coInsured: List<CoInsuredDto>,
      val squareMeters: Long,
      val ancillaryArea: Long,
      val yearOfConstruction: Int,
      val numberOfBathrooms: Int,
      val extraBuildings: List<ExtraBuildingDto>,
      val isSubleted: Boolean
  ) : AgreementQuote()

  data class NorwegianHomeContentQuote(
      override val quoteId: UUID,
      override val fromDate: LocalDate?,
      override val toDate: LocalDate?,
      override val premium: BigDecimal,
      override val currency: String,
      override val currentInsurer: String?,
      val address: AddressDto,
      val coInsured: List<CoInsuredDto>,
      val squareMeters: Long,
      val lineOfBusiness: NorwegianHomeContentLineOfBusiness
  ) : AgreementQuote()

  data class NorwegianTravelQuote(
      override val quoteId: UUID,
      override val fromDate: LocalDate?,
      override val toDate: LocalDate?,
      override val premium: BigDecimal,
      override val currency: String,
      override val currentInsurer: String?,
      val coInsured: List<CoInsuredDto>,
      val lineOfBusiness: NorwegianTravelLineOfBusiness
  ) : AgreementQuote()
}