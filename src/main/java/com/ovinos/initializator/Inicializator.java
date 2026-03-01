package com.ovinos.initializator;

import com.ovinos.entity.Batch;
import com.ovinos.entity.Deads;
import com.ovinos.entity.Enum.BatchType;
import com.ovinos.entity.Enum.ConditionSheep;
import com.ovinos.entity.Enum.SheepStatus;
import com.ovinos.entity.Female;
import com.ovinos.entity.Male;
import com.ovinos.repository.BatchRepository;
import com.ovinos.repository.DeadsRepository;
import com.ovinos.repository.SheepRepository;
import com.ovinos.resource.BatchResource;
import com.ovinos.resource.SheepResource;
import com.ovinos.service.DeadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class Inicializator implements CommandLineRunner {

    @Autowired
    private SheepRepository sheepRepository;

    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private DeadsRepository deadsRepository;

    @Autowired
    private DeadsService deadsService;

    SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void run(String... args) throws Exception {

        Batch batch1 = new Batch("1", BatchType.CONFINAMENTO);
        Batch batch2 = new Batch("2", BatchType.RECRIA);

        batchRepository.saveAll(Arrays.asList(batch1, batch2));

        Female f1 = new Female("1", sfd.parse("02/01/2026"),SheepStatus.VIVO, ConditionSheep.MAMANDO, (double) 10, batch1);
        Male m1 = new Male("2", sfd.parse("27/12/2025"), SheepStatus.DOADO, ConditionSheep.RECRIA,(double) 16, batch1);
        Female f2 = new Female("3", sfd.parse("12/02/2026"), SheepStatus.DESCONHECIDO,ConditionSheep.COBERTA,(double) 10, batch1);

        Male m2 = new Male("4", sfd.parse("07/12/2025"),SheepStatus.ABATIDO, ConditionSheep.RECRIA,(double) 15, batch2);

        sheepRepository.saveAll(Arrays.asList(f1, f2, m1, m2));


    }
}
