package pekan4_2511531009;

public class QueueArrayDriver_2511531009 {

	public static void main(String[] args) {
		QueueArray_2511531009 queue_1009 = new QueueArray_2511531009(1000);
		queue_1009.enqueue_1009(10);
		queue_1009.enqueue_1009(20);
		queue_1009.enqueue_1009(30);
		queue_1009.enqueue_1009(40);
	
		System.out.println("Item di depan " + queue_1009.front_1009());
		System.out.println("Item paling belakang " + queue_1009.rear_1009());
		
		System.out.println("tampilan queue");
		queue_1009.display_1009();
		System.out.println();
		System.out.println(queue_1009.dequeue_1009() + " dihapus dari queue");
		System.out.println("Item di depan " + queue_1009.front_1009());
		System.out.println("Item di belakang " + queue_1009.rear_1009());
		System.out.println("tampilan queue setelah satu data dihapus");
		queue_1009.display_1009();
		
		
	}

}
