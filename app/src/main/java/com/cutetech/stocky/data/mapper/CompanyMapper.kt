package com.cutetech.stocky.data.mapper

import com.cutetech.stocky.data.local.CompanyListingEntity
import com.cutetech.stocky.data.remote.dto.CompanyInfoDto
import com.cutetech.stocky.domain.model.CompanyInfo
import com.cutetech.stocky.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing() =
    CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange
    )


fun CompanyListing.toCompanyListingEntity() =
    CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange
    )

fun CompanyInfoDto.toCompanyInfo() =
    CompanyInfo(
        symbol = symbol ?: "",
        description = description ?: "",
        name = name ?: "",
        country = country ?: "",
        industry = industry ?: ""
    )