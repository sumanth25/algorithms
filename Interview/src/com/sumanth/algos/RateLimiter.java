package com.sumanth.algos;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Salesforce Interview Round
 *
 * A rate limiter algorithm is used to limit the number of requests a client can make to a service within a given time window. To implement a rate limiter in Java that allows repeated requests to the same URL within a 5-second or 30-second window, and returns a 429 (Too Many Requests) error otherwise, we can use a sliding window or a token bucket approach.
 *
 * Here's an implementation using a sliding window approach for simplicity:
 *
 * Key points of the implementation:
 * Rate Limiting Logic: If the same URL is requested multiple times within the same time window (5 seconds or 30 seconds), further requests should be denied (429 error).
 * Time Window: We will track timestamps of the requests and check whether the requests occur within the 5-second or 30-second window.
 * Bucket Size: For simplicity, we consider a fixed bucket size for requests within the given windows.
 *
 * Time Complexity:
 * Worst-case time complexity for isRequestAllowed(url) is O(n), where n is the number of requests stored for a given URL (within the 30-second window).
 * Space Complexity:
 * Space complexity is O(n) per URL, where n is the number of requests stored in the deque for each URL (bounded by the 30-second window).
 * Total space complexity across all URLs can be O(m * n), where m is the number of unique URLs and n is the number of requests for each URL.
 */
public class RateLimiter {

    // Data structure to store timestamps of requests for each URL
    private Map<String, Deque<Long>> requestHistoryMap = new HashMap<>();

    // Time windows in milliseconds
    private final long FIVE_SECOND_WINDOW = 5 * 1000;  // 5 seconds
    private final long THIRTY_SECOND_WINDOW = 30 * 1000; // 30 seconds

    // Method to check if a request should be allowed or rejected based on rate limiting rules
    public boolean isRequestAllowed(String url) {
        long currentTime = System.currentTimeMillis();

        // Get the request history for the given URL
        Deque<Long> requestHistory = requestHistoryMap.getOrDefault(url, new LinkedList<>());

        // Clean up old requests (out of the 30-second window)
        while (!requestHistory.isEmpty() && requestHistory.peek() <= currentTime - THIRTY_SECOND_WINDOW) {
            requestHistory.poll();  // Remove requests outside the 30-second window
        }

        // Count requests within the 5-second window
        int recentRequestsIn5Seconds = 0;
        for (long timestamp : requestHistory) {
            if (timestamp > currentTime - FIVE_SECOND_WINDOW) {
                recentRequestsIn5Seconds++;
            }
        }

        // If there are requests within the 5-second window, reject the request
        if (recentRequestsIn5Seconds >= 1) {
            System.out.println("Rate limit exceeded (5s window) for URL: " + url);
            return false;  // 429 error
        }

        // Allow the request and add the timestamp to the history
        requestHistory.offer(currentTime);
        requestHistoryMap.put(url, requestHistory);

        // Allow the request if no violation of 5-second window limit
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter();

        // Example usage: simulating requests to the same URL
        String url = "/api/resource";

        // Simulating multiple requests
        System.out.println(rateLimiter.isRequestAllowed(url)); // Should allow the first request
        Thread.sleep(1000);  // Wait for 1 second
        System.out.println(rateLimiter.isRequestAllowed(url)); // Should allow the second request (within 5s)
        Thread.sleep(1000);  // Wait for 1 second
        System.out.println(rateLimiter.isRequestAllowed(url)); // Should allow the third request (within 5s)
        Thread.sleep(3000);  // Wait for 3 seconds to ensure 5s window clears
        System.out.println(rateLimiter.isRequestAllowed(url)); // Should allow after 5 seconds
        Thread.sleep(10000); // Wait for 10 seconds
        System.out.println(rateLimiter.isRequestAllowed(url)); // Should allow after 30 seconds
    }
}

