class Solution {
        public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();

        for (char c : array) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);

            else {
                if (!stack.empty() && c == ')' && stack.pop() == '(')
                    continue;
                else if (!stack.empty() && c == ']' && stack.pop() == '[')
                    continue;
                else if (!stack.empty() && c == '}' && stack.pop() == '{')
                    continue;
                else
                    return false;
            }
        }
        return stack.empty();
    }
}