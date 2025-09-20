import java.util.*;

class Router {

    class Packet {
        public int source, dest, timestamp;
        Packet(int source, int dest, int timestamp) {
            this.source = source;
            this.dest = dest;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Packet)) return false;
            Packet packet = (Packet) obj;
            return source == packet.source &&
                    dest == packet.dest &&
                    timestamp == packet.timestamp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, dest, timestamp);
        }
    }

    HashSet<Packet> hset;
    Deque<Packet> dq;                               // FIFO queue
    HashMap<Integer, List<Integer>> destmap;        // dest → sorted timestamps
    int limit;

    public Router(int memoryLimit) {
        limit = memoryLimit;
        hset = new HashSet<>();
        dq = new ArrayDeque<>();
        destmap = new HashMap<>();
    }

    public boolean addPacket(int source, int dest, int timestamp) {
        Packet packet = new Packet(source, dest, timestamp);

        // checking for duplicate packet
        if(hset.contains(packet)) {
            return false;
        }

        // evict the oldest packet if limit is reached
        if(dq.size() == limit) {
            Packet p = dq.remove();
            hset.remove(p);

            List<Integer> timestamps = destmap.get(p.dest);
            if (timestamps != null && !timestamps.isEmpty()) {
                timestamps.remove(0);
                if (timestamps.isEmpty()) {
                    destmap.remove(p.dest);
                }
            }
        }

        // add new packet
        hset.add(packet);
        dq.offer(packet);

        destmap.computeIfAbsent(dest, k -> new ArrayList<>());
        destmap.get(dest).add(timestamp);

        return true;
    }

    public int[] forwardPacket() {
        if (dq.isEmpty()) {
            return new int[0];
        }

        Packet p = dq.remove();
        hset.remove(p);

        List<Integer> timestamps = destmap.get(p.dest);
        if (timestamps != null && !timestamps.isEmpty()) {
            timestamps.remove(0);
            if (timestamps.isEmpty()) {
                destmap.remove(p.dest);
            }
        }

        return new int[]{p.source, p.dest, p.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destmap.containsKey(destination)) {
            return 0;
        }
        List<Integer> list = destmap.get(destination);
        Collections.sort(list); // ensure sorted order
        int left = lowerBound(list, startTime);   // first ≥ startTime
        int right = upperBound(list, endTime);    // first > endTime
        return right - left;
    }

    private int lowerBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int upperBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}

public class Problem_3508 {
    public static void main(String[] args) {
        Router router = new Router(3);

        System.out.println("Add packet 1: " + router.addPacket(1, 2, 10)); // true
        System.out.println("Add packet 2: " + router.addPacket(2, 2, 20)); // true
        System.out.println("Add packet 3: " + router.addPacket(3, 3, 30)); // true
        System.out.println("Add packet 4 (should evict oldest): " + router.addPacket(4, 2, 40)); // true

        int[] forwarded = router.forwardPacket();
        if (forwarded.length > 0) {
            System.out.println("Forwarded packet: " + Arrays.toString(forwarded));
        } else {
            System.out.println("No packet forwarded");
        }

        System.out.println("Count for dest=2, time in [15,45]: " + router.getCount(2, 15, 45));
        System.out.println("Count for dest=3, time in [25,35]: " + router.getCount(3, 25, 35));
    }
}
