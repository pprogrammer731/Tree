public class BinaryTree<E> {
    private Node<E>root=null;
    private int size=0;
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    protected Node<E>createNode(E e,Node<E>p,Node<E>l,Node<E>r){
        return new Node<E>(e,p,l,r);
    }
    protected Node<E>validate(Position<E>p){
        if (!(p instanceof Node))
            throw new IllegalArgumentException("this is not validate");
        Node<E>n= (Node<E>) p;
        if (n.getParent()==n)  throw new IllegalArgumentException("This position is removed");
        return n;
    }
    public Position<E> root(){
        return root;
    }
    public Position<E> parent(Position<E>p){
        Node<E>n=validate(p);
        return n.getParent();
    }
    public Position<E> left(Position<E>p){
        Node<E>n=validate(p);
        return n.getLeft();
    }

    public Position<E> right(Position<E>p){
        Node<E>n=validate(p);
        return n.getRight();
    }

    public int numOfChildren(Position<E>p){
        Node<E> n=validate(p);
        int count=0;
        if (n.getLeft()!=null)count++;
        if (n.getRight()!=null)count++;
        return count;
    }
    public Position<E> addRoot(E e){
        if (!isEmpty())throw new IllegalStateException("There is already root");
        root=new Node<E>(e,null,null,null);
        size=1;
        return root;
    }


    private static class Node<E> implements Position<E>{
        E element;
        Node<E>parent;
        Node<E>left;
        Node<E>right;

        public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        @Override
        public E getElement() {
            return null;
        }
    }
}
