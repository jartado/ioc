import { Engine } from './engine';

export class Car {
    private engineProp: Engine;

    constructor(engineParam: Engine) { 
        this.engineProp = engineParam;
    }

    get engineMethod(): Engine {
        return this.engineProp;
    }

    set engineMethod(value: Engine) {
        if (value == undefined) throw 'Please, supply an Engine'
        this.engineProp = value;
    }

    start(){
        return this.engineProp + " arrancado.";
    }

    stop(){
        return this.engineProp + " parado.";
    }
}
