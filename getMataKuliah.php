<?php
// Mengatur koneksi ke database MySQL
$servername = "localhost"; // Nama host database
$username = "root";        // Username MySQL
$password = "";            // Password MySQL (kosong secara default)
$dbname = "studentcampus"; // Nama database yang telah Anda buat

// Membuat koneksi
$conn = new mysqli($servername, $username, $password, $dbname);

// Cek koneksi
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Query untuk mengambil data mata kuliah
$sql = "SELECT * FROM mata_kuliah";
$result = $conn->query($sql);

// Membuat array untuk menyimpan hasil query
$mataKuliahList = array();
if ($result->num_rows > 0) {
    // Ambil data dan masukkan ke dalam array
    while($row = $result->fetch_assoc()) {
        $mataKuliahList[] = $row;
    }
} else {
    echo "0 results";
}

// Menutup koneksi
$conn->close();

// Mengirimkan data dalam format JSON
echo json_encode($mataKuliahList);
?>
    