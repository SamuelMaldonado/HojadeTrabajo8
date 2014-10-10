/*
Hoja de trabajo 8

Rony Ajtun 13384
Samuel Maldonado 13153
Marvin Najarro 13251

*/

import java.util.*;
       
public class NewTreeMap implements WordSet{
   
    private TreeMap nuevo;
       
        public NewTreeMap(){
                nuevo = new TreeMap();
        }
       
        public Word get(Word word){
             return (Word)nuevo.get(word.getWord());
        }

        public void add(Word wordObject){
          if (!nuevo.containsKey(wordObject.getWord()))
            nuevo.put(wordObject.getWord(),wordObject);
        }
}
