package ci.ada.fitness;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class FitnessApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(FitnessApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
