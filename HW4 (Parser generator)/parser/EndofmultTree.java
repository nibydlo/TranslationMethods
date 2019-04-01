import java.util.HashMap;
import java.util.Arrays;

public class EndofmultTree extends Tree {

	public Integer val = 1;
	private HashMap<String,Integer> hm;
	public EndofmultTree(String node, HashMap<String,Integer> hm, Tree... children) {
		this.node = node;
		this.hm = hm;
		this.children = Arrays.asList(children);
	}
}
