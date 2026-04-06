package pekan2_2511531009;
import java.util.*;
public class DaftarKata_2511531009 {
	private final ArrayList<String> data;
	
	// Constructor
	public DaftarKata_2511531009()	{
		this.data = new ArrayList<>();
	}
	
	// Adding element in the end of the list
	public void tambah_2511531009(String elemen) {
		data.add(elemen);
	}
	
	// Adding element in an index (insert)
	public void tambahPada_2511531009(int index, String elemen) {
		data.add(index, elemen);
	}
	
	// Change element in an element, turn it into a new value of the index
	public void ubahElemen_2511531009(int index, String nilaiBaru) {
		data.set(index, nilaiBaru);
	}
	
	// Delete an element on an index and return deleted element
	public String hapusElemen_2511531009(int index) {
		return data.remove(index);
	}
	
	// Do an iteration and print every element in format : (index)
	// does not return a value, only demonstration
	public void iterasiCetak_2511531009() {
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i) + " ");
		}
	}
	
	// does not return a value, only demonstration
	public String get_2511531009(int index) {
		return data.get(index);
	}
	
	// String representation
	@Override
	public String toString()	{
		return data.toString();
	}
}
