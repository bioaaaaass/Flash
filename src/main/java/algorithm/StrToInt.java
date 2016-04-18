package algorithm;

import java.util.Scanner;

/**
 * Created by huangzhibo on 4/6/16.
 */
public class StrToInt {
//    enum Status {kValid = 0; Kinvalid};
    static int g_status = 0;
    static int strToInt(char[] str){
        g_status = -1;
        long num = 0;
        int i = 0;
        if (str != null && str.length >0 && str[i] != '\0'){
            boolean mminus = false;
            if (str[i] == '+'){
                i++;
            }
            else if (str[i] =='-'){
                i++;
                mminus = true;
            }
            if (str[i] != '\0'){
                num = strToIntCore(str,i,mminus);
            }
        }
        return (int) num;
    }

    static long strToIntCore(char[] str, int i, boolean minus){
        long num = 0;
        while (i< str.length && str[i] != '\0'){
            if (str[i] >= '0' && str[i] <= '9'){
                int flag = minus ? -1 : 1;
                num = num * 10 + flag * (str[i] - '0');
                if ((!minus && num > 0x7FFFFFFF) || (minus && num < 0x80000000)){
                    num = 0;
                    break;
                }
                i++;
            }
            else {
                num = 0;
                break;
            }
        }
        if (i < str.length && str[i] =='\0'){
            g_status = 0;
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] cha = str.toCharArray();
        int result = strToInt(cha);
        System.out.println(result);
    }
}
