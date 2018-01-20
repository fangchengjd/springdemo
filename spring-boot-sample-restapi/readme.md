

Originally from    https://spring.io/guides/gs/rest-service/

Lab Target:  Very simple, All default config, for boottime, for sime restful service.

2018.01.20
 TBD GreetingControllerTests. Not run and not read it deeply.
 
 1. http://localhost:8080/greeting    willl return json   {"id":1,"content":"Hello, World![1.8.0_66][null][4.3.12.RELEASE][1.5.8.RELEASE]"}
 2. How to check port: see bootstrap log " Tomcat started on port(s): 8080 (http)"
 3. What is  context root: see bootstrap log "Mapping servlet: 'dispatcherServlet' to [/]"
 4. What is restful service url : see bootstrap log "Mapped "{[/greeting]}" onto public fangcheng.springframework.lab.springboot.rest.simple.Greeting fangcheng.springframework.lab.springboot.rest.simple.GreetingController.greeting(java.lang.String)"
 
@end 
