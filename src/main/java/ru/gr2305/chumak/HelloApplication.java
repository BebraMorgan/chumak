package ru.gr2305.chumak;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import org.hibernate.jpa.HibernatePersistenceProvider;
import ru.gr2305.chumak.repositories.CargoRepository;
import ru.gr2305.chumak.models.Cargo;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class HelloApplication extends Application {
    @Getter
    private static EntityManager entityManager;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("PM");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        var provider = new HibernatePersistenceProvider();
        EntityManagerFactory entityManagerFactory = provider.createEntityManagerFactory("persistence", Collections.emptyMap());
        entityManager = entityManagerFactory.createEntityManager();
        launch();
        entityManager.close();
    }
}