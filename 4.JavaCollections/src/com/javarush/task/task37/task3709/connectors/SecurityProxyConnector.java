package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector {
    private SimpleConnector simpleConnector;
    private SecurityChecker securityChecker;

    public SecurityProxyConnector(String url) {
        this.simpleConnector = new SimpleConnector(url);
        this.securityChecker = new SecurityCheckerImpl();
    }

    @Override
    public void connect() {
        if (securityChecker.performSecurityCheck())
            simpleConnector.connect();
    }
}