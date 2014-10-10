/*
Hoja de trabajo 8

Rony Ajtun 13384
Samuel Maldonado 13153
Marvin Najarro 13251

*/


public class SplayTree implements WordSet{
    private BinaryNode root;

    public SplayTree() {
        root = null;
    }

    public Word get(Word word) {
        if (root == null) return null;
        splay(word);
        if(root.key.compareTo(word) != 0) return null;
        return  (Word) root.key;
    }

    public void add(Word wordObject) {
        BinaryNode n;
        int c;
        if (root == null) {
            root = new BinaryNode(wordObject);
            return;
        }
        splay(wordObject);
        if ((c = wordObject.compareTo( (Word) root.key)) == 0) {return;}
        n = new BinaryNode(wordObject);
        if (c < 0) {
            n.left = root.left;
            n.right = root;
            root.left = null;
        } else {
            n.right = root.right;
            n.left = root;
            root.right = null;
        }
        root = n;
    }

   
    private static BinaryNode header = new BinaryNode(null); 

    private void splay(Comparable key) {
        BinaryNode l, r, t, y;
        l = r = header;
        t = root;
        header.left = header.right = null;
        for (;;) {
            if (key.compareTo(t.key) < 0) {
                if (t.left == null) break;
                if (key.compareTo(t.left.key) < 0) {
                    y = t.left;                            /* rotacion derecha */
                    t.left = y.right;
                    y.right = t;
                    t = y;
                    if (t.left == null) break;
                }
                r.left = t;                                 /* link derecha */
                r = t;
                t = t.left;
            } else if (key.compareTo(t.key) > 0) {
                if (t.right == null) break;
                if (key.compareTo(t.right.key) > 0) {
                    y = t.right;                            /* rotacion izquierda */
                    t.right = y.left;
                    y.left = t;
                    t = y;
                    if (t.right == null) break;
                }
                l.right = t;                                /* link izquierda */
                l = t;
                t = t.right;
            } else {
                break;
            }
        }
        l.right = t.left;                                   /* armado */
        r.left = t.right;
        t.left = header.right;
        t.right = header.left;
        root = t;
    }
}


class BinaryNode
{
    BinaryNode(Comparable theKey) {
        key = theKey;
        left = right = null;
    }

    Comparable key;         
    BinaryNode left;
    BinaryNode right;
}

//Josh Israel 
//http://www.sanfoundry.com/java-program-implement-splay-tree/
//FUentes: http://www.link.cs.cmu.edu/splay/
//http://codereview.stackexchange.com/questions/12195/splay-tree-implementation
