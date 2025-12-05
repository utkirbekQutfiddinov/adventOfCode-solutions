package uz.utkirbek.aoc.aoc2025;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Day5 {
    public static void main(String[] args) throws IOException {
//        problem1();
        problem2();
    }

    public static void problem1() throws IOException {
//        String text="";
//        String text=Files.readString(Path.of("text.txt"));
        List<String> rows = Files.readAllLines(Path.of("text1.txt"));

        Map<Long, Long> map = new HashMap<>();
        String row = null;

        long result = 0;
        int id = 0;
        Long from = null, to2 = null, to1;
        for (int j = 0; j < rows.size(); j++) {
            row = rows.get(j);
            if (row.equals("") || row.equals(" ") || row.trim().equals("")) {
                id = j;
                break;
            }
            from = Long.parseLong(row.split("-")[0]);
            to2 = Long.parseLong(row.split("-")[1]);

            to1 = map.get(from);

            if (to1 == null) {
                map.put(from, to2);
            } else if (to2 > to1) {
                map.put(from, to2);
            }


        }

        result = 0;
        long idd = 0;
        for (int i = id + 1; i < rows.size(); i++) {
            row = rows.get(i);

            idd = Long.parseLong(row);

            for (Long key : map.keySet()) {
                if (key <= idd) {
                    to1 = map.get(key);
                    if (to1 >= idd) {
                        result++;
                        break;
                    }
                }
            }

        }

        System.out.println(result);

    }

    public static void problem2() throws IOException {
//        String text="";
//        String text=Files.readString(Path.of("text.txt"));
        List<String> rows = Files.readAllLines(Path.of("text.txt"));

        Map<Long, Long> map = new HashMap<>();
        Set<Long> set = new HashSet<>();

        String row = null;

        long result = 0;
        int id = 0;
        long from = 0, to = 0;

        List<long[]> intervals = new ArrayList<>();


        for (int i=0; i < rows.size(); i++) {
            row = rows.get(i);
            String[] parts = row.split("-");
            from = Long.parseLong(parts[0]);
            to = Long.parseLong(parts[1]);
            if (from <= to) {
                intervals.add(new long[]{from, to});
            }
        }


        intervals.sort(Comparator.comparingLong(a -> a[0]));


        List<long[]> merged = new ArrayList<>();
        for (long[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0] - 1) {
                merged.add(interval);
            } else {
                long[] last = merged.get(merged.size() - 1);
                last[1] = Math.max(last[1], interval[1]);
            }
        }

        long total = 0;
        for (long[] interval : merged) {
            total += (interval[1] - interval[0] + 1);
        }


        System.out.println(total);
    }
}
