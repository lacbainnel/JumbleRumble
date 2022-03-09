//package com.mycompany.jumblerumble;

// import java.io.File;
// import java.io.InputStream;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Random;
// import java.util.Scanner;
// import javax.sound.sampled.Clip;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.print.DocFlavor.URL;
import javax.sound.sampled.AudioSystem;
import  java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


public class JumbleRumble {
    Integer score = 0;
    Integer guess = 5;
    private static final ArrayList<String> baseletters_easy1 = new ArrayList<String> (Arrays.asList("e", "a", "r", "p", "t", "n", "o", "w"));  
    private static final ArrayList<String> baseletters_easy2 = new ArrayList<String> (Arrays.asList("a", "c", "n", "e", "b", "t", "i", "s", "u")); 
    private static final ArrayList<String> easy1_store = new ArrayList<String> 
        (Arrays.asList("ear", "pat", "tap", "now", "won", "pot", "top", "cat", "era", "apt", 
                         "own", "opt", "act", "row", "tow", "tap", "war",  "oat", "are", "ate" ,
                         "art", "eat", "ape", "wet", "raw"));
//    private static final ArrayList<String> easy1_words = new ArrayList<String> 
//        (Arrays.asList("ear", "pat", "tap", "now", "won", "pot", "top", "cat", "era", "apt", 
//                         "own", "opt", "act", "row", "tow", "tap", "war",  "oat", "are", "ate" ,
//                         "art", "eat", "ape", "wet", "raw"));   
    private static final ArrayList<String> easy1_words = new ArrayList<String> 
        (Arrays.asList("ear", "pat", "tap"));      
    private static ArrayList<String> easy1_guess = new ArrayList<String> ();

    private static final ArrayList<String> easy2_store = new ArrayList<String> 
        (Arrays.asList("acne", "bane", "bent", "cane", "nice", "bait", "bean", "nabe", "cine",
                        "just", "jest", "cute", "ices", "cite", "tics", "cuts", "jets", "sice", "cist",
                        "scut", "suit", "seat", "cues", "ties"));
//    private static final ArrayList<String> easy1_words = new ArrayList<String> 
//        (Arrays.asList("ear", "pat", "tap", "now", "won", "pot", "top", "cat", "era", "apt", 
//                         "own", "opt", "act", "row", "tow", "tap", "war",  "oat", "are", "ate" ,
//                         "art", "eat", "ape", "wet", "raw"));   
    private static final ArrayList<String> easy2_words = new ArrayList<String> 
        (Arrays.asList("acne", "bane", "bent"));      
    private static ArrayList<String> easy2_guess = new ArrayList<String> ();    
    static float previousVolume = 0;
    static float currentVolume = 0;
    static FloatControl fc;
    static Boolean mute = false;

    public static void main (String[] args) {
        File bg = new File("bg.wav");
        playMusic(bg);
    }

