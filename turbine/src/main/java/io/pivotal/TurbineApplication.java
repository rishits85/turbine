package io.pivotal;

import org.apache.commons.lang.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

import java.util.*;

    @SpringBootApplication
    @EnableTurbine
    public class TurbineApplication {

        public static void main(String[] args) {

            SpringApplication.run(TurbineApplication.class, args);

        }

     /* ===================================================================================================================
         Quicksort implementation
    ===================================================================================================================*/

     /*Note: This is not tested or verified.
     * Write and run test cases if needed.
     * */

    public int[] sort2(int[] input){
        return quicksort(input, 0, input.length);
    }

    private int[] quicksort(int[] input, int start, int end) {
        int pivot = (start + end)/2;
        partition(input, pivot,start, end);
        return new int[0];
    }

        private int[] partition(int[] input, int pivot, int start, int end) {
            int beforePivot = start;
            int afterPivot = end -1;
            while(beforePivot <= afterPivot){
                if(input[beforePivot] > pivot){
                    swapWithSmallerNumberFromEnd(input, pivot, beforePivot, afterPivot);
                    putPivotInCorrectPosition(input, pivot, beforePivot, afterPivot);
                }
            }
           partition(input, (pivot+start)/2,start,pivot);
           partition(input, (pivot+end)/2,pivot,end);
           return input;
        }

        private void putPivotInCorrectPosition(int[] input, int pivot, int beforePivot, int afterPivot) {
            if(pivot > input[afterPivot]){
                swapNumbers(input, pivot, afterPivot);
            }

        }



        private void swapWithSmallerNumberFromEnd(int[] input, int pivot, int beforePivot, int afterPivot) {
            for(int i = afterPivot; i > beforePivot; i--){
                if(input[afterPivot] < input[pivot] ){
                    swapNumbers(input, input[afterPivot], beforePivot);
                }
                afterPivot--;
            }
        }

        private void swapNumbers(int[] input, int indexNewval, int indexOriginalVal) {
                    int temp = input[indexOriginalVal];
                    input[indexOriginalVal] = input[indexNewval];
                    input[input.length] = temp;
                }


 /* ===================================================================================================================
         String to numbers and operation.
    ===================================================================================================================*/

    public int convertToNumbersAndOperators(String input){
        String[] inputArr = input.split("\\.");
        boolean numberSeen = false;
        int multiplier = 1;
        int result = 0;
        List<Integer> numQue = new ArrayList<>();
        List<String> operationQueue = new ArrayList<>();

        for(String s : inputArr){
            if(isNumber(s)){
                if(numberSeen == true){
                    multiplier *= 10;
                }
                numberSeen = true;
                result = (result * multiplier) +  Numbers.valueOf(s.toUpperCase()).getValue();
            }else{
                numberSeen = false;
                addToQueue(numQue, result);
                addToQueue(operationQueue, s);
                result = 0;
                multiplier = 1;

            }
        }

        addToQueue(numQue, result);
        if(numQue.size() - operationQueue.size()!=1){
            System.out.println("Improper number of operations and numbers");
            return -1;
        }

        return performOperation(numQue, operationQueue);
    }

    private int performOperation(List<Integer> numQue, List<String> operationQueue) {
        int result = numQue.remove(0);
        while(!numQue.isEmpty()){
            int num2 = numQue.remove(0);
            String operation = operationQueue.remove(0);
            switch (operation.toLowerCase()){
                case "plus":
                    result += num2;
                    break;
                case "minus":
                    result -= num2;
                    break;
                case "multiply":
                    result *= num2;
                    break;
                case "divide":
                    try{
                        result /= num2;
                    }catch (ArithmeticException e){
                        System.out.println("Cannot divide by 0");
                    }
                    break;
                case "modulus":
                    try{
                        result %= num2;
                    }catch (ArithmeticException e){
                        System.out.println("Cannot modulo by 0");
                    }
                    break;
            }
        }

        return result;
    }

    private <T> void addToQueue(List<T> queue, T result) {
        queue.add(result);
    }

    private boolean isNumber(String s) {
        for(Numbers num: Numbers.values()){
            if(num.getKey().equalsIgnoreCase(s)){
                return true;
            }
        }
        return false;
    }

    enum Numbers{
        ONE("one", 1),
        TWO("two", 2),
        THREE("three", 3),
        FOUR("four", 4),
        FIVE("five", 5),
        SIX("six", 6),
        SEVEN("seven", 7),
        EIGHT("eight", 8),
        NINE("nine", 9);

        private final String key;
        private final Integer value;

        Numbers(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }
        public Integer getValue() {
            return value;
        }
    }


    enum Operators{
        PLUS("plus", 1),
        MINUS("minus", 2),
        MULTIPLY("multiply", 1),
        DIVIDE("divide", 1),
        MODULO("modulo", 1);

        private final String key;
        private final Integer value;

        Operators(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }
        public Integer getValue() {
            return value;
        }
    }







    /* ===================================================================================================================
         University Grading problem
    ===================================================================================================================*/


    /*Considerations:
    * nulls and empty values. Negative marking considered or not for exams.
    * Can talk about the size of array and whether this will fit in memory
    * This however is unlikely in real scenario or the actual problem since a school cannot have more than a few thousand students, something that will easily fit in memory.*/
    public int[] getRoundingAbove40(int[] grades){
        if(null == grades || grades.length == 0){
            System.out.println("Invalid entry. List empty or null");
            return new int[0];

        }

        for(int i =0; i<grades.length; i++){
            if(grades[i] < 38)
                continue;

            if( (5 - (grades[i] % 5))< 3){
                grades[i] = grades[i] + (5 - (grades[i] % 5));
            }
        }
        return grades;
    }





















    public int[] sort(int[] numbers){

       /* Reasons to pick mergeSort
       *  O(nlogn) runtime in all cases.
       *  Useful when status of the numbers is unknown(that is if they appear in a sorted order or not)*/
        return mergeSort(0, numbers.length-1, numbers);
    }

    public int[] mergeSort(int start, int end, int[] numbers){
        /*Considerations: Decimals, duplicates and nulls.
        * This code assumes no nulls or decimals. Duplicates are handled. */
        if(start == end){
            return new int[]{numbers[start]};
        }
        int mid = (start + end)/2;
        int[] firstHalf = mergeSort(start, mid,  numbers) ;
        int[] secondHalf = mergeSort(mid + 1, end, numbers);
        return merge(firstHalf, secondHalf);
    }

    private int[] merge(int[] firstHalf, int[] secondHalf) {
        int[] sortedArr = new int[firstHalf.length + secondHalf.length];
        int firstHalfInd = 0;
        int secondHalfInd = 0;
        int sortedArrayIndex = 0;
        for(int i = 0; i<sortedArr.length; i++){
            sortedArrayIndex = i;

            if(firstHalf[firstHalfInd] < secondHalf[secondHalfInd]){
                sortedArr[i] = firstHalf[firstHalfInd];
                firstHalfInd++;
                if(firstHalfInd >= firstHalf.length)
                    break;
            }else{
                sortedArr[i] = secondHalf[secondHalfInd];
                secondHalfInd++;
                if(secondHalfInd >= secondHalf.length)
                    break;
            }

    }
        sortedArrayIndex++;
        if(firstHalfInd != firstHalf.length){
            addElementsToEnd(sortedArr, sortedArrayIndex, firstHalf, firstHalfInd);
        }

        if(secondHalfInd != secondHalf.length){
            addElementsToEnd(sortedArr, sortedArrayIndex, secondHalf, secondHalfInd);
        }

        return sortedArr;
    }

    private void addElementsToEnd(int[] sortedArr, int sortedArrayIndex, int[] half, int halfInd) {
        for(int i = halfInd; i<half.length; i++){
            sortedArr[sortedArrayIndex] = half[i];
            sortedArrayIndex++;
        }
    }

    private int getMaxValueFromArrays(int[] firstHalf, int firstHalfInd, int[] secondHalf, int secondHalfInd) {
        /*if end of first or second half already reached, return from other array*/
        if(firstHalfInd == firstHalf.length -1){
            secondHalfInd++;
            return secondHalf[secondHalfInd-1];
        }else if(secondHalf[secondHalfInd] == secondHalf.length - 1){
            firstHalfInd ++;
            return firstHalf[firstHalfInd-1];
        }
        /*if end not reached. return the max value from both*/
        if(firstHalf[firstHalfInd] >= secondHalf[secondHalfInd]){
            firstHalfInd++;
            return firstHalf[firstHalfInd -1];

        }else{
            secondHalfInd ++;
            return secondHalf[secondHalfInd-1];
        }

    }












     /* ===================================================================================================================
         Single repeat string problem solution
    ===================================================================================================================*/


    public String findSingleRepeatName(List<String> names){
        Set<String> uniqueNames = new HashSet<>();
    /*Checks that should be ideally done/asked for

    * validate input(Check for null and empty values or variables)
    * Names containing number or special characters. HOw to handle those for comparison when selecting the higher charcter name
    * No single repeats. WHat should be returned. */
        String singleRepeatName = null;
        for(String name: names){
            if(uniqueNames.add(name)){
                if(Objects.isNull(singleRepeatName)){
                    singleRepeatName = name;
                }else{
                    singleRepeatName = getWithHigherChar(singleRepeatName, name);
                }
            }
        }
        return singleRepeatName;
    }

    private String getWithHigherChar(String singleRepeatName, String key) {
        if(singleRepeatName.compareTo(key) > 0){
            return singleRepeatName;
        }else{
            return key;
        }
    }















   /* ===================================================================================================================
         Keypad problem solution
    ===================================================================================================================*/

    public int calculateTime(int[][] grid, String input){
        /*Checks that should be ideally done/asked for

         * validate input(Check for null,negative numbers and empty values or variables for input and grid)
         * what if given number not present in grid
         * largest possible list of inputs possible. If the distance is too large, consider using alternatives like long.
         * solution is flexible for grid size. If grid is too large and map cannot be held in memory, consider using some graph based method.
         */
        input = input.replaceAll("[^0-9]", "");

        if(isNotValid(input)){
            System.out.println("invliad input");
            return -1;
        }

        // if(isNotValidGrid[][])
        Map<Integer , int[]> locationInGrid = extractLocationGrid(grid);
        return calculateDistance(locationInGrid, input);

    }

    public Map<Integer, int[]> extractLocationGrid(int[][] grid){
        Map<Integer, int[]> map = new HashMap<>();

        for(int i =0; i< grid.length; i++){
            int[] row = grid[i];
            for(int j =0; j< row.length; j++){
                int[] position = new int[2];
                position[0] = i;
                position[1] = j;
                map.put(grid[i][j], position);
            }
        }
        return map;

    }

    public int calculateDistance(Map<Integer , int[]> locationGrid, String input){

        int distance = 0;

        for(int i =0; i<input.length() -1; i++){
            int num1 = Character.getNumericValue(input.charAt(i));
            int num2 = Character.getNumericValue(input.charAt(i + 1));
            int[] positionNum1 = locationGrid.get(num1);
            int[] positinoNum2 =  locationGrid.get(num2);
            distance += Math.abs(positionNum1[0] - positinoNum2[0]) +
                    Math.abs(positionNum1[1] - positinoNum2[1]);

        }

        return distance;


    }

    public boolean isNotValid(String input){
        if(Objects.isNull(input) || StringUtils.isBlank(input) || input.length() == 1){
            return true;
        }

        for(int i=0; i<input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                return true;
            }
        }

        return false;
    }
}

