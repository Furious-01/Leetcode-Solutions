class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        if (dead.contains("0000")) return -1;

        q.add("0000");
        visited.add("0000");

        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals(target)) return level;

                for (int j = 0; j < 4; j++) {
                    char[] chars = curr.toCharArray();

                    chars[j] = curr.charAt(j) == '9' ? '0' : (char)(curr.charAt(j) + 1);
                    String up = new String(chars);

                    chars[j] = curr.charAt(j) == '0' ? '9' : (char)(curr.charAt(j) - 1);
                    String down = new String(chars);

                    if (!dead.contains(up) && !visited.contains(up)) {
                        q.add(up);
                        visited.add(up);
                    }

                    if (!dead.contains(down) && !visited.contains(down)) {
                        q.add(down);
                        visited.add(down);
                    }
                }
            }

            level++;
        }

        return -1;
    }
}
