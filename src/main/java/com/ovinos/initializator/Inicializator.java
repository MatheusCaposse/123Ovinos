package com.ovinos.initializator;

import com.ovinos.entity.Female;
import com.ovinos.entity.Male;
import com.ovinos.repository.FemaleRepository;
import com.ovinos.repository.MaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class Inicializator implements CommandLineRunner {

    @Autowired
    private FemaleRepository femaleRepository;

    @Autowired
    private MaleRepository maleRepository;

    SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void run(String... args) throws Exception {

        Female f1 = new Female("1", sfd.parse("11/01/2026"),  (double) 13);
        Female f2 = new Female("2", sfd.parse("01/02/2026"),  (double) 15);
        Female f3 = new Female("3", sfd.parse("20/02/2026"),  (double) 12.2);

        femaleRepository.saveAll(Arrays.asList(f1, f2, f3));

        Male m1 = new Male("4", sfd.parse("22/12/2025"),  (double) 12);
        Male m2 = new Male("5", sfd.parse("03/12/2025"),  (double) 11);
        Male m3 = new Male("6", sfd.parse("12/02/2026"),  (double) 9);

        maleRepository.saveAll(Arrays.asList(m1, m2, m3));
    }
}
