package Online;

public class NumberTransfer {
    public final static String[] chnNumChar = new String[]{"L", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public final static String[] chnUnitSection = new String[]{"", "W", "亿", "万亿"};
    public final static String[] chnUnitChar = new String[]{"", "S", "B", "Q"};
    public static void testNumberToChinese() {
        int[] nums = new int[]{304, 4006, 4000, 10003, 10030, 99999, 12001};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(numberToChinese(nums[i]));
        }
    }
    public static String numberToChinese(int num) {
        String strIns;
        String chnStr = "";
        int unitPos = 0;
        boolean needZero = false;
        if (num == 0)
            return "零";
        while (num > 0) {
            strIns = "";
            int section = num % 10000;
            if (needZero) {
                chnStr = chnNumChar[0] + chnStr;
            }
            // 添加节权（万，亿）
            strIns += (section != 0) ? chnUnitSection[unitPos] : chnUnitSection[0];
            chnStr = strIns + chnStr;
            // 以万为单位，求万以内的权位
            chnStr = sectionToChinese(section, chnStr);
            needZero = (section < 1000) && (section > 0);
            num = num / 10000;
            unitPos++;
        }
        return chnStr;
    }
    private static String sectionToChinese(int section, String chnStr) {
        String strIns;
        int unitPos = 0;
        boolean zero = true;
        while (section > 0) {
            int v = section % 10;
            if (v == 0) {
                if (section == 0 || !zero) {
                    zero = true;// zero确保不会出现多个零
                    chnStr = chnNumChar[v] + chnStr;
                }
            } else {
                zero = false;
                strIns = chnNumChar[v]; // 此位置对应等中文数字
                strIns += chnUnitChar[unitPos];// 此位置对应的权位
                chnStr = strIns + chnStr;
            }
            unitPos++;
            section = section / 10;
        }
        return chnStr;
    }

    public static void main(String[] args) {
        testNumberToChinese();
    }
}
