package bit;

import java.util.ArrayList;
import java.util.List;

public class Insertion {

	public static void main(String[] args) {
		String s = "abcd";
		for (int i = 0; i < (1<<(s.length()-1)); i++) {
			List<String> res = new ArrayList<>();
			int lastcut = 0;
			for (int j = 0; j < s.length()-1; j++) {
				if(((1<<j) & i) != 0) {
					res.add(s.substring(lastcut,j+1));
					lastcut = j+1;
				}
			}
			res.add(s.substring(lastcut));
			System.out.println(res);
		}
	}
}
 