🔐 LoginFormTugas — Java Web Authentication System

Nama anggota:
Tjiu, Kevin Wijaya
Tjia, David Rikhy

Aplikasi web login sederhana berbasis Java Web menggunakan:
Jakarta Servlet
JSP
MySQL
Apache Tomcat 10
NetBeans IDE

Project ini menerapkan fitur:
✅ Register user
✅ Login user
✅ Password hashing
✅ Session authentication
✅ Login metadata logging
✅ Security audit trail


Masuk ke MySQL lalu jalankan:
CREATE DATABASE web_auth_db;
USE web_auth_db;

-- ======================
-- TABLE USERS
-- ======================
DROP TABLE IF EXISTS users;

CREATE TABLE users (
id INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(100) NOT NULL,
password VARCHAR(255) NOT NULL
);

-- ======================
-- TABLE LOGIN AUDIT
-- ======================
DROP TABLE IF EXISTS login_audit;

CREATE TABLE login_audit (
id INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(100),
ip_address VARCHAR(45),
user_agent TEXT,
device_type VARCHAR(20),
is_successful BOOLEAN,
failed_attempt_count INT,
two_factor_verified BOOLEAN,
login_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
🔌 Konfigurasi Database

File:
config/DBConnection.java

Sesuaikan jika perlu:
private static final String URL = "jdbc:mysql://localhost:3306/web_auth_db";
private static final String USER = "root";
private static final String PASSWORD = "";

⚠ Pastikan MySQL aktif sebelum menjalankan project.

🌐 Konfigurasi Servlet Mapping

Project dapat menggunakan:
✔ web.xml
✔ Annotation (@WebServlet)

Gunakan salah satu saja, jangan keduanya untuk URL yang sama.

Jika menggunakan web.xml, tambahkan:
<welcome-file-list>
<welcome-file>login.jsp</welcome-file>
</welcome-file-list>
🔐 Security Audit Logging

Setiap percobaan login akan menyimpan metadata berikut:
Field Keterangan
username Username yang login
ip_address IP client
user_agent Informasi browser
device_type Mobile / Desktop
is_successful Status login
failed_attempt_count Jumlah percobaan gagal
two_factor_verified Status verifikasi 2FA
login_time Waktu login

▶ Cara Menjalankan Project
1️⃣ Jalankan MySQL
Pastikan database web_auth_db tersedia.
2️⃣ Tambahkan MySQL Connector
Tambahkan ke Libraries project:
mysql-connector-j.jar
3️⃣ Jalankan Apache Tomcat 10
Pastikan server sudah terdaftar di NetBeans.
4️⃣ Run Project
Klik:
Run Project

Akses aplikasi:
http://localhost:8080/LoginFormTugas

🔄 Flow Sistem
Register → Data disimpan ke tabel users
Login → Validasi password hash
Login sukses / gagal → Metadata disimpan ke login_audit
Login sukses → Session dibuat
Dashboard → Hanya bisa diakses user login
Logout → Session dihancurkan
# LoginForm_SE
