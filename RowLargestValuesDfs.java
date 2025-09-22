//Time Complexity: O(n)
//Space Complexity: Amortized O(h), Worst case O(n)
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RowLargestValuesDfs {

    public List<Integer> largestValues(TreeNode root) {
        final List<Integer> output = new ArrayList<>();
        if (root == null) return output;

        dfs(root, 0, output);

        return output;
    }

    private void dfs(final TreeNode root, int level, final List<Integer> output) {
        if (root == null) return;

        if (output.size() <= level) output.add(root.val);
        else if (output.get(level) < root.val) output.set(level, root.val);

        //logic
        dfs(root.left, level + 1, output);
        dfs(root.right, level + 1, output);
    }

    public static void main(String[] args) {

    }
}
