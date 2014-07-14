package hello1.hello2.hello3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import groovy.util.logging.Slf4j;
class HelloWorld{
    private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);


    public String sayHello(){
        String str = "hello";
        logger.info("123");

        return str;
    }

}
