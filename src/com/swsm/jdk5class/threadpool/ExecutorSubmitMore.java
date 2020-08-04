package com.swsm.jdk5class.threadpool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author swsm
 * @date 2020/8/4
 */
public class ExecutorSubmitMore {

    public static void main(String[] args) {
        ExecutorService threadPool2 = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService(threadPool2);
        for (int i = 0; i < 10; i++) {
            final int seq = i;

            completionService.submit(() -> {
                Thread.sleep(new Random().nextInt(5000));
                return seq;
            });
        }

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(completionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
    
}
