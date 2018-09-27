import java.util.Scanner;
import java.util.LinkedList;
class Solution {
	Solution() {
		//unused
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		String[] tokens = line.split("");
		LinkedList<Integer> operands = new LinkedList<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			System.out.println(tokens[i]);
			if (!"*/-+".contains(tokens[i])) {
				operands.add(Integer.parseInt(tokens[i]));
			} else {
				System.out.println(tokens[i]);
				switch (tokens[i]) {
				case "+":
					int a = operands.removeLast();
					int b = operands.removeLast();
					// c = c + a + b;
					operands.add(a + b);
					break;
				case "-":
					a = operands.removeLast();
					b = operands.removeLast();
					operands.add(a - b);
					break;
				case "*":
				    a = operands.removeLast();
				    b = operands.removeLast();
				    operands.add(a * b);
				    break;
				case "/":
				    a = operands.removeLast();
				    b = operands.removeLast();
				    operands.add(a / b);    	
                    break;
                default:    
				}
			}
		}
		System.out.println(operands.get(0));
	}
}