# PIXL Passport Reader SDK

**AI-driven passport scanning and identity verification — fast, secure, and fully offline.**

PIXL Passport Reader is a powerful AI-driven passport scanning and identity verification SDK designed for fast, secure, and fully offline document processing. It enables seamless scanning, reading, and verification of passports, visas, and national ID cards directly on-device — with no data ever leaving the user's phone.

Built with a **privacy-first approach**, PIXL Passport Reader performs **100% on-device processing**, ensuring that no personal data, passport information, or document images are uploaded to the cloud. This makes it an ideal solution for security-sensitive environments, including eKYC, banking, fintech, travel, immigration, hospitality, and government applications.

The SDK leverages advanced OCR, NFC passport reading, MRZ recognition, and AI-powered document verification to deliver highly accurate identity data extraction while minimizing manual effort and reducing fraud risk.

---

## ✨ Key Features

- 🔒 **100% Offline, On-Device Processing** — no data ever leaves the device
- 🤖 **AI-Powered Passport, Visa, and ID Card Scanning**
- 📡 **NFC ePassport Reading and Authentication**
- 🔍 **High-Accuracy OCR and MRZ Data Extraction**
- ⚡ **Fast, Secure, and Privacy-Focused Identity Verification**
- 🛠️ **Developer-Friendly Integration**
- ✈️ **Optimized for eKYC, Customer Onboarding, Border Control, and Travel Applications**

---

## 🔑 Get Your Free API Key

Start your free trial and get an API key to begin integrating PIXL Passport Reader:

👉 [https://accounts.pixl.ai/register?productKey=PSDK001](https://accounts.pixl.ai/register?productKey=PSDK001)

---

## 📦 Installation

### 1. Add the repositories

In your **`settings.gradle`** (or `settings.gradle.kts`):

```gradle
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://pixdyn.github.io/Passport-Reader-SDK") }
        maven { url = uri("https://jitpack.io") }
    }
}
```

### 2. Add the dependency

In your module-level **`build.gradle`**:

```gradle
dependencies {
    implementation("com.pixl:passport-reader:1.0.3")
}
```

### 3. Update `gradle.properties`

```properties
android.uniquePackageNames=false
```

---

## 🚀 Usage

### 1. Implement the result callback

Have your `Activity` implement `PixlResultCallback` to receive scan results:

```kotlin
package com.pixl.pixlreader

class MainActivity : ComponentActivity(), PixlResultCallback {

    override fun onScanDataSuccess(passportInfoJson: String) {
        Log.e("PassportResult", "onScanDataSuccess: $passportInfoJson")
    }

    override fun onNFCScanSuccess(
        passportInfoJson: String,
        bitmap: Bitmap
    ) {
        Log.e("PassportResult", "onNFCScanSuccess: $passportInfoJson")
    }

    override fun onScanError(errorCode: String, errorMessage: String) {
        Log.e("ScanError", "onScanError: $errorCode, $errorMessage")
    }
}
```

### 2. Launch the scan activity

```kotlin
private fun startPassportScanActivity() {
    runOnUiThread {
        val apiKey = "YOUR_API_KEY"

        val intent = Intent(this@MainActivity, MRZScanActivity::class.java).apply {
            putExtra(MRZScanActivity.EXTRA_API_KEY, apiKey)
        }

        MRZScanActivity.isNFCBased = false // set to true to enable NFC-based scanning
        MRZScanActivity.scanResultCallback(this@MainActivity)
        startActivity(intent)
    }
}
```

> 🔑 Replace `"YOUR_API_KEY"` with the API key issued for your application.
> Set `MRZScanActivity.isNFCBased = true` to enable NFC ePassport chip reading in addition to MRZ/OCR scanning.

---

## 📋 Callback Reference

| Callback | Description |
|---|---|
| `onScanDataSuccess(passportInfoJson: String)` | Called when MRZ/OCR scanning completes successfully. Returns extracted document data as a JSON string. |
| `onNFCScanSuccess(passportInfoJson: String, bitmap: Bitmap)` | Called when NFC chip reading completes successfully. Returns document data as JSON plus the document photo as a `Bitmap`. |
| `onScanError(errorCode: String, errorMessage: String)` | Called when scanning fails. Provides an error code and human-readable message. |

---

## 🧩 Use Cases

- eKYC & digital onboarding
- Banking & fintech identity verification
- Border control & immigration checkpoints
- Travel & hospitality guest check-in
- Government and enterprise ID verification systems

---

## 🔐 Privacy & Security

PIXL Passport Reader is designed for security-sensitive deployments:

- No document images or extracted data are transmitted to external servers
- All OCR, MRZ, and NFC processing happens locally on-device
- Suitable for environments with strict data residency and compliance requirements

---

## 📄 License

See [LICENSE](LICENSE) for details.

## 🤝 Support

For integration help, issues, or feature requests, please open an issue in this repository.

## 🌐 Website

[https://passportsdk.ai/](https://passportsdk.ai/)

## 📞 Contact Info

- ✉️ Email: [connect@pixl.ai](mailto:connect@pixl.ai)
- 📱 Phone: +91 7994431750
