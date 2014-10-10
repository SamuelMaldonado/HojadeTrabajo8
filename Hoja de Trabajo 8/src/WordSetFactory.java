/*
UVG
Algoritmos y Estructuras de Datos - 2011
Hoja de trabajo 7 
Autor: Eduardo Castellanos

Descripción: WordSetFactory. Clase  utilizada para instanciar los diferentes tipos de sets. 
*/

class WordSetFactory {
       
        // Metodo que genera un objeto que implementa WordSet
        // parametro tipo: 1 = SimpleSet
        //                         2 = implementado con Red black tree
        //                         3 = implementado con Splay Tree
        //                         4 = implementado con Hash Table
        //                         5 = implementado con TreeMap (de Java Collection Framework)
       
        public static WordSet generateSet(int tipo){
           
            if (tipo == 1){
                    return new SimpleSet();
            }
            else if (tipo==2){
                return new RBT();
            }
            else if (tipo==3){
                return new SplayTree();
            }
            else if (tipo==4){
                return new HashTable();
            }
            else if (tipo==5){
                return new NewTreeMap();
            }
            else{
                return null;
            }
               
        }
       
       
}

