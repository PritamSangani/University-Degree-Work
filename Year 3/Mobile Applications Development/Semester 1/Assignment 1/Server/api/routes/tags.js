const express = require('express');
const router = express.Router();
const Tag = require('../models/tag');

// route to get all tags for a specific user.
router.get('/', (req, res, next) => {
    let username = req.query.username;
    Tag.find({
        userName: username
    }, (err, tags) => {
        res.status(200).json({
            message: `Tags Retrieved for ${username}`,
            tags: tags
        });
    });
});

//route to insert a tag for a specific user
router.post('/', (req, res, next) => {
    let tagname = req.body.tagname;
    let username = req.body.username;

    const tag = new Tag({
        _id: tagname,
        userName: username,
    });
    tag
        .save()
        .then(result => {
            console.log(result);
            res.status(200).json({
                message: "Tag created",
                tag: tag
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

module.exports = router;