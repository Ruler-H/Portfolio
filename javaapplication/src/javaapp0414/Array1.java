package javaapp0414;

public class Array1 {

	public static void main(String[] args) {
		int [] rooms = {301, 302, 303, 304};
		System.out.println(rooms);
		System.out.println(rooms[0] + "호");
		for(int i = 0; i<4; i=i+1) {
			System.out.println(rooms[i] + "호");
		}
		int [] room = null;
		System.out.println(room.length);
	}

}
