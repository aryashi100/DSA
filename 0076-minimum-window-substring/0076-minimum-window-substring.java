class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        // Count characters required from t
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int formed = 0;

        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // Add current character to window
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // Did we just satisfy a required character?
            if (need.containsKey(ch) &&
                window.get(ch).intValue() == need.get(ch).intValue()) {

                formed++;
            }

            // Window is valid
            while (formed == need.size()) {

                // Check whether this is the smallest window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                // Remove left character
                char leftChar = s.charAt(left);

                window.put(
                    leftChar,
                    window.get(leftChar) - 1
                );

                // Did removing it make the window invalid?
                if (need.containsKey(leftChar) &&
                    window.get(leftChar) < need.get(leftChar)) {

                    formed--;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minLeft, minLeft + minLength);
    }
}