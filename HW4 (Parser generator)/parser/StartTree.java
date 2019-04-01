import java.util.HashMap;
import java.util.Arrays;

public class StartTree extends Tree {

	public HashMap<String,Integer> hm;
	public StartTree(String node, Tree... children) {
		this.node = node;
		this.children = Arrays.asList(children);
	}
}
