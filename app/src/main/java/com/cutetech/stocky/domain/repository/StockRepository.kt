package com.cutetech.stocky.domain.repository

import com.cutetech.stocky.domain.model.CompanyInfo
import com.cutetech.stocky.domain.model.CompanyListing
import com.cutetech.stocky.domain.model.IntraDayInfo
import com.cutetech.stocky.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String,
    ): Flow<Resource<List<CompanyListing>>>

    suspend fun getIntraDayInfo(symbol: String): Resource<List<IntraDayInfo>>

    suspend fun getCompanyInfo(symbol: String): Resource<CompanyInfo>
}