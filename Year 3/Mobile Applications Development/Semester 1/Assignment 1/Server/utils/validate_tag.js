const Tag = require('../api/models/tag');

function validateTag(username, tagname) {
    return new Promise(((resolve, reject) => {
        Tag.findById(tagname)
            .exec()
            .then(tag => {
                console.log(`Tag: ${tag}`);
                if (tag) resolve(tag.userName === username);
                else resolve(false);
            })
            .catch(err => {
                console.log(err);
                reject(err);
            })
    }))
}

module.exports = validateTag;
