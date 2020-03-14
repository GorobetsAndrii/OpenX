public class Tree {
    private int value;
    private int counter;
    private Tree left;
    private Tree right;

    public Tree(int value) {
        this.value = value;
        counter = 1;
    }

    public Tree() {
        counter = 0;
    }

    public void add(int element) {
        if (this.counter == 0) {
            this.value = element;
            counter++;
            return;
        }

        this.counter++;
        if (element < value) {
            if (left != null) {
                left.add(element);
            } else {
                left = new Tree(element);
            }
        } else {
            if (right != null) {
                this.right.add(element);
            } else {
                this.right = new Tree(element);
            }
        }
    }

    public Tree search(int element){
        if(element == this.value) return this;
        if(element < this.value){
            if(this.left == null){
                return null;
            }
            return this.left.search(element);
        }
        if(element > this.value){
            if(this.right == null){
                return null;
            }
            return this.left.search(element);
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public Tree getLeft() {
        return left;
    }

    public Tree getRight() {
        return right;
    }

    public int getCounter() {
        return counter;
    }
}
