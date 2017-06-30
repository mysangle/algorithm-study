public class ReverseWords {
    public String reverseWords(String s) {
        String[] splitted = s.split(" ");
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < splitted.length; i++) {
            String output = reverse(splitted[i]);
            sb.append(output);
            if (i < splitted.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    // reverse string
    private String reverse(String input) {
        int len = input.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = len - 1; i >= 0; i--) {
            char c = input.charAt(i);
            sb.append(c);
        }
        return sb.toString();
    }
}

