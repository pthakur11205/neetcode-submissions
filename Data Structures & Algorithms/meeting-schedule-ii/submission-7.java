/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> mh = new PriorityQueue<>();
        for(Interval inter: intervals) {
            if(!mh.isEmpty() && mh.peek() <= inter.start) {
                mh.poll();
            }
            mh.offer(inter.end);
        }
        return mh.size();
    }
}
