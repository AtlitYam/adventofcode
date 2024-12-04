const readFileContent = require('../utils/fileReader.js')
const filePath = './../adventofcode/adventofcode/2024/day1/input'

async function splitColumns(filePath) {
    const fileContent = await readFileContent(filePath)

    const column1 = []
    const column2 = []

    // Split de data in regels en verwerk elke regel
    const lines = fileContent.split('\n').filter(line => line.trim() !== '') // Filter lege regels
    lines.forEach(line => {
        const [col1, col2] = line.trim().split(/\s+/) // Splits op spaties
        column1.push(Number(col1))
        column2.push(Number(col2))
    });

    return { column1, column2 }
}

// Extra functie die splitColumns aanroept en de kolommen sorteert van laag naar hoog
async function sortColumns(filepath) {
    const data = await splitColumns(filePath)
    const sortedColumn1 = data.column1.sort()
    const sortedColumn2 = data.column2.sort()

    return { sortedColumn1, sortedColumn2 }
}

function calculateSimilarityScore(value, column2) {
    let count = 0
    column2.forEach(element => (element === value && count++));
    return value * count
}

// Extra functie die splitColumns aanroept en de kolommen logt
async function calculateTotalSimilarityScore(filePath) {
    const data = await sortColumns(filePath)

    let total = 0

    data.sortedColumn1.forEach(function (value, i) {
        total = total + calculateSimilarityScore(value, data.sortedColumn2)
    })

    console.log(total)
}

// Aanroepen van de logColumns functie
calculateTotalSimilarityScore(filePath);