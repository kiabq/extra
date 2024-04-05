const target = {
    message1: "Hello",
    message2: "Everyone"
};

const handler1 = {};

const handler2 = {
    get(target, props, receiver) {
        console.log("prop is " + props);
        if (props === "message2") {
            return "World"
        }

        return Reflect.get(...arguments)
    },
};

const proxy1 = new Proxy(target, handler1);

console.log(proxy1.message1);
console.log(proxy1.message2);

const proxy2 = new Proxy(target, handler2);

console.log(proxy2.message1);
console.log(proxy2.message2);