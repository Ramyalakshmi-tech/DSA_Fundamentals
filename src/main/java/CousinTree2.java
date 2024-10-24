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
        HashMap<Integer,Integer> sumMap=new HashMap<>();
        ArrayList<ArrayList<TreeNode>> list=levelOrderTraversal(parent,sumMap);
        return BuildTree(parent,list,sumMap);
    }
    public ArrayList<ArrayList<TreeNode>> levelOrderTraversal(TreeNode root,HashMap<Integer,Integer> sumMap){
        ArrayList<ArrayList<TreeNode>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level=-1;
        // Traverse while the queue is not empty
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<TreeNode> levelList = new ArrayList<>();
            level+=1;
            int sum=0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelList.add(currentNode);
                //   sum+=map.get(currentNode);

                if (currentNode.left != null) {
                    // System.out.println("Left Child of " + root.val + ": " + root.left.val);
                    sum += currentNode.left.val;
                }
                if (currentNode.right != null) {
                    //  System.out.println("Right Child of " + root.val + ": " + root.right.val);
                    sum += currentNode.right.val;
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            sumMap.put(level,sum);
            result.add(levelList);
        }
        return result;
    }

    public TreeNode BuildTree(TreeNode root,ArrayList<ArrayList<TreeNode>> list,HashMap<Integer,Integer> sumMap){
        int level=-1;
        TreeNode newTree=copyTree(root);
        for(List<TreeNode> list2:list){
            level+=1;
            int levelSum=0;
            for(int i=0;i<list2.size();i++){
                TreeNode k=list2.get(i);
                //   System.out.println(k+" sum");
                if(sumMap.containsKey(level)){
                    levelSum=sumMap.get(level);
                    // System.out.println("level "+level+" levelSum "+levelSum);
                }
                // System.out.println(newVal+" newVal");
                Helper(root,newTree,k,levelSum);
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
        newNode.left = copyTree(root.left);
        newNode.right = copyTree(root.right);

        return newNode;
    }

    public void Helper(TreeNode root,TreeNode newTree,TreeNode k,int levelSum){
        int sum = 0;
        if(root!=null){
            if(root==k){

                if (root.left != null) {
                    sum += root.left.val;
                }
                if (root.right != null) {
                    sum += root.right.val;
                }
                if(root.left!=null){
                    newTree.left.val=levelSum-sum;
                    //   System.out.println( "newTreeleft"+ newTree.left.val);
                }
                if(root.right!=null){
                    newTree.right.val=levelSum-sum;
                    //  System.out.println( "newTreeright"+ newTree.right.val);
                }
            }
        }
        if(root.left!=null)
            Helper(root.left,newTree.left,k,levelSum-sum);
        if(root.right!=null)
            Helper(root.right,newTree.right,k,levelSum-sum);
    }
}