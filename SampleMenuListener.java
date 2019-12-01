import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class SampleMenuListener implements MenuListener {

    @Override
    public void menuSelected(MenuEvent e) {
    	PowerEntry p= new PowerEntry();
    }

    @Override
    public void menuDeselected(MenuEvent e) {
    }

    @Override
    public void menuCanceled(MenuEvent e) {
    }
}