class TimeMap {
    Map<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Pair<String, Integer>> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new Pair(value, timestamp));
        map.put(key, list);
    }

    public String get(String key, int timestamp) {
        List<Pair<String, Integer>> list = map.get(key);
        if (list != null && !list.isEmpty()) {
            int l = 0;
            int r = list.size() - 1;
            int ans = -1;

            while (l <= r) {
                int m = l + (r - l) / 2;
                if (list.get(m).getValue() <= timestamp) {
                    ans = m;
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            return ans != -1 ? list.get(ans).getKey() : "";
        }

        return "";
    }
}