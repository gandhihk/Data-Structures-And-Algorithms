package ds.stacks;

public class Implement2StackIn1Array {
	
	int top1, top2;
	int size;
	int arr[];
	Implement2StackIn1Array(int n){
		top1 = -1;
		top2 = n; size=n;
		arr = new int[n];
	}
	
	void pushInStack1(int k) {
		if(top1<top2-1) {
			top1++;
			arr[top1] = k;
		}else {
			System.out.println("Stack 1 overflow");
		}
	}
	
	void pushInStack2(int k) {
		if(top1<top2-1) {
			top2--;
			arr[top2] = k;
		}else {
			System.out.println("Stack 2 overflow");
		}
	}
	
	int popFromStack1() {
		int ans;
		if(top1>=0) {
			ans = arr[top1];
			top1--;
			return ans;
		}else {
			System.out.println("Stack 1 empty");
			return -1;
		}
	}
	
	int popFromStack2() {
		int ans;
		if(top2<this.size) {
			ans = arr[top2];
			top2++;
			return ans;
		}else {
			System.out.println("Stack 2 empty");
			return -1;
		}
	}

	public static void main(String[] args) {
		Implement2StackIn1Array stack = new Implement2StackIn1Array(10);
		stack.pushInStack1(5); 
        stack.pushInStack2(10); 
        stack.pushInStack2(15); 
        stack.pushInStack1(11); 
        stack.pushInStack2(7); 
        System.out.println("Popped element from"
                           + " stack1 is " + stack.popFromStack1()); 
        stack.pushInStack2(40); 
        System.out.println("Popped element from"
                           + " stack2 is " + stack.popFromStack2());
	}

}
