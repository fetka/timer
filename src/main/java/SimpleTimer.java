import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import util.Logging;

public class SimpleTimer {

  public void schedule(long period) throws InterruptedException {

    // Create a timer task to be executed
    TimerTask task = new TimerTask() {
      @Override
      public void run() {
        System.out.println("Time elapsed!");
        Date stop = Date.from(Instant.now());
        Logging.out(stop);
      }

    };
//    long delay = Duration.ofMinutes(1L).toMillis();
    long delay = 2000;
    System.out.println("delay: " + delay);
    // Create a timer object and schedule the task
    Timer timer = new Timer();
    timer.schedule(task, delay, period * 1000);
    Date start = Date.from(Instant.now());
    Logging.out(start);

  }
}
