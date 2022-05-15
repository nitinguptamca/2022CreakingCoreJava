package com.datastructure.stack;


public class MyDynamicStack {
    private int stackSize;
    private int[] stackArr;
    private int top;

    /**
     * constructor to create stack with size
     *
     * @param size
     */
    public MyDynamicStack(int size) {
        this.stackSize = size;
        this.stackArr = new int[stackSize];
        this.top = -1;
    }

    /**
     * This method adds new entry to the top of the stack
     *
     * @param entry
     * @throws Exception
     */
    public void push(int entry) {
        if (this.isStackFull()) {
            System.out.println(("Stack is full. Increasing the capacity."));
            this.increaseStackCapacity();
        }
        System.out.println("Adding: " + entry);
        this.stackArr[++top] = entry;
    }

    /**
     * This method removes an entry from the top of the stack.
     *
     * @return
     * @throws Exception
     */
    public int pop() throws Exception {
        if (this.isStackEmpty()) {
            throw new Exception("Stack is empty. Can not remove element.");
        }
        int entry = this.stackArr[top--];
        System.out.println("Removed entry: " + entry);
        return entry;
    }

    /**
     * This method returns top of the stack without removing it.
     *
     * @return
     */
    public long peek() {
        return stackArr[top];
    }

    private void increaseStackCapacity() {
        int[] newStack = new int[this.stackSize * 2];
		/*for (int i = 0; i < stackSize; i++) {
			newStack[i] = this.stackArr[i];
		}*/
        this.stackArr = newStack;
        this.stackSize = this.stackSize * 2;
    }

    /**
     * This method returns true if the stack is empty
     *
     * @return
     */
    public boolean isStackEmpty() {
        return (top == -1);
    }

    /**
     * This method returns true if the stack is full
     *
     * @return
     */
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }

    public static void main1(String[] args) {
        MyDynamicStack stack = new MyDynamicStack(2);
        for (int i = 1; i < 10; i++) {
            stack.push(i);
        }
        for (int i = 1; i < 4; i++) {
            try {
                stack.pop();
            } catch (Exception e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /******************************************************************************
     * However a queue can be implemented using two stacks. Algorithm is as follows
     * *****************************************************************************
     *
     * Create two stacks : 's' and 'tmp' as in the program given below For insert
     * operation : if size of s = 0 then push value into s else push all popped
     * elements from s to tmp push value into s push all popped elements from tmp to
     * s
     *
     * For remove operation : if size of s = 0 then throw 'underflow' exception else
     * return pop element from s
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        MyDynamicStack stack = new MyDynamicStack(2);
        MyDynamicStack tmp=new MyDynamicStack(2);
        for (int i = 1; i < 5; i++) {
            stack.push(i);
        }
        while(stack.isStackEmpty()==false) {
            tmp.push(stack.pop());
        }
        while(tmp.isStackEmpty() == false) {
            stack.push(tmp.pop());
        }
        while(stack.isStackEmpty()==false) {
            System.out.println(stack.pop());
        }
    }
}
