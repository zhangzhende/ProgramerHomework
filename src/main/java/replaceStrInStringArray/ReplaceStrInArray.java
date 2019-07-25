package replaceStrInStringArray;

/**
 * @Description 说明类的用途
 * @ClassName ReplaceStrInArray
 * @Author zzd
 * @Create 2019/7/15 11:16
 * @Version 1.0
 **/
public class ReplaceStrInArray {


    public static void main(String[] args) {
        char[] strArr={'A','B','C','D','E','F','B','B'};
        String targetStr="HJKL";
        char sourceStr='B';
        replaceInArray(strArr,sourceStr,targetStr);
    }

    /**
     * small to big
     *
     * @param strArr
     * @param sourceStr
     * @param targetStr
     */
    public static void replaceInArray(char[] strArr, char sourceStr, String targetStr) {
        int targetStrlength = targetStr.length();
        int length = strArr.length;
        int times = 0;
        char[] tarcharr = targetStr.toCharArray();
        int tarcharlen = tarcharr.length;
        for (char letter : strArr) {
            if (sourceStr == letter) {
                times++;
            }
        }
        int expand = (targetStrlength - 1) * times;
        int targetlen = length + expand;
        char[] targetArr = new char[targetlen];
        int tarindex = targetlen - 1;
        for (int i = strArr.length - 1; i >= 0; i--) {
            if (strArr[i] == sourceStr) {
                for (int j = tarcharlen-1; j >= 0; j--) {
                    targetArr[tarindex] = tarcharr[j];
                    tarindex--;
                }
            } else {
                targetArr[tarindex] = strArr[i];
                tarindex--;
            }
        }
        System.out.print(targetArr);
    }

}
