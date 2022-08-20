package l;

public class LeetCode273 {
    public static void main(String[] args) {
        System.out.println("keep Happy boy");

    }

    class Solution {
        // fist step is always to try to undersatand the problem
        // and ask clarification questions if there`s anything that is unclear to you
        //  and then think about corner cases

        // 1，2，3，4，5，6，7，8，9
        private String ones(int num){
            switch(num){
                case 1: return "One";
                case 2: return "Two";
                case 3: return "Three";
                case 4: return "Four";
                case 5: return "Five";
                case 6: return "Six";
                case 7: return "Seven";
                case 8:  return "Eight";
                case 9: return "Nine";
            }
            return "";
        }

        //11 ~ 19
        private String underTwenty(int num){
            switch(num){
                case 10: return "Ten";
                case 11: return "Eleven";
                case 12: return "Twelve";
                case 13: return "Thirteen";
                case 14: return "Fourteen";
                case 15: return "Fifteen";
                case 16: return "Sixteen";
                case 17: return "Seventeen";
                case 18:  return "Eighteen";
                case 19: return "Nineteen";
            }
            return "";
        }

        // tens
        private String tens(int num){
            switch(num){
                case 20:return "Twenty";
                case 30:return "Thirty";
                case 40:return "Forty";
                case 50:return "Fifty";
                case 60:return "Sixty";
                case 70:return "Seventy";
                case 80:return "Eighty";
                case 90:return "Ninety";

            }
            return "";
        }

        private String twoDigits(int num){
            if(num < 10){
                return ones(num);
            }
            if( num < 20){
                return underTwenty(num);
            }

            int tenNum = num/10*10;
            int onesNum = num %10;

            if(onesNum == 0){
                return tens(num);
            }
            return tens(tenNum)+" "+ ones(onesNum);
        }

        private String threeDigits(int num){
            int hundredNum = num/100;
            int res = num %100;

            if(hundredNum == 0){
                return twoDigits(num);
            }

            if(res == 0){
                return ones(hundredNum)+ " "+ "Hundred";
            }
            return ones(hundredNum)+" "+ "Hundred "+ twoDigits(res);
        }

        public String numberToWords(int num) {
            if(num == 0) return "Zero";

            int billion = num /1000000000;
            num -= billion*1000000000;

            int million = num/1000000;
            num-= million*1000000;

            int thoustand = num / 1000;
            num -= thoustand*1000;

            String res = "";
            if(billion > 0){
                res += (threeDigits(billion) + " Billion ");
            }

            if(million > 0){
                res += (threeDigits(million) + " Million ");
            }

            if(thoustand > 0){
                res += (threeDigits(thoustand) + " Thousand ");
            }

            if(num > 0){
                res += threeDigits(num);
            }

            return res.trim();

        }
    }
}
