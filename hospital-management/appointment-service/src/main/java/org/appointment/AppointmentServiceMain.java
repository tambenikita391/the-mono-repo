package org.appointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "org.appointment")
public class AppointmentServiceMain {
  public static void main(String[] args) {
    SpringApplication.run(AppointmentServiceMain.class, args);
  }
}
