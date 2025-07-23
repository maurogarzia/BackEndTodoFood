package com.TodoFood.TodoFood.Repositories;

import com.TodoFood.TodoFood.Entities.ProductsDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailsRepository extends BaseRepository<ProductsDetails, Long>{


}
