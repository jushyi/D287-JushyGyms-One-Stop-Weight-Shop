package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       if (outsourcedPartRepository.count() == 0) {
           OutsourcedPart rubberDisk = new OutsourcedPart();
           rubberDisk.setCompanyName("JirehSynthetics");
           rubberDisk.setName("Rubber Disk");
           rubberDisk.setInv(15);
           rubberDisk.setPrice(15.0);
           rubberDisk.setId(100L);
           outsourcedPartRepository.save(rubberDisk);

           OutsourcedPart metalDisk = new OutsourcedPart();
           metalDisk.setCompanyName("JAMIronWorks");
           metalDisk.setName("Metal Disk");
           metalDisk.setInv(15);
           metalDisk.setPrice(15.0);
           metalDisk.setId(100L);
           outsourcedPartRepository.save(metalDisk);

           OutsourcedPart steelDisk = new OutsourcedPart();
           steelDisk.setCompanyName("JAMIronWorks");
           steelDisk.setName("Steel Disk");
           steelDisk.setInv(15);
           steelDisk.setPrice(30.0);
           steelDisk.setId(100L);
           outsourcedPartRepository.save(steelDisk);

           OutsourcedPart rubberHead = new OutsourcedPart();
           rubberHead.setCompanyName("JirehSynthetics");
           rubberHead.setName("Rubber Head");
           rubberHead.setInv(30);
           rubberHead.setPrice(20.0);
           rubberHead.setId(100L);
           outsourcedPartRepository.save(rubberHead);

           OutsourcedPart metalHead = new OutsourcedPart();
           metalHead.setCompanyName("JAMIronWorks");
           metalHead.setName("Metal Head");
           metalHead.setInv(30);
           metalHead.setPrice(20.0);
           metalHead.setId(100L);
           outsourcedPartRepository.save(metalHead);
       }

      /*  OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());*/

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        if (productRepository.count() == 0) {
            Product rubberPlate = new Product("Rubber Plate", 90.0, 15);
            Product metalPlate = new Product("Metal Plate", 90.0, 15);
            Product calibratedPlate = new Product("Calibrated Plate", 135.0, 15);
            Product rubberDumbbell = new Product("Rubber Dumbbell", 100.0, 15);
            Product metalDumbbell = new Product("Metal Dumbbell", 100.0, 15);
            productRepository.save(rubberPlate);
            productRepository.save(metalPlate);
            productRepository.save(calibratedPlate);
            productRepository.save(rubberDumbbell);
            productRepository.save(metalDumbbell);
        }


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
