module ru.gr2305.chumak {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires lombok;
    requires org.hibernate.commons.annotations;
    requires org.hibernate.orm.core;
    requires annotations;


    opens ru.gr2305.chumak to javafx.fxml, lombok;
    opens ru.gr2305.chumak.models to org.hibernate.orm.core, javafx.base;
    exports ru.gr2305.chumak;
    opens ru.gr2305.chumak.enums to org.hibernate.orm.core;
    exports ru.gr2305.chumak.controllers;
    opens ru.gr2305.chumak.controllers to javafx.fxml, lombok;
    opens ru.gr2305.chumak.controllers.company to javafx.fxml;
    opens ru.gr2305.chumak.controllers.base to javafx.fxml;
    opens ru.gr2305.chumak.exceptions to javafx.fxml;
    opens ru.gr2305.chumak.controllers.room to javafx.fxml;
    opens ru.gr2305.chumak.controllers.rack to javafx.fxml;
    opens ru.gr2305.chumak.controllers.room.racks to javafx.fxml;
    opens ru.gr2305.chumak.models.transformed to javafx.base;
    opens ru.gr2305.chumak.controllers.cargo to javafx.fxml;
    opens ru.gr2305.chumak.controllers.rack.cargos to javafx.fxml;
    opens ru.gr2305.chumak.controllers.contract to javafx.fxml;
    exports ru.gr2305.chumak.repositories;
    opens ru.gr2305.chumak.repositories to javafx.fxml, lombok;
}