const mongoose = require('mongoose');
const Tag = require('../models/tag');
const User = require('../models/user');

const attemptSchema = mongoose.Schema({
    _id: mongoose.Schema.Types.ObjectId,
    tagName: {type: String, ref: Tag},
    userName: {type: String, ref: User},
    attemptDate: mongoose.Schema.Types.Date,
    success: {type: mongoose.Schema.Types.Boolean, required: true},
    openedAt: mongoose.Schema.Types.Date
}, { versionKey: false });

module.exports =  mongoose.model('Attempt', attemptSchema);