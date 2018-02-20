import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class OverlappingSequence {
    public void overlap(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i=0; i<n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        System.out.println(hasOverlap(start, end));
    }

    public boolean hasOverlap(int[] s,  int[] t) {
        Arrays.sort(s);
        Arrays.sort(t);
        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(t));
        int j=0;
        for(int i=1; i<s.length; i++) {
            if(s[i] <= t[i-1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        OverlappingSequence op = new OverlappingSequence();
        List<Interval> intervals = new ArrayList<Interval>();
        Interval it1 = new Interval(39, 48);
        Interval it2 = new Interval(12, 18);
        Interval it3 = new Interval(20, 28);
        Interval it4 = new Interval(55, 56);
        Interval it5 = new Interval(25, 38);
        Interval it6 = new Interval(49, 54);
        //Interval it7 = new Interval(10, 80);
        intervals.add(it1);
        intervals.add(it2);
        intervals.add(it3);
        intervals.add(it4);
        intervals.add(it5);
        intervals.add(it6);
        //intervals.add(it7);
        op.overlap(intervals);
    }
}