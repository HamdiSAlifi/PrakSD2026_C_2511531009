package pekan4_2511531009;

public class QueueArray_2511531009 {
	int front_1009, rear_1009, size_1009;
	int capacity_1009;
	int array_1009[];
	
	// mengontruksikan queuearray
	public QueueArray_2511531009(int capacity_1009) {
		this.capacity_1009 = capacity_1009; // meng-assign capacity input ke capacity pada class
		front_1009 = this.size_1009 = 0;
		rear_1009 = capacity_1009 - 1;
		array_1009 = new int[this.capacity_1009];
	}
	
	boolean isFull_1009(QueueArray_2511531009 queue_1009) {
		return (queue_1009.size_1009 == queue_1009.capacity_1009);
	}
	
	boolean isEmpty_1009(QueueArray_2511531009 queue_1009) {
		return (queue_1009.size_1009 == 0);
	}
	
	void enqueue_1009(int item_1009) {
		if (isFull_1009(this))
			return;
		this.rear_1009 = (this.rear_1009 + 1) % this.capacity_1009;
		this.array_1009[this.rear_1009] = item_1009;
		this.size_1009 = this.size_1009 + 1;
		System.out.println(item_1009 + " enquequed to queue_1009"); // memberitahu user bahwa data telah masuk ke dalam queue
	}
	
	int dequeue_1009() {
		if (isEmpty_1009(this))
			return Integer.MIN_VALUE;
		int item_1009 = this.array_1009[this.front_1009];
		this.front_1009 = (this.front_1009 + 1) % this.capacity_1009;
		this.size_1009 = this.size_1009 - 1;
		return item_1009;
	}
	
	int front_1009() {
		if (isEmpty_1009(this))
			return Integer.MIN_VALUE; // mengindikasikan bahwa queue berada pada kondisi kosong
		
		return this.array_1009[this.front_1009];
	}
	
	int rear_1009() {
		if (isEmpty_1009(this))return Integer.MIN_VALUE;
		
		return this.array_1009[this.rear_1009];
	}
	
	// print queue element
	void display_1009() {
		int i_1009;
		if (front_1009 == rear_1009) {
			System.out.printf("\nAntrian Kososng\n");
			return;
		}
		// visit from last and print
		for (i_1009 = front_1009; i_1009 < rear_1009; i_1009++) {
			System.out.printf(" %d <-- ", array_1009[i_1009]);
		}
	}

}
