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

    let result;
    switch (operator) {
        case '+':
            result = num1 + num2;
            break;
        case '-':
            result = num1 - num2;
            break;
        // Add more cases for other operations if needed
        default:
            result = "Invalid operator";
    }

    document.getElementById('result').innerText = "Result: " + (typeof result === 'number' ? result.toFixed(2) : result);
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
