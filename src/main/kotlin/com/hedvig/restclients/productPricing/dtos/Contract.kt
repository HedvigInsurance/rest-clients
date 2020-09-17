package com.hedvig.restclients.productPricing.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant
import java.time.LocalDate
import java.util.*
import javax.money.CurrencyUnit

data class Contract(
    val id: UUID,
    val holderMemberId: String,
    val switchedFrom: String?,
    val masterInception: LocalDate?,
    val status: ContractStatus,
    val typeOfContract: TypeOfContract,
    @get:JsonProperty("isTerminated")
    val isTerminated: Boolean,
    val terminationDate: LocalDate?,
    val currentAgreementId: UUID,
    val hasPendingAgreement: Boolean,
    val agreements: List<Agreement>,
    val genericAgreements: List<GenericAgreement>,
    val hasQueuedRenewal: Boolean,
    val renewal: Renewal?,
    val preferredCurrency: CurrencyUnit,
    val market: Market,
    val signSource: SignSource?,
    val contractTypeName: String,
    val createdAt: Instant
)