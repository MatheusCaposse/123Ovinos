package com.ovinos.service;

import com.ovinos.DTO.*;
import com.ovinos.entity.Female;
import com.ovinos.entity.auxiliarData.*;
import com.ovinos.entity.superClass.Sheep;
import com.ovinos.repository.*;
import com.ovinos.service.exception.SheepException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

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

    @Autowired
    private WeightRepository weightRepository;

    @Autowired
    private AcitivityRepository acitivityRepository;

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

    @Transactional
    public void treatmentCompleted(String id){
        Sheep sheep = repository.findById(id).orElseThrow(()-> new SheepException("Sheep not found"));
        Treatment treatment = treatmentRepository.findById(sheep.getTreatment().getId()).orElseThrow(()-> new SheepException("Treatment not found"));
        treatmentRepository.delete(treatment);

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

    @Transactional
    public void addWeight(String id, WeightDTO dto){
        Sheep sheep = repository.findById(id).orElseThrow(()-> new SheepException("Sheep not found"));

        if(sheep.getWeight()==null){
            Weight weight = new Weight(dto.getCurrentWeight(), dto.getLastWeight(), dto.getCurrentWeighing(), dto.getFirstWeighing());
            sheep.setWeight(weight);
        } else {
            Weight weight = sheep.getWeight();
            weight.setCurrentWeight(dto.getCurrentWeight());
            weight.setLastWeight(dto.getLastWeight());
            weight.setCurrentWeighing(dto.getCurrentWeighing());
            weight.setFirstWeighing(dto.getFirstWeighing());
        }

        repository.save(sheep);
    }

    @Transactional
    public void addNote(String id, NotesDTO dto){
        Sheep sheep = repository.findById(id).orElseThrow(()-> new SheepException("Sheep not found"));

        if (sheep.getNotes()==null){
            Notes notes = new Notes(dto.getNote(), dto.getAlert());
            sheep.setNotes(notes);
        } else {
            Notes notes = sheep.getNotes();
            notes.setNote(dto.getNote());
            notes.setAlert(dto.getAlert());
        }

        repository.save(sheep);
    }

    @Transactional
    public void addActivity(String id, ActivityDTO dto) {
        Sheep sheep = repository.findById(id).orElseThrow(()-> new SheepException("Sheep not found"));

        if (sheep.getActivity()==null){
            Activity activity = new Activity(dto.getDateActivity(),dto.getActivity());
            sheep.setActivity(activity);
        } else {
            Activity activity = sheep.getActivity();
            activity.setDateActivity(dto.getDateActivity());
            activity.setActivity(dto.getActivity());
        }

        repository.save(sheep);
    }

    public void activityCompleted(String id) {
        Sheep sheep = repository.findById(id).orElseThrow(()-> new SheepException("Sheep not found"));
        if (sheep.getActivity()==null){
            throw new SheepException("This sheep dont have any activity");
        }
        else{
            Activity activity = acitivityRepository.findById(sheep.getActivity().getId()).orElseThrow(()-> new SheepException("Activity not found"));
            sheep.setActivity(null);
            repository.save(sheep);
            acitivityRepository.delete(activity);
        }
    }

    @Transactional
    public void addKinship(String id, KinshipDTO dto){
        Sheep sheep = repository.findById(id).orElseThrow(()-> new SheepException("Sheep not found"));

        if(sheep.getKinship()==null){
            Kinship kinship = new Kinship(dto.getIdPai(), dto.getIdMae());
            sheep.setKinship(kinship);
        }else{
            Kinship kinship = sheep.getKinship();
            kinship.setIdPai(dto.getIdPai());
            kinship.setIdMae(dto.getIdMae());
        }

        repository.save(sheep);
    }
}
