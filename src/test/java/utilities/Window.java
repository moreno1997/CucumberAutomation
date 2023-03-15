package utilities;

import java.util.Set;


public class Window {
    //1
    private static String mainHandle;
    public static void switchToSecondWindow(){
        //need to check for condition
        Set<String> windowHandles = Driver.getDriver().getWindowHandles(); //all windows from opened session
        mainHandle = Driver.getDriver().getWindowHandle(); //this is the main window handle
        if (windowHandles.size()<2){ //check the condition
            System.out.println("No multiple windows found");
        } else { // meaning we have more windows, this is to switch to second one
            for(String windowID: windowHandles){
                if(!windowID.equals(mainHandle)){
                    Driver.getDriver().switchTo().window(windowID);
                }
            }
        }
    }

    //2
    public static void switchToMainWindow(){
        if(mainHandle != null){
            Driver.getDriver().switchTo().window(mainHandle);
        }
    }

    //3 use this method from main page only
    public static void switchToWindow(String title){
        mainHandle = Driver.getDriver().getWindowHandle(); //store main window
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();   //need to check if multiple windows or not
        if(windowHandles.size() < 2){
            System.out.println("No multiple windows found");
        } else {
            for(String window: windowHandles){
                Driver.getDriver().switchTo().window(window); //first we swtich
                if(title.equals(Driver.getDriver().getTitle())){ //then we check if title we are requesting is equal to current switched window
                    break; //to switch to any preferred window
                }
            }
        }
    }
}

