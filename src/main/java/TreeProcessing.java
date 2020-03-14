import exceptions.EmptyTreeException;

public class TreeProcessing {
    public int treeSum(Tree tree) throws EmptyTreeException {
        if(tree.getCounter() == 0) throw new EmptyTreeException();

        int result = tree.getValue();

        if (tree.getLeft() != null) {
            result += treeSum(tree.getLeft());
        }

        if (tree.getRight() != null) {
            result += treeSum(tree.getRight());
        }

        return result;
    }

    public Integer avg(Tree tree) throws EmptyTreeException {
        if(tree.getCounter() == 0) throw new EmptyTreeException();

        return treeSum(tree) / tree.getCounter();
    }

    public int median(Tree tree) throws EmptyTreeException {
        if(tree.getCounter() == 0) throw new EmptyTreeException();

        if (tree.getLeft() == null && tree.getRight() == null) {
            return tree.getValue();
        }

        if (tree.getLeft() != null && tree.getRight() != null) {
            if (tree.getLeft().getCounter() == tree.getRight().getCounter()) {
                return tree.getValue();
            } else {
                return tree.getLeft().getCounter() > tree.getRight().getCounter() ? median(tree.getLeft()) : median(tree.getRight());
            }
        } else if (tree.getLeft() == null) {
            return median(tree.getRight());
        } else {
            return median(tree.getLeft());
        }
    }

}
