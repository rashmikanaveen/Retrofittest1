# Retrofit Test 1 - Stock Symbol Viewer

An Android application built with Kotlin and Jetpack Compose that fetches and displays stock symbols using Retrofit and the Finnhub API.

## Features

- Fetches stock symbols from Finnhub API
- Modern UI built with Jetpack Compose
- Clean Architecture with MVVM pattern
- Retrofit for networking
- Kotlin Coroutines for asynchronous operations

## Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Networking**: Retrofit 3.0.0 + Gson Converter
- **Architecture**: MVVM (Model-View-ViewModel)
- **Lifecycle**: ViewModel Compose 2.10.0
- **Min SDK**: 26 (Android 8.0)
- **Target SDK**: 36

## Prerequisites

Before you begin, ensure you have the following installed:

- [Android Studio](https://developer.android.com/studio) (Latest version recommended)
- JDK 11 or higher
- Android SDK with API level 36
- Git (optional, for cloning the repository)

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/rashmikanaveen/Retrofittest1.git
cd Retrofittest1
```

Or download the ZIP file and extract it.

### 2. Get Your Finnhub API Key

This application uses the [Finnhub API](https://finnhub.io/) to fetch stock data. You'll need to obtain a free API key:

1. Go to [https://finnhub.io/](https://finnhub.io/)
2. Click on **"Get free api key"** or **"Sign Up"**
3. Create an account (you can sign up with Google, GitHub, or email)
4. Once logged in, you'll find your API key on the dashboard
5. Copy your API key (it looks something like: `c1234567890abcdefg`)

### 3. Configure the API Key

**IMPORTANT**: Never commit your API key to version control!

#### Create `local.properties` file

1. In the **root directory** of the project (same level as `build.gradle.kts`), create a file named `local.properties` if it doesn't exist
2. Add your Finnhub API key to the file:

```properties
## This file must *NOT* be checked into Version Control Systems,
# as it contains information specific to your local configuration.



# Finnhub API Key
FINNHUB_API_KEY=your_actual_api_key_here
```

**Replace** `your_actual_api_key_here` with your actual Finnhub API key.

**Example**:
```properties
FINNHUB_API_KEY=c1234567890abcdefg
```

> **Note**: The `local.properties` file is already included in `.gitignore` to prevent accidentally committing sensitive information.

### 4. Sync and Build the Project

1. Open the project in **Android Studio**
2. Wait for Gradle to sync (this may take a few minutes the first time)
3. If prompted, accept any SDK licenses
4. Once synced, click **Build** → **Make Project** or press `Ctrl+F9` (Windows/Linux) or `Cmd+F9` (Mac)

### 5. Run the Application

1. Connect an Android device via USB with **USB Debugging enabled**, or start an **Android Emulator**
2. Click the **Run** button (green play icon) or press `Shift+F10` (Windows/Linux) or `Ctrl+R` (Mac)
3. Select your device/emulator from the list
4. The app will install and launch automatically

## Project Structure

```
app/
├── src/
│   └── main/
│       ├── java/com/example/retrofit_test1/
│       │   ├── data/
│       │   │   ├── api/
│       │   │   │   ├── ApiService.kt          # Retrofit API interface
│       │   │   │   └── RetrofitInstance.kt    # Retrofit client setup
│       │   │   ├── models/
│       │   │   │   ├── StockSymbol.kt         # Stock data model
│       │   │   │   └── UiState.kt             # UI state management
│       │   │   └── repository/
│       │   │       └── StockRepository.kt     # Data repository
│       │   ├── ui/
│       │   │   ├── screens/
│       │   │   │   └── StockListScreen.kt     # Main UI screen
│       │   │   ├── viewmodel/
│       │   │   │   └── StockViewModel.kt      # ViewModel logic
│       │   │   └── theme/                     # Compose theme files
│       │   └── MainActivity.kt
│       └── res/                                # Resources (layouts, values, etc.)
└── build.gradle.kts                            # App-level Gradle config
```

## How It Works

1. **API Service** (`ApiService.kt`): Defines the Retrofit API endpoints
2. **Repository** (`StockRepository.kt`): Handles data fetching logic
3. **ViewModel** (`StockViewModel.kt`): Manages UI state and business logic
4. **UI Screen** (`StockListScreen.kt`): Displays the stock symbols using Compose

The app fetches stock symbols from the Finnhub API and displays them in a list format.

## Troubleshooting

### Build Failed - API Key Error

**Error**: `FINNHUB_API_KEY not found`

**Solution**: Make sure you've created the `local.properties` file in the root directory with your API key.

### Network Error / Empty List

**Possible causes**:
- Invalid API key
- No internet connection
- API rate limit exceeded (free tier has limits)

**Solution**: Check your internet connection and verify your API key is correct.

### Gradle Sync Failed

**Solution**: 
- Try **File** → **Invalidate Caches** → **Invalidate and Restart**
- Ensure you have a stable internet connection for downloading dependencies

## Dependencies

Key dependencies used in this project:

```kotlin
// Retrofit for networking
implementation("com.squareup.retrofit2:retrofit:3.0.0")
implementation("com.squareup.retrofit2:converter-gson:3.0.0")

// Jetpack Compose
implementation(platform("androidx.compose:compose-bom:2024.09.00"))
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.material3:material3")

// ViewModel Compose
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.10.0")
```

## API Reference

This app uses the **Finnhub Stock API**:

- **Base URL**: `https://finnhub.io/api/v1/`
- **Endpoint**: `/stock/symbol`
- **Documentation**: [https://finnhub.io/docs/api](https://finnhub.io/docs/api)

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is open source and available for educational purposes.

## Contact

**Rashmika Naveen** - [@rashmikanaveen](https://github.com/rashmikanaveen)

Project Link: [https://github.com/rashmikanaveen/Retrofittest1](https://github.com/rashmikanaveen/Retrofittest1)

## Acknowledgments

- [Finnhub API](https://finnhub.io/) for providing free stock market data
- [Retrofit](https://square.github.io/retrofit/) by Square
- [Jetpack Compose](https://developer.android.com/jetpack/compose) by Google
