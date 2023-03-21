package com.practice.systemdesign;
import java.util.*;
/**Problem statement:
 Design a logger system that receives a stream of messages along with their timestamps. Each unique
 message should only be printed at most every 10 seconds (i.e. a message printed at timestamp t will
 prevent other identical messages from being printed until timestamp t + 10).

 All messages will come in chronological order. Several messages may arrive at the same timestamp.

 Implement the Logger class:

 Logger() Initializes the logger object.
 bool shouldPrintMessage(int timestamp, string message) Returns true if the message should be printed in the
 given timestamp, otherwise returns false.
 
 Leetcode link: https://leetcode.com/problems/logger-rate-limiter/description/
 **/

public class LoggerRateLimiter {
    Map < String, Integer > map = new HashMap < > ();
    class Logger {

        public Logger() {}
    }
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        } else {
            int prevTimeStamp = map.get(message);
            if (timestamp >= prevTimeStamp + 10) {
                map.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }

    }
}