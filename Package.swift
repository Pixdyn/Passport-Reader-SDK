// swift-tools-version: 6.0

import PackageDescription

let package = Package(
    name: "PixlPassportReader",
    platforms: [
        .iOS(.v15)
    ],
    products: [
        .library(
            name: "PixlPassportReader",
            targets: ["PixlPassportReader"]
        )
    ],
    targets: [
        .binaryTarget(
            name: "PixlPassportReader",
            url: "https://github.com/Pixdyn/Passport-Reader-SDK/releases/download/v1.0.0/PixlPassportReader.xcframework.zip",
            checksum: "208242470e38d9be6c9cf5445cd4e78b0a857d6568934793dbf3ab8c903234c9"
        )
    ]
)