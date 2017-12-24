package fangcheng.springframework.lab.spring3mvc.classloader.extra;




import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class LoopWriter {

	public void execute() {
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();



		executorService.scheduleAtFixedRate( new Runnable()  {

			@Override
			public void run() {
				System.out.println(new Date() + "I am a happy bird.");
				
			}
			// Task
		}, 1, 10, TimeUnit.SECONDS);

	

		//executorService.shutdown();
	}

}
