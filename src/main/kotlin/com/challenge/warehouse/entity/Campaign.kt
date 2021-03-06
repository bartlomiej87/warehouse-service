package com.challenge.warehouse.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.util.*

@Document
data class Campaign(
    @Id
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val campaignDetails: MutableSet<CampaignDetails>
)

data class CampaignDetails(
    val datasourceId: String,
    val adSnapshots: MutableSet<AdSnapshot>,
)

data class AdSnapshot(
    val snapshotDate: LocalDate,
    val clicks: Int,
    val impressions: Int
)