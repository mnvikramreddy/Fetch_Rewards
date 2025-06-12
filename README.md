
# 🚀 Jetpack Compose Clean Architecture App

A **Jetpack Compose** application built using **Modern Clean Architecture**, **Room Database**, **UDF (Unidirectional Data Flow)** pattern, and **Navigation 3 API**. It features **bottom navigation with nested graphs**, **multiple back stacks**, and **data persistence using Room**.

---

## 📱 Features

- 🧱 **Jetpack Compose UI**
- 🧠 **UDF (Unidirectional Data Flow)** with `UiState`, `UiEffect`, `UiEvent`
- 🔁 **StateFlow** for reactive UI
- 📡 **Network Data** with Retrofit
- 🗃️ **Local Caching with Room**
- 🧭 **Navigation 3 API** (object routes, not string-based)
- 🧭 **Bottom Navigation with Nested Graphs & Multiple Back Stacks**
- 🔍 **Details screen navigation with safe arguments**
- 🧪 **Unit & UI Testing**
- ✅ **Modern Clean Architecture (Data / Domain / Presentation layers)**

---

## 🧱 Architecture Overview

presentation/
│ ├── viewmodels/
│ ├── ui/ (composables, screens)
│ └── state/ (UiState, UiEvent, UiEffect)
domain/
│ ├── usecases/
│ └── models/
data/
│ ├── repository/
│ ├── remote/ (API, DTOs)
│ └── local/ (Room, DAO, Entities)
di/
│ ├── AppModule.kt
│ └── DataModule.kt
