//package vn.edu.hcmuaf.fit.ecommerceclothingbackend.model.mapper;
//
//import com.example.restful_demo.entity.Category;
//import com.example.restful_demo.entity.Product;
//import com.example.restful_demo.entity.User;
//import com.example.restful_demo.model.dto.CategoryDto;
//import com.example.restful_demo.model.dto.ProductDto;
//import com.example.restful_demo.model.dto.UserDto;
//
//
//public class Mapper {
//    public static UserDto toUserDto(User user) {
//        UserDto tmp = new UserDto();
//        tmp.setId(user.getId());
//        tmp.setName(user.getName());
//        tmp.setPhone(user.getPhone());
//        tmp.setAvatar(user.getAvatar());
//        tmp.setEmail(user.getEmail());
////        tmp.setDatePost(user.getDatePost());
////        tmp.setDateModified(user.getDateModified());
////        tmp.setUserParent(user.getUserParent());
////        tmp.setUserStatus(user.getUserStatus());
//
//        return tmp;
//    }
//
//    public static ProductDto toProduct(Product p){
//        ProductDto tmp = new ProductDto();
//        tmp.setId(p.getId());
//        tmp.setName(p.getName());
//        tmp.setDescription(p.getDescription());
//        tmp.setImages(p.getImages());
//        tmp.setPrice(p.getPrice());
//        tmp.setCategoryId(p.getCategory().getId());
//        return tmp;
//    }
//    public static CategoryDto toCategoryDto(Category c){
//        CategoryDto tmp = new CategoryDto();
//        tmp.setId(c.getId());
//        tmp.setGender(c.getGender());
//        tmp.setCategory(c.getCategory());
//        return tmp;
//    }
//    public static  ProductDto toProductOrder(Product p){
//        ProductDto productDto = new ProductDto();
//        productDto.setId(p.getId());
//        productDto.setPrice(p.getPrice());
//        productDto.setDescription(p.getDescription());
//        productDto.setName(p.getName());
//        productDto.setImages(p.getImages());
//        return  productDto;
//    }
//
//}