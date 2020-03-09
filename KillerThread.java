import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class KillerThread extends Thread {
    Robot r;

    public KillerThread() {
        super();
        try {
            r = new Robot();
        } catch(Exception e) {
            throw new Error("Something went wrong");
        }
    }

    public void killEnderman() {
        for(int i = 0; i < 5; ++i) {
            attack();

            try {
                sleep(2000);
            } catch(Exception e) {
                throw new Error("sleeping 2 interrupted");
            }
        }

        tryToEat();
        holdSword();
    }

    public void tryToEat() {
        r.keyPress(KeyEvent.VK_9);
        try {
            sleep(500);
        } catch(Exception e) {
            throw new Error("sleeping 3.1");
        }
        r.keyRelease(KeyEvent.VK_9);
        r.mousePress(InputEvent.BUTTON3_DOWN_MASK);

        try {
            sleep(5000);
        } catch(Exception e) {
            throw new Error("sleeping 3.2 interrupted");
        } finally {
            r.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        }
    }

    public void holdSword() {
        r.keyPress(KeyEvent.VK_4);
        r.keyRelease(KeyEvent.VK_4);
    }

    public void attack() {
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void press(KeyEvent key) {
        r.keyPress(key.getKeyCode());
    }

    public void press(KeyEvent key, int t) throws Exception {
        r.keyPress(key.getKeyCode());
        sleep(t);
    }

    public void release(KeyEvent key) {
        r.keyRelease(key.getKeyCode());
    }

    @Override
    public void run() {
        while(true) {
            try {
                sleep(20000);
            } catch(Exception e) {
                throw new Error("sleeping 1 interrupted");
            }
            killEnderman();
        }
    }
}
