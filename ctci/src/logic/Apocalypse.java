package logic;

import java.util.Random;

public class Apocalypse {

	public static int[] runOneFamily() {
		Random random = new Random();
		int boys = 0 ;
		int girls = 0 ;
		while(girls == 0) {
			if(random.nextBoolean()) {
				girls += 1;
			}else {
				boys += 1;
			}
		}
		int[] genders = {girls,boys};
		return genders;
	}
	
	public static void main(String[] args) {
		int boys = 0;
		int girls = 0;
		for (int i = 0; i < 10000000; i++) {
			int[] genders = runOneFamily();
			girls += genders[0];
			boys += genders[1];
		}
		System.out.print(girls / (double)(boys+girls));
	}
}
