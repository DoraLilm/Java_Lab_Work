
package Laba3.Tree;

// Бинарное дерево поиска.
public class BinaryNode {
    private Integer value;
    private BinaryNode parent;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode() {
        value = null;
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
        if (value == null) {
            return false;
        }

        if (value == target) {
            return true;
        }

        if (target < value) {
            return left != null && left.contains(target);
        }

        return right != null && right.contains(target);
    }

    public void remove(int target) {
        if (value == null) {
            return;
        }

        if (target < value) {
            if (left != null) {
                left.remove(target);
            }
            return;
        }

        if (target > value) {
            if (right != null) {
                right.remove(target);
            }
            return;
        }

        // При двух потомках заменяем узел следующим по величине.
        if (left != null && right != null) {
            BinaryNode successor = right;

            while (successor.left != null) {
                successor = successor.left;
            }

            value = successor.value;
            successor.removeNode();
            return;
        }

        removeNode();
    }

    private void removeNode() {
        BinaryNode child;

        if (left != null) {
            child = left;
        } else {
            child = right;
        }

        // Корневой узел остаётся тем же объектом.
        if (parent == null) {
            if (child == null) {
                value = null;
                left = null;
                right = null;
            } else {
                value = child.value;
                left = child.left;
                right = child.right;

                if (left != null) {
                    left.parent = this;
                }

                if (right != null) {
                    right.parent = this;
                }
            }

            return;
        }

        // Удаляемый узел заменяется своим потомком, если он есть.
        if (parent.left == this) {
            parent.left = child;
        } else {
            parent.right = child;
        }

        if (child != null) {
            child.parent = parent;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        buildString(result);
        return result.toString().trim();
    }

    private void buildString(StringBuilder result) {
        if (left != null) {
            left.buildString(result);
        }

        if (value != null) {
            result.append(value).append(" ");
        }

        if (right != null) {
            right.buildString(result);
        }
    }
}
