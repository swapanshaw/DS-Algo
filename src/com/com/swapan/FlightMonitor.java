package com.com.swapan;/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;


class FlightMonitor {
  
  Map<String, Map<String, int[]>> map = new HashMap<>();
  /**
    A customer with id, checks in at the station startCity at time t.
    A customer can only be checked into one place at a time.
  */
  public void start(String user, String startCity, int startTime) {
    Map<String, int[]> usrTimeMap = new HashMap<>();
    int []arr = new int[2];
    arr[0]=startTime;
    usrTimeMap.put(user, arr);
    
    map.put(startCity, usrTimeMap);
  
  }

  /**
    A customer with id, checks out from the station endCity at time t.
  */
  public void end(String user, String endCity, int endTime) {
    
    for(Map.Entry<String, Map<String, int[]>> entry : map.entrySet()) {
      String startCity = entry.getKey();
      Map<String, int[]> usermap = entry.getValue();
      
      if(usermap.get(user)!=null) {
         usermap.get(user)[1] = endTime;
        map.remove(startCity);
        map.put(startCity+"_"+endCity, usermap);
        break;
      }
    }
    
  }

  /**
    Returns the average time it takes to travel from startCity to endCity.
    
    The average time is computed from all the previous traveling times from startCity to endCity that happened directly, meaning a check in at startCity followed by a check out from endCity.
    
    The time it takes to travel from startCity to endCity may be different from the time it takes to travel from endCity to startCity.
    
    There will be at least one customer that has traveled from startCity to endCity before getAverageTime is called.
  */
  public double averageDuration(String startCity, String endCity) {
    double avg = 0;
    String cKey = startCity+"_"+endCity;
    Map<String, int[]> usermap = map.get(cKey);
    
      for(Map.Entry<String, int[]> entry1 : usermap.entrySet()) {
        int[] arr = entry1.getValue();
        avg+= (arr[1]-arr[0]);
      
    }
    System.out.println("----");
    System.out.println(avg);
    System.out.println("----");
    usermap.forEach((k, v) -> System.out.println(k + " : " + v));
    return avg/usermap.size();
  }
  
  
  
}

/**
Map<String, int[]> startMap = [{"city", [starTime, endTime]}, {B,[4]}
Map<String, int[]> endMap = [{A, [14]}, {B,[12]}]

delhi_mumbai-> a->{2,14}, b->{} 
mumba_delhi-> 4,12,

C, Delhi 10
C, Mumbai, 20

*/
class Solution {
  
  public static void main(String[] args) {
    FlightMonitor monitor = new FlightMonitor();
    
    monitor.start("A", "Delhi", 2);
    monitor.start("B", "Mumbai", 4);

    monitor.end("B", "Delhi", 12);
    monitor.end("A", "Mumbai", 14);

   // System.out.println(monitor.averageDuration("Delhi", "Mumbai")); //12
    //System.out.println(monitor.averageDuration("Mumbai", "Delhi"));  //8
    
    monitor.start("C", "Delhi", 11);
    monitor.start("D", "Delhi", 13);
    monitor.start("E", "Delhi", 14);

    monitor.end("C", "Mumbai", 31);
    monitor.end("D", "Mumbai", 33);
    monitor.end("E", "Mumbai", 34);

    monitor.start("A", "Mumbai", 20);
    monitor.end("A", "Delhi", 30);

    monitor.averageDuration("Delhi", "Mumbai");
    monitor.averageDuration("Mumbai", "Delhi");
    //System.out.println(monitor.averageDuration("Delhi", "Mumbai"));   //18
    //System.out.println(monitor.averageDuration("Mumbai", "Delhi"));    //9
    
    
    
  }
}














































/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

 /***
 
Given a resource allocator (having fixed number of pool of resources) with which any client can ask for a resource to use for a certain amount of time, expiry time for a resource is fixed(system-level same expiry time) with resource allocator. Design and implement resource allocator satisfying following conditions
 - client should be given a provision to renew the expiry given the renew request is within the expiry
 - if client asks for a resource within the expiry time, extend the expiry and assign the same resource
 - system should try for maximum stickiness to the client i.e. if client is asking for a resource again in future after the time of expiry; try to assign the same resource that was allocated last time only if that particular resource is never allocated to someone else in between those two requests of that client


  ***/
/*
class Resource {
  String name;
}

interface ResourceManagerI<T> {
 //return resouces
  T borrow();
  
  //void returnBack(T obj);
  
  void extendExpiry(String clientId);
  
}


class ResourceManager  implement ResourceManagerI {
  
  map<Resource, Long> availableResouse = new ConcurrentHashMap<>();
  Queuqe<Resouce> queue = new 
  Map<String, Resource> clientToResoucemap = new ConcurrentHashMap<>();
  
  int capacity;
  static {
    
    
  }
  
  ResourceManager(int _capacity) {
    
    
  }
  
  
}

class Solution {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java " + Runtime.version().feature());

    for (String string : strings) {
      System.out.println(string);
    }
  }
}
*/