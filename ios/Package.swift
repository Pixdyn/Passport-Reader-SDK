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
            path: "./PixlPassportReader.xcframework"
        )
    ]
)