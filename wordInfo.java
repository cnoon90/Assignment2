
package assign2;


public class wordInfo {
    public String word;
    public String meaning;
    
    public wordInfo(String word, String meaning){
        this.word = word;
        this.meaning = meaning;
    }
    
    @Override
    public String toString(){
        return this.word + ", " + this.meaning + " ";
    }
    
}
