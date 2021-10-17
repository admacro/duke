package xyz.admacro.misc;

// This class demonstrates the execution order of constructor,
// anonymous code blocks and static code blocks of java class.
public class ExecutionOrder {
    private static int i = 0;
    private static String INDENT = "----";

    public static void log(int classHierarchyLevel, String executionPoint) {
        String indentation = INDENT.repeat(classHierarchyLevel - 1) + "> ";
        System.out.println(++i + " " + indentation + executionPoint);
    }

    static class GrandParentClass {
        static { ExecutionOrder.log(1, "GrandParentClass static block: static {}"); }
        { ExecutionOrder.log(1, "GrandParentClass anonymous block: {}"); }
        public GrandParentClass() {
            ExecutionOrder.log(1, "GrandParentClass constructor: ()");
        }
    }

    static class ParentClass extends GrandParentClass {
        static { ExecutionOrder.log(2, "ParentClass static block: static {}"); }
        { ExecutionOrder.log(2, "ParentClass anonymous block: {}"); }
        public ParentClass() {
            ExecutionOrder.log(2, "ParentClass constructor: ()");
        }
    }

    static class ChildClass extends ParentClass {
        static { ExecutionOrder.log(3, "ChildClass static block: static {}"); }
        { ExecutionOrder.log(3, "ChildClass anonymous block: {}"); }
        public ChildClass() {
            ExecutionOrder.log(3, "ChildClass constructor: ()");
        }
    }

    public static void main(String args[]) {
        System.out.println("new ChildClass() ==> ");
        new GrandParentClass();
    }
}
