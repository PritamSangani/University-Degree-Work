const mongoose = require('mongoose');
const User = require('../models/user');

const tagSchema = mongoose.Schema({
    _id: String,
    userName: {type: String, ref: User}
},{ versionKey: false });

module.exports =  mongoose.model('Tag', tagSchema);