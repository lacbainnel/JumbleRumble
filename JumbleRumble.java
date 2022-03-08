import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JumbleRumble {
    Integer score = 0;
    Integer guess = 3;
    private static final ArrayList<String> score1_easy1 = new ArrayList<String> (Arrays.asList("ear", "pat", "won", "top", "cat", "era", "apt", "own", "opt", "act"));
    //private static final ArrayList<String> score2_easy1 = new ArrayList<String> (Arrays.asList("era", "apt", "own", "opt", "act"));
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
                    System.out.println("Wrong! You only have " + guess + " guesses left!");
                    guess--;
                    // if (score2_easy1.contains(word1)) {
                    //     System.out.println("You got it! You gained 2 points!");
                    //     score += 2;
                    //     break;
                    // }
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