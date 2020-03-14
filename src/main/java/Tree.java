public class Tree {
    private int value;
    //Counter is used for optimal calculation of median and average
    private int counter;
    private Tree root;
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

        if(this.root != null){
            Tree t = this.root;
            while(t.root != null) t = root;
            addFromRoot(t,element);
        }else {
            addFromRoot(this,element);
        }
    }

    //Adding every element from root
    private void addFromRoot(Tree t, int element){
        t.counter++;
        if (element < t.value) {
            if (t.left != null) {
                t.left.addFromRoot(t.left,element);
            } else {
                t.left = new Tree(element);
                t.left.root = t;
            }
        } else {
            if (t.right != null) {
                t.right.addFromRoot(t.right,element);
            } else {
                t.right = new Tree(element);
                t.right.root = t;
            }
        }
    }

    public void delete(int element){
        if(this.counter == 0) return;
        this.counter--;
        if(element < this.value) left.delete(element);
        else if(element > this.value) right.delete(element);
        else{
            //No Children
            if(this.left == null & this.right == null){
                if(element < this.root.value){
                    this.root.left = null;
                    return;
                }else{
                    this.root.right = null;
                }
            }
            //One Child
            else if(this.left == null || this.right == null){
                if(this.left == null){
                    if(this.value < this.root.value){
                        this.root.left = this.right;
                    }else{
                        this.root.right = this.right;
                    }
                }else{
                    if(this.value < this.root.value){
                        this.root.left = this.left;
                    }else{
                        this.root.right = this.left;
                    }
                }
            }
            //Two Child
            else{
                int min = getMinimum(this.right);
                this.deleteWithOutCounter(min);
                this.value = min;
            }
        }
    }

    //Method to replace elements for delete method
    private void deleteWithOutCounter(int element){
        if(element < this.value) left.deleteWithOutCounter(element);
        else if(element > this.value) right.deleteWithOutCounter(element);
        else{
            //No Children
            if(this.left == null & this.right == null){
                if(element < this.root.value){
                    this.root.left = null;
                    return;
                }else{
                    this.root.right = null;
                }
            }
            //One Child
            else{
                if(this.left == null){
                    if(this.value < this.root.value){
                        this.root.left = this.right;
                    }else{
                        this.root.right = this.right;
                    }
                }else{
                    if(this.value < this.root.value){
                        this.root.left = this.left;
                    }else{
                        this.root.right = this.left;
                    }
                }
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
            return this.right.search(element);
        }
        return null;
    }

    public int getMinimum(Tree t){
        while(t.left != null) t = t.left;
        return t.value;
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
