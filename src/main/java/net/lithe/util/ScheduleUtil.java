package net.lithe.util;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@UtilityClass
public class ScheduleUtil {
    private final Map<String, ScheduledFuture<?>> schedulerMap = new HashMap<>();

    private final ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();

    public void runAsync(Runnable command) {
        scheduledExecutor.submit(command);
    }

    // Отменить шедулер
    public void cancelScheduler(String schedulerId) {
        ScheduledFuture<?> scheduledFuture = schedulerMap.get(schedulerId.toLowerCase());

        if ( scheduledFuture == null || scheduledFuture.isCancelled() ) {
            return;
        }

        scheduledFuture.cancel(true);
        schedulerMap.remove(schedulerId.toLowerCase());
    }

    public void runLater(String schedulerId,
                         Runnable command, long delay, TimeUnit timeUnit) {
        ScheduledFuture<?> scheduledFuture = scheduledExecutor.schedule(command, delay, timeUnit);

        schedulerMap.put(schedulerId.toLowerCase(), scheduledFuture);
    }

    public void runTimer(String schedulerId,
                         Runnable command, long delay, long period, TimeUnit timeUnit) {
        ScheduledFuture<?> scheduledFuture
                = scheduledExecutor.scheduleAtFixedRate(command, delay, period, timeUnit);

        schedulerMap.put(schedulerId.toLowerCase(), scheduledFuture);
    }

}
