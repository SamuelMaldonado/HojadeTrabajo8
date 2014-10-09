public class BinaryNode{
	// elementos en el árbol
		Comparable element;      
        BinaryNode left;        
        BinaryNode right;       
        
        /**
         * post: se hace un nodo nuevo con hijos vacíos
         * @param theElement 
         */
        BinaryNode( Comparable theElement )
        {
            this( theElement, null, null );
        }
        /**
         * 
         * @param theElement
         * @param lt
         * @param rt 
         */
        BinaryNode( Comparable theElement, BinaryNode lt, BinaryNode rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
        }

}