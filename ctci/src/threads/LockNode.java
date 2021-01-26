package threads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;

public class LockNode {
	public enum VisitState {FRESH,VISITING,VISITED};
	
	private ArrayList<LockNode> children;
	private int lockId;
	private Lock lock;
	private int maxLocks;
	
	public LockNode(int lockId, int maxLocks) {
		super();
		this.lockId = lockId;
		this.maxLocks = maxLocks;
	}

	public void join(LockNode curr) {
		children.add(curr);
	}
	
	
}

class LockFactory{
	private static LockFactory instance;
	private int numberOfLocks = 5;
	private LockNode[] locks;
	
	public boolean declare(int pid, int[] resourcesInOrder) {
		HashMap<Integer, Boolean> touchedNodes = new HashMap<Integer,Boolean>();
		/*
		 * add nodes to graph
		 */
		int index = 1;
		touchedNodes.put(resourcesInOrder[0], false);
		for (index = 1; index < resourcesInOrder.length; index++) {
			LockNode prev = locks[resourcesInOrder[index-1]];
			LockNode curr = locks[resourcesInOrder[index]];
			prev.join(curr);
			touchedNodes.put(resourcesInOrder[index], false);
		}
		
		/*
		 * check for cycle
		 */
		
		return true;
	}
}
