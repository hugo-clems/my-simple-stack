package deqo.hcle.mysimplestack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.EmptyStackException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.*;

public class MySimpleStackTest {

	private Item item1 = new Item(1);
	private Item item2 = new Item(2);
	private Item item3 = new Item(3);
	private ArrayList listeWithItems = new ArrayList();
	private MySimpleStack simpleStack;
	private MySimpleStack stackWithItems;

	@Test
	public void testIsEmpty() throws Exception {
		// SimpleStack est vide
		simpleStack = new MySimpleStack();
		boolean estVide = simpleStack.isEmpty();
		assertThat(estVide, is(true));

		// SimpleStack n'est pas vide
		simpleStack.push(item1);
		simpleStack.push(item2);
		estVide = simpleStack.isEmpty();
		assertThat(estVide, is(false));
	}

	@Test
	public void testGetSize() throws Exception {
		// SimpleStack taille 0
		simpleStack = new MySimpleStack();
		int taille = simpleStack.getSize();
		assertThat(taille, is(0));

		// SimpleStack taille 2
		simpleStack.push(item1);
		simpleStack.push(item2);
		taille = simpleStack.getSize();
		assertThat(taille, is(2));

		// SimpleStack taille 4
		simpleStack.push(item1);
		simpleStack.push(item1);
		taille = simpleStack.getSize();
		assertThat(taille, is(4));
	}

	@Test
	public void testPush() throws Exception {
		simpleStack = new MySimpleStack();
		listeWithItems.add(item1);
		stackWithItems = new MySimpleStack(listeWithItems);

		// Ajout d'un élement
		simpleStack.push(item1);
		assertThat(simpleStack.getSize(), is(stackWithItems.getSize()));
		assertThat(simpleStack.peek(), is(stackWithItems.peek()));

		// Ajout d'un NULL
		simpleStack.push(null);
		assertThat(simpleStack.getSize(), is(stackWithItems.getSize()));
		assertThat(simpleStack.peek(), is(stackWithItems.peek()));
	}

	@Test
	public void testPeekOk() throws Exception {
		simpleStack = new MySimpleStack();

		// Stack non vide
		simpleStack.push(item1);
		assertThat(simpleStack.peek(), sameInstance(item1));

		simpleStack.push(item2);
		assertThat(simpleStack.peek(), sameInstance(item2));
	}

	@Test(expected = EmptyStackException.class)
	public void testPeekException() throws Exception {
		// Stack vide
		simpleStack = new MySimpleStack();
		simpleStack.peek();
	}

	@Test
	public void testPopOk() throws Exception {
		simpleStack = new MySimpleStack();

		// Stack non vide
		simpleStack.push(item1);
		assertThat(simpleStack.pop(), sameInstance(item1));

		simpleStack.push(item2);
		assertThat(simpleStack.pop(), sameInstance(item2));
	}

	@Test(expected = EmptyStackException.class)
	public void testPopException() throws Exception {
		// Stack vide
		simpleStack = new MySimpleStack();
		simpleStack.pop();
	}

}