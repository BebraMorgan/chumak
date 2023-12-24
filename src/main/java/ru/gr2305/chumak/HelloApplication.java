package ru.gr2305.chumak;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.io.IOException;
import java.util.Collections;

public class HelloApplication extends Application {
    @Getter
    private static EntityManager entityManager;
    @Getter
    private static EntityManagerDAO entityManagerDAO;

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
        entityManagerDAO = new EntityManagerDAO();
        launch();
        entityManager.close();
    }
}