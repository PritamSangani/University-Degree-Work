// Ex. 1 - add speak method to user object
console.log("Ex. 1");
let user1 = {
    name: "John",
    age: 30,
    speak() {
        console.log(`Hello, my name is ${this.name} and I am ${this.age} years old.`);
    }
};

user1.speak();

// Ex. 2a - Accessor property for name and surname and use to print out email
console.log("Ex. 2a");
let user2a = {
    first_name: "John",
    surname: "Smith",
    get email() {
        return `${this.first_name}.${this.surname}@mmu.ac.uk`
    }
};

console.log(user2a.email);

// Ex. 2b - Extract first name and surname from email
console.log("Ex. 2b");
let user2b = {
    first_name: "John",
    surname: "Smith",
    get email() {
        return `${this.first_name}.${this.surname}@mmu.ac.uk`
    },
    set email(email) {
        const regEx = /([.@])/;
        let splitName = email.split(regEx);
        this.first_name = splitName[0];
        this.surname = splitName[2];
    }
};

user2b.email = "Pritam.Sangani@mmu.ac.uk";
console.log(user2b.first_name);
console.log(user2b.surname);

// Ex. 3a - Implement Ex. 2b but using a Class rather than object
console.log("Ex. 3a");

class User3a {
    constructor(first_name, surname) {
        this.first_name = first_name;
        this.surname = surname;
    }
    get email() {
        return `${this.first_name}.${this.surname}@mmu.ac.uk`
    };
    set email(email) {
        const regEx = /([.@])/;
        let splitName = email.split(regEx);
        this.first_name = splitName[0];
        this.surname = splitName[2];
    };
}

let user3a = new User3a("Pritam", "Sangani");
console.log(user3a.first_name);
console.log(user3a.surname);
console.log(user3a.email);
user3a.email = "David.Haig@mmu.ac.uk";
console.log(user3a.first_name);
console.log(user3a.surname);

// Ex. 3b - Getters and setters for first_name and surname
console.log("Ex. 3b");

class User3b {
    constructor(first_name, surname) {
        this.first_name = first_name;
        this.surname = surname;
    }
    get first_name() {
        return this._first_name;
    }
    set first_name(first_name) {
        this._first_name = first_name;
    }
    get surname() {
        return this._surname;
    }
    set surname(surname) {
        if (surname.length > 3)
            this._surname = surname;
    }
    get email() {
        return `${this.first_name}.${this.surname}@mmu.ac.uk`
    };
    set email(email) {
        const regEx = /([.@])/;
        let splitName = email.split(regEx);
        this.first_name = splitName[0];
        this.surname = splitName[2];
    };
}

let user3b = new User3b("Rick", "DeVoe");
user3b.surname = "Astley";
user3b.surname = "A";
console.log(user3b.first_name);
console.log(user3b.surname);

// Ex. 4 - Extend StaffUser from User
console.log("Ex. 4");

class User4 {
    constructor(first_name, surname) {
        this.first_name = first_name;
        this.surname = surname;
    }
    get first_name() {
        return this._first_name;
    }
    set first_name(first_name) {
        this._first_name = first_name;
    }
    get surname() {
        return this._surname;
    }
    set surname(surname) {
        if (surname.length > 3)
            this._surname = surname;
    }
    get email() {
        return `${this.first_name}.${this.surname}@mmu.ac.uk`
    };
    set email(email) {
        const regEx = /([.@])/;
        let splitName = email.split(regEx);
        this.first_name = splitName[0];
        this.surname = splitName[2];
    };
}

class StaffUser4 extends User4 {
    constructor(first_name, surname) {
        super(first_name, surname);
    }
    get email() {
        return `${this.first_name}.${this.surname}@staff.mmu.ac.uk`
    };
}

let user4 = new User4("Nick", "Drake");
console.log(user4.email);
let staffUser4 = new StaffUser4("Bernie", "Taupin");
console.log(staffUser4.email);