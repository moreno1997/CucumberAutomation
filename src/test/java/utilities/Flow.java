package utilities;

import org.openqa.selenium.interactions.Actions;

public class Flow {

    // create a static method wait that accepts integer in milliseconds
    // the method simply uses Thread.sleep with exception handled
    // Flow.wait(500); //needs to wait for 500 milliseconds

    //can have explicit wait here, as well

    public static void wait(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Interruption happened"); //here, it will not throw an exception, let it happen, but don't make it break the code
        }
    }

    public static void scrollDown(int deltaY){
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollByAmount(0, deltaY).perform();
    }

    public static void scrollUp(int deltaY){
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollByAmount(0, -deltaY).perform();
    }

}
