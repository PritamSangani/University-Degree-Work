/* Ex. 1 - FizzBuzz */
// for (let i = 1; i <= 200; i++) {
//     if (i%3 === 0 && i%5 === 0) {
//         console.log("FizzBuzz");
//     } else if (i%3 === 0) {
//         console.log("Fizz");
//     } else if (i%5 === 0) {
//         console.log("Buzz");
//     } else {
//         console.log(i);
//     }
// }
// console.log("\n");

/* Ex. 2 - Coin Flipper (num > 0.5 : Heads! and continue; num <= 0.5 : Tails! and stop) */
// while(true) {
//     let randNum = Math.random();
//     if (randNum <= 0.5) {
//         console.log("Heads!");
//     } else {
//         console.log("Tails!");
//         break;
//     }
// }

/* Ex. 3 - compute first n Fibonacci numbers returning them in an array */
// let computeFibonacci = n => {
//     let array = [0,1];
//     for (let i = 2; i < n; i++) {
//         let nextNumber = array[i-1] + array[i-2];
//         array.push(nextNumber);
//     }
//     return array;
// };
// console.log(computeFibonacci(20));

/* Ex. 4 - display Two Times Tables */
// let twoTimesTable = x => `Two times ${x} is ${2*x}`;
//
// let iterate = (action, count) => {
//     for (let i = 0; i < count; i++) {
//         console.log(action(i));
//     }
// };
// iterate(twoTimesTable, 10);

/* Ex. 5a - capitalise strings in an array */
let animals = ["Cat", "Dog", "Cow", "Rabbit"];

// for (let i = 0; i < animals.length; i++) {
//     console.log(animals[i].toUpperCase());
// }

/* Ex. 5b - use forEach instead of for loop */
// animals.forEach(function (animal) {
//     console.log(animal.toUpperCase());
// });

/* Ex. 5c - use arrow notation instead of function notation */
animals.forEach((animal) => console.log(animal.toUpperCase()));