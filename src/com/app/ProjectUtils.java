package com.app;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProjectUtils {

	public static String[] getArrayOfStrings(String str) {
        if (str != null && str.length() > 0) {
            return str.split(",");
        }
        return null;
    }
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) 
	{
	    Map<Object, Boolean> map = new ConcurrentHashMap<>();
	    return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
}
