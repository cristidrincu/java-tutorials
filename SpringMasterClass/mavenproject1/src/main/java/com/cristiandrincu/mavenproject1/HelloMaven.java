/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cristiandrincu.mavenproject1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author cristiandrincu
 */
public class HelloMaven {
    private static final Logger log = LoggerFactory.getLogger(HelloMaven.class);
    public static void main(String[] args) {
        log.info("Hello info");
        log.debug("Hello debug");
    }
}
