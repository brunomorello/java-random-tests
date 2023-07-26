package com.bmo.fibonacci;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int target = 100;

        PrimeNumbersTask primeNumbersTask = new PrimeNumbersTask();
        Thread primesGeneratorThread = new Thread(primeNumbersTask);
        primesGeneratorThread.setName("primesGeneratorThread");
        primesGeneratorThread.start();

        FibonacciNumbersTask fibonacciNumbersTask = new FibonacciNumbersTask();
        Thread fibonacciGeneratorThread = new Thread(fibonacciNumbersTask);
        fibonacciGeneratorThread.setName("fibonacciGeneratorThread");
        fibonacciGeneratorThread.start();

        CombinedNumbersTask combinedNumbersTask = new CombinedNumbersTask();
        combinedNumbersTask.setFibonacciNumbersTask(fibonacciNumbersTask);
        combinedNumbersTask.setPrimeNumbersTask(primeNumbersTask);

        Thread combinedNumbersGeneratorThread = new Thread(combinedNumbersTask);
        combinedNumbersGeneratorThread.setName("combinedNumbersGeneratorThread");
        combinedNumbersGeneratorThread.start();

        int combined = 0;
        int interactions = 0;
        while (combined < target) {
            interactions++;
            combined = combinedNumbersTask.getSize();

            if (combined > 100) {
                primeNumbersTask.taskCompleted();
                fibonacciNumbersTask.taskComplete();
                combinedNumbersTask.taskComplete();
            }

            if (interactions > 200) {
                interactions = 0;
                System.out.println("currently got: " + combined + " matching numbers.");
                if (combined > 0) combinedNumbersTask.printCombinedNumbers();
                Thread.sleep(1000);
            }
        }

        System.out.println("job done - found: " + combined + ".");
        if (combined > 0) combinedNumbersTask.printCombinedNumbers();

    }
}
