import java.util.*;

class Router {
    private static class Packet {
        int source, destination, timestamp;
        Packet(int s, int d, int t) {
            source = s; destination = d; timestamp = t;
        }
    }

    private int memoryLimit;
    private Queue<Packet> queue;
    private Set<String> packetSet;
    // destination -> prefix sums of counts by timestamp
    private Map<Integer, TreeMap<Integer, Integer>> destToPrefix;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new LinkedList<>();
        this.packetSet = new HashSet<>();
        this.destToPrefix = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (packetSet.contains(key)) return false; // duplicate

        // Evict oldest if memory full
        if (queue.size() == memoryLimit) {
            Packet old = queue.poll();
            String oldKey = old.source + "#" + old.destination + "#" + old.timestamp;
            packetSet.remove(oldKey);
            // Decrement count in prefix sums
            TreeMap<Integer, Integer> prefix = destToPrefix.get(old.destination);
            // shift all future prefix values down by 1
            for (Map.Entry<Integer, Integer> e : prefix.tailMap(old.timestamp, true).entrySet()) {
                prefix.put(e.getKey(), e.getValue() - 1);
            }
        }

        Packet newPacket = new Packet(source, destination, timestamp);
        queue.offer(newPacket);
        packetSet.add(key);

        destToPrefix.putIfAbsent(destination, new TreeMap<>());
        TreeMap<Integer, Integer> prefix = destToPrefix.get(destination);
        int prev = prefix.isEmpty() ? 0 : prefix.lastEntry().getValue();
        prefix.put(timestamp, prev + 1);

        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[0];

        Packet p = queue.poll();
        String key = p.source + "#" + p.destination + "#" + p.timestamp;
        packetSet.remove(key);

        // decrement from prefix sums
        TreeMap<Integer, Integer> prefix = destToPrefix.get(p.destination);
        for (Map.Entry<Integer, Integer> e : prefix.tailMap(p.timestamp, true).entrySet()) {
            prefix.put(e.getKey(), e.getValue() - 1);
        }

        return new int[]{p.source, p.destination, p.timestamp};
    }

    private int prefixCount(TreeMap<Integer, Integer> prefix, int time) {
        Map.Entry<Integer, Integer> entry = prefix.floorEntry(time);
        return entry == null ? 0 : entry.getValue();
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destToPrefix.containsKey(destination)) return 0;
        TreeMap<Integer, Integer> prefix = destToPrefix.get(destination);
        return prefixCount(prefix, endTime) - prefixCount(prefix, startTime - 1);
    }
}
