package util;

import java.util.*;

public class PrintUtil {

    private static final  String replace = "\\{\\}";

    public static void p(int[] o) {
        System.out.println(Arrays.toString(o));
    }


    public static void p(Object o) {
        System.out.println(o);
    }

    /**
     * [[0,0,0],[0,1,0],[0,1,0],[0,1,0],[0,0,0]] 变为int的二维数组，这样方面一些代码
     * */
    public static int[][] twoDimensionalArray(String s) {
        String[] spit = s.split("],");
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < spit.length; i++) {
            String array = spit[i].replace("[","").replace("]","");
            String[] arrayElemet = array.split(",");
            ArrayList<Integer> arrayTmp = new ArrayList<>();
            for (String e : arrayElemet) arrayTmp.add(Integer.parseInt(e));
            result.add(arrayTmp);
        }
        int[][] a = new int[result.size()][result.get(0).size()];
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                a[i][j]=result.get(i).get(j);
            }
        }
        return a;
    }

    public static int[] oneDimensionalArray(String s) {
        String[] spit = s.split(",");
        int[] result = new int[spit.length];
        for (int i = 0; i < spit.length; i++) {
            String array = spit[i].replace("[","").replace("]","");
            result[i] = Integer.parseInt(array);
        }
        return result;
    }


    public static <T> void p(T[] words, int left, int right, String spit) {
        for (int i = left; i <= right ; i++) {
            String value = words[i].toString() + (spit!=null?spit:"");
            System.out.print(value );
        }
        System.out.println();
    }

    public static TreeNode costructTreeNode(String s) {

        String[] spit = s.split(",");
        if(s.startsWith("[")){
            for (int i = 0; i < spit.length; i++) {
                spit[i] = spit[i].replaceAll("\\[","");
                spit[i] = spit[i].replaceAll("]","");
            }
        }
        TreeNode node = new TreeNode(Integer.parseInt(spit[0]));;
        costructTreeNode(0,node,spit);
        return node;

    }

    private static void costructTreeNode(int i, TreeNode node, String[] spit) {
        if(2*i+1 < spit.length){
            String value = spit[2*i+1];
            if("null".equals(value)){
                node.left = null;
                return;
            }else{
                node.left = new TreeNode(Integer.parseInt(value));
                costructTreeNode(2*i+1,node.left,spit);
            }

        }

        if(2*(i + 1) < spit.length){
            String value = spit[2*(i+1)];
            if("null".equals(value)){
                node.right = null;
                return;
            }else{
                node.right = new TreeNode(Integer.parseInt(value));
                costructTreeNode(2*(i+1),node.right,spit);
            }
        }
    }

    public static Set<Integer> toSet(String s) {
        HashSet<Integer> set = new HashSet<>();
        String[] spit = s.split(",");
        for (int i = 0; i < spit.length; i++) {
            set.add(Integer.parseInt(spit[i]));
        }
        return set;
    }


    private enum Level {
        SOIUT("consoult");
        private String s;

        Level(String s) {
            this.s = s;
        }
    }

    public static void p(String format, Object... arguments) {
        info(Level.SOIUT, format, arguments);
    }

    private static void info(Level info, String format, Object[] arguments) {
        switch (info){
            case SOIUT:
                for (int i = 0; i < arguments.length; i++) {
                    format = format.replaceFirst(replace,arguments[i].toString());
                }
                System.out.println(format);
            default:
                return;
        }
    }


    public static void pIntArray(int[][] a) {
        if (a != null) {
            for (int[] element : a) {
                System.out.println(Arrays.toString(element));
            }
        }
    }


    // [5,4,8,11,null,13,4,7,2,null,null,5,1]
    public TreeNode construct(String value){
        TreeNode root = new TreeNode();
        return root;
    }

    public static void pLine() {
        System.out.println("----------------------------------------------------------------------------------------");
    }


}
