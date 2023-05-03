package vn.edu.hcmuaf.fit.ecommerceclothingbackend.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.constant.ERole;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.*;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.CategoryRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.ColorRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.ProductRepository;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.SizeRepository;

import java.util.*;

@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository, ColorRepository colorRepository, SizeRepository sizeRepository, CategoryRepository categoryRepository) {

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                IMPORT SIZE VÀO DATABASE

//                ProductSize size1 = new ProductSize("XS");
//                ProductSize size2 = new ProductSize("S");
//                ProductSize size3 = new ProductSize("M");
//                ProductSize size4 = new ProductSize("L");
//                ProductSize size5 = new ProductSize("XL");
//                ProductSize size6 = new ProductSize("XXL");
//                sizeRepository.save(size1);
//                sizeRepository.save(size2);
//                sizeRepository.save(size3);
//                sizeRepository.save(size4);
//                sizeRepository.save(size5);
//                sizeRepository.save(size6);

//                for (int i = 90; i <= 160; i+=10) {
//                    ProductSize size = new ProductSize(i+"");
//                    sizeRepository.save(size);
//                }

                // IMPORT COLOR VÀO DATABASE


//                ProductColor c2 = new ProductColor("sg529","mạ");
//                ProductColor c3 = new ProductColor("sn198","nâu");
//                ProductColor c4 = new ProductColor("sb060","đen");
//                ProductColor c5 = new ProductColor("sm485","hồng");
//                ProductColor c6 = new ProductColor("sa344","xám");
//                ProductColor c7 = new ProductColor("sb120","xanh dương");
//                ProductColor c8 = new ProductColor("sp071","xanh tím");
//                ProductColor c9 = new ProductColor("sy059","caro vàng");
//                ProductColor c10 = new ProductColor("sb146","xanh da trời");
//                ProductColor c11 = new ProductColor("sw001","trắng");
//                ProductColor c12 = new ProductColor("sg044","xanh lá");
//                ProductColor c13 = new ProductColor("so221","cam");
//                ProductColor c14 = new ProductColor("sg428","mạ xanh");
//                ProductColor c15 = new ProductColor("sn265","da");
//                ProductColor c16 = new ProductColor("sm197","đỏ");
//                ProductColor c17 = new ProductColor("fm217","caro hồng");
//                ProductColor c18 = new ProductColor("fm218","bi hồng");
//                colorRepository.save(new ProductColor("sa014","xám"));
//                colorRepository.save(new ProductColor("sm001","hồng phấn"));
//                colorRepository.save(new ProductColor("sk010","đen"));
//                colorRepository.save(c11);
//                colorRepository.save(c12);
//                colorRepository.save(c13);
//                colorRepository.save(c14);
//                colorRepository.save(c15);
//                colorRepository.save(c16);
//                colorRepository.save(c17);
//                colorRepository.save(c18);
//                colorRepository.save(c19);
//                colorRepository.save(c10);

//                    IMPORT CATORY VÀO DATABASE
//                Category c1 =  new Category("Nam");
//                Category c2 = new Category("Nữ");
//                Category c6 = new Category("Trẻ em");
//                Category c3 = new Category("Quần");
//                Category c4 = new Category("Áo");
//                Category c5 =new Category("Đồ mặc nhà");
//                categoryRepository.save(c1);
//                categoryRepository.save(c2);
//                categoryRepository.save(c6);
//                categoryRepository.save(c3);
//                categoryRepository.save(c4);
//                categoryRepository.save(c5);


//                IMPORT PRODUCT VÀO DATABASE (lưu ý cascade = CascadeType.ALL)

                Set<Category> categories = new HashSet<>();
                List<ProductImage> listImg = new ArrayList<>();
                Set<ProductSize> productSizes = new HashSet<>();
                Set<ProductColor> productColors = new HashSet<>();
                //product 1
//                Product p1 = new Product("Bộ mặc nhà nữ có hình in", "Bộ mặc nhà chất liệu 100% cotton, áo cổ tròn tay cộc, quần lửng cạp chun.", "Giặt máy ở chế độ nhẹ, nhiệt độ thường.\n" +
//                        "Không sử dụng hóa chất tẩy có chứa Clo.\n" +
//                        "Phơi trong bóng mát.\n" +
//                        "Sấy thùng, chế độ nhẹ nhàng.\n" +
//                        "Là ở nhiệt độ trung bình 150 độ C.\n" +
//                        "Giặt với sản phẩm cùng màu.\n" +
//                        "Không là lên chi tiết trang trí.", 279300, 0.3, 100);
//                categories.add(categoryRepository.findById(2).get());
//                categories.add(categoryRepository.findById(5).get());
//                categories.add(categoryRepository.findById(6).get());
//                p1.setCategories(categories);
//                listImg.add(new ProductImage(p1,"https://canifa.com/img/486/733/resize/6/l/6ls23s003-sm001-2-thumb.webp"));
//                listImg.add(new ProductImage(p1,"https://canifa.com/img/1000/1500/resize/6/l/6ls23s003-sw001-1.webp"));
//                listImg.add(new ProductImage(p1,"https://canifa.com/img/212/284/resize/6/l/6ls23s003-sw001-m-1-ghep.webp"));
//                p1.setProductImages(listImg);
//                productColors.add(colorRepository.findByColorCode("sa014"));
//                productColors.add(colorRepository.findByColorCode("sm001"));
//                productColors.add(colorRepository.findByColorCode("sw001"));
//                p1.setProductColors(productColors);
//                for (int i = 2; i < 6; i++) {
//                    productSizes.add(sizeRepository.findById(i).get());
//                }
//                p1.setProductSizes(productSizes);
//                productRepository.save(p1);

                //product 2
//                Product p2 = new Product("Áo phông bé gái in Winnie the Pooh", "Áo phông chất liệu 100% cotton, cổ tròn tra bo, tay cộc.", "Giặt máy ở chế độ nhẹ, nhiệt độ thường.\n" +
//                        "Không sử dụng hóa chất tẩy có chứa Clo.\n" +
//                        "Phơi trong bóng mát.\n" +
//                        "Sấy thùng, chế độ nhẹ nhàng.\n" +
//                        "Là ở nhiệt độ trung bình 150 độ C.\n" +
//                        "Giặt với sản phẩm cùng màu.\n" +
//                        "Không là lên chi tiết trang trí.", 169000, 0, 100);
//                categories.add(categoryRepository.findById(3).get());
//                categories.add(categoryRepository.findById(5).get());
//                p2.setCategories(categories);
//                listImg.add(new ProductImage(p2,"https://canifa.com/img/212/284/resize/1/t/1ts23s005-sp071-1-thumb.webp"));
//                listImg.add(new ProductImage(p2,"https://canifa.com/img/212/284/resize/1/t/1ts23s005-sp071-2.webp"));
//                listImg.add(new ProductImage(p2,"https://canifa.com/img/212/284/resize/1/t/1ts23s005-sp071-3.webp"));
//                listImg.add(new ProductImage(p2,"https://canifa.com/img/212/284/resize/1/t/1ts23s005-sp071-120-1.webp"));
//                p2.setProductImages(listImg);
//                productColors.add(colorRepository.findByColorCode("SP071"));
//                p2.setProductColors(productColors);
//                for (int i = 7; i < 14; i++) {
//                    productSizes.add(sizeRepository.findById(i).get());
//                }
//                p2.setProductSizes(productSizes);
//                productRepository.save(p2);

                //product3

//                Product p3 = new Product("Quần soóc active nam", "Quần soóc nam cạp chun, form regular.", "Giặt máy ở nhiệt độ thường.\n" +
//                        "Không sử dụng hóa chất tẩy có chứa Clo.\n" +
//                        "Phơi trong bóng mát.\n" +
//                        "Không sử dụng máy sấy.\n" +
//                        "Là ở nhiệt độ thấp 110 độ C.\n" +
//                        "Giặt với sản phẩm cùng màu.\n" +
//                        "Tránh xa nguồn lửa.", 179000, 0.1, 100);
//                categories.add(categoryRepository.findById(1).get());
//                categories.add(categoryRepository.findById(4).get());
//                p3.setCategories(categories);
//                listImg.add(new ProductImage(p3,"https://canifa.com/img/212/284/resize/8/b/8bs23s005-sa344-xl-1.webp"));
//                listImg.add(new ProductImage(p3,"https://canifa.com/img/212/284/resize/8/b/8bs23s005-sa344-xl-2.webp"));
//                listImg.add(new ProductImage(p3,"https://canifa.com/img/212/284/resize/8/b/8bs23s005-sb060-xl-1.webp"));
//                listImg.add(new ProductImage(p3,"https://canifa.com/img/212/284/resize/8/b/8bs23s005-sk010-xl-2.webp"));
//                p3.setProductImages(listImg);
//                productColors.add(colorRepository.findByColorCode("sa344"));
//                productColors.add(colorRepository.findByColorCode("sb060"));
//                productColors.add(colorRepository.findByColorCode("sb120"));
//                productColors.add(colorRepository.findByColorCode("sk010"));
//                p3.setProductColors(productColors);
//                for (int i = 2; i < 7; i++) {
//                    productSizes.add(sizeRepository.findById(i).get());
//                }
//                p3.setProductSizes(productSizes);
//                productRepository.save(p3);

                // PRODUCT 4
//                Product p4 = new Product("Áo phông nam", "Áo phông chất liệu 100% cotton, cổ tròn tra bo, tay cộc, phom relax.", "Giặt máy ở chế độ nhẹ, nhiệt độ thường.\n" +
//                        "Không sử dụng hóa chất tẩy có chứa Clo.\n" +
//                        "Phơi trong bóng mát.\n" +
//                        "Sấy thùng, chế độ nhẹ nhàng.\n" +
//                        "Là ở nhiệt độ trung bình 150 độ C.\n" +
//                        "Giặt với sản phẩm cùng màu.\n" +
//                        "Không là lên chi tiết trang trí.", 299000, 0, 100);
//                categories.add(categoryRepository.findById(1).get());
//                categories.add(categoryRepository.findById(5).get());
//                p4.setCategories(categories);
//                listImg.add(new ProductImage(p4, "https://canifa.com/img/212/284/resize/8/t/8ts23s013-so221-xl-1.webp"));
//                listImg.add(new ProductImage(p4, "https://canifa.com/img/212/284/resize/8/t/8ts23s013-so221-xl-2.webp"));
//                p4.setProductImages(listImg);
//                productColors.add(colorRepository.findByColorCode("so221"));
//                p4.setProductColors(productColors);
//                for (int i = 2; i < 6; i++) {
//                    productSizes.add(sizeRepository.findById(i).get());
//                }
//                p4.setProductSizes(productSizes);
//                p4.setEvent("mới");
//                productRepository.save(p4);

                //PRODUCT 5

//                Product p5 = new Product("Áo polo nam", "Áo polo chất liệu cotton pha, cổ bẻ tay cộc, phom regular.", "Giặt máy ở chế độ nhẹ, nhiệt độ thường.\n" +
//                        "Không sử dụng hóa chất tẩy có chứa Clo.\n" +
//                        "Phơi trong bóng mát.\n" +
//                        "Sấy thùng, chế độ nhẹ nhàng.\n" +
//                        "Là ở nhiệt độ trung bình 150 độ C.\n" +
//                        "Giặt với sản phẩm cùng màu.\n" +
//                        "Không là lên chi tiết trang trí.", 291000, 0.12, 100);
//                categories.add(categoryRepository.findById(1).get());
//                categories.add(categoryRepository.findById(5).get());
//                p5.setCategories(categories);
//                listImg.add(new ProductImage(p5, "https://canifa.com/img/212/284/resize/8/t/8tp23a001-sa010-1.webp"));
//                listImg.add(new ProductImage(p5, "https://canifa.com/img/212/284/resize/8/t/8tp23a001-sa010-2.webp"));
//                listImg.add(new ProductImage(p5, "https://canifa.com/img/212/284/resize/8/t/8tp23a001-sa010-xl-1.webp"));
//                listImg.add(new ProductImage(p5, "https://canifa.com/img/212/284/resize/8/t/8tp23a001-sb422-xl-2.webp"));
//                p5.setProductImages(listImg);
//                colorRepository.save(new ProductColor("sg543","xanh lục"));
//                productColors.add(colorRepository.findByColorCode("sg543"));
//                colorRepository.save(new ProductColor("sn281","đỏ gạch"));
//                productColors.add(colorRepository.findByColorCode("sn281"));
//                colorRepository.save(new ProductColor("sa010","xám trắng"));
//                productColors.add(colorRepository.findByColorCode("sa010"));
//                colorRepository.save(new ProductColor("sb422","xanh đương đen"));
//                productColors.add(colorRepository.findByColorCode("sb422"));
//                productColors.add(colorRepository.findByColorCode("sk010"));
//                p5.setProductColors(productColors);
//                for (int i = 2; i < 7; i++) {
//                    productSizes.add(sizeRepository.findById(i).get());
//                }
//                p5.setProductSizes(productSizes);
//                p5.setEvent("giá tốt");
//                productRepository.save(p5);


//
//
//
//
//                Product productA = new Product("jean",100000,new Date(2023,1,5),"");
//                Product productB = new Product("kirt",110000,new Date(2023,1,5),"");
//                logger.info("insert data:"+  productRepository.save(productA));
//                logger.info("insert data:"+  productRepository.save(productB));
            }
        };
    }
}
