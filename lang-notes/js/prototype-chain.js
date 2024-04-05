const o = {
    a: 1,
    b: 2,
    __proto__: {
        b: 3,
        c: 4,
        __proto__: {
            d: 5
        }
    }
}

/*  
    These two are essentially the same,
    However, when we try to access property d,
    it will see that 'd' cannot be accessesd,
    so it will check it's [[prototype]]. In this
    next [[prototype]], it sees that it still does
    not exist, so it will check that [[prototype]]'s
    [[prototype]], thus returning 'd'.
*/
console.log(o.d);
console.log(o.__proto__.__proto__.d);
