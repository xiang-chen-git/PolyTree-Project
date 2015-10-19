package tree;

import java.util.Collection;

/**
 * This class represents a non-empty search tree. An instance of this class
 * should contain:
 * <ul>
 * <li>A key
 * <li>A value (that the key maps to)
 * <li>A reference to a left Tree that contains key:value pairs such that the
 * keys in the left Tree are less than the key stored in this tree node.
 * <li>A reference to a right Tree that contains key:value pairs such that the
 * keys in the right Tree are greater than the key stored in this tree node.
 * </ul>
 *  
 */
 public class NonEmptyTree<K extends Comparable<K>, V> implements Tree<K, V> {

	/* Provide whatever instance variables you need */
	 private Tree<K,V> left, right;
	 private K key;
	 private V value;

	/**
	 * Only constructor we need.
	 * @param key
	 * @param value
	 * @param left
	 * @param right
	 */
	public NonEmptyTree(K key, V value, Tree<K,V> left, Tree<K,V> right) {
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = right;

		//throw new UnsupportedOperationException("You must implement this method.");
	}

	public V search(K key) {
		int comparison = this.key.compareTo(key);
		if (comparison == 0) 
		return value;
		else if (comparison > 0) 
		return left.search(key);
		else
		return right.search(key);
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	
	public NonEmptyTree<K, V> insert(K key, V value) {
		int comparison = this.key.compareTo(key);
		if (comparison == 0) {
		this.value = value; // replace
		}
		else if (comparison > 0) {
		left = left.insert(key, value);
		}
		else {
		right = right.insert(key, value);
		}
		return this;

		//throw new UnsupportedOperationException("You must implement this method.");
	}
	
	public Tree<K, V> delete(K key) {
		int comparison = key.compareTo(this.key);
		if (comparison < 0) 
		left = left.delete(key);
		else if (comparison > 0)
		right = right.delete(key);
		else { 
		/* Found element to delete */
		try {
		K maximum = left.max();
		this.value = search(maximum);
		this.key = maximum;
		left = left.delete(maximum);
		} catch (TreeIsEmptyException e) {
		return right;
		}
		}
		return this;
		//throw new UnsupportedOperationException("You must implement this method.");
	}

	public K max() {
		try {
			return right.max();
			} catch (TreeIsEmptyException e) {
			return key;
			}
		//throw new UnsupportedOperationException("You must implement this method.");
	}

	public K min() {
		try {
			return left.min();
			} catch (TreeIsEmptyException e) {
			return key;
			}
		//throw new UnsupportedOperationException("You must implement this method.");
	}

	public int size() {
		return 1 + left.size() + right.size();

		//throw new UnsupportedOperationException("You must implement this method.");
	}

	public void addKeysToCollection(Collection<K> c) {
		left.addKeysToCollection(c);
		c.add(key);
		right.addKeysToCollection(c);
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	
	public Tree<K,V> subTree(K fromKey, K toKey) {
		if (key.compareTo(fromKey) < 0)
			return right.subTree(fromKey, toKey);
			else if (toKey.compareTo(key) < 0)
			return left.subTree(fromKey, toKey);
			else
			return new NonEmptyTree<K, V>(key, value, left.subTree(fromKey, toKey), 
			right.subTree(fromKey, toKey));
		//throw new UnsupportedOperationException("You must implement this method.");
	}
	
	public int height() {
		return Math.max(left.height(), right.height()) + 1;

		//throw new UnsupportedOperationException("You must implement this method.");
	}
	
	public void inorderTraversal(TraversalTask<K,V> p) {
		left.inorderTraversal(p);
		p.performTask(key, value);
		right.inorderTraversal(p);

		//throw new UnsupportedOperationException("You must implement this method.");
	}
	
	public void rightRootLeftTraversal(TraversalTask<K,V> p) {
		right.rightRootLeftTraversal(p);
		p.performTask(key, value);
		left.rightRootLeftTraversal(p);

		//throw new UnsupportedOperationException("You must implement this method.");
	}	
}