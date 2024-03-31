public class Notifier {

  private static Notifier INSTANCE;
  private long origin;
  private long current;

  private Notifier(long origin) {
    this.origin = origin;
  }

  public static Notifier getInstance(long origin) {
    if (INSTANCE == null) {
      INSTANCE = new Notifier(origin);
    }
    return INSTANCE;
  }

  public long subscribe() {
    return getCurrent();
  }

  public long getOrigin() {
    return origin;
  }

  public long getCurrent() {
    return current;
  }

  public void setCurrent(int current) {
    this.current = current;
  }

  protected void increaseCurrent() {
    if (current < origin) {
      ++current;
    }
  }

  public long emit() {
    return current;
  }
}
