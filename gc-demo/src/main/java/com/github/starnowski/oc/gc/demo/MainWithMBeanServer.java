package com.github.starnowski.oc.gc.demo;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class MainWithMBeanServer {

    /*
     * Check below page about how to register MBeanServer.
     * https://docs.oracle.com/javase/tutorial/jmx/mbeans/standard.html
     */
    public static void main(String[] args)
            throws Exception {

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("com.github.starnowski.oc.gc.demo:type=CircleReferenceManager");
        CircleReferenceManager mbean = new CircleReferenceManager();
        mbs.registerMBean(mbean, name);

        //

        System.out.println("Waiting forever...");
        Thread.sleep(Long.MAX_VALUE);
    }
}
