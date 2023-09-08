//package com.proj.crud.executorframework;
//
//import lombok.extern.slf4j.Slf4j;
//
//import java.time.LocalDateTime;
//import java.util.concurrent.*;
//
//@Slf4j
//public class Executor {
//    public static void main(String[] args)
//    {
//        //Demo task
//        Runnable runnableTask = () -> {
//            try {
//                TimeUnit.MILLISECONDS.sleep(1000);
//                log.info("Current time :: " + LocalDateTime.now());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };
//
//        //Executor service instance
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//
//        //1. execute task using execute() method
//        executor.execute(runnableTask);
//
//        //2. execute task using submit() method
//        Future<String> result = executor.submit(runnableTask, "DONE");
//
//        while(result.isDone())
//        {
//            try
//            {
//                log.info("The method return value : " + result.get());
//                break;
//            }
//            catch (InterruptedException | ExecutionException e)
//            {
//                e.printStackTrace();
//            }
//
//            //Sleep for 1 second
//            try {
//                Thread.sleep(1000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        //Shut down the executor service
//        executor.shutdownNow();
//    }
//}
