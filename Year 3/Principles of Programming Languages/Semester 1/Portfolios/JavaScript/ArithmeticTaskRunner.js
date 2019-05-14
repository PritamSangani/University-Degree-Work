class ArithmeticTaskRunner {
    constructor() {
        this.tasks = [];
    }

    //TODO: addNegationTask - adds anonymous function to tasks array which takes an argument, x, which should return, -x.
    addNegationTask() {
        this.tasks.push((x) => -x);
    }

    //TODO: addAdditionTask - takes an argument y and adds anonymous function to tasks array which takes an argument, x, and return x+ y.
    addAdditionTask(y) {
        this.tasks.push((x) => x+y);
    }

    //TODO: addMultiplicationTask - takes an argument y and adds anonymous function to tasks array which takes an argument, x, and return x* y.
    addMultiplicationTask(y) {
        this.tasks.push((x) => x*y);
    }

    get taskCount() {
        return this.tasks.length;
    }

    //TODO: execute - takes single argument startValue which defaults to 0 if no value is provided. Should iterate over tasks array executing each function on the current value. Returns result when all tasks have executed.
    execute(startValue = 0) {
        this.tasks.forEach(task => startValue = task(startValue));
        return startValue;
    }
}