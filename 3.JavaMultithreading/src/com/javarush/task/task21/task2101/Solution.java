package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netAddress = new byte[ip.length];

        for(int i = 0; i < ip.length && i < mask.length; i++) {
            char[] ipBytes = toBinary(ip[i]).toCharArray();
            char[] maskBytes = toBinary(mask[i]).toCharArray();
            char[] result = new char[ipBytes.length];

            for(int k = 0; k < ipBytes.length; k++) {
                if(ipBytes[k] == '1' && maskBytes[k] == '1') {
                    result[k] = '1';
                }
                else {
                    result[k] = '0';
                }
            }

            StringBuilder builder = new StringBuilder();

            for(int l = 0; l < result.length; l++)
                builder.append(result[l]);

            netAddress[i] = (byte) (toDecimal(builder.toString()) + 128);
        }

        return netAddress;
    }

    public static void print(byte[] bytes) {
        for(int i = 0; i < bytes.length -1; i++)
            System.out.print(toBinary(bytes[i]) + " ");
        System.out.println(toBinary(bytes[bytes.length-1]));
    }

    public static String toBinary(byte b) {
        StringBuilder builder = new StringBuilder();
        int bInteger = Byte.toUnsignedInt(b); // & 0xff

        while(bInteger > 0) {
            builder.append(bInteger%2);
            bInteger /= 2;
        }

        for(int i = 8; i > builder.length();) {
            builder.append('0');
        }

        return builder.reverse().toString();
    }

    public static byte toDecimal(String b) {
        char[] chars = new StringBuilder(b).reverse().toString().toCharArray();

        byte result = -128;

        for(int i = 0, m = 0; i < chars.length; i++) {
            if(chars[i] == '1') {
                int add = 1;

                for(int k = 0; k < m; k++)
                    add *= 2;

                result += add;
            }

            m++;
        }
        return (byte) Byte.toUnsignedInt(result);
    }
}
