import java.util.ArrayList;

public class Stack {
    ArrayList<String> stack;

    public Stack (){
        this.stack = new ArrayList<String>();
    }

    public String top (){
        return this.stack.get(length()-1);
    }

    public void push (String s){
        this.stack.add(s);
    }

    public void pop (){
        if (!empty()){
            this.stack.remove(length() -1);
        }
    }

    public boolean empty (){
        return this.stack.size() == 0;
    }

    public int length (){
        return this.stack.size();
    }



}
