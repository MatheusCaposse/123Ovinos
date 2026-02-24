package com.ovinos.initializator;

import com.ovinos.entity.Sheep;
import com.ovinos.repository.SheepRepository;
import com.ovinos.resource.SheepResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class Inicializator implements CommandLineRunner {

    @Autowired
    private SheepRepository sheepRepository;

    SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void run(String... args) throws Exception {


        Sheep s1 = new Sheep( (long) 1, sfd.parse("23/02/2026"),  (double) 10);
        Sheep s2 = new Sheep( (long) 2, sfd.parse("20/02/2026"), (double) 14);
        Sheep s3 = new Sheep( (long) 3, sfd.parse("10/01/2026"), (double) 13.3);

        sheepRepository.saveAll(Arrays.asList(s1,s2,s3));
    }
}
