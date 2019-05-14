const mongoose = require('mongoose');

const userSchema = mongoose.Schema({
    _id: String,
    userName: String
},{ versionKey: false });

module.exports =  mongoose.model('User', userSchema);