# ApplyMate 📱

**Your AI-Powered Job Application Assistant**

ApplyMate is a comprehensive Android application designed to streamline your job search process with AI-powered features. From resume optimization to interview preparation, ApplyMate helps you land your dream job with confidence.

## ✨ Features

### 🎯 Core Functionality
- **Smart Resume Optimization** - Make your resume ATS-friendly with AI suggestions
- **Document Chat** - Upload documents and ask questions using AI
- **Job Search Integration** - Find relevant job opportunities
- **Referral Message Generator** - Create personalized referral requests
- **Activity Tracking** - Monitor your job application progress

### 🤖 AI-Powered Tools
- **Resume Analysis** - Get detailed feedback on your resume
- **Chat Interface** - Interactive AI assistant for career guidance
- **Document Processing** - Extract and analyze text from uploaded files
- **Personalized Suggestions** - Tailored recommendations based on your profile

## 🏗️ Architecture

ApplyMate follows **Clean Architecture** principles with **MVVM pattern**:

```
📁 app/src/main/java/com/example/applymate/
├── 📁 common/           # Shared utilities and UI states
├── 📁 data/
│   ├── 📁 localDatas/   # Local data sources
│   ├── 📁 model/        # Data models
│   ├── 📁 remote/       # API interfaces
│   └── 📁 repository/   # Repository implementations
├── 📁 di/               # Dependency injection modules
├── 📁 presentation/
│   ├── 📁 components/   # Reusable UI components
│   ├── 📁 navigation/   # Navigation setup
│   ├── 📁 screens/      # Screen composables
│   └── 📁 viewModel/    # ViewModels
└── 📁 utils/            # Utility functions
```

## 🛠️ Tech Stack

### **Frontend**
- **Kotlin** - Primary programming language
- **Jetpack Compose** - Modern UI toolkit
- **Material 3** - Design system
- **Navigation Component** - Screen navigation

### **Architecture & DI**
- **MVVM** - Architectural pattern
- **Dagger Hilt** - Dependency injection
- **Repository Pattern** - Data layer abstraction

### **Networking & Data**
- **Retrofit** - HTTP client
- **OkHttp** - Network interceptor
- **Gson** - JSON serialization
- **Coroutines & Flow** - Asynchronous programming

### **Additional Libraries**
- **Lifecycle Components** - Android lifecycle management
- **Material Icons Extended** - Rich icon set
- **Google Play Services** - Authentication

## 🚀 Getting Started

### Prerequisites
- **Android Studio** Arctic Fox or later
- **JDK 11** or higher
- **Android SDK** (API level 24+)
- **Gradle 8.10.2**

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/ApplyMate.git
   cd ApplyMate
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned directory

3. **Configure API Keys**
   - Create `local.properties` file in the root directory
   - Add your API configuration:
   ```properties
   BASE_URL="your_api_base_url_here"
   ```

4. **Build and Run**
   ```bash
   ./gradlew assembleDebug
   ```
   Or use Android Studio's build button

## 📱 App Screens & Navigation

ApplyMate features a clean, intuitive interface with 5 main screens accessible via bottom navigation:

### 🏠 Dashboard (HomeScreen)
**Your personalized career command center**
- **Welcome Header** - Personalized greeting with motivational message
- **Recent Activities** - Track your latest job search actions and progress
- **Quick Actions Grid** - Fast access to core features:
  - Find Jobs on LinkedIn
  - Optimize Resume (ATS-friendly)
  - Chat with Documents
  - Generate Referral Messages
- **Activity Tracking** - Monitor application progress and success metrics

### 💼 Job Search (JobScreen)
**Smart LinkedIn job discovery powered by AI**
- **Smart Job Finder** - AI-powered job search with LinkedIn integration
- **Advanced Filters** - Filter by role, location, experience level, and keywords
- **Real-time Search** - Live job search with loading states and error handling
- **LinkedIn Integration** - Direct redirection to relevant LinkedIn job listings
- **Search History** - Track previous searches and refine results
- **Keyword Optimization** - AI suggests relevant search terms

### 📄 Resume Optimizer (ResumeScreen)
**AI-powered resume enhancement for ATS compatibility**
- **Document Upload** - Support for PDF/DOC resume uploads
- **Job Description Matching** - Upload JD for targeted optimization
- **Real-time Processing** - Live document analysis with progress indicators
- **Resume Review** - Visual preview of uploaded resume content
- **AI Suggestions** - Detailed improvement recommendations
- **ATS Optimization** - Make resumes scanner-friendly
- **Generate Optimized Resume** - Create tailored versions for specific jobs

