import java.util.HashMap;
import java.util.Arrays;

public class OtherTree extends Tree {

	private HashMap<String,Integer> hm;
	public OtherTree(String node, HashMap<String,Integer> hm, Tree... children) {
		this.node = node;
		this.hm = hm;
		this.children = Arrays.asList(children);
	}
}
