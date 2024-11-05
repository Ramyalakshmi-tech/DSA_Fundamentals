package wordLadder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class wordLadderBfs {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            // Convert wordList to a set for faster lookup
            Set<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) {
                return 0;
            }

            // Queue for BFS and Set to track visited nodes
            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();

            // Begin BFS from beginWord
            queue.add(beginWord);
            visited.add(beginWord);

            int count = 1; // Start count at 1 for the first word (beginWord)

            while (!queue.isEmpty()) {
                int levelSize = queue.size(); // Number of nodes at the current level

                // Process all nodes at the current level
                for (int i = 0; i < levelSize; i++) {
                    String currWord = queue.poll();

                    // Check if we've reached the endWord
                    if (currWord.equals(endWord)) {
                        return count;
                    }

                    // Add all neighbors (one-letter transformations) to the queue
                    for (String word : wordSet) {
                        if (!visited.contains(word) && isNeighbor(currWord, word)) {
                            queue.add(word);
                            visited.add(word); // Mark as visited
                        }
                    }
                }
                count++; // Increment level count after processing current level
            }

            return 0; // Return 0 if no path is found
        }

        // Helper function to check if two words differ by exactly one character
        private boolean isNeighbor(String word1, String word2) {
            int diff = 0;
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    diff++;
                    if (diff > 1) return false; // Stop early if more than one difference
                }
            }
            return diff == 1;
        }
    }

