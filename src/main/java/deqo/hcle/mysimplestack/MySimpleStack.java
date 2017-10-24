package deqo.hcle.mysimplestack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MySimpleStack implements SimpleStack {

	private ArrayList liste;

	public MySimpleStack() {
		this.liste = new ArrayList();
	}

	public MySimpleStack(ArrayList liste) {
		this.liste = liste;
	}

	public boolean isEmpty() {
		return liste.isEmpty();
	}

	public int getSize() {
		return liste.size();
	}

	public void push(Item item) {
		if (item != null) {
			liste.add(item);
		}
	}

	public Item peek() throws EmptyStackException {
		if (liste.isEmpty()) {
			throw new EmptyStackException();
		}
		return (Item) liste.get(getSize()-1);
	}

	public Item pop() throws EmptyStackException {
		if (liste.isEmpty()) {
			throw new EmptyStackException();
		}
		return (Item) liste.remove(getSize()-1);
	}

}