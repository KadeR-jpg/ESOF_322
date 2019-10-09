package Gens;

import java.util.*;


public class SLLDemo {
    public static void main(String[] args){

        //Constructing our linked list from several string objects
        SinglyLinkedList<String> airports;
        airports = new <String>SinglyLinkedList();
        airports.addFirst("BZN");
        airports.addFirst("BOS");
        airports.addFirst("SLC");
        System.out.println(airports.toString());
        airports.removeFirst();
        System.out.println(airports.toString());
        airports.addFirst("SLC");
        airports.addFirst("LAX");
        airports.addFirst("SFO");

        //Constructing another linked list by instantiating our class with more objects.
        SinglyLinkedList<String> queue = new SinglyLinkedList<String>();
        String[] songArr = {"Stargazing", "Backseat Freestyle", "I Am A God", "Night Drive"};
        String[] artistArr = {"Travis Scott", "Kendrick Lamar", "Kanye West", "Ari Lennox"};
        Song songs = new Song(songArr[0], artistArr[0]);
        queue.addFirst(songs.toString());
        songs = new Song(songArr[1], artistArr[1]);
        queue.addLast(songs.toString());
        songs = new Song(songArr[2], artistArr[2]);
        queue.addLast(songs.toString());
        songs = new Song(songArr[3], artistArr[3]);
        queue.addLast(songs.toString());

        //Printing our LL output and Nth test
        System.out.println(airports.toString());
        System.out.println(airports.getNth(2));
        System.out.println(queue);
    }
}
