package wordLadder;

import java.util.ArrayList;
import java.util.List;

public class wordLadder2Dfs {
        int mini= Integer.MAX_VALUE;
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> res=new ArrayList<>();
            List<String> Visited=new ArrayList<>();
            List<String> list=new ArrayList<>();

            list.add(beginWord);
            int count=0;
            boolean isPresent=false;
            for(String word:wordList){
                if(word.equals(endWord)){
                    isPresent=true;
                }
            }
            if(!isPresent){
                return res;
            }

            findNeighbor(beginWord,endWord,wordList,Visited,res,list);
            return res;
        }
        public void findNeighbor(String currWord,String endWord,List<String> wordList,List<String> Visited,List<List<String>> res,List<String> list){
            if(currWord.equals(endWord)){
                if(list.size()>mini){
                    return;
                }
                res.add(list);
                mini=res.get(0).size();
                return ;

            }
            ArrayList<String> neighbors =new ArrayList<>();
            for(String word : wordList){
                if(!Visited.contains(word) && isNeighbor(word,currWord)){
                    //   System.out.println("CURRWORD2   "+currWord +" WORD "+word);
                    Visited.add(word);
                    neighbors.add(word);
                }
            }

            for(String neighbor:neighbors){
                List<String> list2 = new ArrayList<>(list);
                list2.add(neighbor);
                findNeighbor(neighbor,endWord,wordList,Visited,res,list2);
                Visited.remove(neighbor);
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


