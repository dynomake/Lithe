package net.lithe.reader;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.experimental.FieldDefaults;
import net.lithe.util.ScheduleUtil;

import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

@Builder(builderMethodName = "create", buildMethodName = "apply")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TerminalReader {

    String line;
    Consumer<String> onPrint;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(line);
        ScheduleUtil.runTimer(UUID.randomUUID().toString(), () -> {
            if (scanner.hasNext()) {
                onPrint.accept(scanner.nextLine().replaceFirst(line, ""));
                System.out.print("\r");
                System.out.print(line);
            }
        }, 3, 1, TimeUnit.MILLISECONDS);
    }
}
