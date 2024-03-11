package interfaces;

import trees.TreeNodeBase;

public interface ITreeBase<T, DT extends TreeNodeBase<T>>
{
    DT delete(DT root, int key);
    T search(DT root, int key);
    DT insert(DT root, int key, T value);

    DT getRoot();
}
