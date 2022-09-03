package com.nilsnahooy.quizapp

object Constants {
    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()
        val q1 = Question(
            1, "To which country does this flag belong?",
            R.drawable.ic_flag_of_argentina,
            arrayListOf("Argentina", "Austria", "Belgium", "None of the above"),
            0
        )
        val q2 = Question(
            2, "To which country does this flag belong?",
            R.drawable.ic_flag_of_australia,
            arrayListOf("Austria", "Australia", "Fiji", "None of the above"),
            1
        )
        val q3 = Question(
            3, "To which country does this flag belong?",
            R.drawable.ic_flag_of_belgium,
            arrayListOf("Germany", "France", "Belgium", "None of the above"),
            2
        )
        val q4 = Question(
            4, "To which country does this flag belong?",
            R.drawable.ic_flag_of_brazil,
            arrayListOf("Argentina", "Austria", "Belgium", "None of the above"),
            3
        )
        val q5 = Question(
            5, "What is the capitol of the country this flag belongs to?",
            R.drawable.ic_flag_of_denmark,
            arrayListOf("Stockholm", "Madrid", "Copenhagen", "Amsterdam"),
            2
        )
        val q6 = Question(
            6, "This flag can be easily confused with the flag for which country?",
            R.drawable.ic_flag_of_fiji,
            arrayListOf("Argentina", "Austria", "Australia", "Fiji"),
            2
        )
        val q7 = Question(
            7, "To which country does this flag belong?",
            R.drawable.ic_flag_of_germany,
            arrayListOf("Germany", "Austria", "Belgium", "Switzerland"),
            0
        )
        val q8 = Question(
            8, "For which company does this country provide tech support?",
            R.drawable.ic_flag_of_india,
            arrayListOf("Apple", "Google", "Microsoft", "All of the above"),
            3
        )
        val q9 = Question(
            9, "To which country does this flag belong?",
            R.drawable.ic_flag_of_kuwait,
            arrayListOf("Shell", "Q8", "Texaco", "I don't get it?"),
            1
        )
        val q10 = Question(
            10, "To which country does this flag belong?",
            R.drawable.ic_flag_of_new_zealand,
            arrayListOf("Great Britain", "Fiji", "Australia", "None of the above"),
            3
        )
        val tempList = mutableListOf(q1, q2, q3, q4, q5, q6, q7, q8, q9, q10)
        tempList.shuffle()
        questionList.addAll(tempList)
        return questionList
    }
}