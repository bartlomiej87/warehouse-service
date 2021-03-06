package com.challenge.warehouse.repository

import com.challenge.warehouse.model.AnalyticsView
import com.challenge.warehouse.model.Metric
import com.challenge.warehouse.model.TopCampaignRequest
import java.time.LocalDate

interface AnalyticsAggregatorRepository {
    fun aggregateByDatasource(metrics: Set<Metric>, dateFrom: LocalDate?, dateTo: LocalDate?): List<AnalyticsView>
    fun aggregateByCampaign(metrics: Set<Metric>, dateFrom: LocalDate?, dateTo: LocalDate?): List<AnalyticsView>
    fun aggregateWithoutDimension(metrics: Set<Metric>, dateFrom: LocalDate?, dateTo: LocalDate?): List<AnalyticsView>
    fun findTopCampaign(topCampaignRequest: TopCampaignRequest): List<AnalyticsView>
}