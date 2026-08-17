class Solution {
    static class NodeInfo {
        int row;
        int value;

        NodeInfo(int row, int value) {
            this.row = row;
            this.value = value;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<NodeInfo>> map = new TreeMap<>();

        f(root, map, 0, 0);

        List<List<Integer>> result = new ArrayList<>();

        for (List<NodeInfo> nodes : map.values()) {
            nodes.sort((a, b) -> {
                if (a.row != b.row) {
                    return a.row - b.row;
                }
                return a.value - b.value;
            });

            List<Integer> column = new ArrayList<>();

            for (NodeInfo node : nodes) {
                column.add(node.value);
            }

            result.add(column);
        }

        return result;
    }

    private void f(
        TreeNode root,
        Map<Integer, List<NodeInfo>> map,
        int row,
        int col
    ) {
        if (root == null) {
            return;
        }

        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new NodeInfo(row, root.val));

        f(root.left, map, row + 1, col - 1);
        f(root.right, map, row + 1, col + 1);
    }
}