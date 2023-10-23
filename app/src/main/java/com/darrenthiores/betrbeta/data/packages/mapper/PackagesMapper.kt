package com.darrenthiores.betrbeta.data.packages.mapper

import com.darrenthiores.betrbeta.data.packages.remote.dto.request.GetPackagesByNameRequest
import com.darrenthiores.betrbeta.data.packages.remote.dto.response.PackagesResponse
import com.darrenthiores.betrbeta.domain.packages.model.Package
import com.darrenthiores.betrbeta.domain.packages.model.PackageRequest

fun PackageRequest.toPackageRequest(): GetPackagesByNameRequest.PackageRequest {
    return GetPackagesByNameRequest.PackageRequest(
        name = name,
        lastUserUpdateDate = lastUserUpdateDare
    )
}

fun PackagesResponse.toPackages(): List<Package> {
    val size = minOf(packagesData.size, parsedPackagesData.size)
    val packages = mutableListOf<Package>()

    repeat(size) { index ->
        val data = packagesData.getOrNull(index)
        val parsed = parsedPackagesData.getOrNull(index)

        if (data != null && parsed != null) {
            packages.add(
                Package(
                    data = Package.Data(
                        adSupported = data.adSupported,
                        androidMaxVersion = data.androidVersion,
                        androidVersion = data.androidMaxVersion,
                        androidVersionText = data.androidVersionText,
                        appId = data.appId,
                        available = data.available,
                        categories = data.categories.map {
                            Package.Category(
                                id = it.id,
                                name = it.name
                            )
                        },
                        comments = data.comments,
                        contentRating = data.contentRating,
                        currency = data.currency,
                        description = data.description,
                        descriptionHTML = data.descriptionHTML,
                        developer = data.developer,
                        developerAddress = data.developerAddress,
                        developerEmail = data.developerEmail,
                        developerId = data.developerId,
                        developerInternalID = data.developerInternalID,
                        developerWebsite = data.developerWebsite,
                        earlyAccessEnabled = data.earlyAccessEnabled,
                        free = data.free,
                        genre = data.genre,
                        genreId = data.genreId,
                        headerImage = data.headerImage,
                        histogram = Package.Histogram(
                            one = data.histogram.one,
                            two = data.histogram.two,
                            three = data.histogram.three,
                            four = data.histogram.four,
                            five = data.histogram.five
                        ),
                        icon = data.icon,
                        installs = data.installs,
                        isAvailableInPlayPass = data.isAvailableInPlayPass,
                        lastUserUpdateDate = data.lastUserUpdateDate,
                        maxInstalls = data.maxInstalls,
                        minInstalls = data.minInstalls,
                        offersIAP = data.offersIAP,
                        preregister = data.preregister,
                        price = data.price,
                        priceText = data.priceText,
                        privacyPolicy = data.privacyPolicy,
                        ratings = data.ratings,
                        recentChanges = data.recentChanges,
                        released = data.released,
                        releasesDetails = Package.ReleasesDetails(
                            releaseName1 = Package.ReleaseName(
                                developerUpdateDate = data.releasesDetails.releaseName1.developerUpdateDate,
                                releaseClassification = data.releasesDetails.releaseName1.releaseClassification,
                                releaseNotes = data.releasesDetails.releaseName1.releaseNotes
                            ),
                            releaseName2 = Package.ReleaseName(
                                developerUpdateDate = data.releasesDetails.releaseName2.developerUpdateDate,
                                releaseClassification = data.releasesDetails.releaseName2.releaseClassification,
                                releaseNotes = data.releasesDetails.releaseName2.releaseNotes
                            )
                        ),
                        reviews = data.reviews,
                        score = data.score,
                        scoreText = data.scoreText,
                        screenshots = data.screenshots,
                        summary = data.summary,
                        title = data.title,
                        updated = data.updated,
                        url = data.url,
                        version = data.version
                    ),
                    parsed = Package.Parsed(
                        appName = parsed.appName,
                        developerUpdateDate = parsed.developerUpdateDate,
                        fromPlayStore = parsed.fromPlayStore,
                        genreId = parsed.genreId,
                        icon = parsed.icon,
                        outOfDateBy = parsed.outOfDateBy,
                        packageName = parsed.packageName,
                        releaseAge = parsed.releaseAge,
                        releaseNotes = parsed.releaseNotes,
                        updateCategory = parsed.updateCategory,
                        version = parsed.version
                    )
                )
            )
        }
    }

    return packages.toList()
}