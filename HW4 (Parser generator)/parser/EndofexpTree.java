import java.util.HashMap;
import java.util.Arrays;

public class EndofexpTree extends Tree {

	public Integer val = 0;
	private HashMap<String,Integer> hm;
	public EndofexpTree(String node, HashMap<String,Integer> hm, Tree... children) {
		this.node = node;
		this.hm = hm;
		this.children = Arrays.asList(children);
	}
}
