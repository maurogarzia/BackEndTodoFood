package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.PromotionDetails;
import com.TodoFood.TodoFood.Entities.UnitaryDetails;
import com.TodoFood.TodoFood.Repositories.UnitaryDetailsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PromotionDetailsService extends BaseService<PromotionDetails>{

    @Autowired
    UnitaryDetailsRepository unitaryDetailsRepository;

    public PromotionDetailsService(JpaRepository<PromotionDetails, Long> baseRepository) {
        super(baseRepository);
    }

    @Transactional
    @Override
    public PromotionDetails save(PromotionDetails newPromotionDetail) throws Exception{
        try{
            List<UnitaryDetails> unitaryDetails = new ArrayList<>();

            for (UnitaryDetails details : newPromotionDetail.getUnitaryDetails()){
                UnitaryDetails detail = unitaryDetailsRepository.findById(details.getId())
                        .orElseThrow(() -> new Exception("No se encontro el detalle unitario con con ID: " + details.getId()));
                unitaryDetails.add(detail);
            }

            newPromotionDetail.setUnitaryDetails(unitaryDetails);
            newPromotionDetail.calculatePrice();
            return baseRepository.save(newPromotionDetail);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    @Override
    public PromotionDetails update(Long id, PromotionDetails newPromotionDetails) throws Exception {
        try {
            if (!baseRepository.existsById(id)) {
                throw new Exception("No se encontró el Detalle Promoción con Id: " + id);
            }

            List<UnitaryDetails> unitaryDetails = new ArrayList<>();

            for (UnitaryDetails details : newPromotionDetails.getUnitaryDetails()) {
                UnitaryDetails detail = unitaryDetailsRepository.findById(details.getId())
                        .orElseThrow(() -> new Exception("No se encontró el detalle unitario con ID: " + details.getId()));
                unitaryDetails.add(detail);
            }

            newPromotionDetails.setUnitaryDetails(unitaryDetails);
            newPromotionDetails.calculatePrice();

            newPromotionDetails.setId(id);

            return baseRepository.save(newPromotionDetails);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
