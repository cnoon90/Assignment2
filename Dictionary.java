package assign2;


public class Dictionary {
    private wordInfo[] wordI;
    private int size;
    private int num;
    Node root;
    
    public Dictionary(){
        root = null; 
        size = 2000;
        num = 1;
        wordI = new wordInfo[size];
    }
    
    public boolean add(String word, String meaning){
        Node newNode = new Node(word);
        wordInfo newWord = new wordInfo(word, meaning);
        
        if (root == null){
            root=newNode;
            return true;
        }
        Node par,curr;
        par=curr=root;
        while(curr!=null){
            par=curr;
            if (word.compareTo(curr.data)<0){
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }            
        }
        if (word.compareTo(par.data)<0){
            par.left=newNode;
            wordI[num] = newWord;
        }
        else if(word.compareTo(par.data)==0){
                return false;
        }
        else{
            par.right=newNode;
            wordI[num] = newWord;
        }
        num++;
        return true;
        
    }
    
    public boolean delete(String word){
        root = reDelete(root, word);
        return true;
    }
    
    private Node reDelete(Node root, String word){
        if (root==null) return null;
        
        if (word.compareTo(root.data)<0){
            root.left = reDelete(root.left,word);
        }
        else{
            if(word.compareTo(root.data)>0){
                root.right = reDelete(root.right,word);
            }
            else{
                if (root.left==null) return root.right;
                if (root.right==null) return root.left;
                Node s = root.right;
                while (s.left!=null){
                    s=s.left;
                }
                root.data=s.data;
                root.right=reDelete(root.right,s.data);
            }
        }
        
        return root;    
    }
    
    public boolean exists(String word){
        Node curr=root;
        if(root==null) return false;
        while(curr!=null && !curr.data.equals(word)){
            if(word.compareTo(curr.data)<0){
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }
        }
        if(curr!=null) return true;
        return false;    
    }
    
    public String getMeaning(String word){
        Node curr=root;
        while(curr!=null && !curr.data.equals(word)){
            if(word.compareTo(curr.data)<0){
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }
        }
        
        if(curr!=null) return curr.data;
        return null;  
    }
    
    public int getCount(){
        int count = 0;
        for(int x=0;x<wordI.length;x++){
            if(wordI[x]!=null){
                count++;
            }
        }
        return count+1;
    }
    
    public String printWordList(){
        String list = "";
        for(int x = 0;x<wordI.length;x++){
            if(wordI[x]!=null){
                list += wordI[x];
            }
        }
        return list;
    }
    
    public void printDictionary(){
        inOrder(root);
    }
    
    private void inOrder(Node curr){
        if(curr!=null){
            inOrder(curr.left);
            System.out.println(curr.data);
            inOrder(curr.right);
        }
    }
    
}
