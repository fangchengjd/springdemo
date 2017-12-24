package hello;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Value("${name.test}")
    private String testname;

    @PostConstruct
    public void init(){
        System.out.println("MyService init method called");
        long start =  System.currentTimeMillis();
        long lapse = 0;
        while (lapse < 10* 60 * 1000)  {

            if (true) break;

            System.out.println(new Date());
            long current = System.currentTimeMillis();
            lapse = current - start;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {

        String javaversion = System.getProperty("java.version");
        String javaruntimeversion  = System.getenv("java.runtime.version");
        String springversion = SpringVersion.getVersion();
        String springbootversion = SpringBootVersion.getVersion();

        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name) + "[" + testname +"] [" + javaversion + "][" + javaruntimeversion + "][" + springversion + "][" + springbootversion  +"]");
    }
}
