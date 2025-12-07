package uz.utkirbek.aoc.aoc2025;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day6 {
    public static void main(String[] args) throws IOException {
//        problem1();
        //problem2();
        System.out.println("Integer.toBinaryString(3664) = " + Integer.toBinaryString(3664));


    }

    public static void problem1() throws IOException {
//        String text="";
//        String text=Files.readString(Path.of("text.txt"));
        List<String> rows = Files.readAllLines(Path.of("text.txt"));

        for (int i = 0; i < rows.size(); i++) {
            rows.set(i, rows.get(i).trim());
        }


        List<String[]> numbers = new ArrayList<>();

        for (int i = 0; i < rows.size() - 1; i++) {
            String row = rows.get(i);
            String[] nums = row.split(" +");
            numbers.add(nums);
        }

        List<Long> results = new ArrayList<>();

        String[] opers = rows.get(rows.size() - 1).split(" +");


        boolean init = false;

        for (int i = 0; i < opers.length; i++) {
            Long res = 0l;
            init = false;
            for (int j = 0; j < rows.size() - 1; j++) {

                if (!init && opers[i].equals("*")) {

                    res = apply(1l, numbers.get(j)[i], opers[i]);
                    init = true;
                } else {

                    res = apply(res, numbers.get(j)[i], opers[i]);
                }


            }
            results.add(res);
        }
        Long ans = 0l;

        for (Long num : results) {
            ans = ans + num;
        }


        System.out.println(ans);

    }

    private static Long apply(Long res, String newNumber, String oper) {
        oper = oper.trim();

        switch (oper) {
            case "+" -> {
                return res + Long.parseLong(newNumber);
            }
            case "*" -> {
                return res * Long.parseLong(newNumber);
            }
        }

        return res;
    }

    public static void problem2() throws IOException {
//        String text="";
//        String text=Files.readString(Path.of("text.txt"));
        List<String> rows = Files.readAllLines(Path.of("text.txt"));


        long answer = 0;
        long currAnswer = 0;
        long currNum = 0;
        List<List<String>> numbers = new ArrayList<>();
        List<String> numberRow = new ArrayList<>();
boolean init=false;

        String[] operators = rows.get(rows.size() - 1).split(" +");
        int operIndex = 0;

        StringBuilder sb=new StringBuilder();

        for (int i = 0; i < rows.get(0).length(); i++) {
            sb=new StringBuilder("0");
            for (int j = 0; j < rows.size() - 1; j++) {
                    if (rows.get(j).charAt(i) == ' ') {
                    continue;
                }else  {
                    sb.append(rows.get(j).charAt(i));
                }
            }
            if (Long.parseLong(sb.toString())==0) {

                init=false;
                currAnswer=0l;
                for (String num : numberRow) {
                    if (!init && operators[operIndex].equals("*")) {
                        currAnswer=apply(1l,num,operators[operIndex]);
                        init=true;
                    }else {
                        currAnswer=apply(currAnswer,num,operators[operIndex]);
                    }
                }
                operIndex++;

                answer += currAnswer;
                numberRow=new ArrayList<>();
            }else {
                numberRow.add(sb.toString());
            }
        }

        init=false;
        currAnswer=0l;
        for (String num : numberRow) {
            if (!init && operators[operIndex].equals("*")) {
                currAnswer=apply(1l,num,operators[operIndex]);
                init=true;
            }else {
                currAnswer=apply(currAnswer,num,operators[operIndex]);
            }
        }
        operIndex++;
        answer += currAnswer;
        System.out.println(answer);

    }
}
