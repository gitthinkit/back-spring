package eu.spb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.filedemo.property.FileStorageProperties;

import eu.spb.dao.CategorieRepository;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
=======
import org.springframework.context.annotation.ComponentScan;

import eu.spb.dao.CategorieRepository;
import eu.spb.entities.Categorie;

@SpringBootApplication
>>>>>>> fdc3e92537e2ba4b7c4fe2a32f3dfd36aeaf243b
public class SpbProjetApplication implements CommandLineRunner{
	@Autowired
	CategorieRepository categorierep ;
	public static void main(String[] args) {
		SpringApplication.run(SpbProjetApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	}
}
