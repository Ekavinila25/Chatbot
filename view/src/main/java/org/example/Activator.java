package org.example;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Bundle;


public class Activator implements BundleActivator {

    public static Bundle bundle;

    public void start(BundleContext context) {
        System.out.println("Starting the VIEW bundle");
        bundle = context.getBundle();
        ChatBot.userInput();
    }

    public void stop(BundleContext context) {
        System.out.println("Stopping the bundle");
    }
}