package com.sailing.leetcode.solution43;

/**
 * yangyang
 * 2018-05-18 代码量好大
 */
public class Solution {
    int maxLength = 300;

    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null){
            return null;
        }

        if(num1.length() == 0 || num2.length() == 0){
            return "";
        }


        byte[] num1byte = strToByteArray(num1);
        byte[] num2byte = strToByteArray(num2);

        byte[] sumbyte = new byte[maxLength];

        int countnum1 = num1.length();
        int countnum2 = num2.length();

        byte[] multiResult = new byte[maxLength];
        for (int i = 0; i < countnum1; i++ ){
//            clear(multiResult);
            byte multiNum = num1byte[i];
            multiResult = multipWithSingal(multiNum, countnum2, num2byte,i, multiResult);
            addToSum(multiResult, sumbyte, i + countnum2 + 1);
        }

        int countTotal = countnum2 + countnum1;
        StringBuilder sb = new StringBuilder(countTotal);
        boolean needAppend = false;
        for (int i = countTotal; i >= 0; i -- ){
            if(sumbyte[i] != 0){
                needAppend = true;
            }
            if(needAppend)
                sb.append(sumbyte[i]);
        }

        if(!needAppend){
            return "0";
        }

        return sb.toString();
    }

    private void clear(byte[] multiResult) {
        for(int i = 0; i < multiResult.length; i++){
            multiResult[i] = 0;
        }
    }

    private void addToSum(byte[] singleSum, byte[] byteSum, int length) {
        byte incr = 0;
        for(int  i = 0; i < length || incr > 0; i++){
            byte r = (byte) (incr + byteSum[i] + singleSum[i]);
            incr = (byte) (r / (byte)10);
            byte remain = (byte) (r % 10);
            byteSum[i] = remain;
            singleSum[i] = 0;
        }
    }

    private byte[] multipWithSingal(byte single, int countnum2, byte[] num2byte, int offset, byte[] multiResult) {

        byte incr = 0;
        for(int i = 0; i < countnum2; i ++){
            byte r = (byte) (num2byte[i] * single + incr);
            incr = (byte) (r / (byte)10);
            byte remain = (byte) (r % 10);

            multiResult[offset] = remain;
            offset ++;
        }

        multiResult[offset] = incr;
        return multiResult;
    }

    public byte[] strToByteArray(String numStr){
        byte[] numb = new byte[maxLength];
        int bindex = 0;
        for(int index = numStr.length() - 1; index >= 0; index--, bindex ++){
            byte digit = (byte) (numStr.charAt(index) - '0');
            numb[bindex] = digit;
        }

        return numb;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().multiply("12","12"));
    }
}
