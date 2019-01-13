<?php

if ($_SERVER['REQUEST_METHOD']=='POST') {

    $nama = $_POST['nama'];
    $no = $_POST['no'];
	$alamat = $_POST['alamat'];
	$kode = $_POST['kode'];
	$alasan =$_POST['alasan'];

    require_once 'connect.php';

    $sql = "SELECT * FROM refund_table";

    $response = mysqli_query($conn, $sql);

    $result = array();
    $result['kembali'] = array();
	
	    if ( mysqli_num_rows($response) === 1 ) {
        
        $row = mysqli_fetch_assoc($response);
            
			$index['nama'] = $row['nama'];
			$index['no'] = $row['no'];
			$index['alamat'] = $row['alamat'];
			$index['kode'] = $row['kode'];
			$index['alasan'] = $row['alasan'];
            $index['id'] = $row['id'];

            array_push($result['kembali'], $index);

            $result['success'] = "1";
            $result['message'] = "success";
            echo json_encode($result);

            mysqli_close($conn);

        } else {

            $result['success'] = "0";
            $result['message'] = "error";
            echo json_encode($result);

            mysqli_close($conn);
    }
}

?>