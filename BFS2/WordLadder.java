package BFS2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder {

  public static void main(String []args) {
    WordLadder solution = new WordLadder();

    List<String>  dict = new ArrayList<>() ;
    String [] original = new String[]{"izvcnt","hyjwgb","luzvff","illbjg","iehfzp","jjofku","tmkrma","yrrvpq","ntijqd","lbruez","jtoimy","fgktfq","tmtibx","vujkns","fjdeds","cicrlt","lkupnp","kbquoc","vaqnwd","sybbkk","voifyl","zycdrm","yxfkyg","tusvnf","bfffsq","oxqtaq","slynkf","eiamsy","cxmvkt","xsmdmi","jckoeq","zxpjjf","ndjdtk","xvqomc","hmqrlq","nwmoyw","swomhn","tqrljp","ruwdbe","hgliyu","cclull","fpeltr","kivdkq","puuqfh","kdjnrw","ceuvpm","axnoct","kfxhjj","mhvqjv","kmhlgy","avgxno","jiqrjj","rkiyyt","pjvjuf","twlwjy","mdjlug","nqmteo","mbqith","unfgkn","snvcok","ytjezq","jzbgdm"} ;

    for (int i = 0 ; i < original.length ; i++) {
      dict.add( original[i] ) ;
    }

    System.out.print( solution.ladderLength("cclull", "kfxhjj", dict )  );
  }
  private   Map<String, Integer> wordIndex = new HashMap<>() ;
  private    List<String> wordList ;

  public  void NeighborFinder (List<String> wordList) {

    for (int i = 0 ;  i < wordList.size() ; i ++) {

      String word = wordList.get(i) ;
      wordIndex.put(word, i) ;
    }
    this.wordList = wordList ;
  }

  public   List<Integer> findNeighbors(int i) {

    List<Integer> neighbors = new ArrayList<>(16) ;
    String word = wordList.get(i) ;
    StringBuilder wordModifier = new StringBuilder(word) ;
    for (int j = 0 ; j < wordModifier.length() ; j++) {

      char orig = word.charAt(j) ;
      for (char c = 'a' ; c <= 'z' ; c++) {
        if (c == orig) {
          continue ;
        }
        wordModifier.setCharAt(j, c) ;
        int neighbor = wordIndex.getOrDefault(wordModifier.toString(), - 1) ;
        if (neighbor != -1) {
          neighbors.add(neighbor) ;
        }
      }
      wordModifier.setCharAt(j, orig) ;
    }
    return neighbors ;

  }

  public  int ladderLength(String beginWord, String endWord, List<String> wordList) {
    // Write your solution here
    NeighborFinder(wordList) ;
    Map<Integer, Integer> visitedAndSteps = new HashMap<>() ;

    Queue<Integer> queue = new ArrayDeque<>() ;
    queue.offer( wordIndex.get(endWord) );

    visitedAndSteps.put( wordIndex.get(endWord), 1 ) ;
    while ( !queue.isEmpty() ) {
      Integer cur = queue.poll() ;
      int step = visitedAndSteps.get(cur) ;
      for ( Integer nei : findNeighbors( cur ) ) {


        if ( !visitedAndSteps.containsKey(nei) ) {
          queue.offer(nei) ;
          visitedAndSteps.put( nei, step + 1);
        }
      }
    }
    return visitedAndSteps.getOrDefault( wordIndex.get(beginWord) , 0) ;

  }
}
