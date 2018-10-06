package basic_class_02;

/**
 * 求最大回文长度
 */

public class Code_04_Manacher {

	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

	public static int maxLcpsLength(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] charArr = manacherString(str);
		int[] pArr = new int[charArr.length]; //记录回文半径
		int centerPos = -1;  //记录最右回文边界对应的回文中心
		int pR = -1;  //记录回文最右边界
		int max = Integer.MIN_VALUE;
		for (int i = 0; i != charArr.length; i++) {
			pArr[i] = pR > i ? Math.min(pArr[2 * centerPos - i], pR - i) : 1;  //2*index - i 为 i 所对应的 i' ， pArr[i']为i'的半径
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) { // 向外扩，判断两侧是否越界
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
					pArr[i]++;
				else {
					break;
				}
			}
			if (i + pArr[i] > pR) { //判断最右回文边界是否更长
				pR = i + pArr[i]; //更新最右回文边界
				centerPos = i; // 更新回文中心
			}
			max = Math.max(max, pArr[i]);
		}
		return max - 1;
	}

	public static void main(String[] args) {
		String str1 = "abc1234321ab";
		String str2 = "abc121cba";
		System.out.println(maxLcpsLength(str1));
		System.out.println(maxLcpsLength(str2));
	}

}
