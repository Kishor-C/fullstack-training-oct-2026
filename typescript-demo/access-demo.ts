class Person { 
    private username : string;
    public age : number;
    protected phone: number;
    constructor(username : string, age : number, phone : number) {
        this.username = username;
        this.age = age;
        this.phone = phone;
    }
    display() {
        console.log(`Username = ${this.username}, Age = ${this.age}, Phone = ${this.phone}`)
    }
}
class Employee extends Person {
    constructor(username: string, age : number, phone: number) {
        super(username, age, phone);
    }
    getPhone() {
        return `Phone = ${this.phone}`;
    }
}
let emp : Employee = new Employee("Ajay", 35, 989348934);
console.log(emp.getPhone());
//emp.phone = 99389348 ; // error
emp.age = 40; // since age is public, you can access it
emp.display();