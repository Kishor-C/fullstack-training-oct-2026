// a greet function that returns string
function greet(user: string, age: number): string {
 return `Hello ${user}, your age is ${age}`;   
}
// an add function that returns numberq 
function add(x: number , y: number) : number {
    return x + y;
}
// a sum function that accepts an array and returns a number
function sum(items : number[]) : number {
    let total : number = 0;
    for(let num of items) {
        total = total + num;
    }
    return total;
}
// invoking functions that returns string or number
// union type
let result : number | string;
result = greet("Raj", 35);
console.log(result);
result = add(20, 30);
console.log(result);
result = sum([10, 20, 30, 40]);
console.log(result);