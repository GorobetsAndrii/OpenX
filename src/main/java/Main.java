import exceptions.EmptyTreeException;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(50);
        tree.add(25);
        tree.add(75);
        tree.add(75);
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(100);
        //tree.delete(50);

        TreeProcessing tpr = new TreeProcessing();
        try {
            System.out.println(tpr.treeSum(tree));
            System.out.println(tpr.avg(tree));
            System.out.println(tpr.median(tree));
            System.out.println(tpr.median(tree.getLeft()));

        }catch (EmptyTreeException e){
            e.printStackTrace();
        }
    }
}
