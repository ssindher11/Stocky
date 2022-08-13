package com.cutetech.stocky.presentation.company_info

import com.cutetech.stocky.domain.model.CompanyInfo
import com.cutetech.stocky.domain.model.IntraDayInfo

data class CompanyInfoState(
    val stockInfos: List<IntraDayInfo> = emptyList(),
    val company: CompanyInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
