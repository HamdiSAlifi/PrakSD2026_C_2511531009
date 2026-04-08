package pekan3_2511531009;

import java.util.ArrayList;

class Siswa_2511531009 {
	
	String nama;
	int nim;
	
	public Siswa_2511531009(String nama, int nim) {
		this.nama = nama;
		this.nim = nim;
		
	}
	
	@Override
	public String toString() {
		return "NIM : " + nim + 
				", Nama : " + nama;
	}
}	
public class SiswaStack_2511531009 {
	private ArrayList<Siswa_2511531009> stack_1009;
	
	public SiswaStack_2511531009() {
		stack_1009 = new ArrayList<>();
	}
	
	public void push_1009(Siswa_2511531009 mhs) {
		stack_1009.add(mhs);
		
	}
	
	public Siswa_2511531009 pop_1009() {
		if (!stack_1009.isEmpty()) {
			return stack_1009.remove(stack_1009.size() - 1);
		}
		return null;
	}
	
	public Siswa_2511531009 peek_1009() {
		if (!stack_1009.isEmpty()) {
			return stack_1009.get(stack_1009.size() - 1);
		}
		return null;
	}
	
	public boolean isEmpty() {
		return stack_1009.isEmpty();
	}
	
	public void tampilkanSiswa() {
		for (int i = stack_1009.size() - 1; i >= 0; i--) {
			System.out.println(stack_1009.get(i));
		}
	}
	
	public static void main(String[] args) {
		SiswaStack_2511531009 studentStack = new SiswaStack_2511531009();
		
		Siswa_2511531009 mhs1_1009 = new Siswa_2511531009("Ali", 1);
		Siswa_2511531009 mhs2_1009 = new Siswa_2511531009("Bobby", 2);
		Siswa_2511531009 mhs3_1009 = new Siswa_2511531009("Charles", 3);
		
		studentStack.push_1009(mhs1_1009);
		studentStack.push_1009(mhs2_1009);
		studentStack.push_1009(mhs3_1009);
		
		System.out.println("Siswa di dalam stack");
		studentStack.tampilkanSiswa();
		
		System.out.println("siswa teratas " + studentStack.peek_1009());
		System.out.println("mengeluarkan siswa teratas dari stack : " + studentStack.pop_1009());
		System.out.println("daftar siswa setelah di pop_1009 : ");
		studentStack.tampilkanSiswa();
	}
	
	
}
