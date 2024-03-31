import java.util.Timer;
import java.util.TimerTask;

public class TimerJob {

  Notifier notifier;

  public void schedule(long delayInMin) {
    notifier = Notifier.getInstance(delayInMin);
    TimerTask timerTask = new TimerTask() {
      @Override
      public void run() {
        notifier.increaseCurrent();
        notifier.emit();
      }
    };

    Timer timer = new Timer();

    timer.schedule(timerTask, delayInMin);
  }

  private long calculateDelay(long in) {
    return in * 60_000;
  }

}
