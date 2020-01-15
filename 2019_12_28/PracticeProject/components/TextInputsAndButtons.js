import React, { Component } from 'react';
import {TextInput,View,Text,Keyboard, Button, Alert, TouchableOpacity} from 'react-native';

export class MyInputs extends Component {
    constructor(props) {
        super(props)
        this.state={
            typedText:'please enter your Text',
            typedPassword:'please enter your password',
            typedDescription:'enter your description'
        };
    }
    componentWillMount(){
        this.KeyboardDidShowListener=Keyboard.addListener('keyboardDidShow',()=>{
            this.setState({
                typedText:'Keyboard is shown'
            })
        });
        this.KeyboardDidHideListener=Keyboard.addListener('keyboardDidHide',()=>{
            this.setState({
                typedText:'Keyboard is hided'
            })
        });
    }
    componentWillUnmount(){
        this.KeyboardDidHideListener.remove();
        this.KeyboardDidShowListener.remove();
    }
    render() {
        return (
            <View>
                <TextInput
                style={{
                    height:40,
                    margin:20,
                    padding:10,
                    borderColor:'gray',
                    borderWidth:1
                }}
                keyboardType='email-address'
                placeholder='Enter Your email'
                placeholderTextColor='red'
                autoFocus={true}
                onChangeText={
                    (text)=>{
                        this.setState({
                            typedText:text
                        })
                    }
                }/>
                <Text>{this.state.typedText}</Text>
                <TextInput
                    style={{
                    height:40,
                    margin:20,
                    padding:10,
                    borderColor:'gray',
                    borderWidth:1
                    }}
                    keyboardType='default'
                    placeholder='Enter Your password'
                    secureTextEntry={true}
                    onChangeText={
                        (text)=>{
                            this.setState({
                                typedPassword:text
                            })
                        }
                    }
                />
                <Text>{this.state.typedPassword}</Text>
                <TextInput
                    style={{
                    height:100,
                    margin:20,
                    padding:10,
                    borderColor:'gray',
                    borderWidth:1
                    }}
                    multiline={true}
                    borderBottomColor='green'
                    borderBottomWidth={3}
                    borderLeftColor='green'
                    borderLeftWidth={3}
                    borderRightColor='green'
                    borderRightWidth={3}
                    editable={true}
                    returnKeyType='done'
                    onSubmitEditing={Keyboard.dismiss}
                    onChangeText={
                        (text)=>{
                            this.setState({
                                typedDescription:text
                            })
                        }
                    }
                />
                <Text>{this.state.typedDescription}</Text>
                <View
                style={{
                    alignItems:'center',
                }}>
                <Button onPress={()=>{
                        Alert.alert("You Pressed the Button")
                    }}
                    title="This is a button"
                    color="green">

                </Button>
                <TouchableOpacity onPress={()=>{
                        Alert.alert("You Pressed the Button")
                    }}
                    onPressOut={()=>{
                        alert('OnPressed out')
                    }}>
                    <Text style={{
                        color:'blue',
                        backgroundColor:'grey',
                        padding:5,
                        margin:10}}>TouchableOpacity</Text>
                </TouchableOpacity>
                </View>
            </View>
        )
    }
}

export default MyInputs
