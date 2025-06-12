
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

```

presentation/
│   ├── viewmodels/
│   ├── ui/ (composables, screens)
│   └── state/ (UiState, UiEvent, UiEffect)
domain/
│   ├── usecases/
│   └── models/
data/
│   ├── repository/
│   ├── remote/ (API, DTOs)
│   └── local/ (Room, DAO, Entities)
di/
│   ├── AppModule.kt
│   └── DataModule.kt

````

---

## 🧪 Tech Stack

| Layer          | Technology                        |
|----------------|-----------------------------------|
| UI             | Jetpack Compose, Material 3       |
| State mgmt     | Kotlin StateFlow, UDF             |
| Navigation     | Navigation-Compose (v3)           |
| Persistence    | Room, DAO                         |
| Network        | Retrofit, OkHttp                  |
| DI             | Hilt                              |
| Architecture   | Clean Architecture (3 Layers)     |
| Testing        | JUnit, Turbine, Compose UI Tests  |

---

## 📸 Screenshots

> _Add screenshots here if available_

---

## 🛠️ Setup Instructions

```bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
./gradlew build
````

* Open in **Android Studio Hedgehog or later**
* Run the app on emulator or device

---

## 💡 Key Concepts

* **Room** used for offline caching and persistence
* **Compose `LazyColumn`** displays list of items from local/remote source
* **ViewModel** emits `UiState` using `StateFlow`
* **Navigation 3** uses `object` routes, not strings, for safer navigation
* **Bottom Navigation** maintains individual back stack using `NavigationHost`
* **UseCases** encapsulate business logic, injected into ViewModels

---

## 🧪 Testing

```bash
./gradlew test
```

Includes:

* [ ] Unit tests for UseCases
* [ ] DAO tests using in-memory Room DB
* [ ] ViewModel tests using Turbine
* [ ] Compose UI tests

---

## 🚀 Upcoming Improvements

* [ ] Add Paging 3 for large data sets
* [ ] Add offline sync with WorkManager
* [ ] Add theming and dark mode
* [ ] Implement shared element transitions

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🙌 Credits

Built with ❤️ by [Your Name](https://github.com/your-username)

```

---

Would you like me to:
- Generate the `Routes` object sample?
- Provide DAO + Room example with mappers?
- Add GitHub badges (build status, license, etc.)?

Let me know and I’ll update the README accordingly.
```
