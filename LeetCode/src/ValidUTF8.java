import java.text.DecimalFormat;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/10/22 19:09
 */

public class ValidUTF8 {
        public boolean validUtf8(int[] data) {
            int len = data.length;
            int subCount = 0;
            int mask1 = 1 << 7;
            int mask2 = 1 << 6;

            for (int i = 0; i < len; i++) {

                if (subCount == 0) {
                    int mask = 1 << 7;
                    while ((mask & data[i]) != 0) {
                        subCount++;
                        mask = mask >> 1;
                    }

                    // 当前字符为一字节字符
                    if (subCount == 0) {
                        if (i == len - 1) {
                            return true;
                        }
                        continue;
                    }
                    if (subCount > 4 || subCount == 1 || subCount + i > len) {
                        return false;
                    }
                    subCount--;

                } else {
                    if (!((data[i] & mask1) != 0 && (mask2 & data[i]) == 0)) {
                        return false;
                    }
                    if (i == len - 1) {
                        return true;
                    }
                    subCount--;
                }

            }
            return false;
        }
    }

