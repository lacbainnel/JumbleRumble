//package com.mycompany.jumblerumble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JumbleRumble {
    Integer score = 0;
    Integer guess = 5;
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
    //private static final ArrayList<String> score2_easy1 = new ArrayList<String> (Arrays.asList("era", "apt", "own", "opt", "act"));
    //private static final String[] score1_easy1 = new String[] {"ear", "pat", "won", "top", "cat"};
    //private static final String[] score2_easy1 = new String[] {"era", "apt", "own", "opt", "act"};

    public static void main (String[] args) {
        JumbleRumble jr = new JumbleRumble();
        jr.easyLevelOne();
    }

    private void easyLevelOne() {
        JumbleRumble jr = new JumbleRumble();
        Scanner sc = new Scanner(System.in);
        //String test = Arrays.toString(score1_easy1);
        // String test = TextUtils.join("",score1_easy1);
        StringBuilder builder = new StringBuilder();
        for(String s : easy1_store) {
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
        System.out.println("Score: " + score);
    }
 
    //for further edit
    private void easyLevelTwo() {
        //JumbleRumble jr = new JumbleRumble();
        Scanner sc = new Scanner(System.in);
        //String test = Arrays.toString(score1_easy1);
        // String test = TextUtils.join("",score1_easy1);
        StringBuilder builder = new StringBuilder();
        for(String s : easy1_store) {
            builder.append(s);
        }
        String str = builder.toString();
        //System.out.println(str);

        Random r = new Random();
        String word = scramble(r, str);
        System.out.println(word);

        while (guess != 0) {
            System.out.println("Enter a 3-letter word: ");
            String word1 = sc.nextLine();
            for (int i=0; i<easy1_store.size(); i++) {
                if (easy1_store.contains(word1)) {
                    System.out.println("You got it! You gained 1 point!");
                    score += 1;
                    break;
                } else {
                    --guess;
                    System.out.println("Wrong! You only have " + guess + " guesses left!");
                    break;
                }
            }
        }
        if (score == 5) {
            System.out.println("You obtained a perfect score! You will not progree to Level 2!");
        } else {
            System.out.println("Your score: " + score);
        }
        
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

    return new String(a);
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