### 💬 Chat Interface (ChatScreen)
**Interactive AI assistant for career guidance**
- **Document Upload** - Upload resumes, cover letters, or job descriptions
- **AI-Powered Chat** - Ask questions about uploaded documents
- **Conversation History** - Maintain chat context across sessions
- **Real-time Responses** - Instant AI replies with typing indicators
- **Document Analysis** - Extract insights from career documents
- **Career Guidance** - Get personalized advice and recommendations
- **Multi-format Support** - Handle various document types

### 🤝 Referral Generator (ReferralScreen)
**Create compelling referral messages for networking**
- **Job Details Form** - Input job title, company, and contact information
- **Personalization Fields** - Add custom notes and specific requirements
- **AI Message Generation** - Create professional, personalized referral requests
- **Template Customization** - Modify generated messages to match your style
- **Markdown Support** - Rich text formatting for professional presentation
- **Copy & Share** - Easy sharing via email, LinkedIn, or messaging apps
- **Message History** - Save and reuse successful referral templates

### 🎨 UI/UX Features
- **Material 3 Design** - Modern, accessible interface following Google's design principles
- **Responsive Layout** - Optimized for various screen sizes and orientations
- **Loading States** - Clear feedback during API calls and processing
- **Error Handling** - User-friendly error messages with retry options
- **Bottom Navigation** - Easy switching between main features
- **Consistent Theming** - Unified color scheme and typography throughout
- **Accessibility** - Screen reader support and keyboard navigation

### 📊 State Management
- **MVVM Architecture** - Clean separation of UI and business logic
- **StateFlow & Flow** - Reactive state management with Kotlin Coroutines
- **Hilt Dependency Injection** - Efficient dependency management
- **Repository Pattern** - Centralized data access layer
- **UiState Handling** - Consistent loading, success, error, and idle states

## 🔧 Configuration

### Build Variants
- **Debug** - Development build with logging
- **Release** - Production build with optimizations

### API Configuration
The app uses a configurable base URL for API calls. Set your backend URL in `local.properties`:

```properties
BASE_URL="https://your-api-server.com/api/"
```

## 🧪 Testing

### Unit Tests
```bash
./gradlew test
```

### Instrumented Tests
```bash
./gradlew connectedAndroidTest
```

### Test Coverage
- Repository layer tests
- ViewModel unit tests
- UI component tests

## 📦 Build & Release

### Debug Build
```bash
./gradlew assembleDebug
```

### Release Build
```bash
./gradlew assembleRelease
```

### APK Location
Generated APKs can be found in:
```
app/build/outputs/apk/
```

## 🤝 Contributing

We welcome contributions! Please follow these steps:

1. **Fork the repository**
2. **Create a feature branch**
   ```bash
   git checkout -b feature/amazing-feature
   ```
3. **Commit your changes**
   ```bash
   git commit -m 'Add amazing feature'
   ```
4. **Push to the branch**
   ```bash
   git push origin feature/amazing-feature
   ```
5. **Open a Pull Request**

### Code Style
- Follow [Kotlin coding conventions](https://kotlinlang.org/docs/coding-conventions.html)
- Use meaningful variable and function names
- Add comments for complex logic
- Ensure proper error handling

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- **Android Jetpack** - For providing robust architecture components
- **Material Design** - For beautiful and consistent UI guidelines
- **Kotlin Community** - For the amazing programming language
- **Open Source Contributors** - For the libraries that make this app possible

## 📞 Support

If you encounter any issues or have questions:

- **Create an Issue** - [GitHub Issues](https://github.com/yourusername/ApplyMate/issues)
- **Discussions** - [GitHub Discussions](https://github.com/yourusername/ApplyMate/discussions)

## 🔮 Roadmap

- [ ] **Offline Mode** - Cache data for offline usage
- [ ] **Dark Theme** - Complete dark mode implementation
- [ ] **Multi-language Support** - Internationalization
- [ ] **Advanced Analytics** - Detailed job search insights
- [ ] **Integration APIs** - LinkedIn, Indeed job boards
- [ ] **Push Notifications** - Job alerts and reminders

---

**Made with ❤️ for job seekers everywhere**

*ApplyMate - Your AI companion in the journey to career success*