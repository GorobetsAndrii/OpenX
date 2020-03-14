import exceptions.EmptyTreeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TreeProcessingTest {
    private TreeProcessing tpr = new TreeProcessing();
    private Tree tree = new Tree();

    @Before
    public void setUp() {
        tree.add(50);
        tree.add(25);
        tree.add(75);
        tree.add(75);
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
    }

    @Test
    public void countSumOfTree() throws EmptyTreeException {
        Assert.assertEquals(240, tpr.treeSum(tree));
    }

    @Test
    public void countAvgOfTree() throws EmptyTreeException {
        Assert.assertEquals((Integer)26,tpr.avg(tree));
    }

    @Test
    public void countMedianOfTree() throws EmptyTreeException {
        Assert.assertEquals(5, tpr.median(tree));
    }

    @Test
    public void addElementAndTryToCountSum() throws EmptyTreeException {
        tree.add(100);
        Assert.assertEquals(340,tpr.treeSum(tree));
    }

    @Test
    public void addElementAndTryToCountAvg() throws EmptyTreeException {
        tree.add(100);
        Assert.assertEquals((Integer)34,tpr.avg(tree));
    }

    @Test
    public void addElementAndTryToCountMedian() throws EmptyTreeException {
        tree.add(100);
        Assert.assertEquals(5,tpr.median(tree));
    }

    @Test(expected = EmptyTreeException.class)
    public void shouldThrowEmptyTree() throws EmptyTreeException {
        tree = new Tree();
        tpr.median(tree);
        Assert.fail("This method should throw EmptyTree");
    }
}
