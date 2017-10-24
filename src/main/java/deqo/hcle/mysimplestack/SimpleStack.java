package deqo.hcle.mysimplestack;

import java.util.EmptyStackException;

public interface SimpleStack {

	public boolean isEmpty();
	public int getSize();
	public void push(Item item);
	public Item peek() throws EmptyStackException;
	public Item pop() throws EmptyStackException;

}