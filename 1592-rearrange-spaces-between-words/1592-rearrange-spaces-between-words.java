class Solution {
    public String reorderSpaces(String text) {
                int totalSpaces = 0;

        for (char c : text.toCharArray()) {
            if (c == ' ') {
                totalSpaces++;
            }
        }

        String[] words = text.trim().split("\\s+");

        if (words.length == 1) {
            return words[0] + " ".repeat(totalSpaces);
        }

        int spacesBetween = totalSpaces / (words.length - 1);
        int remaining = totalSpaces % (words.length - 1);

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            ans.append(words[i]);

            if (i != words.length - 1) {
                ans.append(" ".repeat(spacesBetween));
            }
        }

        ans.append(" ".repeat(remaining));

        return ans.toString();
    }
}