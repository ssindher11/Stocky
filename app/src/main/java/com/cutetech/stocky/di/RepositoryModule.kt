package com.cutetech.stocky.di

import com.cutetech.stocky.data.csv.CSVParser
import com.cutetech.stocky.data.csv.CompanyListingParser
import com.cutetech.stocky.data.csv.IntraDayInfoParser
import com.cutetech.stocky.data.repository.StockRepositoryImpl
import com.cutetech.stocky.domain.model.CompanyListing
import com.cutetech.stocky.domain.model.IntraDayInfo
import com.cutetech.stocky.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingsParser(
        companyListingParser: CompanyListingParser
    ): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindIntraDayInfoParser(
        intraDayInfoParser: IntraDayInfoParser
    ): CSVParser<IntraDayInfo>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
}