//package vn.edu.hcmuaf.fit.ecommerceclothingbackend.database;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import vn.edu.hcmuaf.fit.ecommerceclothingbackend.models.Product;
//import vn.edu.hcmuaf.fit.ecommerceclothingbackend.repositories.ProductRepository;
//
//import java.util.Date;
//
//@Configuration
//public class Database {
//    private static  final Logger logger = LoggerFactory.getLogger(Database.class);
//    @Bean
//    CommandLineRunner initDatabase(ProductRepository productRepository){
//
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
////                Product productA = new Product("jean",100000,new Date(2023,1,5),"");
////                Product productB = new Product("kirt",110000,new Date(2023,1,5),"");
////                logger.info("insert data:"+  productRepository.save(productA));
////                logger.info("insert data:"+  productRepository.save(productB));
//            }
//        };
//    }
//}
