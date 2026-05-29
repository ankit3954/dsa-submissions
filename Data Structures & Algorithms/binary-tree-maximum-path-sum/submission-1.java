class Solution {
    // This is our global scoreboard to track the absolute highest sum found
    int globalMaxSum; 

    public int maxPathSum(TreeNode root) {
        // Initialize the scoreboard with the root's value
        globalMaxSum = root.val;
        
        // Start exploring the tree from the root
        getBestStraightLine(root);
        
        return globalMaxSum;
    }

    private int getBestStraightLine(TreeNode currentNode) {
        // Base case: If there is no node, it contributes nothing
        if (currentNode == null) {
            return 0;
        }

        // Ask the left and right children for their best straight lines
        int leftBranchSum = getBestStraightLine(currentNode.left);
        int rightBranchSum = getBestStraightLine(currentNode.right);

        // Rule: If a branch gives a negative sum, ignore it (take 0 instead)
        if (leftBranchSum < 0) {
            leftBranchSum = 0;
        }
        if (rightBranchSum < 0) {
            rightBranchSum = 0;
        }

        // HAT 1: Act as the "Peak" (Inverted 'V' path)
        // Combine the current node with BOTH branches to see the total local path sum
        int localVPathSum = currentNode.val + leftBranchSum + rightBranchSum;

        // Update the global scoreboard if this local 'V' path breaks the record
        if (localVPathSum > globalMaxSum) {
            globalMaxSum = localVPathSum;
        }

        // HAT 2: Act as the "Team Player"
        // Return only the SINGLE best branch + current node value to the parent above
        if (leftBranchSum > rightBranchSum) {
            return currentNode.val + leftBranchSum;
        } else {
            return currentNode.val + rightBranchSum;
        }
    }
}
