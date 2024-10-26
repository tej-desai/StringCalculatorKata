package org.example;

public class StringCalculator {
    public int add(String numbers){
        int num = 0;
        String negativeNumbers = "";
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
                numbers = numbers.substring(4);
                System.out.println("NEW NUMBERS: " + numbers);
                String[] nums = numbers.split(delimiter);
                for(String ele : nums ){
                    if(Integer.parseInt(ele)<0)
                    {
                        if(negativeNumbers.isEmpty()) {
                            negativeNumbers = negativeNumbers + ele;
                        }
                        else {
                            negativeNumbers = negativeNumbers + ", " + ele;
                        }
                    }

                    if(Integer.parseInt(ele)<1001) {
                        num = num + Integer.parseInt(ele);
                    }
                }
                if (!negativeNumbers.isEmpty())
                {
                    throw new IllegalArgumentException("negative numbers not allowed " + negativeNumbers);
                }
            }
            else {
                String[] nums = numbers.split("[,\\n]");
                for (String ele : nums) {
                    if(Integer.parseInt(ele)<0)
                    {
                        if(negativeNumbers.isEmpty()) {
                            negativeNumbers = negativeNumbers + ele;
                        }
                        else {
                            negativeNumbers = negativeNumbers + ", " + ele;
                        }
                    }
                    if(Integer.parseInt(ele)<1001) {
                        num = num + Integer.parseInt(ele);
                    }
                    if (!negativeNumbers.isEmpty())
                    {
                        throw new IllegalArgumentException("negative numbers not allowed " + negativeNumbers);
                    }
                }
            }
        }
        //handles single numbers
        else {
            num = Integer.parseInt(numbers);
        }
        return num;
    }
    public static  void main(String[] args){
        String input = "//:\n1:-6:-2";
        StringCalculator obj = new StringCalculator();
        int result = obj.add(input);
    }
}
