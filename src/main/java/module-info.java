module com.group.job_board {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.group.job_board to javafx.fxml;
    exports com.group.job_board;
}
