import org.junit.Assert;
import org.junit.Test;

public class TreeTest {
    private Tree tree = new Tree();

    @Test
    public void addTest(){
        tree.add(5);
        Assert.assertEquals(5,tree.getValue());
    }

    @Test
    public void checkPropertiesOfBinaryTree(){
        tree.add(5);
        tree.add(7);
        tree.getRight().add(3);
        Assert.assertEquals(7,tree.getRight().getValue());
        Assert.assertEquals(3,tree.getLeft().getValue());
    }

    @Test
    public void counterTest(){
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        Assert.assertEquals(4,tree.getCounter());
    }

    @Test
    public void deleteTest(){
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.delete(7);
        Assert.assertEquals(null,tree.search(7));
        Assert.assertEquals(3,tree.getCounter());
    }

}
