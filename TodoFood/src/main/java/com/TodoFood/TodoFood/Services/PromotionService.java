package com.TodoFood.TodoFood.Services;

import com.TodoFood.TodoFood.Entities.Price;
import com.TodoFood.TodoFood.Entities.ProductsDetails;
import com.TodoFood.TodoFood.Entities.Promotion;
import com.TodoFood.TodoFood.Repositories.PriceRepository;
import com.TodoFood.TodoFood.Repositories.ProductDetailsRepository;
import com.TodoFood.TodoFood.Repositories.PromotionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService extends BaseService<Promotion>{

    @Autowired
    PriceRepository priceRepository;

    @Autowired
    ProductDetailsRepository productDetailsRepository;

    public PromotionService(JpaRepository<Promotion, Long> baseRepository) {
        super(baseRepository);

    }

//    // Sobreescribo el metodo save
    @Override
    @Transactional
    public Promotion save(Promotion newPromotion) throws Exception {
        System.out.println("Entro al save");
        try{
            List<ProductsDetails> fullDetails = newPromotion.getDetails().stream()
                    .map(detail -> productDetailsRepository.findById(detail.getId())
                            .orElseThrow(() -> new RuntimeException("No se encontró el detalle con ID: " + detail.getId())))
                    .toList();

            // Remplaza los detalles con objetos completos
            newPromotion.setDetails(fullDetails);

            // Calcula el precio promocional
            newPromotion.calculatePricePromotinal();

            // Guardo el precio calculado
            Price savedPrice = priceRepository.save(newPromotion.getPrice());
            newPromotion.setPrice(savedPrice);

            // Retorno la entidad
            return baseRepository.save(newPromotion);

        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
