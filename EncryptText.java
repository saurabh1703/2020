public class EncryptText {

    public static void main(String[] args) {
        //Input
        String inputString = null;
        if(args.length > 0){
            inputString = args[0];
        } else {
            inputString = "the black cat jumped on the roof";
        }
        System.out.println("inputString: " + inputString);
        //String inputString = "chill out";
        String replacedString = inputString.replaceAll(" ", "");
        //Space Removal
        int inputLength = replacedString.length();

        int smallerPerferctSquare = 0;
        int greaterPerfectSquare = 0;
        System.out.println("inputLength After Space removal: " + inputLength);

        //C: b. Where [PRESQRT(L)] = square root of largest perfect square number less than or equals to L
        for (int i = inputLength; i > 0; i--) {
            double smallerPerferctSquareX = Math.sqrt(i);
            if ((smallerPerferctSquareX - Math.floor(smallerPerferctSquareX) == 0)) {
                smallerPerferctSquare = (int) Math.round(smallerPerferctSquareX);
                System.out.println("squareRootNumber1: " + smallerPerferctSquare);
                break;
            }
        }

        //C: c. Where [POSTSQRT(L)] = square root of smallest perfect square number greater than or	equals to L
        boolean largeFound = true;
        int largeNumber = inputLength;
        while (largeFound) {
            double greaterPerfectSquareX = Math.sqrt(largeNumber);
            if ((greaterPerfectSquareX - Math.floor(greaterPerfectSquareX) == 0)) {
                greaterPerfectSquare = (int) Math.round(greaterPerfectSquareX);
                System.out.println("squareRootNumber2: " + greaterPerfectSquare);
                largeFound = false;
                break;
            }
            largeNumber++;
        }

        //[PRESQRT(L)] <= R <= C <= [POSTSQRT(L)]: R*C >= L
        // smallerPerferctSquare <= R <= C greaterPerfectSquare
        // 5 <= R <= C <= 6
        // 2 <= R <= C <= 3

        int r = smallerPerferctSquare;
        int c = smallerPerferctSquare;
        if (r * c >= inputLength) {
            System.out.println("GridSize Found: " + r + " and " + c);
        } else {
            c = greaterPerfectSquare;
            if (r * c >= inputLength) {
                System.out.println("GridSize Found: " + r + " and " + c);
            } else {
                r = greaterPerfectSquare;
                System.out.println("GridSize Found: " + r + " and " + c);
            }
        }
        char[] charArray = replacedString.toCharArray();

        StringBuilder outputString = new StringBuilder();
        for(int i = 0; i < c; i++){
            outputString.append(charArray[i]);
            for(int j = i+c; j < inputLength; j = j+r+1){
                outputString.append(charArray[j]);
            }
            outputString.append(" ");
        }
        System.out.println(outputString.toString());
    }
}
