const express = require('express');
const mysql = require('mysql');
const app = express();
const port = 3000;

// MySQL connection settings
const connection = mysql.createConnection({
  host: 'localhost',
  user: 'aman',
  password: 'nama',
  database: 'kevents'
});

connection.connect(error => {
  if (error) throw error;
  console.log('Successfully connected to the database.');
});

// Endpoint to get data from MySQL and send to Android app
app.get('/data', (req, res) => {
  connection.query('SELECT * FROM events', (error, results) => {
    if (error) throw error;
    // Send data as JSON
    res.json(results);
  });
});

app.use('/images', express.static('public/images'));

app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});
