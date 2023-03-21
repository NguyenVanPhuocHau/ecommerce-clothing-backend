package vn.edu.hcmuaf.fit.ecommerceclothingbackend.service;

import vn.edu.hcmuaf.fit.ecommerceclothingbackend.models.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getCategoryByGender(String gender);
    public List<Category> getAll();
}
