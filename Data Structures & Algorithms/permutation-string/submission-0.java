class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            Map<Character, Integer> sub = new HashMap<>();
            int j = i;
            while (j < s2.length() && j < i + s1.length()) {
                sub.put(s2.charAt(j), sub.getOrDefault(s2.charAt(j), 0) + 1);
                j++;
            }

            int idx = 0;
            boolean pExist = true;
            for(char c : s1.toCharArray()) {
                if(sub.get(c) == null || sub.get(c) != map.get(c)) {
                    pExist = false;
                    break;
                }
            }
            if (pExist)
                return true;
        }
        return false;
    }
}
