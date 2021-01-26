package logic;

public class EggDrop {

	static Integer worstCaseCount = 0;
	
	public static int findBreakingPoint(int floors, int breakingPoint){
		int interval = findInterval(floors);
		int egg1 = interval;
		int previous = 1;
		
		while(!drop(egg1,breakingPoint) && egg1 <= floors) {
			interval-=1;
			previous = egg1;
			egg1 += interval;
		}
		
		int egg2 = previous;
		while(!drop(egg2,breakingPoint) && egg2 < egg1 && egg2 <= floors) {
			egg2 += 1;
		}
		
		return egg2 > floors ? -1 : egg2;
	}
	
	public static boolean drop(Integer floor, Integer breakingPoint) {
		worstCaseCount += (floor >= breakingPoint ? 0 : 1);
		return floor >= breakingPoint;
	}
	
	public static int findInterval(int floor) {
		double determinant = 1+8*floor;
		int firstRoot = (int) Math.ceil((-1+Math.sqrt(determinant))/2);
		return firstRoot;
	}
	
	public static void main(String[] args) {
		System.out.println(findBreakingPoint(100,14));
		System.out.println(worstCaseCount);
	}
}
