import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.sound.sampled.AudioSystem;
import  java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JumbleRumble {
    Integer score = 0;
    Integer guess = 5;

    //FOR EASY LEVEL 1
    private static final ArrayList<String> baseletters_easy1 = new ArrayList<String> (Arrays.asList("e", "a", "r", "p", "t", "n", "o", "w"));  
    private static final ArrayList<String> easy1_store = new ArrayList<String> 
        (Arrays.asList("ear", "pat", "tap", "now", "won", "pot", "top", "cat", "era", "apt", 
                         "own", "opt", "act", "row", "tow", "tap", "war",  "oat", "are", "ate" ,
                         "art", "eat", "ape", "wet", "raw"));
   private static final ArrayList<String> easy1_words = new ArrayList<String> 
       (Arrays.asList("ear", "pat", "tap", "now", "won", "pot", "top", "cat", "era", "apt", 
                        "own", "opt", "act", "row", "tow", "tap", "war",  "oat", "are", "ate" ,
                        "art", "eat", "ape", "wet", "raw"));   
    // private static final ArrayList<String> easy1_words = new ArrayList<String> 
    //     (Arrays.asList("ear", "pat", "tap"));      
    private static ArrayList<String> easy1_guess = new ArrayList<String> ();

    //FOR EASY LEVEL 2
    private static final ArrayList<String> baseletters_easy2 = new ArrayList<String> (Arrays.asList("a", "c", "n", "e", "b", "t", "i", "s", "u")); 
    private static final ArrayList<String> easy2_store = new ArrayList<String> 
        (Arrays.asList("acne", "bane", "bent", "cane", "nice", "bait", "bean", "nabe", "cine",
                        "just", "jest", "cute", "ices", "cite", "tics", "cuts", "jets", "sice", "cist",
                        "scut", "suit", "seat", "cues", "ties"));
   private static final ArrayList<String> easy2_words = new ArrayList<String> 
       (Arrays.asList("ear", "pat", "tap", "now", "won", "pot", "top", "cat", "era", "apt", 
                        "own", "opt", "act", "row", "tow", "tap", "war",  "oat", "are", "ate" ,
                        "art", "eat", "ape", "wet", "raw"));   
    // private static final ArrayList<String> easy2_words = new ArrayList<String> 
    //     (Arrays.asList("acne", "bane", "bent"));      
    private static ArrayList<String> easy2_guess = new ArrayList<String> ();  
    
    //FOR VOLUME SETTINGS
    static float previousVolume = 0;
    static float currentVolume = 0;
    static FloatControl fc;
    static Boolean mute = false;

    public static void main (String[] args) {
        //invoking the background music to play all throughout the game
        File music = new File("bg.wav");
        playMusic(music);
    }

    //FUNCTION FOR EASY LEVEL ONE
    private void easyLevelOne() {
        JumbleRumble jr = new JumbleRumble();
        Scanner sc = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();

        for (String s:baseletters_easy1) {
            builder.append(s);
        }
        String str = builder.toString();

        Random r = new Random();
        String scrambledLetters1 = scramble(r, str);
        System.out.println(scrambledLetters1);

        while (guess != 0) {
            if (!easy1_words.isEmpty()) { //checks if wordbank is empty
                System.out.println("Enter a 3-letter word: ");
                String guessWord = sc.nextLine();
                
                //checks if guess matches wordbank
                for (int i=0; i<easy1_store.size(); i++) { 
                    if (easy1_store.contains(guessWord)) { //if it's in wordbank
                        if (easy1_guess.contains(guessWord)) { //checks if it was already guessed
                            --guess;
                            System.out.println("You have already guessed this word! You only have " + guess + " guesses left!");
                            break;                              
                        } else { //newly guessed word matches the one on wordbank
                            System.out.println("You got it! You gained 1 point!");
                            easy1_words.remove(guessWord);
                            easy1_guess.add(guessWord);
                            score += 1;
                            break;                             
                        }
                    } else { //not in wordbank
                        --guess;
                        System.out.println("Wrong! You only have " + guess + " guesses left!");
                        break;                           
                    }      
                }
            } else {
                System.out.println("You have already guessed all of the words! Congratulations!");
                System.out.println("Score: " + score);
                jr.easyLevelTwo(); //goes to the next level
            }       
        }
        sc.close();
    }
 
    //FUNCTION FOR EASY LEVEL TWO
    private void easyLevelTwo() {
        Scanner sc = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();

        for (String s:baseletters_easy2) {
            builder.append(s);
        }
        String str = builder.toString();

        Random r = new Random();
        String scrambledLetters2 = scramble(r, str);
        System.out.println(scrambledLetters2);

        while (guess != 0) {
            if (!easy2_words.isEmpty()) {
                System.out.println("Enter a 4-letter word: ");
                String guessWord = sc.nextLine();
                
                for (int i=0; i<easy2_store.size(); i++) {
                    if (easy2_store.contains(guessWord)) {
                        if (easy2_guess.contains(guessWord)) {
                            --guess;
                            System.out.println("You have already guessed this word! You only have " + guess + " guesses left!");
                            break;                              
                        } else {
                            System.out.println("You got it! You gained 2 points!");
                            easy2_words.remove(guessWord);
                            easy2_guess.add(guessWord);
                            score += 2;
                            break;                             
                        }
                    } else {
                        --guess;
                        System.out.println("Wrong! You only have " + guess + " guesses left!");
                        break;                           
                    }      
                }
            } else {
                System.out.println("You have already guessed all of the words! Congratulations!");
                System.out.println("Score: " + score);
                System.exit(0);
                //TODO insert easy level three
            }       
        } 
        sc.close();      
    }    

    public static String scramble (Random random, String lettersToScramble) {
        //convert your string into a simple char array:
        char a[] = lettersToScramble.toCharArray();

        //scramble the letters using the standard Fisher-Yates shuffle 
        for (int i=0; i<a.length; i++) {
            int j = random.nextInt(a.length);
            //swap letters
            char temp = a[i]; 
            a[i] = a[j];  
            a[j] = temp;
        }       

        return new String(a);
    }

    //SOUND SETTINGS
    public static void playMusic (File Sound) {
        JFrame f = new JFrame();
        GridLayout gl = new GridLayout(1,3);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(gl);

        JButton up = new JButton("Volume Up");
        up.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                currentVolume += 1.0f;

                if (currentVolume > 6.0) {
                    //max volume is 6.0f
                    currentVolume = 6.0f;
                }
                fc.setValue(currentVolume);
            }
        });
        f.add(up);

        JButton down = new JButton("Volume Down");
        down.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                currentVolume -= 1.0f;

                if (currentVolume < -80.0f) {
                    //min volume is -80.0f
                    currentVolume = -80.0f;
                }
        
                fc.setValue(currentVolume);
            }
        });        
        f.add(down);

        JButton volumeMute = new JButton("Mute");
        volumeMute.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                if (mute == false) {
                    //prev vol is stored so when the users unmutes, it will 
                    //go back to prev vol before it was muted
                    previousVolume = currentVolume;
                    currentVolume = -80.0f;
                    fc.setValue(currentVolume);
                    mute = true;
                } else if (mute == true) {
                    currentVolume = previousVolume;
                    fc.setValue(currentVolume);
                    mute = false;
                }
            }
        });        
        f.add(volumeMute); 
        
        f.pack();
        f.setVisible(true);

        try {
            Clip clip = AudioSystem.getClip();
            clip.open (AudioSystem.getAudioInputStream(Sound));
            clip.start();
            fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);

            JumbleRumble jr = new JumbleRumble();
            jr.easyLevelOne();

            //Thread.sleep(clip.getMicrosecondLength()/1000);
        } catch (Exception e) {
            System.out.println("no music found");
        }
    }
}