//Time Complexity: O(n)
//Space Complexity: worst case O(n), amortized O(n)
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RowLargestValuesBfs {

    public List<Integer> largestValues(TreeNode root) {
        final List<Integer> output = new ArrayList<>();
        if (root == null) return output;

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                final TreeNode current = queue.poll();
                max = Math.max(max, current.val);

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            output.add(max);
        }

        return output;
    }

    public static void main(String[] args) {

    }
}
