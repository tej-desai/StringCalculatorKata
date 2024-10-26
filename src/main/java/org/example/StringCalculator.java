package org.example;

public class StringCalculator {
    //check once - if static is needed
    public int add(String numbers){
        int num = 0;
        String delimiter;
        //handle empty string
        if(numbers.isEmpty()){
            return 0;
        }
        //handle comma separated numbers and newLine
        else if (numbers.contains(",") || numbers.contains("\n")) {
            String checkDelimiter = numbers.substring(0,2);
            if(checkDelimiter.equals("//"))
            {
                delimiter = String.valueOf(numbers.charAt(2));
//                System.out.println("DELIMITER: " + checkDelimiter);
                numbers = numbers.substring(4);
                System.out.println("NEW NUMBERS: " + numbers);
                String[] nums = numbers.split(delimiter);
                for(String ele : nums ){
                    if(Integer.parseInt(ele)<0)
                    {
                        throw new IllegalArgumentException("negative numbers not allowed");
                    }
                    num = num + Integer.parseInt(ele);
                }
            }
            else {
                String[] nums = numbers.split("[,\\n]");
                for (String ele : nums) {
                    if(Integer.parseInt(ele)<0)
                    {
                        throw new IllegalArgumentException("negative numbers not allowed");
                    }
                    num = num + Integer.parseInt(ele);
                }
//                System.out.println("SUM: " + num);
            }
        }
        //handles single numbers
        else {
            num = Integer.parseInt(numbers);
        }
        return num;
    }
    public static  void main(String[] args){
        String input = "//:\n1:-6";
        StringCalculator obj = new StringCalculator();
        int result = obj.add(input);
//        System.out.println("String Calculator: " + result);
    }
}
