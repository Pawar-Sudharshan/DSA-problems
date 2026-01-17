class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                // ignore empty tokens and current directory
                continue;
            } else if (part.equals("..")) {
                // go up one directory if possible
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else {
                // any other name (including "...", "....", etc.) is valid
                stack.addLast(part);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append('/').append(dir);
        }
        return sb.toString();
    }
}
