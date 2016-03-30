public class ParenDemo{
    private static MyStack<Character> stack =new MyStack<Character>();
    public static boolean isMatching(String s){
	for(char chars : s.toCharArray()){
	    if(chars=='('||chars=='['||chars=='{'||chars=='<'){
		stack.push(chars);
	    } 
	    if(!stack.isEmpty() && match(stack.peek(),chars)){
		stack.pop();
	    }
	    else if(chars==')'||chars==']'||chars=='}'||chars=='>'){
		return false;
	    }
	}
        return stack.isEmpty();
    }
    private static boolean match(char open,char close){
	if(open=='('&&close==')'){
	    return true;
	}
	if(open=='['&&close==']'){
	    return true;
	}
	if(open=='<'&&close=='>'){
	    return true;
	}
	return open=='{'&&close=='}';	
    }


 public static void main(String[]args){
     String input = "()()(([[]]))";
 if(args.length > 0){
    input = args[0];
    System.out.println(isMatching(input)); 
 }else{
    System.out.println(isMatching(input)); 
 }
 
 }
}
