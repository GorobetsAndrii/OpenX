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

        if (tree.getCounter() == 1) {
            return tree.getValue();
        }

        int counter = tree.getCounter()/2;
        return stepsToMedian(tree,counter);
    }

    private int stepsToMedian(Tree tree, int count){
        if(count == 0) return tree.getValue();
        if(tree.getLeft() != null && tree.getRight() != null) {
            if (tree.getLeft().getCounter() == tree.getRight().getCounter()) {
                return tree.getValue();
            } else {
                return tree.getLeft().getCounter() > tree.getRight().getCounter() ? stepsToMedian(tree.getLeft(),--count) : stepsToMedian(tree.getRight(),--count);
            }
        } else if (tree.getLeft() == null) {
            return stepsToMedian(tree.getRight(),--count);
        } else {
            return stepsToMedian(tree.getLeft(),--count);
        }
    }

}
