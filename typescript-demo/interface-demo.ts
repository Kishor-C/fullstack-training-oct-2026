interface Product {
    id : number;
    name : string;
    price: number;
}
interface User {
    name : string; skills: string[]; isEmployeed?: boolean;
}


let user1 : User, user2: User;
let product1: Product;

user1 = {name: "Brad", skills:["Java", "React"]};
user2 = {name: "Charles", skills: ["Python", "Angular"], isEmployeed: true};
product1 = {id: 100, name : "Laptop", price: 45000};
// we can print all these object in console & run in node.js
console.log(user1);
console.log(user2);
console.log(product1);