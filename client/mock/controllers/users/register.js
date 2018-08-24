const express = require('express');

const router = express.Router();

router.post('/register' , (request, response) => {
  var userData = [
    {
      username: 'admin',
      email: 'admin@domain.com',
      password: 'admin'
    },
    {
      username: 'none',
      email: 'none@nodomain.com',
      password: 'none'
    }
  ];

  if(userData.filter(user => user.username === request.body.username).length !== 0) {
    console.log(userData);
    response.status(400).json({
      message: 'Username already taken',
      status: 400
    })
  } else if(userData.filter(user => user.email === request.body.email).length !== 0) {
    response.status(400).json({
      message: 'Email in use',
      status: 400
    })
  } else if(request.body.password !== request.body.password2) {
    response.status(400).json({
      message: 'Passwords don\'t match',
      status: 400
    })
  } else {
    //console.log(request.body);
    userData.push({
      username: request.body.username,
      email: request.body.email,
      password: request.body.password
    });
    response.status(200).json({
      message: 'Te-ai inregistrat cu succes.',
      status: 200
    })
  }
  //console.log(userData);
 console.log(request.body);
})

module.exports = router;