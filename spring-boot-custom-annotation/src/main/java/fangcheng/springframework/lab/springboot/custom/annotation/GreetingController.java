package fangcheng.springframework.lab.springboot.custom.annotation;

import java.util.concurrent.atomic.AtomicLong;

import fangcheng.springframework.lab.springboot.custom.annotation.Bean.SimpleBean;
import fangcheng.springframework.lab.springboot.custom.annotation.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private NameService service;

    @Value("#{InsideProperties[mykey]}")
    private String sampleName;

    @Resource(name = "simplebean")
    private SimpleBean mybean;


    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {

        String javaversion = System.getProperty("java.version");
        String javaruntimeversion  = System.getenv("java.runtime.version");
        String springversion = SpringVersion.getVersion();
        String springbootversion = SpringBootVersion.getVersion();

        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name) + "[" + javaversion + "][" + javaruntimeversion + "][" + springversion + "][" + springbootversion  +"]"
                                    + service.listAllName()  +"]["  + mybean.getLocation() + "]["  + sampleName + "]");
    }
}
