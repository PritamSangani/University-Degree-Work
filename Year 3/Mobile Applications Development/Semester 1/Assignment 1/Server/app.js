const express = require('express');
const tagRoutes = require('./api/routes/tags');
const attemptRoutes = require('./api/routes/attempts');
const morgan = require('morgan');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');

const DB_URL = process.env.DB_URL;
const app = express();

//middleware to decide which routes to take
//first route (morgan) is used to logan any incoming requests in the console.
app.use(morgan('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

app.use((req, res, next) => {
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Headers',
        'Origin, X-Requested-With, Content-Type, Accept, Authorization'
    );

    if(req.method === 'OPTIONS') {
        res.header('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, PATCH');
        return res.status(200).json({});
    }
    next();
});

app.use('/tag', tagRoutes);
app.use('/attempt', attemptRoutes);

app.use((req, res, next) => {
    const error = new Error('Route not found');
    error.status = 404;
    next(error);
});

app.use((error, req, res, next) => {
    res.status(error.status || 500);
    res.json({
        error : {
            message : error.message
        }
    });
});

mongoose.connect(DB_URL, { useNewUrlParser: true }, (err) => {
    console.log('mongodb connected', err);
});

module.exports = app;