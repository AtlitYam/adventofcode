const fs = require('fs');
const path = require('path');

/**
 * Lees een bestand en geef de inhoud terug.
 * @param {string} filePath - Het pad naar het bestand.
 * @returns {Promise<string>} - De inhoud van het bestand.
 */
async function readFileContent(filePath) {
    return new Promise((resolve, reject) => {
        const absolutePath = path.resolve(filePath);

        fs.readFile(absolutePath, 'utf8', (err, data) => {
            if (err) {
                reject(`Error reading file: ${err.message}`);
            } else {
                resolve(data);
            }
        });
    });
}

module.exports = readFileContent