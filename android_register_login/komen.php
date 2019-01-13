<?php
require_once 'connect.php';
if ($_SERVER['REQUEST_METHOD'] =='POST'){

    $nama = $_POST['nama'];
    $komen = $_POST['komen'];

    $sql = "INSERT INTO komen_table (nama, komen) VALUES ('$nama', '$komen')";

    if ( mysqli_query($conn, $sql) ) {
        $result["success"] = "1";
        $result["message"] = "success";

        echo json_encode($result);
        mysqli_close($conn);

    } else {

        $result["success"] = "0";
        $result["message"] = "error";

        echo json_encode($result);
        mysqli_close($conn);
    }
}

?>