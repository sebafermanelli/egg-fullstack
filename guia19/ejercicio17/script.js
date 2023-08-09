const vector = new Array();

for (let i = 0; i < 5; i++) {
    vector[i] = Math.round(Math.random() * 10);
}

console.log(vector);

vector.pop();
vector.pop();

console.log(vector);