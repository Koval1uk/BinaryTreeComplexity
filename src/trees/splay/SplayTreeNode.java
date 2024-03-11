package trees.splay;


import trees.TreeNodeBase;

public class SplayTreeNode<T> extends TreeNodeBase<T>
{
    private SplayTreeNode<T> parent;

    public SplayTreeNode(int key, T value)
    {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public SplayTreeNode<T> getLeft() { return (SplayTreeNode<T>) left; }
    public SplayTreeNode<T> getRight() { return (SplayTreeNode<T>) right; }

    public SplayTreeNode<T> getParent() { return parent; }

    public void setLeft(SplayTreeNode<T> left) 
    {
        this.left = left;
        if (left != null)
            left.parent = this;
    }

    public void setRight(SplayTreeNode<T> right) 
    {
        this.right = right;
        if (right != null)
            right.parent = this;
    }

    public void setParent(SplayTreeNode<T> parent) 
    {
        this.parent = parent;
    }

    public void insert(SplayTreeNode<T> node)
    {
        if (node.getKey() < this.getKey())
        {
            if (this.getLeft() == null)
                this.setLeft(node);
            else
                this.getLeft().insert(node);
        }
        else
        {
            if (this.getRight() == null)
                this.setRight(node);
            else
                this.getRight().insert(node);
        }
    }

    public SplayTreeNode<T> find(int key)
    {
        if (key == this.getKey())
            return this;

        else if (key < this.getKey())
        {
            if (this.getLeft() == null)
                return this;
            else
                return this.getLeft().find(key);
        }
        else
        {
            if (this.getRight() == null)
                return this;
            else
                return this.getRight().find(key);
        }
    }

    public SplayTreeNode<T> findMax()
    {
        if (this.getRight() == null)
            return this;
        else
            return this.getRight().findMax();
    }


    public String toString() {
        return "SplayTreeNode [key=" + key + ", value=" + value + "]";
    }

    public void print()
    {
        System.out.println(this.toString());
    }


    public boolean equals(SplayTreeNode<T> other)
    {
        if (value != other.value)
            return false;
        return true;
    }
}
