class Solution {

    class Node {
        int leftChar;
        int rightChar;
        int leftLen;
        int rightLen;
        int maxLen;
        int len;

        Node(int c) {
            leftChar = rightChar = c;
            leftLen = rightLen = maxLen = len = 1;
        }
    }

    Node[] tree;
    char[] s;

    public int[] longestRepeating(
            String str,
            String queryCharacters,
            int[] queryIndices) {

        s = str.toCharArray();
        int n = s.length;

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int q = 0; q < queryIndices.length; q++) {

            int index = queryIndices[q];
            char c = queryCharacters.charAt(q);

            s[index] = c;

            update(1, 0, n - 1, index, c);

            ans[q] = tree[1].maxLen;
        }

        return ans;
    }

    private void build(int node, int l, int r) {

        if (l == r) {
            tree[node] = new Node(s[l]);
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private void update(
            int node,
            int l,
            int r,
            int index,
            char c) {

        if (l == r) {
            tree[node] = new Node(c);
            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, c);
        } else {
            update(node * 2 + 1, mid + 1, r, index, c);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node merge(Node a, Node b) {

        Node res = new Node(a.leftChar);

        res.len = a.len + b.len;

        res.leftChar = a.leftChar;
        res.rightChar = b.rightChar;

        res.leftLen = a.leftLen;
        res.rightLen = b.rightLen;

        res.maxLen = Math.max(a.maxLen, b.maxLen);

        if (a.leftLen == a.len && a.rightChar == b.leftChar) {
            res.leftLen = a.len + b.leftLen;
        }

        if (b.rightLen == b.len && a.rightChar == b.leftChar) {
            res.rightLen = b.len + a.rightLen;
        }

        if (a.rightChar == b.leftChar) {
            res.maxLen = Math.max(
                res.maxLen,
                a.rightLen + b.leftLen
            );
        }

        return res;
    }
}