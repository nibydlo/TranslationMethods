import java.util.HashMap;
import java.util.Arrays;

public class ExpTree extends Tree {

	public Integer val = 0;
	private HashMap<String,Integer> hm;
	public ExpTree(String node, HashMap<String,Integer> hm, Tree... children) {
		this.node = node;
		this.hm = hm;
		this.children = Arrays.asList(children);
	}
}
