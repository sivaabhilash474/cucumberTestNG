package org.w2.selnium.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {
	
	public static void takeScreenShot(WebDriver webdriver, String fileWithPath) throws IOException{
		
		//Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
                
                System.out.println(SrcFile.getName());
                System.out.println(SrcFile.getAbsolutePath());

            //Move image file to new destination
                System.out.println("File copying to: "+ fileWithPath+SrcFile.getName());

                File DestFile=new File(fileWithPath+SrcFile.getName());

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);
		
	}

}
