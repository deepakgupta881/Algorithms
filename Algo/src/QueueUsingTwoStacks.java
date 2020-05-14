import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QueueUsingTwoStacks {

	public Stack<Integer> stack1 = new Stack<>();
	public Stack<Integer> stack2 = new Stack<>();
	public static int front = -1;

	public static void enqueu(int x, Stack<Integer> stack1, Stack<Integer> stack2) {

		if (stack2.isEmpty()) {
			stack1.push(x);
//			front=stack1.peek();
		} else {
			while (!stack2.isEmpty()) {
				int item = stack2.peek();
				stack2.pop();
				stack1.push(item);
			}
			stack1.push(x);
		}

	}

	public static void dequeu(Stack<Integer> stack1, Stack<Integer> stack2) {
		while (!stack1.isEmpty()) {
			int d = stack1.peek();
			stack1.pop();
			stack2.push(d);
		}
		stack2.pop();
//		front=stack2.pop();
	}

	public static void print(Stack<Integer> stack1, Stack<Integer> stack2) {
		/*
		 * if (stack.isEmpty()) { return; }
		 */

		if (stack1.isEmpty() && stack2.isEmpty()) {
			return;
		}

		while (!stack1.isEmpty()) {
			int d = stack1.peek();
			stack1.pop();
			stack2.push(d);
		}
		System.out.println(stack2.peek());
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		QueueUsingTwoStacks s = new QueueUsingTwoStacks();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int q = sc.nextInt();
			switch (q) {
			case 1:
				int data = sc.nextInt();
				QueueUsingTwoStacks.enqueu(data, s.stack1, s.stack2);
				break;

			case 2:
				QueueUsingTwoStacks.dequeu(s.stack1, s.stack2);
				break;

			case 3:
				QueueUsingTwoStacks.print(s.stack1, s.stack2);
				break;

			}

		}

	}
}