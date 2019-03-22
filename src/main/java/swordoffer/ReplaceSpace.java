package swordoffer;

/**
 * @author: Penger
 * @time: 2019/3/22
 * @description: <p>请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 * </p>
 **/
public class ReplaceSpace {
    /**
     * 使用 String 的api,额外创建空间
     *
     * @param str replace str
     * @return result
     */
    public static String replace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        return str.toString().replaceAll("\\s", "%20");
    }

    /**
     * 使用 StringBuffer 创建多于的长度，属于in place解决方案
     *
     * @param str replace str
     * @return result
     */
    private static String replaceInPlace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        int oldLen = str.length();
        int count = 0;
        for (char c : str.toString().toCharArray()) {
            if (c == ' ') {
                count++;
            }
        }
        int newLen = oldLen + count * 2;
        str.setLength(newLen);
        for (int i = oldLen - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == ' ') {
                str.setCharAt(newLen - 1, '0');
                str.setCharAt(newLen - 2, '2');
                str.setCharAt(newLen - 3, '%');
                newLen = newLen - 3;
            } else {
                str.setCharAt(newLen - 1, c);
                newLen--;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceInPlace(new StringBuffer("We Are Happy")));
        System.out.println(replaceInPlace(new StringBuffer("hello  world")));
    }
}
