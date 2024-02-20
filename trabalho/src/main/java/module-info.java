module app {
    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    
    requires transitive java.persistence;
    requires org.hibernate.orm.core;
    requires org.postgresql.jdbc;
    requires java.sql;
 
    requires org.junit.jupiter.api;
    
    opens app to javafx.fxml;
    opens model to org.hibernate.orm.core;
 
    exports app;
    exports util;
    exports model;
}


