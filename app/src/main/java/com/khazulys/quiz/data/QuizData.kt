package com.khazulys.quiz.data

object QuizData {
    
    private val matematikaQuestions = listOf(
        Question(
            id = 1,
            question = "Berapakah hasil dari 15 + 27?",
            options = listOf("32", "42", "52", "62"),
            correctAnswerIndex = 1,
            timeLimit = 20
        ),
        Question(
            id = 2,
            question = "Berapakah hasil dari 8 × 7?",
            options = listOf("54", "56", "58", "60"),
            correctAnswerIndex = 1,
            timeLimit = 20
        ),
        Question(
            id = 3,
            question = "Berapakah hasil dari 144 ÷ 12?",
            options = listOf("10", "11", "12", "13"),
            correctAnswerIndex = 2,
            timeLimit = 20
        ),
        Question(
            id = 4,
            question = "Berapakah hasil dari 5² (5 pangkat 2)?",
            options = listOf("10", "15", "25", "35"),
            correctAnswerIndex = 2,
            timeLimit = 20
        ),
        Question(
            id = 5,
            question = "Berapakah hasil dari √81?",
            options = listOf("7", "8", "9", "10"),
            correctAnswerIndex = 2,
            timeLimit = 20
        ),
        Question(
            id = 6,
            question = "Jika x + 5 = 12, berapakah nilai x?",
            options = listOf("5", "6", "7", "8"),
            correctAnswerIndex = 2,
            timeLimit = 25
        ),
        Question(
            id = 7,
            question = "Berapakah hasil dari 15% dari 200?",
            options = listOf("20", "25", "30", "35"),
            correctAnswerIndex = 2,
            timeLimit = 30
        ),
        Question(
            id = 8,
            question = "Berapa sisi pada sebuah segi delapan?",
            options = listOf("6", "7", "8", "9"),
            correctAnswerIndex = 2,
            timeLimit = 15
        )
    )

    private val bahasaIndonesiaQuestions = listOf(
        Question(
            id = 1,
            question = "Apa sinonim dari kata 'rajin'?",
            options = listOf("Malas", "Tekun", "Bodoh", "Lemah"),
            correctAnswerIndex = 1,
            timeLimit = 20
        ),
        Question(
            id = 2,
            question = "Apa antonim dari kata 'tinggi'?",
            options = listOf("Rendah", "Besar", "Kecil", "Lebar"),
            correctAnswerIndex = 0,
            timeLimit = 20
        ),
        Question(
            id = 3,
            question = "Manakah yang merupakan kalimat efektif?",
            options = listOf(
                "Dia pergi ke pasar untuk membeli sayur",
                "Dia pergi untuk ke pasar membeli sayur",
                "Untuk membeli sayur dia ke pasar pergi",
                "Ke pasar dia pergi untuk sayur membeli"
            ),
            correctAnswerIndex = 0,
            timeLimit = 30
        ),
        Question(
            id = 4,
            question = "Apa arti kata 'frasa'?",
            options = listOf(
                "Gabungan kata yang membentuk kalimat",
                "Gabungan dua kata atau lebih yang tidak membentuk kalimat",
                "Kata tunggal",
                "Kalimat majemuk"
            ),
            correctAnswerIndex = 1,
            timeLimit = 30
        ),
        Question(
            id = 5,
            question = "Kata baku dari 'apotek' adalah?",
            options = listOf("Apotik", "Apotek", "Apothek", "Apothik"),
            correctAnswerIndex = 0,
            timeLimit = 20
        ),
        Question(
            id = 6,
            question = "Apa imbuhan yang tepat untuk kata 'jalan' menjadi kata kerja?",
            options = listOf("ber-", "me-", "ter-", "pe-"),
            correctAnswerIndex = 0,
            timeLimit = 25
        ),
        Question(
            id = 7,
            question = "Manakah kata yang menggunakan huruf kapital dengan benar?",
            options = listOf(
                "saya tinggal di jakarta",
                "Saya tinggal di Jakarta",
                "Saya Tinggal Di Jakarta",
                "saya Tinggal di jakarta"
            ),
            correctAnswerIndex = 1,
            timeLimit = 25
        )
    )

    private val bahasaInggrisQuestions = listOf(
        Question(
            id = 1,
            question = "What is the past tense of 'go'?",
            options = listOf("Goed", "Went", "Gone", "Going"),
            correctAnswerIndex = 1,
            timeLimit = 20
        ),
        Question(
            id = 2,
            question = "Which one is a pronoun?",
            options = listOf("Run", "Beautiful", "She", "Quickly"),
            correctAnswerIndex = 2,
            timeLimit = 20
        ),
        Question(
            id = 3,
            question = "Choose the correct sentence:",
            options = listOf(
                "He don't like apples",
                "He doesn't likes apples",
                "He doesn't like apples",
                "He not like apples"
            ),
            correctAnswerIndex = 2,
            timeLimit = 25
        ),
        Question(
            id = 4,
            question = "What is the opposite of 'hot'?",
            options = listOf("Warm", "Cool", "Cold", "Freezing"),
            correctAnswerIndex = 2,
            timeLimit = 20
        ),
        Question(
            id = 5,
            question = "Which article is correct: ___ apple",
            options = listOf("a", "an", "the", "no article"),
            correctAnswerIndex = 1,
            timeLimit = 20
        ),
        Question(
            id = 6,
            question = "What is the plural form of 'child'?",
            options = listOf("Childs", "Children", "Childrens", "Childes"),
            correctAnswerIndex = 1,
            timeLimit = 20
        ),
        Question(
            id = 7,
            question = "She ___ to school every day.",
            options = listOf("go", "goes", "going", "gone"),
            correctAnswerIndex = 1,
            timeLimit = 20
        )
    )

