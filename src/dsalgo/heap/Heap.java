package dsalgo.heap;

import java.util.Arrays;

public class Heap {

	int[] heap;
	
	int heapSize;
	
	int maxSize;
	
	public Heap(int max) {
		maxSize = max;
		heapSize = 0;
		heap = new int[maxSize];
		
	}
	
	public boolean isEmpty() {
		return heapSize == 0;
	}
	
	public boolean insert(int item) {
		if(heapSize == maxSize-1)
			return false;
		
		
		heap[heapSize] = item;
		
		int pos = heapSize;
		
		while(pos!=0 && item > heap[(pos-1)/2]) {
			heap[pos] = heap[(pos-1)/2];
			pos = (pos-1)/2;
		}
		
		heap[pos] = item;
		heapSize++;
		return true;
	}
	
	public int remove() {
		int el = heap[0];
		
		heap[0]  = heap[heapSize-1];
		heap[heapSize-1] = 0;
		heapSize--;
		
		int start = 0;
		while(start<heapSize/2 && (heap[start*2 +1] > heap[start] || heap[start*2 +2] > heap[start])) {
			
			if(heap[start*2 +1] > heap[start*2 +2]) {
				int temp = heap[start];
				heap[start] = heap[start*2 +1];
				heap[start*2 +1] = temp;
			}else {
				int temp = heap[start];
				heap[start] = heap[start*2 +2];
				heap[start*2 +2] = temp;
			}
		}
		
		return el;
	}
	public static void main(String[] args) {
		Heap heap = new Heap(10);
		heap.insert(3);
		heap.insert(4);
		heap.insert(5);
		heap.insert(1);
		heap.insert(12);
		/*heap.remove();
		heap.remove();
		heap.remove();*/
		System.out.println(Arrays.toString(Arrays.copyOf(heap.heap, heap.heapSize)));
	}
}
