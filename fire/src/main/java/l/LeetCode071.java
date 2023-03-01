package l;

import java.util.Stack;

public class LeetCode071 {

    //Given a string path, which is an absolute path (starting with a slash '/') to
//a file or directory in a Unix-style file system, convert it to the simplified ca
//nonical path.
//
// In a Unix-style file system, a period '.' refers to the current directory, a
//double period '..' refers to the directory up a level, and any multiple consecut
//ive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any
// other format of periods such as '...' are treated as file/directory names.
//
// The canonical path should have the following format:
//
//
// The path starts with a single slash '/'.
// Any two directories are separated by a single slash '/'.
// The path does not end with a trailing '/'.
// The path only contains the directories on the path from the root directory to
// the target file or directory (i.e., no period '.' or double period '..')
//
//
// Return the simplified canonical path.
//
//
// Example 1:
//
//
//Input: path = "/home/"
//Output: "/home"
//Explanation: Note that there is no trailing slash after the last directory nam
//e.
//
//
// Example 2:
//
//
//Input: path = "/../"
//Output: "/"
//Explanation: Going one level up from the root directory is a no-op, as the roo
//t level is the highest level you can go.
//
//
// Example 3:
//
//
//Input: path = "/home//foo/"
//Output: "/home/foo"
//Explanation: In the canonical path, multiple consecutive slashes are replaced
//by a single one.
//
//
// Example 4:
//
//
//Input: path = "/a/./b/../../c/"
//Output: "/c"
//
//
//
// Constraints:
//
//
// 1 <= path.length <= 3000
// path consists of English letters, digits, period '.', slash '/' or '_'.
// path is a valid absolute Unix path.
//
// Related Topics String Stack
// 👍 380 👎 110

    public static void main(String[] args) {
        System.out.println("keep happy");
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }


    public static String simplifyPath(String path) {
        if(path == null|| 0== path.length()||".".equals(path) || !path.startsWith("/")) return "";
        String[] split = path.split("/");

        Stack<String> stack = new Stack<>();
        for (String tmp : split){
            if (tmp.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!tmp.equals(".") && !tmp.equals("")) {
                stack.push(tmp);
            }
        }

        if(stack.isEmpty()) return "/";

        StringBuilder result = new StringBuilder();
        for (String tmp : stack) result.append("/").append(tmp);
        return result.toString();
    }
}
