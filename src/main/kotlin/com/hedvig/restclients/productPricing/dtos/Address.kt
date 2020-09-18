package com.hedvig.restclients.productPricing.dtos

import com.neovisionaries.i18n.CountryCode

data class Address(
    val street: String,
    val coLine: String?,
    val postalCode: String,
    val city: String,
    val country: CountryCode
)