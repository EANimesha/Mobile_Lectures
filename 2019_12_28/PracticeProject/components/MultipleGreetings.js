import React,{Component} from 'react';
import {Text,View,StyleSheet} from 'react-native';

class Greeting extends Component{
    render(){
        let greetingString=`

            Hello ${this.props.name} , How are you?

        `;
        return(
            <Text style={styles.firstText}>{greetingString}</Text>
        );
    }
}

export default class MultipleGreetings extends Component{
    render(){
        return(
            <View
            style={styles.container}
            >
            <Greeting name="Nimesha"></Greeting>
            <Greeting name="Dilini"></Greeting>
            </View>
        )
    }
}
const styles=StyleSheet.create({
    container:{
        marginTop:20,
        marginLeft:10,
        marginRight:10,
        backgroundColor:'#2BB463',
        borderWidth:3,
        borderColor:'#100000',
        alignItems:'center'
    },
    firstText:{
        color:'white',
        margin:5,
        fontSize:15
    }
})