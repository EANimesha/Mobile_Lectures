import React, { Component } from 'react';
import {View,Text} from 'react-native';

class Blink extends Component {
    constructor(props){
        super(props);
        this.state={
            showText:true
        };
        var taskToDo=()=>{
            this.setState(previousState=>{
                return{
                    showText:!previousState.showText
                };
            });
        };
        const TimeToBlink=500;
        setInterval(taskToDo,TimeToBlink);
    }
    render() {
            let textToDisplay=this.state.showText?this.props.inputText: '';
            return(
                <Text>{textToDisplay}</Text>
            );
    }
}

export default class TextBlink extends Blink{
    render(){
        return(
            <View>
                <Blink inputText="Hello,How are you?"></Blink>
                <Blink inputText="HI am Fine"></Blink>
            </View>
        );
    }
}
