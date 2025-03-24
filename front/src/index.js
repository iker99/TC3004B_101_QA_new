function getNumbers() {
    const num1 = parseFloat(document.getElementById('num1').value);
    const num2 = parseFloat(document.getElementById('num2').value);
    return { num1, num2 };
}

function calculate(operator) {
    const { num1, num2 } = getNumbers();

    if (isNaN(num1) || isNaN(num2)) {
        document.getElementById('result').innerText = "Result: Invalid input";
        return;
    }

    // Encode the operator if it is '+'
    const encodedOperator = operator === '+' ? '%2B' : operator;

    fetch('http://localhost:8080/api/calculator/calculate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: `num1=${num1}&num2=${num2}&operator=${encodedOperator}`
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById('result').innerText = "Result: " + (typeof data.result === 'number' ? data.result.toFixed(2) : data.result);
    })
    .catch(error => {
        console.error('Error:', error);
        document.getElementById('result').innerText = "Result: Error occurred";
    });
}

function addition() {
    calculate('+');
}

function subtraction() {
    calculate('-');
}

function resetFields() {
    document.getElementById('num1').value = '';
    document.getElementById('num2').value = '';
    document.getElementById('operator').value = '+';
    document.getElementById('result').innerText = 'Result: ';
}