class test {
    constructor(number, thing, thing2) {
        this.number = number;
        this.thing = thing;
        this.thing2 = thing2;
    }
}
const obj = new test(2, "hi", "bye")
console.log(obj.thing, obj.thing2, obj.number)
//yay