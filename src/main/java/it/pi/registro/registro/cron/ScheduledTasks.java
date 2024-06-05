package it.pi.registro.registro.cron;

import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.service.ScheduledService;
import it.pi.registro.registro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class ScheduledTasks {

    @Autowired
    private ScheduledService scheduledService;

    @Autowired
    UserService userService;

//    @Scheduled(cron = "* * * * * *") // Cron expression for running every minute
    public void execute() {

        long unixTimeStamps = System.currentTimeMillis() / 1000L;

        File report  = new File("REPORT_" + unixTimeStamps + ".txt");

        try {
            FileWriter fileWriter = new FileWriter(report);

            for(User u: userService.getUsersWithoutDetails()){
                System.out.println(u);
                fileWriter.append(u.getFirstName() + " " + u.getLastName() + "\n");

            }

            /*userService.getUsersWithoutDetails()
                    .forEach(user -> {
                        fileWriter.append(user.getFirstName());
                    });*/
            fileWriter.flush();
            fileWriter.close();
            System.out.println("File created successfully!");

        } catch (IOException e) {
            System.out.println("Error creating file");
            e.printStackTrace();
        }
    }

//    @Scheduled(cron = "1 * * * * *") // Cron expression for running every minute
    public void execute1() {
        scheduledService.createReport();
    }
}
