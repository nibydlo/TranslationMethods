public  class Visualizer {

    public static void simpleVis(Tree tree) {
        simpleVis(tree, 0);
    }

    public static void simpleVis(Tree tree, int indent) {
        System.out.println();
        for (int i = 0; i < indent; i++) {
            System.out.print('\t');
        }
        System.out.print(tree.node);
        for (int i = 0; i < tree.children.size(); i++) {
            simpleVis(tree.children.get(i), indent + 1);
        }
    }
}
