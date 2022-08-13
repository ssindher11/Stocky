package com.cutetech.stocky.data.csv

import com.cutetech.stocky.data.mapper.toIntraDayInfo
import com.cutetech.stocky.data.remote.dto.IntraDayInfoDto
import com.cutetech.stocky.domain.model.IntraDayInfo
import com.opencsv.CSVReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.io.InputStreamReader
import java.time.LocalDate
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IntraDayInfoParser @Inject constructor() : CSVParser<IntraDayInfo> {

    override suspend fun parse(stream: InputStream): List<IntraDayInfo> {
        val csvReader = CSVReader(InputStreamReader(stream))
        return withContext(Dispatchers.IO) {
            val completeList = csvReader
                .readAll()
                .drop(1)
                .mapNotNull { line ->
                    val timestamp = line.getOrNull(0) ?: return@mapNotNull null
                    val close = line.getOrNull(4) ?: return@mapNotNull null
                    val dto = IntraDayInfoDto(timestamp, close.toDouble())
                    dto.toIntraDayInfo()
                }
            csvReader.close()
            var daysToSubtract = 1L
            var tempList: MutableList<IntraDayInfo>
            do {
                tempList = completeList
                    .filter {
                        it.date.dayOfMonth == LocalDate.now().minusDays(daysToSubtract).dayOfMonth
                    }.toMutableList()
                daysToSubtract++
            } while (tempList.isEmpty())
            tempList.sortedBy { it.date.hour }
        }
    }
}