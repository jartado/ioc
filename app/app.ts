import { Car } from './car';
import { Engine } from './engine';

console.log("Dependencias V.1.4")

var motor1 = new Engine(250,"Motor V6");
var motor2 = new Engine(300,"Motor V8");


var cocheA = new Car(motor1);
var cocheB = new Car(motor1);

var cocheC = new Car(motor2);
var cocheD = new Car(motor2);

console.log("El motor del cocheA es un " + cocheA.engineMethod.engineType + 
" con una potencia de " + cocheA.engineMethod.horsePower + "CV")

console.log("El motor del cocheC es un " + cocheC.engineMethod.engineType + 
" con una potencia de " + cocheA.engineMethod.horsePower + "CV")