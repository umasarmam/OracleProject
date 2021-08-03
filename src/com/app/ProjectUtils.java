package com.app;

/*
 * this is a utils class which contains all the utility methods we use across the project
 */
public class ProjectUtils {

	/*
	 * this method is used to split the data using , and returns String array
	 */
	public static String[] getArrayOfStrings(String str) {
        if (str != null && str.length() > 0) {
            return str.split(",");
        }
        return null;
    }
	
}
