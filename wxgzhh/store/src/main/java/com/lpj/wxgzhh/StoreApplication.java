package com.lpj.wxgzhh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class StoreApplication {
    private static final Logger LOG = LoggerFactory.getLogger(StoreApplication.class);

    public static void main( String[] args )
    {
        SpringApplication.run(StoreApplication.class, args);
    }
}
