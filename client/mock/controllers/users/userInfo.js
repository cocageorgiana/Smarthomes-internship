const express = require('express');

const router = express.Router();

router.get('/users', (request, response) => {
  //console.log(request.query);

  var users = [
    {
      username: 'none',
      email: 'none@none.com',
      firstName: 'John',
      lastName: 'Smith',
      dateOfBirth: '01.01.1980'
    },
    {
      username: 'admin',
      email: 'admin@domain.com',
      firstName: 'Dick',
      lastName: 'Richard',
      dateOfBirth: '01.01.1970'
    }
  ];

  let user = users.filter(user => user.username == request.query.username);

  if(user.length === 0) {
    // console.log(request.query);
    response.status(400).json({
      message: "Urthfgtent",
      status: 400
    });
  } else {
    user = user[0];

    response.status(200).json({
      message: "Utilizator existent",
      status: 200,
      user: {
        firstName: user.firstName,
        lastName: user.lastName,
        email: user.email,
        dateOfBirth: user.dateOfBirth
      }
    })
  }
});

module.exports = router;