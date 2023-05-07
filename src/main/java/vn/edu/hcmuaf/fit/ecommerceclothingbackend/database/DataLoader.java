package vn.edu.hcmuaf.fit.ecommerceclothingbackend.database;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.constant.ERole;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.*;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final ColorRepository colorRepository;
    private final SizeRepository sizeRepository;
    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleCheckExist()) {
            createRole();
        }
        if (sizeCheckExist()) {
            createSize();
        }
        if (colorCheckExist()) {
            createColor();
        }
        if (catoryCheckExist()) {
            createCatory();
        }
        if (productCheckExist()) {
            createProduct();
        }

    }

    public void createRole() {
        roleRepository.save(new Roles(ERole.ROLE_USER));
        roleRepository.save(new Roles(ERole.ROLE_ADMIN));
    }

    public void createSize() {
        ProductSize size1 = new ProductSize("XS");
        ProductSize size2 = new ProductSize("S");
        ProductSize size3 = new ProductSize("M");
        ProductSize size4 = new ProductSize("L");
        ProductSize size5 = new ProductSize("XL");
        ProductSize size6 = new ProductSize("XXL");
        sizeRepository.save(size1);
        sizeRepository.save(size2);
        sizeRepository.save(size3);
        sizeRepository.save(size4);
        sizeRepository.save(size5);
        sizeRepository.save(size6);

        for (int i = 90; i <= 160; i += 10) {
            ProductSize size = new ProductSize(i + "");
            sizeRepository.save(size);
        }

    }

    public void createColor() {

        colorRepository.save(new ProductColor("sg529", "mạ"));
        colorRepository.save(new ProductColor("sn198", "nâu"));
        colorRepository.save(new ProductColor("sb060", "đen"));
        colorRepository.save(new ProductColor("sm485", "hồng"));
        colorRepository.save(new ProductColor("sa344", "xám"));
        colorRepository.save(new ProductColor("sb120", "xanh dương"));
        colorRepository.save(new ProductColor("sp071", "xanh tím"));
        colorRepository.save(new ProductColor("sy059", "caro vàng"));
        colorRepository.save(new ProductColor("sb146", "xanh da trời"));
        colorRepository.save(new ProductColor("sw001", "trắng"));
        colorRepository.save(new ProductColor("sg044", "xanh lá"));
        colorRepository.save(new ProductColor("so221", "cam"));
        colorRepository.save(new ProductColor("sg428", "mạ xanh"));
        colorRepository.save(new ProductColor("sn265", "da"));
        colorRepository.save(new ProductColor("sm197", "đỏ"));
        colorRepository.save(new ProductColor("fm217", "caro hồng"));
        colorRepository.save(new ProductColor("fm218", "bi hồng"));
        colorRepository.save(new ProductColor("sa014", "xám"));
        colorRepository.save(new ProductColor("sm001", "hồng phấn"));
        colorRepository.save(new ProductColor("sk010", "đen"));
        colorRepository.save(new ProductColor("sg543", "xanh lục"));
        colorRepository.save(new ProductColor("sb422", "xanh đương đen"));
        colorRepository.save(new ProductColor("sn281", "đỏ gạch"));
        colorRepository.save(new ProductColor("sa010", "xám trắng"));
    }

    public void createCatory() {
        Category c1 = new Category("Nam");
        Category c2 = new Category("Nữ");
        Category c6 = new Category("Trẻ em");
        Category c3 = new Category("Quần");
        Category c4 = new Category("Áo");
        Category c5 = new Category("Đồ mặc nhà");
        categoryRepository.save(c1);
        categoryRepository.save(c2);
        categoryRepository.save(c6);
        categoryRepository.save(c3);
        categoryRepository.save(c4);
        categoryRepository.save(c5);
    }

    public void createProduct() {
        Set<Category> categories = new HashSet<>();
        List<ProductImage> listImg = new ArrayList<>();
        Set<ProductSize> productSizes = new HashSet<>();
        Set<ProductColor> productColors = new HashSet<>();
        //product 1

        Product p1 = new Product("Bộ mặc nhà nữ có hình in", "Bộ mặc nhà chất liệu 100% cotton, áo cổ tròn tay cộc, quần lửng cạp chun.", "Giặt máy ở chế độ nhẹ, nhiệt độ thường.\n" +
                "Không sử dụng hóa chất tẩy có chứa Clo.\n" +
                "Phơi trong bóng mát.\n" +
                "Sấy thùng, chế độ nhẹ nhàng.\n" +
                "Là ở nhiệt độ trung bình 150 độ C.\n" +
                "Giặt với sản phẩm cùng màu.\n" +
                "Không là lên chi tiết trang trí.", 279300, 0.3, 100);
        p1.setEvent("mới");
        categories.add(categoryRepository.findById(2).get());
        categories.add(categoryRepository.findById(5).get());
        categories.add(categoryRepository.findById(6).get());
        p1.setCategories(categories);
        listImg.add(new ProductImage(p1, "https://canifa.com/img/486/733/resize/6/l/6ls23s003-sm001-2-thumb.webp"));
        listImg.add(new ProductImage(p1, "https://canifa.com/img/1000/1500/resize/6/l/6ls23s003-sw001-1.webp"));
        listImg.add(new ProductImage(p1, "https://canifa.com/img/212/284/resize/6/l/6ls23s003-sw001-m-1-ghep.webp"));
        p1.setProductImages(listImg);
        productColors.add(colorRepository.findByColorCode("sa014"));
        productColors.add(colorRepository.findByColorCode("sm001"));
        productColors.add(colorRepository.findByColorCode("sw001"));
        p1.setProductColors(productColors);
        for (int i = 2; i < 6; i++) {
            productSizes.add(sizeRepository.findById(i).get());
        }
        p1.setProductSizes(productSizes);
        productRepository.save(p1);
//        product 2
        categories.clear();
        productSizes.clear();
        productColors.clear();
        listImg.clear();
        Product p2 = new Product("Áo phông bé gái in Winnie the Pooh", "Áo phông chất liệu 100% cotton, cổ tròn tra bo, tay cộc.", "Giặt máy ở chế độ nhẹ, nhiệt độ thường.\n" +
                "Không sử dụng hóa chất tẩy có chứa Clo.\n" +
                "Phơi trong bóng mát.\n" +
                "Sấy thùng, chế độ nhẹ nhàng.\n" +
                "Là ở nhiệt độ trung bình 150 độ C.\n" +
                "Giặt với sản phẩm cùng màu.\n" +
                "Không là lên chi tiết trang trí.", 169000, 0, 100);
        categories.add(categoryRepository.findById(3).get());
        categories.add(categoryRepository.findById(5).get());
        p2.setEvent("giá tốt");
        p2.setCategories(categories);
        listImg.add(new ProductImage(p2, "https://canifa.com/img/212/284/resize/1/t/1ts23s005-sp071-1-thumb.webp"));
        listImg.add(new ProductImage(p2, "https://canifa.com/img/212/284/resize/1/t/1ts23s005-sp071-2.webp"));
        listImg.add(new ProductImage(p2, "https://canifa.com/img/212/284/resize/1/t/1ts23s005-sp071-3.webp"));
        listImg.add(new ProductImage(p2, "https://canifa.com/img/212/284/resize/1/t/1ts23s005-sp071-120-1.webp"));
        p2.setProductImages(listImg);
        productColors.add(colorRepository.findByColorCode("SP071"));
        p2.setProductColors(productColors);
        for (int i = 7; i < 14; i++) {
            productSizes.add(sizeRepository.findById(i).get());
        }
        p2.setProductSizes(productSizes);
        productRepository.save(p2);

        //product3
        categories.clear();
        productSizes.clear();
        productColors.clear();
        listImg.clear();
        Product p3 = new Product("Quần soóc active nam", "Quần soóc nam cạp chun, form regular.", "Giặt máy ở nhiệt độ thường.\n" +
                "Không sử dụng hóa chất tẩy có chứa Clo.\n" +
                "Phơi trong bóng mát.\n" +
                "Không sử dụng máy sấy.\n" +
                "Là ở nhiệt độ thấp 110 độ C.\n" +
                "Giặt với sản phẩm cùng màu.\n" +
                "Tránh xa nguồn lửa.", 179000, 0.1, 100);
        categories.add(categoryRepository.findById(1).get());
        categories.add(categoryRepository.findById(4).get());
        p3.setCategories(categories);
        listImg.add(new ProductImage(p3, "https://canifa.com/img/212/284/resize/8/b/8bs23s005-sa344-xl-1.webp"));
        listImg.add(new ProductImage(p3, "https://canifa.com/img/212/284/resize/8/b/8bs23s005-sa344-xl-2.webp"));
        listImg.add(new ProductImage(p3, "https://canifa.com/img/212/284/resize/8/b/8bs23s005-sb060-xl-1.webp"));
        listImg.add(new ProductImage(p3, "https://canifa.com/img/212/284/resize/8/b/8bs23s005-sk010-xl-2.webp"));
        p3.setProductImages(listImg);
        productColors.add(colorRepository.findByColorCode("sa344"));
        productColors.add(colorRepository.findByColorCode("sb060"));
        productColors.add(colorRepository.findByColorCode("sb120"));
        productColors.add(colorRepository.findByColorCode("sk010"));
        p3.setProductColors(productColors);
        for (int i = 2; i < 7; i++) {
            productSizes.add(sizeRepository.findById(i).get());
        }
        p3.setProductSizes(productSizes);
        productRepository.save(p3);
        // PRODUCT 4
        categories.clear();
        productSizes.clear();
        productColors.clear();
        listImg.clear();
        Product p4 = new Product("Áo phông nam", "Áo phông chất liệu 100% cotton, cổ tròn tra bo, tay cộc, phom relax.", "Giặt máy ở chế độ nhẹ, nhiệt độ thường.\n" +
                "Không sử dụng hóa chất tẩy có chứa Clo.\n" +
                "Phơi trong bóng mát.\n" +
                "Sấy thùng, chế độ nhẹ nhàng.\n" +
                "Là ở nhiệt độ trung bình 150 độ C.\n" +
                "Giặt với sản phẩm cùng màu.\n" +
                "Không là lên chi tiết trang trí.", 299000, 0, 100);
        categories.add(categoryRepository.findById(1).get());
        categories.add(categoryRepository.findById(5).get());
        p4.setCategories(categories);
        listImg.add(new ProductImage(p4, "https://canifa.com/img/212/284/resize/8/t/8ts23s013-so221-xl-1.webp"));
        listImg.add(new ProductImage(p4, "https://canifa.com/img/212/284/resize/8/t/8ts23s013-so221-xl-2.webp"));
        p4.setProductImages(listImg);
        productColors.add(colorRepository.findByColorCode("so221"));
        p4.setProductColors(productColors);
        for (int i = 2; i < 6; i++) {
            productSizes.add(sizeRepository.findById(i).get());
        }
        p4.setProductSizes(productSizes);
        p4.setEvent("mới");
        productRepository.save(p4);

        //PRODUCT 5
        categories.clear();
        productSizes.clear();
        productColors.clear();
        listImg.clear();
        Product p5 = new Product("Áo polo nam", "Áo polo chất liệu cotton pha, cổ bẻ tay cộc, phom regular.", "Giặt máy ở chế độ nhẹ, nhiệt độ thường.\n" +
                "Không sử dụng hóa chất tẩy có chứa Clo.\n" +
                "Phơi trong bóng mát.\n" +
                "Sấy thùng, chế độ nhẹ nhàng.\n" +
                "Là ở nhiệt độ trung bình 150 độ C.\n" +
                "Giặt với sản phẩm cùng màu.\n" +
                "Không là lên chi tiết trang trí.", 291000, 0.12, 100);
        categories.add(categoryRepository.findById(1).get());
        categories.add(categoryRepository.findById(5).get());
        p5.setCategories(categories);
        listImg.add(new ProductImage(p5, "https://canifa.com/img/212/284/resize/8/t/8tp23a001-sa010-1.webp"));
        listImg.add(new ProductImage(p5, "https://canifa.com/img/212/284/resize/8/t/8tp23a001-sa010-2.webp"));
        listImg.add(new ProductImage(p5, "https://canifa.com/img/212/284/resize/8/t/8tp23a001-sa010-xl-1.webp"));
        listImg.add(new ProductImage(p5, "https://canifa.com/img/212/284/resize/8/t/8tp23a001-sb422-xl-2.webp"));
        p5.setProductImages(listImg);
        productColors.add(colorRepository.findByColorCode("sg543"));
        productColors.add(colorRepository.findByColorCode("sn281"));
        productColors.add(colorRepository.findByColorCode("sa010"));
        productColors.add(colorRepository.findByColorCode("sb422"));
        productColors.add(colorRepository.findByColorCode("sk010"));
        p5.setProductColors(productColors);
        for (int i = 2; i < 7; i++) {
            productSizes.add(sizeRepository.findById(i).get());
        }
        p5.setProductSizes(productSizes);
        p5.setEvent("giá tốt");
        productRepository.save(p5);


    }

    public boolean roleCheckExist() {
        return roleRepository.findAll().isEmpty();
    }

    public boolean colorCheckExist() {
        return colorRepository.findAll().isEmpty();
    }

    public boolean sizeCheckExist() {
        return sizeRepository.findAll().isEmpty();
    }

    public boolean productCheckExist() {
        return productRepository.findAll().isEmpty();
    }

    public boolean catoryCheckExist() {
        return categoryRepository.findAll().isEmpty();
    }


}
