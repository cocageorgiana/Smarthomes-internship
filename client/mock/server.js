const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');

const app = express();
const PORT = 5555;

const users = require('./controllers/users/userInfo');
const login = require('./controllers/users/login');
const register = require('./controllers/users/register');

app.use(cors());
app.use(bodyParser.json());

app.use('/api', users);
app.use('/api', login);
app.use('/api', register);

app.listen(PORT, err => {
    if(err) {
        alert(err);
        return;
    }

    console.log('Listenint on port ', PORT);
});