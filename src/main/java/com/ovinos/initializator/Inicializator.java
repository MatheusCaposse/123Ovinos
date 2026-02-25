package com.ovinos.initializator;

import com.ovinos.entity.Female;
import com.ovinos.repository.FemaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class Inicializator implements CommandLineRunner {

    @Autowired
    private FemaleRepository femaleRepository;

    SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void run(String... args) throws Exception {

        Female f1 = new Female("1", sfd.parse("11/01/2026"),  (double) 13);
        Female f2 = new Female("2", sfd.parse("01/02/2026"),  (double) 15);
        Female f3 = new Female("3", sfd.parse("20/02/2026"),  (double) 12.2);

        femaleRepository.saveAll(Arrays.asList(f1, f2, f3));

    }
}
