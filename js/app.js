System.register("engine", [], function (exports_1, context_1) {
    "use strict";
    var Engine;
    var __moduleName = context_1 && context_1.id;
    return {
        setters: [],
        execute: function () {
            Engine = /** @class */ (function () {
                function Engine(horsePower, engineType) {
                    this.horsePower = horsePower;
                    this.engineType = engineType;
                }
                return Engine;
            }());
            exports_1("Engine", Engine);
        }
    };
});
System.register("car", [], function (exports_2, context_2) {
    "use strict";
    var Car;
    var __moduleName = context_2 && context_2.id;
    return {
        setters: [],
        execute: function () {
            Car = /** @class */ (function () {
                function Car(engineParam) {
                    this.engineProp = engineParam;
                }
                Object.defineProperty(Car.prototype, "engineMethod", {
                    get: function () {
                        return this.engineProp;
                    },
                    set: function (value) {
                        if (value == undefined)
                            throw 'Please, supply an Engine';
                        this.engineProp = value;
                    },
                    enumerable: true,
                    configurable: true
                });
                Car.prototype.start = function () {
                    return this.engineProp + " arrancado.";
                };
                Car.prototype.stop = function () {
                    return this.engineProp + " parado.";
                };
                return Car;
            }());
            exports_2("Car", Car);
        }
    };
});
System.register("app", ["car", "engine"], function (exports_3, context_3) {
    "use strict";
    var car_1, engine_1, motor1, motor2, cocheA, cocheB, cocheC, cocheD;
    var __moduleName = context_3 && context_3.id;
    return {
        setters: [
            function (car_1_1) {
                car_1 = car_1_1;
            },
            function (engine_1_1) {
                engine_1 = engine_1_1;
            }
        ],
        execute: function () {
            console.log("Dependencias V.1.4");
            motor1 = new engine_1.Engine(250, "Motor V6");
            motor2 = new engine_1.Engine(300, "Motor V8");
            cocheA = new car_1.Car(motor1);
            cocheB = new car_1.Car(motor1);
            cocheC = new car_1.Car(motor2);
            cocheD = new car_1.Car(motor2);
            console.log("El motor del cocheA es un " + cocheA.engineMethod.engineType +
                " con una potencia de " + cocheA.engineMethod.horsePower + "CV");
            console.log("El motor del cocheC es un " + cocheC.engineMethod.engineType +
                " con una potencia de " + cocheA.engineMethod.horsePower + "CV");
        }
    };
});
