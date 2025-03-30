package com.prawin.cinescope.model

data class Filter(
    val filterId: Int,
    val filterName: String,
    val subFilters: List<SubFilter>,
    val isSelected: Boolean
)

data class SubFilter(val subFilterId: Int, val subFilterName: String, var isChecked: Boolean)
