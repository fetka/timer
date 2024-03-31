import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main {

  private JButton startBtn;
  private JPanel panel1;
  private JSlider slider;
  private JLabel sliderLabel;
  private JLabel startAt;
  private JLabel stopAt;
  private JLabel valueLabel;

  public Main() {
    addListener();
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Main");
    frame.setContentPane(new Main().panel1);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.pack();
    frame.setVisible(true);

  }

  private void addListener() {
    ChangeListener listener = new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        System.out.println(source.getValue());
        valueLabel.setText(String.valueOf(source.getValue()));

      }
    };

    slider.addChangeListener(listener);
    ActionListener actionListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          new SimpleTimer().schedule(Long.valueOf(valueLabel.getText()));
        } catch (InterruptedException ex) {
          throw new RuntimeException(ex);
        }
      }
    };

    startBtn.addActionListener(actionListener);
  }

}
