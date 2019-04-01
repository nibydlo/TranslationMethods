import java.util.HashMap;
import java.util.Arrays;

public class AtomTree extends Tree {

	public Integer val;
	private HashMap<String,Integer> hm;
	public AtomTree(String node, HashMap<String,Integer> hm, Tree... children) {
		this.node = node;
		this.hm = hm;
		this.children = Arrays.asList(children);
	}
}
