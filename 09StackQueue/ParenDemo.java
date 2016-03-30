public class ParenDemo{
    private static MyStack<Character> stack =new MyStack<Character>();
    public static boolean isMatching(String s){
	char[] chars=s.toCharArray();
	for(int x=0;x<chars.length;x++){
	    if(chars[x]=='('||chars[x]=='['||chars[x]=='{'){
		stack.push(chars[x]);
	    } 
	    if(!stack.isEmpty() && match(stack.peek(),chars[x])){
		stack.pop();
	    }
	    else if(chars[x]==')'||chars[x]==']'||chars[x]=='}'){
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
