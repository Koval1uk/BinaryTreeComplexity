package trees;

public abstract class TreeNodeBase<T>
{
    protected int key;
    protected T value;
    protected TreeNodeBase<T> left;
    protected TreeNodeBase<T> right;

    public int getKey() { return key; }
    public T getValue() { return value; }
    public TreeNodeBase<T> getLeft() { return left; }
    public TreeNodeBase<T> getRight() { return right; }

    public void setKey(int key) { this.key = key; }
    public void setValue(T value) { this.value = value; }
    public void setLeft(TreeNodeBase<T> left) { this.left = left; }
    public void setRight(TreeNodeBase<T> right) { this.right = right; }
}
