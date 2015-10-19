package performanceReport;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

import tree.PolymorphicBST;

/**
 * Provides examples on how to get timing information. 
 * Use this example as a starting point while developing your own
 * timing experiments (those associated with the report).  Your
 * report should be in the file performanceReport.docx.
 * @author cmsc132
 *
 */
public class TreeSpeed {
	static int[] data;
	static final int MAX_DATA = 500000;
	
	public static void main(String[] args) {
		generateRandomData(2000);
		timePolymorphicTree();
		timeTreeMap();
		
		generateSortedData(2000);
		timePolymorphicTree();
		timeTreeMap();
	}
	
	/**
	 * Generate a random data set
	 * @param size
	 */
	private static void generateRandomData(int size) {
		Random r = new Random(100L); 
		data = new int[size];
		for (int i = 1; i < size ; i++) {
			data[i] = r.nextInt(MAX_DATA);
		}
	}
	
	/**
	 * Generate a sorted data set
	 * @param size
	 */
	private static void generateSortedData(int size) {
		Random r = new Random(100L); 
		data = new int[size];
		for (int i = 1; i < size ; i++) {
			data[i] = i;
		}
	}
	 
	private static void timePolymorphicTree(){
		PolymorphicBST<Integer,Integer> myTree = new PolymorphicBST<Integer,Integer>();
		long time = System.currentTimeMillis();
		
		for (int i = 1; i < data.length; i++) {
			myTree.put(data[i], i);
		}
		time = System.currentTimeMillis() - time;
		System.out.println("PolymorphicBST Time(msec) = "+time);
	}

	private static void timeTreeMap(){
		TreeMap<Integer,Integer> myTree = new TreeMap<Integer,Integer>();
		long time = System.currentTimeMillis();
		
		for (int i = 1; i < data.length; i++) {
			myTree.put(data[i], i);
		}
		time = System.currentTimeMillis() - time;
		System.out.println("TreeMap Time(msec) = "+time);
	}
}
