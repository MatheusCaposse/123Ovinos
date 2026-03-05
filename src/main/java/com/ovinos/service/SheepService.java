package com.ovinos.service;

import com.ovinos.DTO.CharacteristicsDTO;
import com.ovinos.DTO.PregnancyDTO;
import com.ovinos.DTO.TreatmentDTO;
import com.ovinos.entity.Enum.SheepStatus;
import com.ovinos.entity.Female;
import com.ovinos.entity.auxiliarData.Characteristics;
import com.ovinos.entity.auxiliarData.Pregnancy;
import com.ovinos.entity.auxiliarData.Treatment;
import com.ovinos.entity.superClass.Sheep;
import com.ovinos.repository.CharacteristicsRepository;
import com.ovinos.repository.FemaleRepository;
import com.ovinos.repository.SheepRepository;
import com.ovinos.repository.TreatmentRepository;
import com.ovinos.service.exception.SheepException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SheepService {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private SheepRepository repository;

    @Autowired
    private FemaleRepository femaleRepository;

    @Autowired
    private CharacteristicsRepository characteristicsRepository;

    @Autowired
    private TreatmentRepository treatmentRepository;

    public List<Sheep> findAll(){
        List<Sheep> list = repository.findAll();
        return list;
    }

    public Sheep findById(String id){
        Sheep obj = repository.findById(id).orElseThrow(() -> new SheepException("Sheep not found"));
        return obj;
    }

    @Transactional
    public void addCharacteristics(String id, CharacteristicsDTO characteristicsDTO){
        Sheep sheep = repository.findById(id).orElseThrow(() -> new SheepException("Sheep not found"));

        Characteristics characteristics = new Characteristics(characteristicsDTO.getStatus(), characteristicsDTO.getConditionSheep(), characteristicsDTO.getRaceSheep());

        sheep.setCharacteristics(characteristics);
        repository.save(sheep);

    }

    @Transactional
    public void addTreatment(String id, TreatmentDTO treatmentDTO) {

        Sheep sheep = repository.findById(id)
                .orElseThrow(() -> new SheepException("Sheep not found"));

        if (sheep.getTreatment() == null) {
            Treatment treatment = new Treatment(treatmentDTO.getDescricao(), treatmentDTO.getMedicamento(), treatmentDTO.getDosagem(), treatmentDTO.getDataAplicacao());
            sheep.setTreatment(treatment);

        } else {
            Treatment treatment = sheep.getTreatment();

            treatment.setDescricao(treatmentDTO.getDescricao());
            treatment.setMedicamento(treatmentDTO.getMedicamento());
            treatment.setDosagem(treatmentDTO.getDosagem());
            treatment.setDataAplicacao(treatmentDTO.getDataAplicacao());
        }

        repository.save(sheep);
    }

    public void treatmentCompleted(String id){
        Sheep sheep = repository.findById(id).orElseThrow(()-> new SheepException("Sheep not found"));

        sheep.setTreatmentCompleted(null);

        repository.save(sheep);
    }

    @Transactional
    public void addPregnancy(String id, PregnancyDTO dto){
        Female female = femaleRepository.findById(id).orElseThrow(() -> new SheepException("Female not found"));

        Pregnancy pregnancy = new Pregnancy(dto.getTypeBirth(), dto.getIdPai());

        female.setPregnancy(pregnancy);

        femaleRepository.save(female);
    }
}
