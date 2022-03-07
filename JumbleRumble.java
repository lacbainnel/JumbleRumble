import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JumbleRumble {
    Integer score = 0;
    Integer guess = 3;
    private static final ArrayList<String> score1_easy1 = new ArrayList<String> (Arrays.asList("ear", "pat", "won", "top", "cat"));
    private static final ArrayList<String> score2_easy1 = new ArrayList<String> (Arrays.asList("era", "apt", "own", "opt", "act"));
    //private static final String[] score1_easy1 = new String[] {"ear", "pat", "won", "top", "cat"};
    //private static final String[] score2_easy1 = new String[] {"era", "apt", "own", "opt", "act"};

    public static void main (String[] args) {
        JumbleRumble jr = new JumbleRumble();
        jr.mainGame();
    }

    private void mainGame() {
        Scanner sc = new Scanner(System.in);
        //String test = Arrays.toString(score1_easy1);
        // String test = TextUtils.join("",score1_easy1);
        StringBuilder builder = new StringBuilder();
        for(String s : score1_easy1) {
            builder.append(s);
        }
        String str = builder.toString();
        //System.out.println(str);

        Random r = new Random();
        String word = scramble(r, str);
        System.out.println(word);

        while (guess != 0) {
            System.out.print("Enter a word: ");
            String word1 = sc.nextLine();
            for (int i=0; i<5; i++) {
                if (score1_easy1.contains(word1)) {
                    System.out.println("You got it! You gained 1 point!");
                    score += 1;
                    break;
                } else {
                    if (score2_easy1.contains(word1)) {
                        System.out.println("You got it! You gained 2 points!");
                        score += 2;
                        break;
                    }
                    // }  else {
                    //     System.out.println("Wrong! You only have " + guess + " guesses left!");
                    //     guess--;
                    // }
                    // System.out.println("Wrong! You only have " + guess + " guesses left!");
                    // guess--;
                    continue;
                }
                // } else if (word1 == score2_easy1[i]){
                //     System.out.println("You got it! You gained 2 points!");
                //     score += 2;
                // }
                //continue;
            }
            guess--;
        }
        System.out.println("Your score: " + score);
    }

    public static String scramble(Random random, String inputString ) {
    // Convert your string into a simple char array:
    char a[] = inputString.toCharArray();

    // Scramble the letters using the standard Fisher-Yates shuffle, 
    for( int i=0 ; i<a.length ; i++ ) {
        int j = random.nextInt(a.length);
        // Swap letters
        char temp = a[i]; a[i] = a[j];  a[j] = temp;
    }       

    return new String( a );
    }
}


// import java.util.Scanner;
// import java.util.concurrent.ThreadLocalRandom;
 
// // How to create a Jumble word game in Java
 
// public class JumbleRumble {
 
//     private static final String[] WORDS_DATABASE = new String[] {
//         "superman","jungle","programmer","letter","house","helium"
//     };
     
//     public static void main(String[] args) {
//         JumbleRumble jg = new JumbleRumble();
//         jg.startGame();
//     }
 
//     /**
//      * Run a game of Jumble in Java. The steps in the game are,
//      * 1. Get a random word from the words database
//      * 2. Shuffle/jumble the word by randomly shuffling characters
//      * 3. Present the jumbled word to the user and ask him to guess the word.
//      * 4. Repeat the guess till answer is found or user decides to quit.
//      */
//     private void startGame() {
//         int numberOfGuesses = 0;
//         String original = selectRandomWord();
//         String shuffled = getShuffledWord(original);
//         boolean gameOn = true;
//         while(gameOn) {
//             System.out.println("Shuffled word is: "+shuffled);
//             numberOfGuesses++;
//             String userGuess = getUserGuess();
//             if(original.equalsIgnoreCase(userGuess)) {
//                 System.out.println("Congratulations! You found the word in "+numberOfGuesses+" guesses");
//                 gameOn = false;
//             }else {
//                 System.out.println("Sorry, Wrong answer");
//             }
//         }        
//     }
     
//     /**
//      * Get the user's word guess from command line
//      * @return 
//      */
//     public String getUserGuess() {
//         Scanner sn = new Scanner(System.in);
//         System.out.println("Please type in the original word: ");
//         return sn.nextLine();
//     }
     
//     /**
//      * Select a random word from the WORDS_DATABASE array.
//      * @return 
//      */
//     public String selectRandomWord() {
//         int rPos = ThreadLocalRandom.current().nextInt(0, WORDS_DATABASE.length);
//         return WORDS_DATABASE[rPos];
//     }
     
//     /**
//      * Shuffle the original word by randomly swapping characters 10 times
//      * @param original
//      * @return 
//      */
//     public String getShuffledWord(String original) {
//         String shuffledWord = original; // start with original
//         int wordSize = original.length();
//         int shuffleCount = 10; // let us randomly shuffle letters 10 times
//         for(int i=0;i<shuffleCount;i++) {
//             //swap letters in two indexes
//             int position1 = ThreadLocalRandom.current().nextInt(0, wordSize);
//             int position2 = ThreadLocalRandom.current().nextInt(0, wordSize);
//             shuffledWord = swapCharacters(shuffledWord,position1,position2);
//         }
//         return shuffledWord;
//     }
 
//     /**
//      * Swaps characters in a string using the given character positions
//      * @param shuffledWord
//      * @param position1
//      * @param position2
//      * @return 
//      */
//     private String swapCharacters(String shuffledWord, int position1, int position2) {
//         char[] charArray = shuffledWord.toCharArray();
//         // Replace with a "swap" function, if desired:
//         char temp = charArray[position1];
//         charArray[position1] = charArray[position2];
//         charArray[position2] = temp;
//         return new String(charArray);
//     }
// }