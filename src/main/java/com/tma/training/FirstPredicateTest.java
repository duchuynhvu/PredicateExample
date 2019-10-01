package com.tma.training;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

public class FirstPredicateTest {

    public static void main(String[] args) {
        // ################################################
        // ### Sử dụng and(), or(), negate(), isEqual() ###
        
        Predicate<String> predicate = s -> {
            return s.equals("gpcoder");
        };
 
        // AND logical operation
        Predicate<String> predicateAnd = predicate.and(s -> s.length() == 11);
        System.out.println(predicateAnd.test("gpcoder.com")); // true
 
        // OR logical operation
        Predicate<String> predicateOr = predicate.or(s -> s.length() == 11);
        System.out.println(predicateOr.test("gpcoder.com")); // true
 
        // NEGATE logical operation
        Predicate<String> predicateNegate = predicate.negate();
        System.out.println(predicateNegate.test("gpcoder")); // false

        // ###############################
        // ### Kết hợp nhiều Predicate ###
                
        // Creating predicate
        Predicate<Integer> greaterThanTen = (i) -> i > 10;
        Predicate<Integer> lessThanTwenty = (i) -> i < 20;
 
        // Calling Predicate Chaining
        boolean result = greaterThanTen.and(lessThanTwenty).test(15);
        System.out.println(result); // true
 
        // Calling Predicate method
        boolean result2 = greaterThanTen.and(lessThanTwenty).negate().test(15);
        System.out.println(result2); // false
        
        // ##################################################################
        // ### Sử dụng Predicate với các lớp cho kiểu dữ liệu nguyên thủy ###
        
        System.out.print("IntPredicate: ");
        int[] intNumbers = { 3, 5, 6, 2, 1 };
        IntPredicate intPredicate = i -> i > 5;
        Arrays.stream(intNumbers).filter(intPredicate).forEach(System.out::println);
 
        System.out.print("\nLongPredicate: ");
        long[] longNumbers = { 3, 5, 6, 2, 1 };
        LongPredicate longPredicate = l -> l > 5;
        Arrays.stream(longNumbers).filter(longPredicate).forEach(System.out::println);
 
        System.out.print("\nDoublePredicate: ");
        double[] dbNumbers = { 3.2, 5.0, 6.3, 2.5, 1.0 };
        DoublePredicate dbPredicate = d -> d > 2;
        Arrays.stream(dbNumbers).filter(dbPredicate).forEach(System.out::println);
    
        // ##################################################
        // ### Sử dụng Predicate 2 đối số với BiPredicate ###
        
        BiPredicate<Integer, String> condition = (i, s) -> i > 2 && s.startsWith("J");
        System.out.println(condition.test(5, "Java")); // true
        System.out.println(condition.test(2, "Javascript")); // false
        System.out.println(condition.test(1, "C#")); // false
    }

}
