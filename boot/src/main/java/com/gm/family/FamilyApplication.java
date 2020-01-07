package com.gm.family;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动项目.
 *  - 在启动项目的同时, 会将CcFramework启动
 *  - 详见{@link com.gm.cc.boot.CcApplication}
 *
 * @author : Jason.lee
 * @version : 1.0
 */
@SpringBootApplication
public class FamilyApplication {
    public static void main(String[] args) {
        SpringApplication.run(FamilyApplication.class);
    }
}