    private void easyLevelOne() {
        JumbleRumble jr = new JumbleRumble();
        Scanner sc = new Scanner(System.in);
        //String test = Arrays.toString(score1_easy1);
        // String test = TextUtils.join("",score1_easy1);
        StringBuilder builder = new StringBuilder();
        for(String s : baseletters_easy1) {
            builder.append(s);
        }
        String str = builder.toString();
        //System.out.println(str);

        Random r = new Random();
        String word = scramble(r, str);
        System.out.println(word);

        while (guess != 0) {
//            if (!easy1_words.isEmpty()) {
//            System.out.println("Enter a 3-letter word: ");
//            String guessWord = sc.nextLine();
//            for (int i=0; i<easy1_store.size(); i++) {
////                if (easy1_words.isEmpty()) {
////                    System.out.println("You have already guessed all of the words! Congratulations!");
////                                jr.easyLevelTwo();
////                                break;                      
////                } else {
//                        if (easy1_store.contains(guessWord)) {
//                            
//                                System.out.println("You got it! You gained 1 point!");
//                                easy1_words.remove(guessWord);
//                                easy1_guess.add(guessWord);
//                                score += 1;
//                                break;                                 
//                            
//                   
//                        } else if (easy1_guess.contains(guessWord)) {
//                            --guess;
//                            System.out.println("You have already guessed this word! You only have " + guess + " guesses left!");
//                            break;    
//                        } else {
//                            --guess;
//                            System.out.println("Wrong! You only have " + guess + " guesses left!");
//                            break;                           
//                        } 
//                        
//                }
//
// 
//
////                    } else {
////                    System.out.println("You have already guessed all of the words! Congratulations!");
////                    break;
//                                 
//                
//
//            } else {
//                System.out.println("You have already guessed all of the words! Congratulations!");
//                jr.easyLevelTwo();
//            }
        

            if (!easy1_words.isEmpty()) {
                System.out.println("Enter a 3-letter word: ");
                String guessWord = sc.nextLine();
                
                for (int i=0; i<easy1_store.size(); i++) {
                    if (easy1_store.contains(guessWord)) {
                        if (easy1_guess.contains(guessWord)) {
                            --guess;
                            System.out.println("You have already guessed this word! You only have " + guess + " guesses left!");
                            break;                              
                        } else {
                            System.out.println("You got it! You gained 1 point!");
                            easy1_words.remove(guessWord);
                            easy1_guess.add(guessWord);
                            score += 1;
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
                jr.easyLevelTwo();
            }       
        }
        //System.out.println("Score: " + score);
    }
 
    //for further edit
    private void easyLevelTwo() {
        JumbleRumble jr = new JumbleRumble();
        Scanner sc = new Scanner(System.in);
        //String test = Arrays.toString(score1_easy1);
        // String test = TextUtils.join("",score1_easy1);
        StringBuilder builder = new StringBuilder();
        for(String s : baseletters_easy2) {
            builder.append(s);
        }
        String str = builder.toString();
        //System.out.println(str);

        Random r = new Random();
        String word = scramble(r, str);
        System.out.println(word);

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
                //jr.easyLevelThree();
            }       
        }       
    }    

    public static String scramble(Random random, String inputString ) {
        // Convert your string into a simple char array:
        char a[] = inputString.toCharArray();

        // Scramble the letters using the standard Fisher-Yates shuffle, 
        for (int i=0 ; i<a.length ; i++) {
            int j = random.nextInt(a.length);
            // Swap letters
            char temp = a[i]; 
            a[i] = a[j];  
            a[j] = temp;
        }       

        return new String(a);
    }

    // public static void playMusic (String filepath) {
    //     InputStream music;
         
    //     try {
    //         music = new FileInputStream (new File(filepath));
    //         AudioStream audios = new AudioStream (music);
    //         AudioPlayer.player.start(audios);
    //     } catch (Exception e) {
    //         System.out.println("no music");
    //     }
    // }

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

// import javax.swing.*;
// import sun.audio.*;
// import java.awt.event.*;
// import java.io.*;
// public class JumbleRumble {
// public static void main(String[] args)
// {
// JFrame frame = new JFrame();
// frame.setSize(200,200);
// JButton button = new JButton("Click me");
// frame.add(button);
// button.addActionListener(new AL());
// frame.setVisible(true);
// }
// public static class AL implements ActionListener{
// public final void actionPerformed(ActionEvent e){
// music();
// }
// }
// public static void music(){
// AudioPlayer MGP = AudioPlayer.player;
// AudioStream BGM;
// AudioData MD;
// ContinuousAudioDataStream loop = null;
// try{
// BGM = new AudioStream(new FileInputStream("C:\\test\\ha.wav"));
// MD = BGM.getData();
// loop = new ContinuousAudioDataStream(MD);
// }catch(IOException error){
// System.out.print("file not found");
// }
// MGP.start(loop);
// }
// }