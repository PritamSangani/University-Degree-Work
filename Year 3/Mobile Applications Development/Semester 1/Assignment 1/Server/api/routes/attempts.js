const express = require('express');
const router = express.Router();
const mongoose = require('mongoose');
const Attempt = require('../models/attempt');
const validate = require('../../utils/validate_tag');

//route to retrieve all attempts made by the user
router.get('/', (req, res, next) => {
    let username = req.query.username;
    Attempt.find({
        userName: username
    }, (err, attempts) => {
        res.status(200).json({
            message: `Attempts Retrieved for ${username}`,
            attempts: attempts
        });
    });
});

//route to post an attempt
router.post('/', (req, res) => {
    console.log(req);
    let tagname = req.body.sensorvalue;
    let username = req.body.username;
    //validate whether username matches tagname(tagID)
    validate(username, tagname)
        .then((result) => {
            //set up new document for attempt
            let attempt = new Attempt({
                _id: mongoose.Types.ObjectId(),
                tagName: tagname,
                userName: username,
                attemptDate: Date.now(),
                success: result
            });
            console.log("Attempt: " + attempt);
            console.log(attempt.success);
            attempt
                .save()
                .then(result => {
                    console.log(result);
                    res.status(201).json({
                        message: "The attempt has been recorded",
                        attemptResult: attempt.success
                    });
                })
                .catch(error => {
                    console.log(error);
                    res.status(500).json({
                       message: "There was an error on the server. Please try later.",
                       error: error
                    });
                });

        });
});

module.exports = router;