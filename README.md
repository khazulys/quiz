# Quiz App

A simple quiz application built with Kotlin for Android.

## Features

- Multiple choice questions
- Score tracking
- Instant feedback on answers
- Restart quiz functionality

## Build

This project uses Gradle and can be built using GitHub Actions.

### Building locally

```bash
./gradlew assembleDebug
```

The APK will be generated in `app/build/outputs/apk/debug/`

## GitHub Actions

The project is configured with GitHub Actions to automatically build APK on every push to main/master branch.

## Requirements

- Android SDK 24+
- Kotlin 1.9.20
- Gradle 8.2.0
