const express = require('express');

const router = express.Router();

router.post('/login', (request, response) => {
    var data =   [
        {
            username: 'admin',
            password: 'admin'
        },
        {
            username: 'none',
            password: 'none'
        }
    ];

    // const users = [{
    //     name: 'Asfa',
    //     age: 22
    // }, {
    //     name: 'asdsdasda',
    //     age: 20
    // }, {
    //     name: 'asdlsad;kl',
    //     age: 18
    // }];

    //console.log(users.filter(user => user.age == 20 && user.name == 'asddasda').length);
    console.log(data.filter(user => user.username == request.body.username
        && user.password == request.body.password));

    if(data.filter(user => user.username == request.body.username
        && user.password == request.body.password).length == 0) {
            response.status(400).json({
                message: 'Username/password inexistente',
                status: 400
            })
    } else {
        response.status(200).json({
            message: 'Esti autentificat',
            status: 200
        })
    }
    /*data.forEach(user => {
        if(user.username == request.body.username && user.password == request.body.password){
            response.status(200).json("ESTI AUTENTIFICAT");
        }
    })*/
    console.log(request.body);
    
});

module.exports = router;