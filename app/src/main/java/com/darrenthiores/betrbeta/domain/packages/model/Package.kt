package com.darrenthiores.betrbeta.domain.packages.model

data class Package(
    val data: Data,
    val parsed: Parsed
) {
    data class Data(
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
    
    data class Parsed(
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

    data class Category(
        val id: String,
        val name: String
    )

    data class Histogram(
        val one: Int,
        val two: Int,
        val three: Int,
        val four: Int,
        val five: Int
    )

    data class ReleasesDetails(
        val releaseName1: ReleaseName,
        val releaseName2: ReleaseName
    )

    data class ReleaseName(
        val developerUpdateDate: String,
        val releaseClassification: String,
        val releaseNotes: String
    )
}
