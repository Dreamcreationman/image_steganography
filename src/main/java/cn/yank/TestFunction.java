package cn.yank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;

/**
 * TestFunction
 */
public class TestFunction {

    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', 
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static void main(String[] args) {
       
    }

    public static byte[] hexToByteArray(String inHex){  
        int hexlen = inHex.length();  
        byte[] result;  
        if (hexlen % 2 == 1){  
            //奇数  
            hexlen++;  
            result = new byte[(hexlen/2)];  
            inHex="0"+inHex;  
        }else {  
            //偶数  
            result = new byte[(hexlen/2)];  
        }  
        int j=0;  
        for (int i = 0; i < hexlen; i+=2){  
            result[j]=hexToByte(inHex.substring(i,i+2));  
            j++;  
        }  
        return result;   
    }  

    public static byte hexToByte(String inHex){  
        return (byte)Integer.parseInt(inHex,16);  
     }

    public static String bytesToHexFun1(byte[] bytes) {
        // 一个byte为8位，可用两个十六进制位标识
        char[] buf = new char[bytes.length * 2];
        int a = 0;
        int index = 0;
        for(byte b : bytes) { // 使用除与取余进行转换
            if(b < 0) {
                a = 256 + b;
            } else {
                a = b;
            }

            buf[index++] = HEX_CHAR[a / 16];
            buf[index++] = HEX_CHAR[a % 16];
        }
        return new String(buf);
    }

}