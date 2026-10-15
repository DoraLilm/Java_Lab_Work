package Laba3;

class BinaryNode {
    private Integer value;
    private BinaryNode parent;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode() {
        this.value = null;
    }

    public void add(int newValue) {
        if (value == null) {
            value = newValue;
            return;
        }
        if (newValue > value) {
            if (right == null) {
                right = new BinaryNode();
                right.parent = this;
            }
            right.add(newValue);
        } else {
            if (left == null) {
                left = new BinaryNode();
                left.parent = this;
            }
            left.add(newValue);
        }
    }

    public boolean contains(int target) {
        if (value == null) return false;
        if (value == target) return true;
        if (target > value && right != null) return right.contains(target);
        if (target < value && left != null) return left.contains(target);
        return false;
    }

    public void remove(int target) {
        if (value == null) return;
        if (value == target) {
            BinaryNode p = parent;
            collectAndReattach(this, p);
            if (p == null) {
                this.value = null;
                this.left = null;
                this.right = null;
            }
            return;
        }
        if (target > value && right != null) right.remove(target);
        else if (target < value && left != null) left.remove(target);
    }

    private void collectAndReattach(BinaryNode node, BinaryNode newParent) {
        if (node.left != null) {
            node.left.parent = newParent;
            if (newParent != null && newParent.left == null) newParent.left = node.left;
            else if (newParent != null && newParent.right == null) newParent.right = node.left;
            else if (newParent != null) newParent.left = node.left;
            collectAndReattach(node.left, newParent);
        }
        if (node.right != null) {
            node.right.parent = newParent;
            if (newParent != null && newParent.right == null) newParent.right = node.right;
            else if (newParent != null && newParent.left == null) newParent.left = node.right;
            collectAndReattach(node.right, newParent);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        buildString(sb);
        return sb.toString().trim();
    }

    private void buildString(StringBuilder sb) {
        if (left != null) left.buildString(sb);
        if (value != null) sb.append(value).append(" ");
        if (right != null) right.buildString(sb);
    }
}