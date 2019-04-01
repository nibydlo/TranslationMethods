import java.util.HashMap;
import java.util.Arrays;

public class AssignVarTree extends Tree {

	private HashMap<String,Integer> hm;
	public AssignVarTree(String node, HashMap<String,Integer> hm, Tree... children) {
		this.node = node;
		this.hm = hm;
		this.children = Arrays.asList(children);
	}
}
