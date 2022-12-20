package treads;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ConcurrentHashMap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int Pages_number = 5;
        int Thread_number = 50;
        int Clicks = 10;
        Random random = new Random();


        Map<String, Integer> info = new ConcurrentHashMap<>();
        for (int i = 0; i<Pages_number; i++) {
            info.put("page_" + i, 0);
        }
        Page page = new Page(info);

        Thread[] threads = new Thread[Thread_number];
        for (int i=0; i < Thread_number; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    User[] users = new User[Clicks];
                    for (int j = 0; j < Clicks; j ++) {
                        users[j] = new User(page.getLists().get(random.nextInt(Pages_number)));
                        page.Click(users[j].Get_num());
                        users[j].run();
                    }
                }
            });
        }

        for (int i = 0; i < Thread_number; i++){
            threads[i].start();
        }

        try {
            for (int i = 0; i < Thread_number; i ++){
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.ListUrls();
    }
}
