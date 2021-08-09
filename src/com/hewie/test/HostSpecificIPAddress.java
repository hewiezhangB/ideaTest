package com.hewie.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostSpecificIPAddress {
    public static void main(String[] args) {
        InetAddress inetAddress = null;
        /**
         * 抛出异常使用 Ctrl + Alt + T
         * */
        try {
            inetAddress = InetAddress.getByName("www.baidu.com");
        } catch (UnknownHostException e) {
            System.exit(2);
        }
        System.out.println(inetAddress.getHostName() + System.lineSeparator() + "the ip is:" + inetAddress.getHostAddress());
        System.exit(0);
    }
}
