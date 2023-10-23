package com.darrenthiores.betrbeta.data.packages.remote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PackagesResponse(
    val packagesData: List<PackagesData>,
    val parsedPackagesData: List<ParsedPackagesData>
) {
    @Serializable
    data class PackagesData(
        val adSupported: Boolean,
        val androidMaxVersion: String,
        val androidVersion: String,
        val androidVersionText: String,
        val appId: String,
        val available: Boolean,
        val categories: List<Category>,
        val comments: List<String>,
        val contentRating: String,
        val currency: String,
        val description: String,
        val descriptionHTML: String,
        val developer: String,
        val developerAddress: String,
        val developerEmail: String,
        val developerId: String,
        val developerInternalID: String,
        val developerWebsite: String,
        val earlyAccessEnabled: Boolean,
        val free: Boolean,
        val genre: String,
        val genreId: String,
        val headerImage: String,
        val histogram: Histogram,
        val icon: String,
        val installs: String,
        val isAvailableInPlayPass: Boolean,
        val lastUserUpdateDate: String,
        val maxInstalls: Long,
        val minInstalls: Long,
        val offersIAP: Boolean,
        val preregister: Boolean,
        val price: Int,
        val priceText: String,
        val privacyPolicy: String,
        val ratings: Int,
        val recentChanges: String,
        val released: String,
        val releasesDetails: ReleasesDetails,
        val reviews: Int,
        val score: Double,
        val scoreText: String,
        val screenshots: List<String>,
        val summary: String,
        val title: String,
        val updated: Long,
        val url: String,
        val version: String
    )

    @Serializable
    data class ParsedPackagesData(
        val appName: String,
        val developerUpdateDate: String,
        val fromPlayStore: Boolean,
        val genreId: String,
        val icon: String,
        val outOfDateBy: Int,
        val packageName: String,
        val releaseAge: Int,
        val releaseNotes: String,
        val updateCategory: List<String>,
        val version: String
    )

    @Serializable
    data class Category(
        val id: String,
        val name: String
    )

    @Serializable
    data class Histogram(
        @SerialName("1")
        val one: Int,
        @SerialName("2")
        val two: Int,
        @SerialName("3")
        val three: Int,
        @SerialName("4")
        val four: Int,
        @SerialName("5")
        val five: Int
    )

    @Serializable
    data class ReleasesDetails(
        val releaseName1: ReleaseName,
        val releaseName2: ReleaseName
    )

    @Serializable
    data class ReleaseName(
        val developerUpdateDate: String,
        val releaseClassification: String,
        val releaseNotes: String
    )
}