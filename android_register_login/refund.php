<?php
require_once 'connect.php';
if ($_SERVER['REQUEST_METHOD'] =='POST'){

    $nama = $_POST['nama'];
    $no = $_POST['no'];
	$alamat = $_POST['alamat'];
	$kode = $_POST['kode'];
	$alasan =$_POST['alasan'];

    $sql = "INSERT INTO refund_table (nama, no, alamat, kode, alasan) VALUES ('$nama', '$no', '$alamat', '$kode', '$alasan')";

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