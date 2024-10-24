/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        TreeNode parent=root;
        HashMap<TreeNode,Integer> map= new HashMap<>();
        findChild(map,root);
        ArrayList<ArrayList<TreeNode>> list=levelOrderTraversal(parent);
        HashMap<Integer,Integer> sumMap=LevelSum(list,parent,map);
        return BuildTree(parent,map,list,sumMap);
    }
    public void findChild(HashMap<TreeNode, Integer> map, TreeNode root) {
        if (root == null) {
            return;
        }
        int sum = childrenSum(root);
        //  System.out.println("Node Value: " + root.val + ", Children Sum: " + sum);
        map.put(root, sum);

        findChild(map, root.left);
        findChild(map, root.right);
    }

    public int childrenSum(TreeNode root) {
        // System.out.println("Child parent: " + root.val );
        int sum = 0;
        if (root.left != null) {
            // System.out.println("Left Child of " + root.val + ": " + root.left.val);
            sum += root.left.val;
        }
        if (root.right != null) {
            //  System.out.println("Right Child of " + root.val + ": " + root.right.val);
            sum += root.right.val;
        }
        return sum;
    }


    public ArrayList<ArrayList<TreeNode>> levelOrderTraversal(TreeNode root){
        ArrayList<ArrayList<TreeNode>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Traverse while the queue is not empty
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<TreeNode> levelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelList.add(currentNode);

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            result.add(levelList);
        }
        return result;
    }

    public HashMap<Integer,Integer> LevelSum(ArrayList<ArrayList<TreeNode>> list,TreeNode root,HashMap<TreeNode,Integer> map){
        int level=-1;
        HashMap<Integer,Integer> sumMap=new HashMap<>();
        for(List<TreeNode> list2:list){
            level=level+1;
            int sum=0;
            for(int i=0;i<list2.size();i++){
                TreeNode k=list2.get(i);
                if(map.containsKey(k)){
                    sum+=map.get(k);
                }
            }

            sumMap.put(level,sum);
        }
        return sumMap;

    }

    public TreeNode BuildTree(TreeNode root,HashMap<TreeNode,Integer> map,
                              ArrayList<ArrayList<TreeNode>> list,  HashMap<Integer,Integer> sumMap){
        int level=-1;
        TreeNode newTree=copyTree(root);
        for(List<TreeNode> list2:list){
            level+=1;
            int currSum=0;
            int levelSum=0;
            for(int i=0;i<list2.size();i++){
                TreeNode k=list2.get(i);
                //   System.out.println(k+" sum");
                if(map.containsKey(k)){
                    currSum=map.get(k);
                    //   System.out.println("curr "+currSum);
                }
                if(sumMap.containsKey(level)){
                    levelSum=sumMap.get(level);
                    // System.out.println("level "+level+" levelSum "+levelSum);
                }
                int newVal=levelSum-currSum;
                // System.out.println(newVal+" newVal");
                Helper(root,newTree,k,newVal);
            }

        }
        newTree.val=0;
        return newTree;
    }
    public TreeNode copyTree(TreeNode root) {
        if (root == null) {
            return null;  // Base case: if the node is null, return null.
        }

        // Create a new node with the same value as the root node.
        TreeNode newNode = new TreeNode(root.val);

        // Recursively copy the left and right subtrees.
        newNode.left = copyTree(root.left);
        newNode.right = copyTree(root.right);

        return newNode;
    }

    public void Helper(TreeNode root,TreeNode newTree,TreeNode k,int newVal){

        if(root!=null){
            if(root==k){
                if(root.left!=null){
                    newTree.left.val=newVal;
                    //   System.out.println( "newTreeleft"+ newTree.left.val);
                }
                if(root.right!=null){
                    newTree.right.val=newVal;
                    //  System.out.println( "newTreeright"+ newTree.right.val);
                }
            }
        }

        if(root.left!=null)
            Helper(root.left,newTree.left,k,newVal);
        if(root.right!=null)
            Helper(root.right,newTree.right,k,newVal);

    }
}