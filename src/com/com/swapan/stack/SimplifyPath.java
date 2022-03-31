package com.com.swapan.stack;

import java.util.Stack;

/**
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 * <p>
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 * <p>
 * The canonical path should have the following format:
 * <p>
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 */
public class SimplifyPath {

  static String simplifyPath(String path) {
    final Stack<String> stack = new Stack<>();

    String[] components = path.split("/");

    for (String dir : components) {

      if (dir.equals(".") || dir.isEmpty())
        continue;

      if (dir.equals("..")) {
        if (!stack.isEmpty()) stack.pop();
      } else {
        stack.push(dir);
      }
    }

    StringBuilder stringBuilder = new StringBuilder();

    for (String s : stack) {
      stringBuilder.append("/").append(s);
    }

    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    System.out.println(simplifyPath("/home//foo/../xyz/dfg/../sdr"));
  }
}
