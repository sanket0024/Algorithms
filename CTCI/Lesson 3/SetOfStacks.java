import java.util.List;
import java.util.ArrayList;
class SetOfStacks {
	int stackSize = 3;
	List<Integer[]> listStack = new ArrayList<Integer[]>();
	int top = -1;
	public void push(int value) {
		Integer[] temp;
		top++;
		if (listStack.isEmpty()) {
			temp = new Integer[stackSize];
			listStack.add(temp);
		}
		else {
			temp = listStack.get(listStack.size()-1);
		}
		if(top >= stackSize) {
			top = 0;
			temp = new Integer[stackSize];
			temp[top] = value;
			listStack.add(temp);
			return;
		}
		temp[top] = value;
	}

	public Integer pop() {
		if(listStack.isEmpty())
			return null;
		Integer[] temp = listStack.get(listStack.size()-1);
		int res = temp[top];
		temp[top] = null;
		top--;
		if(top < 0) {
			listStack.remove(temp);
			if(listStack.isEmpty())
				top = -1;
			else
				top = stackSize-1;
		}
		return res;
	}

	// Assumption that the all stacks are full except the last one
	public Integer popAt(int stackIndex) {
		if(listStack.isEmpty() || stackIndex > listStack.size()-1)
			return null;
		Integer[] temp = listStack.get(stackIndex);
		if(stackIndex == listStack.size()-1) {
			int res = temp[top];
			top--;
			if(top < 0) {
				listStack.remove(temp);
				top = listStack.isEmpty() ? -1 : stackSize-1;
			}
			return res;
		}
		else {
			int res = temp[stackSize-1];
			int index = stackSize-1;
			while(temp[index] != null) {
				if(index == 0) {
					index = stackSize-1;
					stackIndex++;
					temp = listStack.get(stackIndex);
				}
				else
					index--;
				temp[index] = temp[index+1];
			}
			temp[index-1] = null;
			return res;
		}
	}

	public void printStack() {
		Integer[] temp;
		//System.out.println("Stack Size: " + listStack.size());
		//System.out.println("Top: " + top);
		System.out.println();
		System.out.println();
		if(listStack.isEmpty()) {
			System.out.println("EMPTY");
			return;
		}
		for(int i=0; i<listStack.size(); i++) {
			temp = listStack.get(i);
			for(int j=0; j<temp.length; j++) {
				System.out.print(temp[j] + "  ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		SetOfStacks s = new SetOfStacks();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
		s.push(70);
		s.push(80);
		s.push(90);
		s.push(100);
		s.printStack();
		s.popAt(2);
		s.printStack();
	}
}