    private val ipaQuestions = listOf(
        Question(
            id = 1,
            question = "Planet apa yang dikenal sebagai Planet Merah?",
            options = listOf("Venus", "Mars", "Jupiter", "Saturnus"),
            correctAnswerIndex = 1,
            timeLimit = 20
        ),
        Question(
            id = 2,
            question = "Apa rumus kimia air?",
            options = listOf("H2O", "CO2", "O2", "H2O2"),
            correctAnswerIndex = 0,
            timeLimit = 20
        ),
        Question(
            id = 3,
            question = "Fotosintesis terjadi pada bagian tumbuhan yang bernama?",
            options = listOf("Akar", "Batang", "Daun", "Bunga"),
            correctAnswerIndex = 2,
            timeLimit = 25
        ),
        Question(
            id = 4,
            question = "Satuan untuk mengukur gaya adalah?",
            options = listOf("Joule", "Newton", "Watt", "Pascal"),
            correctAnswerIndex = 1,
            timeLimit = 25
        ),
        Question(
            id = 5,
            question = "Berapa jumlah tulang pada tubuh manusia dewasa?",
            options = listOf("186", "206", "226", "246"),
            correctAnswerIndex = 1,
            timeLimit = 30
        ),
        Question(
            id = 6,
            question = "Apa gas yang dibutuhkan manusia untuk bernapas?",
            options = listOf("Karbon dioksida", "Nitrogen", "Oksigen", "Hidrogen"),
            correctAnswerIndex = 2,
            timeLimit = 20
        ),
        Question(
            id = 7,
            question = "Suhu air mendidih pada tekanan normal adalah?",
            options = listOf("90°C", "100°C", "110°C", "120°C"),
            correctAnswerIndex = 1,
            timeLimit = 20
        )
    )

    private val ipsQuestions = listOf(
        Question(
            id = 1,
            question = "Siapa presiden pertama Indonesia?",
            options = listOf("Soeharto", "Soekarno", "Habibie", "Megawati"),
            correctAnswerIndex = 1,
            timeLimit = 20
        ),
        Question(
            id = 2,
            question = "Indonesia merdeka pada tanggal?",
            options = listOf("17 Agustus 1945", "17 Agustus 1944", "1 Juni 1945", "20 Mei 1945"),
            correctAnswerIndex = 0,
            timeLimit = 20
        ),
        Question(
            id = 3,
            question = "Ibu kota Indonesia adalah?",
            options = listOf("Bandung", "Surabaya", "Jakarta", "Medan"),
            correctAnswerIndex = 2,
            timeLimit = 15
        ),
        Question(
            id = 4,
            question = "Benua terbesar di dunia adalah?",
            options = listOf("Afrika", "Amerika", "Asia", "Eropa"),
            correctAnswerIndex = 2,
            timeLimit = 20
        ),
        Question(
            id = 5,
            question = "Pancasila terdiri dari berapa sila?",
            options = listOf("3", "4", "5", "6"),
            correctAnswerIndex = 2,
            timeLimit = 15
        ),
        Question(
            id = 6,
            question = "Samudra terluas di dunia adalah?",
            options = listOf("Samudra Atlantik", "Samudra Hindia", "Samudra Pasifik", "Samudra Arktik"),
            correctAnswerIndex = 2,
            timeLimit = 25
        ),
        Question(
            id = 7,
            question = "Pahlawan yang dijuluki Bapak Koperasi Indonesia adalah?",
            options = listOf("Ki Hajar Dewantara", "Mohammad Hatta", "Soekarno", "Sudirman"),
            correctAnswerIndex = 1,
            timeLimit = 25
        )
    )
    
    val categories = listOf(
        QuizCategory(
            id = "matematika",
            name = "Matematika",
            description = "Uji kemampuan matematika Anda",
            icon = "📐",
            questions = matematikaQuestions
        ),
        QuizCategory(
            id = "bahasa_indonesia",
            name = "Bahasa Indonesia",
            description = "Uji kemampuan bahasa Indonesia Anda",
            icon = "📚",
            questions = bahasaIndonesiaQuestions
        ),
        QuizCategory(
            id = "bahasa_inggris",
            name = "Bahasa Inggris",
            description = "Test your English skills",
            icon = "🇬🇧",
            questions = bahasaInggrisQuestions
        ),
        QuizCategory(
            id = "ipa",
            name = "IPA (Sains)",
            description = "Uji pengetahuan sains Anda",
            icon = "🔬",
            questions = ipaQuestions
        ),
        QuizCategory(
            id = "ips",
            name = "IPS (Sosial)",
            description = "Uji pengetahuan sosial Anda",
            icon = "🌍",
            questions = ipsQuestions
        )
    )
}
