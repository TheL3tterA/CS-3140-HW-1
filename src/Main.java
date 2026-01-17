void main(){
    String[] sonnetWords = {
            "Two", "households,", "both", "alike", "in", "dignity,",
            "In", "fair", "Verona,", "where", "we", "lay", "our", "scene,",
            "From", "ancient", "grudge", "break", "to", "new", "mutiny,",
            "Where", "civil", "blood", "makes", "civil", "hands", "unclean.",
            "From", "forth", "the", "fatal", "loins", "of", "these", "two", "foes",
            "A", "pair", "of", "star-cross’d", "lovers", "take", "their", "life;",
            "Whose", "misadventured", "piteous", "overthrows",
            "Do", "with", "their", "death", "bury", "their", "parents’", "strife.",
            "The", "fearful", "passage", "of", "their", "death-mark’d", "love,",
            "And", "the", "continuance", "of", "their", "parents’", "rage,",
            "Which,", "but", "their", "children’s", "end,", "nought", "could", "remove,",
            "Is", "now", "the", "two", "hours’", "traffic", "of", "our", "stage;",
            "The", "which", "if", "you", "with", "patient", "ears", "attend,",
            "What", "here", "shall", "miss,", "our", "toil", "shall", "strive", "to", "mend."
    };
    // variable declarations
    int wordCount = 0; // 106
    int correctGuesses = 0;
    int wrongGuesses = 0;
    Scanner input = new Scanner(System.in);

    // count words in given sonnet array
    for(String sonnetWord : sonnetWords) {
        wordCount++;
    }

    // loop for playing the game
    while(correctGuesses < 3 && wrongGuesses < 3) {
        int randomWord = new Random().nextInt(wordCount-1);
        String wordToGuess = sonnetWords[randomWord];

        // copy the array to a new sliced array then join every word together
        String[] copyOfSonnet = Arrays.copyOfRange(sonnetWords,  0, randomWord);
        String sonnet = String.join(" ", copyOfSonnet);
        IO.println(sonnet);

//        IO.println("Guess: " + wordToGuess); // for debugging comment out for product

        // pauses program for player to input guess
        String guessedWord = input.next();

        // guess logic
        if (guessedWord.equals(wordToGuess)) {
            correctGuesses++;
            IO.println("Correct!");
        }
        else {
            wrongGuesses++;
            IO.println("Wrong!");
        }
    }

    IO.println(); // prints new line for separation of println
    if (correctGuesses == 3) {
        IO.println("You Win! Thanks for playing!");
    }
    else {
        IO.println("You Lose! Thanks for playing!");
    }
}