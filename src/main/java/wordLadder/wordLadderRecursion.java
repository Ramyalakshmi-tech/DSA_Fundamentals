package wordLadder;

import java.util.ArrayList;
import java.util.List;

class wordLadderRecursion {
    int minCount= Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> Visited=new ArrayList<>();
        int count=0;
        boolean isPresent=false;
        for(String word:wordList){
            if(word.equals(endWord)){
                isPresent=true;
            }
        }
        if(!isPresent){
            return 0;
        }

        findNeighbor(beginWord,endWord,wordList,Visited,0);
        return minCount==Integer.MAX_VALUE?0:minCount;
    }

    public void findNeighbor(String currWord,String endWord,List<String> wordList,List<String> Visited,int count){
        if(currWord.equals(endWord)){
            System.out.println("ans "+count);
            minCount=Math.min(minCount,count+1);
            return ;

        }
        ArrayList<String> neighbors =new ArrayList<>();
        for(String word : wordList){
            if(!Visited.contains(word) && isNeighbor(word,currWord)){
                System.out.println("CURRWORD2   "+currWord +" WORD "+word+ " count "+ count);
                Visited.add(word);
                neighbors.add(word);
            }
        }

        for(String neighbor:neighbors){
            findNeighbor(neighbor,endWord,wordList,Visited,count+1);

        }

    }

    public boolean isNeighbor(String word1,String word2){
        if(word1.length()!=word2.length()){
            return false;
        }
        int diff=0;
        for(int i=0;i<word1.length();i++){
            if(word1.charAt(i)!=word2.charAt(i)){
                diff++;
            }
        }
        return diff==1?true:false;
    }
}