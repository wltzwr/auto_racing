package com.autohome.autoracing.model;

import com.autohome.autoracing.race.RaceMode;
import com.autohome.autoracing.race.RaceResult;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import lombok.Data;
import sun.security.provider.NativePRNG;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.*;

@Data
public class Room {


    private final int maxCount = 5;
    private final int init = 0;
    private final int start = 1;
    private final int end = 2;

    private ExecutorService threadPool = Executors.newCachedThreadPool();

    private BlockingQueue<RaceResult> queue = Queues.newLinkedBlockingQueue();

    private Set<Racer> users = Sets.newConcurrentHashSet();

    private String id = UUID.randomUUID().toString();

    private RaceMode mode;

    private int status = 0;

    public String join(Racer user){
        if (users.contains(user) || users.size() >= 5){
            return null;
        } else {
            users.add(user);
            return this.id;
        }
    }

    public void start(){
        this.status = 1;
        users.forEach(e -> {
            Future<RaceResult> raceResultFuture = threadPool.submit(() -> e.getCar().start(this.mode));
            try {
                queue.put(raceResultFuture.get());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (ExecutionException ex) {
                ex.printStackTrace();
            }
        });
    }



}
