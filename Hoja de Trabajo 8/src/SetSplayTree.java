

    // SplayTree class
    //
    // CONSTRUCTION: with no initializer
    //
    // ******************PUBLIC OPERATIONS*********************
    // void insert( x )       --> Insert x
    // void remove( x )       --> Remove x
    // Comparable find( x )   --> Return item that matches x
    // Comparable findMin( )  --> Return smallest item
    // Comparable findMax( )  --> Return largest item
    // boolean isEmpty( )     --> Return true if empty; else false
    // void makeEmpty( )      --> Remove all items
    // void printTree( )      --> Print tree in sorted order

    /**
     * Implements a top-down splay tree.
     * Note that all "matching" is based on the compareTo method.
     * @author Mark Allen Weiss
     */
    public class SetSplayTree
    {
    	private static BinaryNode newNode = null;
    	private static BinaryNode nullNode;
    	private static BinaryNode header = new BinaryNode(null);
    	private BinaryNode root;
        /**
         * Construct the tree.
         */
        public SetSplayTree( )
        {
            root = nullNode;
            nullNode.left = nullNode;
            nullNode.right = nullNode;
            nullNode = new BinaryNode(null);
        }

        /**
         * Insert into the tree.
         * @param x the item to insert.
         */
        public void insert( Comparable x )
        {
            if( newNode == null )
                newNode = new BinaryNode( null );
            newNode.element = x;

            if( root == nullNode )
            {
                newNode.left = newNode.right = nullNode;
                root = newNode;
            }
            else
            {
                root = splay( x, root );
                if( x.compareTo( root.element ) < 0 )
                {
                    newNode.left = root.left;
                    newNode.right = root;
                    root.left = nullNode;
                    root = newNode;
                }
                else
                if( x.compareTo( root.element ) > 0 )
                {
                    newNode.right = root.right;
                    newNode.left = root;
                    root.right = nullNode;
                    root = newNode;
                }
                else
                    return;
            }
            newNode = null;   // So next insert will call new
        }



        /**
         * Find an item in the tree.
         * @param x the item to search for.
         * @return the matching item or null if not found.
         */
        public Comparable find( Comparable x )
        {
            root = splay( x, root );

            if( isEmpty( ) || root.element.compareTo( x ) != 0 )
                return null;

            return root.element;
        }

        /**
         * Test if the tree is logically empty.
         * @return true if empty, false otherwise.
         */
        public boolean isEmpty( )
        {
            return root == nullNode;
        }
        
        private BinaryNode splay( Comparable x, BinaryNode t )
        {
            BinaryNode leftTreeMax, rightTreeMin;

            header.left = header.right = nullNode;
            leftTreeMax = rightTreeMin = header;

            nullNode.element = x;   // Guarantee a match

            for( ; ; )
                if( x.compareTo( t.element ) < 0 )
                {
                    if( x.compareTo( t.left.element ) < 0 )
                        t = rotateWithLeftChild( t );
                    if( t.left == nullNode )
                        break;
                    // Link Right
                    rightTreeMin.left = t;
                    rightTreeMin = t;
                    t = t.left;
                }
                else if( x.compareTo( t.element ) > 0 )
                {
                    if( x.compareTo( t.right.element ) > 0 )
                        t = rotateWithRightChild( t );
                    if( t.right == nullNode )
                        break;
                    // Link Left
                    leftTreeMax.right = t;
                    leftTreeMax = t;
                    t = t.right;
                }
                else
                    break;

            leftTreeMax.right = t.left;
            rightTreeMin.left = t.right;
            t.left = header.right;
            t.right = header.left;
            return t;
        }

        /**
         * Rotate binary tree node with left child.
         */
        static BinaryNode rotateWithLeftChild( BinaryNode k2 )
        {
            BinaryNode k1 = k2.left;
            k2.left = k1.right;
            k1.right = k2;
            return k1;
        }

        /**
         * Rotate binary tree node with right child.
         */
        static BinaryNode rotateWithRightChild( BinaryNode k1 )
        {
            BinaryNode k2 = k1.right;
            k1.right = k2.left;
            k2.left = k1;
            return k2;
        }

        /**
         * Internal method to print a subtree in sorted order.
         * WARNING: This is prone to running out of stack space.
         * @param t the node that roots the tree.
         */
        private void printTree( BinaryNode t )
        {
            if( t != t.left )
            {
                printTree( t.left );
                System.out.println( t.element.toString( ) );
                printTree( t.right );
            }
        }
    }