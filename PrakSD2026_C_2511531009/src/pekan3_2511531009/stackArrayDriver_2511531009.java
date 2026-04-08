package pekan3_2511531009;

public class stackArrayDriver_2511531009 {

	public static void main(String[] args) {
		stackArray_2511531009 s = new stackArray_2511531009();
			s.push_1009(10);
			s.push_1009(20);
			s.push_1009(30);
			System.out.println(s.pop_1009() + " dikeluarkan dari stack");
			System.out.println("Elemen teratas adalah : " + s.peek_1009());
			System.out.print("Element pada stack : ");
			s.print_1009();
	}

}
