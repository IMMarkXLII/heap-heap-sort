# heap-heap-sort

```
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
  
```
