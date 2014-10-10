/*
Hoja de trabajo 8

Rony Ajtun 13384
Samuel Maldonado 13153
Marvin Najarro 13251

*/

import java.util.*;

class HashTable implements WordSet{
        private Hashtable nuevo;
        private int key;
       
        public HashTable(){
            nuevo = new Hashtable();
            key = 0;
        }
		
        public void add(Word wordObject){
            nuevo.put(key, wordObject);
            key++;
        }
		
        public Word get(Word word){
            Word wordNuevo;
            for(int x=0; x<nuevo.size(); x++){
                wordNuevo = (Word) nuevo.get(x);
                if(wordNuevo.getWord().equals(word.getWord())){
                    return wordNuevo;
                }
            }
            return null;
        }
       

}
