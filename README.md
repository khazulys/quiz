# Quiz App

Aplikasi kuis interaktif berbasis Android yang dibangun dengan Kotlin dan Jetpack Compose.

## ✨ Fitur

- 🎯 **5 Kategori Mata Pelajaran**: Matematika, Bahasa Indonesia, Bahasa Inggris, IPA, dan IPS
- ⏱️ **Timer Countdown**: Setiap soal memiliki batas waktu yang harus diselesaikan
- 🎨 **UI Modern**: Menggunakan Jetpack Compose dan Material Design 3
- 📊 **Summary Lengkap**: Menampilkan skor, jawaban benar, salah, dan tidak terjawab
- 🔄 **Auto Submit**: Jawaban otomatis tersubmit jika waktu habis
- 📱 **Responsive Design**: Tampilan yang optimal di berbagai ukuran layar

## 🛠️ Teknologi

- **Kotlin** - Bahasa pemrograman utama
- **Jetpack Compose** - UI toolkit modern untuk Android
- **Material Design 3** - Design system dari Google
- **ViewModel** - Untuk state management
- **Navigation Compose** - Untuk navigasi antar screen

## 📸 Screenshot

### Home Screen
Menu pilihan kategori kuis dengan berbagai mata pelajaran.

### Quiz Screen
Soal kuis dengan timer countdown dan pilihan jawaban interaktif.

### Summary Screen
Hasil akhir dengan detail skor dan performa.

## 🚀 Build

Project ini menggunakan Gradle dan dapat di-build menggunakan GitHub Actions.

### Build Locally

```bash
./gradlew assembleDebug
```

APK akan dihasilkan di `app/build/outputs/apk/debug/`

### Build Release

```bash
./gradlew assembleRelease
```

## 📋 GitHub Actions

Project ini dikonfigurasi dengan GitHub Actions untuk otomatis build APK setiap kali ada push ke branch main/master.

Hasil build dapat didownload dari tab **Actions** di GitHub repository.

## 📱 Requirements

- Android SDK 24+ (Android 7.0 Nougat atau lebih tinggi)
- Kotlin 1.9.20
- Gradle 8.2.0
- JDK 17

## 📝 Struktur Kuis

Setiap kategori kuis memiliki:
- 7-8 soal pilihan ganda
- Timer 15-30 detik per soal
- 4 pilihan jawaban
- Feedback instan setelah submit

## 🎯 Cara Menggunakan

1. Pilih kategori kuis dari home screen
2. Baca soal dan pilih jawaban sebelum waktu habis
3. Klik "Submit Jawaban" untuk melihat hasilnya
4. Lanjut ke soal berikutnya atau lihat hasil akhir
5. Restart kuis atau kembali ke menu utama

## 📄 License

MIT License
