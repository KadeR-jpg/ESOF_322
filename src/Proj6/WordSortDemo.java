/**
 * Project 6
 * <p>
 * Use Quicksort or Mergesort (your choice) to sort words of a paragraph from a file
 * into lexicographical order, and then by word length, from the longest words to the smallest.
 * You may use the implementation given in the book for Mergesort and/or Quicksort.
 * <p>
 * Write the output of the program to files Lexicographical.txt and LongestToShortest.txt.
 * Submit the text files, along with this modified driver program, your Quicksort or Mergesort program,
 * and the StringLengthComparator.
 * <p>
 * Besides this WordSortDemo driver file to get you started, included in this week's content are
 * * StringLengthComparator.java -- the comparator from page 364 of the textbook
 * * IOExample.java -- an example program showing how read from and write to files Java
 * * SortExample.java -- an example program demonstrating the use of comparators, including the above
 * * FarewellToArms.txt -- 	a text file of Earnest Hemmingway's masterpiece opening to the book.
 * (These are the words you will be sorting in the project.)
 * <p>
 * Note: lexicographical natural ordering puts capital letters in front of any lower case letters. That's fine
 * Note: Punctuation marks will be stuck to some of the words. That's fine.
 */

package Proj6;

import java.io.*;
import java.util.*;

public class WordSortDemo {

    public static void main(String[] args) {
        ArrayList<String> wordAL = new ArrayList<>();
        File inFile = new File("C:\\Users\\KadeC\\IdeaProjects\\CSCI_132\\src\\Proj6\\FarewellToArms.txt");
        try (Scanner scan = new Scanner(inFile)) {
            while (scan.hasNextLine()) {
                wordAL.add(scan.next());
            }
        } catch (FileNotFoundException E) {
            System.out.println("That file does not exist. ");
        }

        String[] wordArray = {"These", "will", "be", "Hemmingway's", "words"};

        Comparator<String> byLexigraphical = Comparator.naturalOrder();
        StringLengthComparator byWordLength = new <String>StringLengthComparator();

        Arrays.sort(wordArray, byLexigraphical);
        mergeSort(wordAL, byWordLength);
        try {
            PrintWriter lexiFile = new PrintWriter(new FileWriter("C:\\Users\\KadeC\\IdeaProjects\\CSCI_132\\src\\Proj6\\Lexicographical.txt"));
            PrintWriter lenFile = new PrintWriter(new FileWriter("C:\\Users\\KadeC\\IdeaProjects\\CSCI_132\\src\\Proj6\\LongestToShortest.txt"));
            PrintWriter outputFile = new PrintWriter(new FileWriter("C:\\Users\\KadeC\\IdeaProjects\\CSCI_132\\src\\Proj6\\FarewellByLexigraphical.txt"));

            for (String word : wordArray) {
                outputFile.println(word);
            }
            for (String word : wordAL) {
                lenFile.println(word);
            }

            //Sorting the word in alphabetical order ignoring the case so it sorts correctly.

            Collections.sort(wordAL, String::compareToIgnoreCase);

            // for:each loop to print all words to the output file.

            for(String word : wordAL){
                lexiFile.println(word);
            }

            //Closing all Files.
            outputFile.close();
            lenFile.close();
            lexiFile.close();

        } catch (IOException exc) {
            System.out.println("There was a problem opening the output file.");
        }
        System.out.println("<end>");
    }

    /**
     *
     * @param strL our whole ArrayList
     * @param left the left half of the ArrayList
     * @param right the right half of the ArrayList
     * @param comp our custom comparator that compares the length of strings and returns an int
     * @param <String> type reference
     */
    public static <String> void merge(ArrayList<String> strL, ArrayList<String> left, ArrayList<String> right, Comparator<String> comp) {
        int wholeIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (comp.compare(left.get(leftIndex), right.get(rightIndex)) < 0) {
                strL.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                strL.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }
        while(leftIndex < left.size()){
            strL.set(wholeIndex, left.get(leftIndex));
            leftIndex++;
            wholeIndex++;
        }
        while (rightIndex < right.size()){
            strL.set(wholeIndex, right.get(rightIndex));
            rightIndex++;
            wholeIndex++;
        }
    }

    /**
     *
     * @param strL taking entire Arraylist as input.
     * @param comp our custom String comparator
     * @param <String> type reference
     */
    public static <String> void mergeSort(ArrayList<String> strL, Comparator<String> comp) {
        ArrayList<String> sorted;
        int pivot = strL.size()/2;
        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();
        if(strL.size() > 1){
            for(int i = 0; i < pivot; i++){
                left.add(strL.get(i));
            }
            for(int j = pivot; j < strL.size(); j++){
                right.add(strL.get(j));
            }
        mergeSort(left, comp);
        mergeSort(right, comp);
        }else{
            return;
        }
        merge(strL, left, right, comp);
    }
}


